package fdv.d.ui;

import java.util.List;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

import fdv.d.R;
import fdv.d.data.db.Drink;
import fdv.d.vm.ListViewModel;

import static fdv.d.App.doReset;
import static fdv.d.App.drinkType;
import static fdv.d.ui.DetailActivity.EXTRA_PATH;
import static fdv.d.ui.DetailActivity.EXTRA_ID_DRINK;

public class MainActivity extends AppCompatActivity implements ListAdapter.ItemClickListener {
    private static final int DEFAULT_SIZE = 180;
    private ListViewModel viewModel;
    private List<Drink> list;
    private ListAdapter.ItemClickListener listener;
    private ListAdapter adapter;

    @BindView(R.id.rv_list) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        Log.d("TAG", "onCreate");
//        recyclerView = findViewById(R.id.rv_list);
        int numberOfColumns = calculateColumns(this);
        // Set the gridLayoutManager on recyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, numberOfColumns);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new ListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), VERTICAL));

        obtainViewModel();
        Log.d("TAG", " obtained VM ");
    }
    // Obtain Cocktail's information from internet
    private void obtainViewModel() {
        // Get a new or existing ViewModel from the ViewModelProvider.
        final ListViewModel viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        // Add an observer on the LiveData returned by getListLiveData.
        // The onChanged() method fires when the observed data changes
        Log.d("TAG", "observe");
        viewModel.getListLiveData().observe(this, new Observer<List<Drink>>() {
            @Override
            public void onChanged(@Nullable final List<Drink> drinks) {
                // Update the cached copy of the drinks in the adapter.
                list = drinks;
                Log.d("TAG", "adapter set Drinks");
                adapter.setDrinks(list);
/*
                if(list == null) {
                    list = drinks;
                    Log.d("TAG", "adapter set Drinks");
                    adapter.setDrinks(list);
                } else {
                    Log.d("TAG", "adapter reset Drinks");
                    list = drinks;
//                    adapter.notifyDataSetChanged();
                }
*/
            }
        });
    }
    // Override method in order to handle RecyclerView item clicks.
    @Override
    public void onItemClickListener(String idDrink, String pathDrink) {
        Log.d("TAG","Item: " + idDrink + pathDrink);
        Intent intent = new Intent(this, DetailActivity.class);
        // Pass the data to the DetailActivity
        intent.putExtra(EXTRA_ID_DRINK, idDrink);
        intent.putExtra(EXTRA_PATH, pathDrink);
        startActivity(intent);
    }
    // Creating Drinks search menu: ( Strong Soft Health ) Favorite Ingredient
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.strong_item:
                Log.d("TAG", " strong ");
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                if(item.isEnabled()) drinkType = "Alcoholic";
                doReset = true;
                obtainViewModel();
                return true;
            case R.id.soft_item:
                Log.d("TAG", " soft ");
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                if(item.isEnabled()) drinkType = "Non_Alcoholic";
                doReset = true;
                obtainViewModel();
                return true;
            case R.id.health_item:
                Log.d("TAG", " healthy ");
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                if(item.isEnabled()) drinkType = "Optional_Alcohol";
                doReset = true;
                obtainViewModel();
                return true;
            case R.id.fav_search:
                drinkType = "Favorite";
                doReset = true;
                obtainViewModel();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
     // Calculate number of columns in GridLayoutManager
    private static int calculateColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (dpWidth / DEFAULT_SIZE);
    }
}