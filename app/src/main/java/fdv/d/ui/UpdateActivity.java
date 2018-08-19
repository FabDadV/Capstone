package fdv.d.ui;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;

import fdv.d.App;
import fdv.d.R;
import fdv.d.data.api.DrinksList;
import fdv.d.data.db.Drink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static fdv.d.ui.DetailActivity.EXTRA_ID_DRINK;
import static fdv.d.ui.DetailActivity.EXTRA_PATH;

public class UpdateActivity extends AppCompatActivity {

    private Drink drink;

    @BindView(R.id.iv_update) ImageView drinkView;
    @BindView(R.id.tv_drink) TextView tvDrink;
    @BindView(R.id.tv_cat) TextView tvCategory;
    @BindView(R.id.tv_text) TextView tvInstruction;

    @BindView(R.id.tv_ing1) TextView tvIngredient1;
    @BindView(R.id.edit_mes1) EditText editMeasure1;
    @BindView(R.id.tv_ing2) TextView tvIngredient2;
    @BindView(R.id.edit_mes2) EditText editMeasure2;
    @BindView(R.id.tv_ing3) TextView tvIngredient3;
    @BindView(R.id.edit_mes3) EditText editMeasure3;
    @BindView(R.id.tv_ing4) TextView tvIngredient4;
    @BindView(R.id.edit_mes4) EditText editMeasure4;
    @BindView(R.id.tv_ing5) TextView tvIngredient5;
    @BindView(R.id.edit_mes5) EditText editMeasure5;
    @BindView(R.id.tv_ing6) TextView tvIngredient6;
    @BindView(R.id.edit_mes6) EditText editMeasure6;
    @BindView(R.id.tv_ing7) TextView tvIngredient7;
    @BindView(R.id.edit_mes7) EditText editMeasure7;
    @BindView(R.id.tv_ing8) TextView tvIngredient8;
    @BindView(R.id.edit_mes8) EditText editMeasure8;
    @BindView(R.id.tv_ing9) TextView tvIngredient9;
    @BindView(R.id.edit_mes9) EditText editMeasure9;
    @BindView(R.id.tv_ing10) TextView tvIngredient10;
    @BindView(R.id.edit_mes10) EditText editMeasure10;
    @BindView(R.id.tv_ing11) TextView tvIngredient11;
    @BindView(R.id.edit_mes11) EditText editMeasure11;
    @BindView(R.id.tv_ing12) TextView tvIngredient12;
    @BindView(R.id.edit_mes12) EditText editMeasure12;
    @BindView(R.id.tv_ing13) TextView tvIngredient13;
    @BindView(R.id.edit_mes13) EditText editMeasure13;
    @BindView(R.id.tv_ing14) TextView tvIngredient14;
    @BindView(R.id.edit_mes14) EditText editMeasure14;
    @BindView(R.id.tv_ing15) TextView tvIngredient15;
    @BindView(R.id.edit_mes15) EditText editMeasure15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);
/*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/
        ButterKnife.bind(this);

        FloatingActionButton fab = findViewById(R.id.update_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Save Coctail's version", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String idDrink = getIntent().getStringExtra(EXTRA_ID_DRINK);
        String pathDrink = getIntent().getStringExtra(EXTRA_PATH);
        updateIngredients(idDrink);

        Picasso.get()
                .load(pathDrink)
                .placeholder(R.drawable.no_drink)
                .error(R.drawable.err_drink)
                .into(drinkView);

    }
    // Obtain Cocktail's detail information from internet by id:
    // https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=13060
    public void updateIngredients(String idDrink) {
        App.getApi().loadById(idDrink).enqueue(new Callback<DrinksList>() {
            @Override
            public void onResponse(Call<DrinksList> call, Response<DrinksList> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG","Update is Ok");
                    drink = response.body().getList().get(0);
                    tvDrink.setText(drink.getStrDrink());
                    tvCategory.setText(drink.getStrCategory());
                    tvInstruction.setText(drink.getStrInstructions());
                    inflateIngredients(drink);
                } else {
                    Log.e("TAG", "response code " + response.code());
                }
            }
            @Override
            public void onFailure(Call<DrinksList> call, Throwable t) {
                Log.e("TAG", "API Error: " + t.toString());
            }
        });
    }

    private void inflateIngredients(Drink drink) {
        Log.d("TAG"," inflate Ings" + drink.getStrIngredient1());
        Resources resources = this.getResources();
        int color = resources.getColor(R.color.colorPrimaryLight);
        Log.d("TAG"," inflate Ings" + drink.getStrIngredient1());
        if(checkEmpty(drink.getStrIngredient1(), drink.getStrMeasure1())) {
            tvIngredient1.setVisibility(View.INVISIBLE);
            editMeasure1.setVisibility(View.INVISIBLE);
        }else{
            tvIngredient1.setText(drink.getStrIngredient1());
            editMeasure1.setText(drink.getStrMeasure1());
        }
        if(checkEmpty(drink.getStrIngredient2(), drink.getStrMeasure2())) {
            tvIngredient2.setVisibility(View.INVISIBLE);
            editMeasure2.setVisibility(View.INVISIBLE);
        }else {
            tvIngredient2.setText(drink.getStrIngredient2());
            editMeasure2.setText(drink.getStrMeasure2());
        }
        if(checkEmpty(drink.getStrIngredient3(), drink.getStrMeasure3())) {
            tvIngredient3.setVisibility(View.INVISIBLE);
            editMeasure3.setVisibility(View.INVISIBLE);
        }else {
            tvIngredient3.setText(drink.getStrIngredient3());
            editMeasure3.setText(drink.getStrMeasure3());
        }
        if(checkEmpty(drink.getStrIngredient4(), drink.getStrMeasure4())) {
            tvIngredient4.setVisibility(View.GONE);
            editMeasure4.setVisibility(View.GONE);
            editMeasure4.setBackgroundColor(color);
        }else {
            tvIngredient4.setText(drink.getStrIngredient4());
            editMeasure4.setText(drink.getStrMeasure4());
        }
        if(checkEmpty(drink.getStrIngredient5(), drink.getStrMeasure5())) {
            tvIngredient5.setVisibility(View.GONE);
            editMeasure5.setVisibility(View.GONE);
            editMeasure5.setBackgroundColor(color);
        }else {
            tvIngredient5.setText(drink.getStrIngredient5());
            editMeasure5.setText(drink.getStrMeasure5());
        }
        if(checkEmpty(drink.getStrIngredient6(), drink.getStrMeasure6())) {
            tvIngredient6.setVisibility(View.GONE);
            editMeasure6.setVisibility(View.GONE);
            editMeasure6.setBackgroundColor(color);
        }else {
            tvIngredient6.setText(drink.getStrIngredient6());
            editMeasure6.setText(drink.getStrMeasure6());
        }
        if(checkEmpty(drink.getStrIngredient7(), drink.getStrMeasure7())) {
            tvIngredient7.setVisibility(View.GONE);
            editMeasure7.setVisibility(View.GONE);
            editMeasure7.setBackgroundColor(color);
        }else {
            tvIngredient7.setText(drink.getStrIngredient7());
            editMeasure7.setText(drink.getStrMeasure7());
        }
        if(checkEmpty(drink.getStrIngredient8(), drink.getStrMeasure8())) {
            tvIngredient8.setVisibility(View.GONE);
            editMeasure8.setVisibility(View.GONE);
            editMeasure8.setBackgroundColor(color);
        }else {
            tvIngredient8.setText(drink.getStrIngredient8());
            editMeasure8.setText(drink.getStrMeasure8());
        }
        if(checkEmpty(drink.getStrIngredient9(), drink.getStrMeasure9())) {
            tvIngredient9.setVisibility(View.GONE);
            editMeasure9.setVisibility(View.GONE);
            editMeasure9.setBackgroundColor(color);
        }else {
            tvIngredient9.setText(drink.getStrIngredient9());
            editMeasure9.setText(drink.getStrMeasure9());
        }
        if(checkEmpty(drink.getStrIngredient10(), drink.getStrMeasure10())) {
            tvIngredient10.setVisibility(View.GONE);
            editMeasure10.setVisibility(View.GONE);
            editMeasure10.setBackgroundColor(color);
        }else {
            tvIngredient10.setText(drink.getStrIngredient10());
            editMeasure10.setText(drink.getStrMeasure10());
        }
        if(checkEmpty(drink.getStrIngredient11(), drink.getStrMeasure11())) {
            tvIngredient11.setVisibility(View.GONE);
            editMeasure11.setVisibility(View.GONE);
            editMeasure11.setBackgroundColor(color);
        }else {
            tvIngredient11.setText(drink.getStrIngredient11());
            editMeasure11.setText(drink.getStrMeasure11());
        }
        if(checkEmpty(drink.getStrIngredient12(), drink.getStrMeasure12())) {
            tvIngredient12.setVisibility(View.GONE);
            editMeasure12.setVisibility(View.GONE);
            editMeasure12.setBackgroundColor(color);
        }else {
            tvIngredient12.setText(drink.getStrIngredient12());
            editMeasure12.setText(drink.getStrMeasure12());
        }
        if(checkEmpty(drink.getStrIngredient13(), drink.getStrMeasure13())) {
            tvIngredient13.setVisibility(View.GONE);
            editMeasure13.setVisibility(View.GONE);
            editMeasure13.setBackgroundColor(color);
        }else {
            tvIngredient13.setText(drink.getStrIngredient13());
            editMeasure13.setText(drink.getStrMeasure13());
        }
        if(checkEmpty(drink.getStrIngredient14(), drink.getStrMeasure14())) {
            tvIngredient14.setVisibility(View.GONE);
            editMeasure14.setVisibility(View.GONE);
            editMeasure14.setBackgroundColor(color);
        }else {
            tvIngredient14.setText(drink.getStrIngredient14());
            editMeasure14.setText(drink.getStrMeasure14());
        }
        if(checkEmpty(drink.getStrIngredient15(), drink.getStrMeasure15())) {
            tvIngredient15.setVisibility(View.GONE);
            editMeasure15.setVisibility(View.GONE);
            editMeasure15.setBackgroundColor(color);
        }else {
            tvIngredient15.setText(drink.getStrIngredient15());
            editMeasure15.setText(drink.getStrMeasure15());
        }
    }

    private boolean checkEmpty(String t, String m) {
        return (t.equals("") || t.equals(" ") || t.equals("\n")) &&
                (m.equals("") || m.equals(" ") || m.equals("\n"));
    }
}
