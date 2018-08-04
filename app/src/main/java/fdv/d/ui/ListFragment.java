package fdv.d.ui;

import java.util.List;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fdv.d.R;
import fdv.d.ui.ListAdapter.ItemClickListener;
import fdv.d.data.db.Drink;
import fdv.d.vm.ListViewModel;

import static fdv.d.ui.DetailFragment.EXTRA_ID_DRINK;
import static fdv.d.ui.DetailFragment.EXTRA_PATH;

public class ListFragment extends Fragment implements ItemClickListener {
    private ListViewModel viewModel;
    private List<Drink> list;
    private RecyclerView recyclerView;
    private ItemClickListener listener;
    private ListAdapter adapter;

    public ListFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onCreateView");
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        final Context context = getActivity();
        recyclerView = view.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
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
        return view;
    }
    // Override method in order to handle RecyclerView item clicks.
    @Override
    public void onItemClickListener(String idDrink, String pathDrink) {
        Log.d("TAG","Item: " + idDrink + pathDrink);
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        // Pass the data to the DetailActivity
        intent.putExtra(EXTRA_ID_DRINK, idDrink);
        intent.putExtra(EXTRA_PATH, pathDrink);
        startActivity(intent);
    }
}
