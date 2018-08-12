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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import fdv.d.R;
import fdv.d.data.db.Drink;
import fdv.d.vm.ListViewModel;

import static fdv.d.App.drinkType;
import static fdv.d.ui.DetailActivity.EXTRA_PATH;
import static fdv.d.ui.DetailActivity.EXTRA_ID_DRINK;

public class MainActivity extends AppCompatActivity implements ListAdapter.ItemClickListener {
    private static final int DEFAULT_SIZE = 180;
    private ListViewModel viewModel;
    private List<Drink> list;
//    private RecyclerView recyclerView;
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

        // Get a new or existing ViewModel from the ViewModelProvider.
        final ListViewModel viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        // Add an observer on the LiveData returned by getListLiveData.
        // The onChanged() method fires when the observed data changes
        Log.d("TAG", "observe");
        viewModel.getListLiveData().observe(this, new Observer<List<Drink>>() {
            @Override
            public void onChanged(@Nullable final List<Drink> drinks) {
                // Update the cached copy of the drinks in the adapter.
                if(list == null) {
                    list = drinks;
                    Log.d("TAG", "adapter set Drinks");
                    adapter.setDrinks(list);
                } else {
                    list = drinks;
//                    adapter.notifyDataSetChanged();
                }
            }
        });
    /*
     Set the Floating Action Button (FAB) to its corresponding View.
     Attach an OnClickListener to it, so that when it's clicked, a new intent will be created
     to launch the AddActivity.
    */
        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to start an AddTaskActivity
                Intent addIntent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(addIntent);
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
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                if(item.isEnabled()) drinkType = "Alcoholic";
//                adapter.notifyDataSetChanged();
//                recyclerView.invalidate();;
//                ListViewModel.class.newInstance().getListLiveData();
                return true;
            case R.id.soft_item:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                if(item.isEnabled()) drinkType = "No_Alcoholic";
                return true;
            case R.id.health_item:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                if(item.isEnabled()) drinkType = "Optional_Alcohol";
                return true;
            case R.id.fav_search:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                return true;
/*
            case R.id.ing_search:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                return false;
            case R.id.run_search:
                return true;
*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Initialize member variable for the data base
//    db = AppDB.getInstance(getApplicationContext());

     // Calculate number of columns in GridLayoutManager
    private static int calculateColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (dpWidth / DEFAULT_SIZE);
    }
}