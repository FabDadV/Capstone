package fdv.d.ui;

import java.util.List;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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
import fdv.d.data.db.Drink;
import fdv.d.vm.ListViewModel;

public class ListFragment extends Fragment {
    private ListViewModel viewModel;
    private List<Drink> list;
    private RecyclerView recyclerView;
    private ListAdapter adapter;

    public static ListFragment newInstance() { return new ListFragment(); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onCreateView");
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        // Get a new or existing ViewModel from the ViewModelProvider.
        final ListViewModel viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        // Add an observer on the LiveData returned by getList.
        // The onChanged() method fires when the observed data changes
        Log.d("TAG", "observe");
        viewModel.getList().observe(this, new Observer<List<Drink>>() {
            @Override
            public void onChanged(@Nullable final List<Drink> drinks) {
                // Update the cached copy of the drinks in the adapter.
                if(list == null) {
                    list = drinks;
                    adapter = new ListAdapter(list);
                    recyclerView.setAdapter(adapter);
                    Log.d("TAG", "adapter");
                } else {
                    list = drinks;
//                    adapter.notifyDataSetChanged();
                }
            }
        });
        return view;
    }
}
