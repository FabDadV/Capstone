package fdv.d.ui;

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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fdv.d.R;
import fdv.d.data.db.Drink;

import static fdv.d.App.appDB;
import static fdv.d.App.appExecutors;

public class AddActivity extends AppCompatActivity {

    private List<Drink> list;
    private Drink addDrink;
    private int ver;

    @BindView(R.id.iv_add) ImageView addView;
    @BindView(R.id.edit_drink) TextView editDrink;
    @BindView(R.id.edit_cat) TextView editCategory;
    @BindView(R.id.edit_text) TextView editInstruction;
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

        ImageView addImage = findViewById(R.id.iv_add);
/*
        OnClickListener onClickImage = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "addImage");

            }
        };
*/
        FloatingActionButton fab = findViewById(R.id.save_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                if(fillDrinks()) {
                    addDrink.setIdDrink(String.valueOf(ver));
                    appExecutors.diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            appDB.drinkDao().insertDrink(addDrink);
                        }
                    });
                }
*/
//                finish();



                Snackbar.make(view, "Save own Cocktail's detail information", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void AddThumb(View view) {
        Log.d("TAG", "addThumb");
        Snackbar.make(view, "Add Cocktail's Image in App", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
