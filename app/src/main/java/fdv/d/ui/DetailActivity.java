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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import fdv.d.R;
import fdv.d.App;
import fdv.d.data.db.Drink;
import fdv.d.data.api.DrinksList;
import fdv.d.utils.Utils;
import fdv.d.widget.DrinkWidget;

import static fdv.d.App.appDB;
import static fdv.d.App.appExecutors;
import static fdv.d.App.drinkType;
import static fdv.d.App.FAVORITE;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID_DRINK = "id_drink";
    public static final String EXTRA_DRINK = "drink";
    public static final String EXTRA_PATH = "path_drink";

    private Drink drink;
    private String idDrink;
    private AdView adView;

    @BindView(R.id.iv_drink) ImageView drinkView;
    @BindView(R.id.tv_drink) TextView tvDrink;
    @BindView(R.id.tv_cat) TextView tvCategory;
    @BindView(R.id.tv_text) TextView tvInstruction;

    @BindView(R.id.tv_ing1) TextView tvIngredient1;
    @BindView(R.id.tv_mes1) TextView tvMeasure1;
    @BindView(R.id.tv_ing2) TextView tvIngredient2;
    @BindView(R.id.tv_mes2) TextView tvMeasure2;
    @BindView(R.id.tv_ing3) TextView tvIngredient3;
    @BindView(R.id.tv_mes3) TextView tvMeasure3;
    @BindView(R.id.tv_ing4) TextView tvIngredient4;
    @BindView(R.id.tv_mes4) TextView tvMeasure4;
    @BindView(R.id.tv_ing5) TextView tvIngredient5;
    @BindView(R.id.tv_mes5) TextView tvMeasure5;
    @BindView(R.id.tv_ing6) TextView tvIngredient6;
    @BindView(R.id.tv_mes6) TextView tvMeasure6;
    @BindView(R.id.tv_ing7) TextView tvIngredient7;
    @BindView(R.id.tv_mes7) TextView tvMeasure7;
    @BindView(R.id.tv_ing8) TextView tvIngredient8;
    @BindView(R.id.tv_mes8) TextView tvMeasure8;
    @BindView(R.id.tv_ing9) TextView tvIngredient9;
    @BindView(R.id.tv_mes9) TextView tvMeasure9;
    @BindView(R.id.tv_ing10) TextView tvIngredient10;
    @BindView(R.id.tv_mes10) TextView tvMeasure10;
    @BindView(R.id.tv_ing11) TextView tvIngredient11;
    @BindView(R.id.tv_mes11) TextView tvMeasure11;
    @BindView(R.id.tv_ing12) TextView tvIngredient12;
    @BindView(R.id.tv_mes12) TextView tvMeasure12;
    @BindView(R.id.tv_ing13) TextView tvIngredient13;
    @BindView(R.id.tv_mes13) TextView tvMeasure13;
    @BindView(R.id.tv_ing14) TextView tvIngredient14;
    @BindView(R.id.tv_mes14) TextView tvMeasure14;
    @BindView(R.id.tv_ing15) TextView tvIngredient15;
    @BindView(R.id.tv_mes15) TextView tvMeasure15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ButterKnife.bind(this);

        idDrink = getIntent().getStringExtra(EXTRA_ID_DRINK);
        String pathDrink = getIntent().getStringExtra(EXTRA_PATH);
        if(drinkType.equals(FAVORITE)) {
            loadDrink();
        } else {
            obtainDrink();
        }
        Picasso.get()
                .load(pathDrink)
                .placeholder(R.drawable.no_drink)
                .error(R.drawable.err_drink)
                .into(drinkView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adView = findViewById(R.id.adView);
        // Create an ad request
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        FloatingActionButton fab = findViewById(R.id.edit_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateIntent = new Intent(DetailActivity.this, UpdateActivity.class);
                Log.d("TAG", "Put: " + drink.getStrDrink() + drink.getStrIngredient1());
                // Pass the data to the UpdateActivity
                updateIntent.putExtra(EXTRA_DRINK, drink);
                startActivity(updateIntent);
                finish();
            }
        });
    }
    // Obtain Cocktail's detail information from internet by id:
    // https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=13060
    public void obtainDrink() {
        App.getApi().loadById(idDrink).enqueue(new Callback<DrinksList>() {
            @Override
            public void onResponse(Call<DrinksList> call, Response<DrinksList> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG","API is Ok");
                    Utils.addDelay(1000);
                    drink = response.body().getList().get(0);
                    inflateDrink(drink);
/*
                    String s = Utils.getIngregientsList(drink);
                    tvIngredients.setText(s);
*/
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
    // Load Cocktail's detail information from local Database by id:
    public void loadDrink() {
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                drink = appDB.drinkDao().getByIdDrink(idDrink);
            }
        });
        Utils.addDelay(2000);
        Log.d("TAG","Load Drink is Ok");
        inflateDrink(drink);
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
    // Delete Favorite cocktail information from the local database
    private void deleteFav() {
        Log.d("TAG", "deleteFav: " + String.valueOf(drink.getIdDrink()));
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                appDB.drinkDao().deleteDrink(drink);
            }
        });
    }
    // Creating menu: Favorite & Add Widget
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        MenuItem fav = menu.findItem(R.id.fav);
        MenuItem notFav = menu.findItem(R.id.not_fav);
        if(drinkType.equals(FAVORITE)) {
            fav.setVisible(false);
            notFav.setVisible(true);
        } else {
            fav.setVisible(true);
            notFav.setVisible(false);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav:
                saveFav();
                return true;
            case R.id.not_fav:
                if(drinkType.equals(FAVORITE)) {deleteFav();}
                finish();
                return true;
            case R.id.add_widget:
                String name = tvDrink.getText().toString();
                String text = Utils.getIngregientsList(drink);
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this, DrinkWidget.class));
                //Now update all widgets
                DrinkWidget.updateWidgets(this, appWidgetManager, name, text, appWidgetIds);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    // Inflate ingredients information
    private void inflateDrink(Drink drink) {
        Log.d("TAG","inflate Drink " + drink.getStrDrink());
        tvDrink.setText(drink.getStrDrink());
        tvCategory.setText(drink.getStrCategory());
        tvInstruction.setText(drink.getStrInstructions());
        if(checkEmpty(drink.getStrIngredient1()) && checkEmpty(drink.getStrMeasure1())) {
            tvIngredient1.setVisibility(View.INVISIBLE);
            tvMeasure1.setVisibility(View.INVISIBLE);
        }else{
            tvIngredient1.setText(drink.getStrIngredient1());
            tvMeasure1.setText(drink.getStrMeasure1());
        }
        if(checkEmpty(drink.getStrIngredient2()) && checkEmpty(drink.getStrMeasure2())) {
            tvIngredient2.setVisibility(View.INVISIBLE);
            tvMeasure2.setVisibility(View.INVISIBLE);
        }else {
            tvIngredient2.setText(drink.getStrIngredient2());
            tvMeasure2.setText(drink.getStrMeasure2());
        }
        if(checkEmpty(drink.getStrIngredient3()) && checkEmpty(drink.getStrMeasure3())) {
            tvIngredient3.setVisibility(View.INVISIBLE);
            tvMeasure3.setVisibility(View.INVISIBLE);
        }else {
            tvIngredient3.setText(drink.getStrIngredient3());
            tvMeasure3.setText(drink.getStrMeasure3());
        }
        if(checkEmpty(drink.getStrIngredient4()) && checkEmpty(drink.getStrMeasure4())) {
            tvIngredient4.setVisibility(View.GONE);
            tvMeasure4.setVisibility(View.GONE);
        }else {
            tvIngredient4.setText(drink.getStrIngredient4());
            tvMeasure4.setText(drink.getStrMeasure4());
        }
        if(checkEmpty(drink.getStrIngredient5()) && checkEmpty(drink.getStrMeasure5())) {
            tvIngredient5.setVisibility(View.GONE);
            tvMeasure5.setVisibility(View.GONE);
        }else {
            tvIngredient5.setText(drink.getStrIngredient5());
            tvMeasure5.setText(drink.getStrMeasure5());
        }
        if(checkEmpty(drink.getStrIngredient6()) && checkEmpty(drink.getStrMeasure6())) {
            tvIngredient6.setVisibility(View.GONE);
            tvMeasure6.setVisibility(View.GONE);
        }else {
            tvIngredient6.setText(drink.getStrIngredient6());
            tvMeasure6.setText(drink.getStrMeasure6());
        }
        if(checkEmpty(drink.getStrIngredient7()) && checkEmpty(drink.getStrMeasure7())) {
            tvIngredient7.setVisibility(View.GONE);
            tvMeasure7.setVisibility(View.GONE);
        }else {
            tvIngredient7.setText(drink.getStrIngredient7());
            tvMeasure7.setText(drink.getStrMeasure7());
        }
        if(checkEmpty(drink.getStrIngredient8()) && checkEmpty(drink.getStrMeasure8())) {
            tvIngredient8.setVisibility(View.GONE);
            tvMeasure8.setVisibility(View.GONE);
        }else {
            tvIngredient8.setText(drink.getStrIngredient8());
            tvMeasure8.setText(drink.getStrMeasure8());
        }
        if(checkEmpty(drink.getStrIngredient9()) && checkEmpty(drink.getStrMeasure9())) {
            tvIngredient9.setVisibility(View.GONE);
            tvMeasure9.setVisibility(View.GONE);
        }else {
            tvIngredient9.setText(drink.getStrIngredient9());
            tvMeasure9.setText(drink.getStrMeasure9());
        }
        if(checkEmpty(drink.getStrIngredient10()) && checkEmpty(drink.getStrMeasure10())) {
            tvIngredient10.setVisibility(View.GONE);
            tvMeasure10.setVisibility(View.GONE);
        }else {
            tvIngredient10.setText(drink.getStrIngredient10());
            tvMeasure10.setText(drink.getStrMeasure10());
        }
        if(checkEmpty(drink.getStrIngredient11()) && checkEmpty(drink.getStrMeasure11())) {
            tvIngredient11.setVisibility(View.GONE);
            tvMeasure11.setVisibility(View.GONE);
        }else {
            tvIngredient11.setText(drink.getStrIngredient11());
            tvMeasure11.setText(drink.getStrMeasure11());
        }
        if(checkEmpty(drink.getStrIngredient12()) && checkEmpty(drink.getStrMeasure12())) {
            tvIngredient12.setVisibility(View.GONE);
            tvMeasure12.setVisibility(View.GONE);
        }else {
            tvIngredient12.setText(drink.getStrIngredient12());
            tvMeasure12.setText(drink.getStrMeasure12());
        }
        if(checkEmpty(drink.getStrIngredient13()) && checkEmpty(drink.getStrMeasure13())) {
            tvIngredient13.setVisibility(View.GONE);
            tvMeasure13.setVisibility(View.GONE);
        }else {
            tvIngredient13.setText(drink.getStrIngredient13());
            tvMeasure13.setText(drink.getStrMeasure13());
        }
        if(checkEmpty(drink.getStrIngredient14()) && checkEmpty(drink.getStrMeasure14())) {
            tvIngredient14.setVisibility(View.GONE);
            tvMeasure14.setVisibility(View.GONE);
        }else {
            tvIngredient14.setText(drink.getStrIngredient14());
            tvMeasure14.setText(drink.getStrMeasure14());
        }
        if(checkEmpty(drink.getStrIngredient15()) && checkEmpty(drink.getStrMeasure15())) {
            tvIngredient15.setVisibility(View.GONE);
            tvMeasure15.setVisibility(View.GONE);
        }else {
            tvIngredient15.setText(drink.getStrIngredient15());
            tvMeasure15.setText(drink.getStrMeasure15());
        }
    }

    private static boolean checkEmpty(String s) {
        return (s.equals("") || s.equals(" ") || s.equals("\n"));
    }


}
