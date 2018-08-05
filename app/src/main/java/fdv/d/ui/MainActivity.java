package fdv.d.ui;

import java.util.List;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import fdv.d.R;
import fdv.d.data.db.Drink;
import fdv.d.vm.ListViewModel;

import static fdv.d.ui.DetailFragment.EXTRA_ID_DRINK;
import static fdv.d.ui.DetailFragment.EXTRA_PATH;

public class MainActivity extends AppCompatActivity implements ListAdapter.ItemClickListener {
    private ListViewModel viewModel;
    private List<Drink> list;
    private RecyclerView recyclerView;
    private ListAdapter.ItemClickListener listener;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Log.d("TAG", "onCreateView");
        recyclerView = findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
}
