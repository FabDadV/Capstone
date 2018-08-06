package fdv.d.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.squareup.picasso.Picasso;

import fdv.d.R;
import fdv.d.App;
import fdv.d.utils.Utils;
import fdv.d.data.db.Drink;
import fdv.d.data.api.DrinksList;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID_DRINK = "id_drink";
    public static final String EXTRA_PATH = "path_drink";
    private TextView tvDrink;
    private TextView tvCategory;
    private TextView tvIngredients;
    private TextView tvInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_acrivity);

        FloatingActionButton fab = findViewById(R.id.edit_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*              Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
*/
                Intent updateIntent = new Intent(DetailActivity.this, UpdateActivity.class);
                startActivity(updateIntent);

            }
        });

        ImageView drinkView = findViewById(R.id.iv_drink);
        drinkView.setMaxWidth(100);
        tvDrink = findViewById(R.id.tv_drink);
        tvCategory = findViewById(R.id.tv_cat);
        tvIngredients = findViewById(R.id.tv_ings);
        tvInstruction = findViewById(R.id.tv_text);

        String id_drink = getIntent().getStringExtra(EXTRA_ID_DRINK);
        String path_drink = getIntent().getStringExtra(EXTRA_PATH);
// https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=13060
        App.getApi().loadById(id_drink).enqueue(new Callback<DrinksList>() {
            @Override
            public void onResponse(Call<DrinksList> call, Response<DrinksList> response) {
                if (response.isSuccessful()) {
                    Log.d("API_ID"," is Ok");
                    Drink drink = response.body().getList().get(0);
                    String s = Utils.getIngregientsList(drink);
                    Log.d("API_ID"," Ings: " +s);
                    tvIngredients.setText(s);
                    tvDrink.setText(drink.getName());
                    tvCategory.setText(drink.getStrCategory());
                    tvInstruction.setText(drink.getStrInstructions());
                } else {
                    Log.e("API", "response code " + response.code());
                }
            }
            @Override
            public void onFailure(Call<DrinksList> call, Throwable t) {
                Log.e("API_ID", "Error: " + t.toString());
            }
        });
        Picasso.get()
                .load(path_drink)
                .placeholder(R.drawable.no_drink)
                .error(R.drawable.err_drink)
                .into(drinkView);
    }
}
