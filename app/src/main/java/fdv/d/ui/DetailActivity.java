package fdv.d.ui;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fdv.d.data.db.AppDB;
import fdv.d.widget.DrinkWidget;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.squareup.picasso.Picasso;

import fdv.d.R;
import fdv.d.App;
import fdv.d.utils.Utils;
import fdv.d.data.db.Drink;
import fdv.d.data.api.DrinksList;
import fdv.d.widget.DrinkWidget;

import static fdv.d.App.appDB;
import static fdv.d.App.appExecutors;
import static fdv.d.App.drinkType;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID_DRINK = "id_drink";
    public static final String EXTRA_PATH = "path_drink";
    public static final String EXTRA_INGREDIENTS = "extra_ings";

    private Drink drink;
/*
    private TextView tvDrink;
    private TextView tvCategory;
    private TextView tvIngredients;
    private TextView tvInstruction;
*/
    @BindView(R.id.iv_drink) ImageView drinkView;
    @BindView(R.id.tv_drink) TextView tvDrink;
    @BindView(R.id.tv_cat) TextView tvCategory;
    @BindView(R.id.tv_ings) TextView tvIngredients;
    @BindView(R.id.tv_text) TextView tvInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_acrivity);
        ButterKnife.bind(this);

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
/*
        ImageView drinkView = findViewById(R.id.iv_drink);
        tvDrink = findViewById(R.id.tv_drink);
        tvCategory = findViewById(R.id.tv_cat);
        tvIngredients = findViewById(R.id.tv_ings);
        tvInstruction = findViewById(R.id.tv_text);
*/

        String id_drink = getIntent().getStringExtra(EXTRA_ID_DRINK);
        String path_drink = getIntent().getStringExtra(EXTRA_PATH);
//  https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=13060
        App.getApi().loadById(id_drink).enqueue(new Callback<DrinksList>() {
            @Override
            public void onResponse(Call<DrinksList> call, Response<DrinksList> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG","API is Ok");
                    drink = response.body().getList().get(0);
                    String s = Utils.getIngregientsList(drink);
//                    Log.d("TAG","Ings: " + s);
                    tvIngredients.setText(s);
                    tvDrink.setText(drink.getStrDrink());
                    tvCategory.setText(drink.getStrCategory());
                    tvInstruction.setText(drink.getStrInstructions());
                } else {
                    Log.e("TAG", "response code " + response.code());
                }
            }
            @Override
            public void onFailure(Call<DrinksList> call, Throwable t) {
                Log.e("TAG", "API Error: " + t.toString());
            }
        });
        Picasso.get()
                .load(path_drink)
                .placeholder(R.drawable.no_drink)
                .error(R.drawable.err_drink)
                .into(drinkView);
    }
    // Check in drink with id is favorite
    private boolean checkIsFav(String id) {
        Drink drink = appDB.drinkDao().getByIdDrink(id);
        Log.d("TAG", "checkIsFav" + String.valueOf(drink.getIdDrink()));
        /* return true if the cursor is not empty */
        boolean isFav = (drink!=null);
        Log.d("TAG", "checkIsFav" + String.valueOf(isFav));
        return isFav;
    }
    // Save Favorite cocktail information to the local database
    private void saveFav() {
        Log.d("TAG", "saveFav: " + String.valueOf(drink.getIdDrink()));
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                appDB.drinkDao().insertDrink(drink);
            }
        });
    }
    // Creating menu: Favorite & Add Widget
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav:
//                if(!checkIsFav(drink.getIdDrink()))
                    saveFav();
                return true;
            case R.id.add_widget:
                String name = tvDrink.getText().toString();
                String text = tvIngredients.getText().toString();
                Log.d("TAG_Wdgt", "updateWidgets");
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, DrinkWidget.class));
                //Now update all widgets
                DrinkWidget.updateWidgets(this, appWidgetManager, name, text, appWidgetIds);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
