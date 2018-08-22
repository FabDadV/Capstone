package fdv.d.ui;

import java.util.List;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import fdv.d.R;
import fdv.d.data.db.Drink;

import static fdv.d.App.appDB;
import static fdv.d.App.appExecutors;

public class AddActivity extends AppCompatActivity {

    private List<String> list;
    private Drink addDrink;
    private int ver;

    @BindView(R.id.iv_add) ImageView addView;
    @BindView(R.id.edit_drink) EditText editDrink;
    @BindView(R.id.edit_cat) EditText editCategory;
    @BindView(R.id.edit_text) EditText editInstruction;

    @BindView(R.id.tv_ings) TextView tvIngredients;
    @BindView(R.id.tv_mes) TextView tvMeasures;
    @BindView(R.id.edit_ing1) EditText editIngredient1;
    @BindView(R.id.edit_mes1) EditText editMeasure1;
    @BindView(R.id.edit_ing2) EditText editIngredient2;
    @BindView(R.id.edit_mes2) EditText editMeasure2;
    @BindView(R.id.edit_ing3) EditText editIngredient3;
    @BindView(R.id.edit_mes3) EditText editMeasure3;
    @BindView(R.id.edit_ing4) EditText editIngredient4;
    @BindView(R.id.edit_mes4) EditText editMeasure4;
    @BindView(R.id.edit_ing5) EditText editIngredient5;
    @BindView(R.id.edit_mes5) EditText editMeasure5;
    @BindView(R.id.edit_ing6) EditText editIngredient6;
    @BindView(R.id.edit_mes6) EditText editMeasure6;
    @BindView(R.id.edit_ing7) EditText editIngredient7;
    @BindView(R.id.edit_mes7) EditText editMeasure7;
    @BindView(R.id.edit_ing8) EditText editIngredient8;
    @BindView(R.id.edit_mes8) EditText editMeasure8;
    @BindView(R.id.edit_ing9) EditText editIngredient9;
    @BindView(R.id.edit_mes9) EditText editMeasure9;
    @BindView(R.id.edit_ing10) EditText editIngredient10;
    @BindView(R.id.edit_mes10) EditText editMeasure10;
    @BindView(R.id.edit_ing11) EditText editIngredient11;
    @BindView(R.id.edit_mes11) EditText editMeasure11;
    @BindView(R.id.edit_ing12) EditText editIngredient12;
    @BindView(R.id.edit_mes12) EditText editMeasure12;
    @BindView(R.id.edit_ing13) EditText editIngredient13;
    @BindView(R.id.edit_mes13) EditText editMeasure13;
    @BindView(R.id.edit_ing14) EditText editIngredient14;
    @BindView(R.id.edit_mes14) EditText editMeasure14;
    @BindView(R.id.edit_ing15) EditText editIngredient15;
    @BindView(R.id.edit_mes15) EditText editMeasure15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

//        ver = getNewVersion();
        ver = 900001;

        FloatingActionButton fab = findViewById(R.id.save_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkFillDrinks(view)) {
                    inflateNewDrink();
                    appExecutors.diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            appDB.drinkDao().insertDrink(addDrink);
                        }
                    });
                }
//                finish();
/*
                Snackbar.make(view, "Save own Cocktail's detail information", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
*/
            }
        });

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
/*
        OnClickListener onClickImage = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "addImage");

            }
        };
*/
    }
    public void AddThumb(View view) {
        Log.d("TAG", "addThumb");
        Snackbar.make(view, "Add Cocktail's Image in App", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    // Create idDrink for new own Cocktail
    private int getNewVersion() {
        Log.d("TAG", "getListOwnDrink");
        appExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                list = appDB.drinkDao().getListIdDrinks();
            }
        });
        if(list==null) {return 900001;};
        Log.d("TAG", "own list");
        int maxId = 0;
        for (String item : list) {
            int l = Integer.valueOf(item);
            int m = l / 10000;
            if (m > maxId) {
                maxId = m;
            }
        }
        ver = maxId + 900000;
        Log.d("TAG", "NewVer: " + String.valueOf(ver));
        return ver;
    }

    // Chech in fields for new Drink
    private boolean checkFillDrinks(View view) {
        Log.d("TAG", " fillDrrinks");
        if (UpdateActivity.checkEmpty(editDrink.getText().toString())) {
            Snackbar.make(view, "Type Cocktail's name", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return false;
        };
        if (UpdateActivity.checkEmpty(editInstruction.getText().toString())) {
            Snackbar.make(view, "Type Cocktail's Instruction", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return false;
        };
        if (UpdateActivity.checkEmpty(editIngredient1.getText().toString())) {
            Snackbar.make(view, "Type Cocktail's ingredient 1", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return false;
        };
        if (UpdateActivity.checkEmpty(editMeasure1.getText().toString())) {
            Snackbar.make(view, "Type Cocktail's measure 1", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return false;
        };
        if (UpdateActivity.checkEmpty(editIngredient2.getText().toString())) {
            Snackbar.make(view, "Type Cocktail's ingredient 2", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return false;
        };
        if (UpdateActivity.checkEmpty(editMeasure2.getText().toString())) {
            Snackbar.make(view, "Type Cocktail's measure 2", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return false;
        };
        return true;
    }
    // Inflate ingredients information
    private void inflateNewDrink() {

        addDrink.setIdDrink(String.valueOf(ver));

        addDrink.setStrDrink(editDrink.getText().toString());
        addDrink.setStrCategory(editCategory.getText().toString());
        addDrink.setStrInstructions(editInstruction.getText().toString());

        addDrink.setStrIngredient1(editIngredient1.getText().toString());
        addDrink.setStrMeasure1(editMeasure1.getText().toString());
        Log.d("TAG"," inflate Ings" + addDrink.getStrIngredient1());
        Log.d("TAG"," inflate Mes" + addDrink.getStrMeasure1());
        addDrink.setStrIngredient2(editIngredient2.getText().toString());
        addDrink.setStrMeasure2(editMeasure2.getText().toString());
        addDrink.setStrIngredient3(editIngredient3.getText().toString());
        addDrink.setStrMeasure3(editMeasure3.getText().toString());
        addDrink.setStrIngredient4(editIngredient4.getText().toString());
        addDrink.setStrMeasure4(editMeasure4.getText().toString());
        addDrink.setStrIngredient5(editIngredient5.getText().toString());
        addDrink.setStrMeasure5(editMeasure5.getText().toString());
        addDrink.setStrIngredient6(editIngredient6.getText().toString());
        addDrink.setStrMeasure6(editMeasure6.getText().toString());
        addDrink.setStrIngredient7(editIngredient7.getText().toString());
        addDrink.setStrMeasure7(editMeasure7.getText().toString());
        addDrink.setStrIngredient8(editIngredient8.getText().toString());
        addDrink.setStrMeasure8(editMeasure8.getText().toString());
        addDrink.setStrIngredient9(editIngredient9.getText().toString());
        addDrink.setStrMeasure9(editMeasure9.getText().toString());
        addDrink.setStrIngredient10(editIngredient10.getText().toString());
        addDrink.setStrMeasure10(editMeasure10.getText().toString());
        addDrink.setStrIngredient11(editIngredient11.getText().toString());
        addDrink.setStrMeasure11(editMeasure11.getText().toString());
        addDrink.setStrIngredient12(editIngredient12.getText().toString());
        addDrink.setStrMeasure12(editMeasure12.getText().toString());
        addDrink.setStrIngredient13(editIngredient13.getText().toString());
        addDrink.setStrMeasure13(editMeasure13.getText().toString());
        addDrink.setStrIngredient14(editIngredient14.getText().toString());
        addDrink.setStrMeasure14(editMeasure14.getText().toString());
        addDrink.setStrIngredient15(editIngredient15.getText().toString());
        addDrink.setStrMeasure15(editMeasure15.getText().toString());
    }

    private boolean checkEmpty(String t, String m) {
        return (t.equals("") || t.equals(" ") || t.equals("\n")) &&
                (m.equals("") || m.equals(" ") || m.equals("\n"));
    }
}
