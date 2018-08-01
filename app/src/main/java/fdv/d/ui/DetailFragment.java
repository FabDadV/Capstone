package fdv.d.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fdv.d.R;
import fdv.d.vm.ListViewModel;

public class DetailFragment extends Fragment {
    public static final String EXTRA_ID_DRINK = "id_drink";
    public static final String EXTRA_NAME = "name";
    private ListViewModel viewModel;

    public DetailFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        TextView tvIdDrink = view.findViewById(R.id.tv_id_drink);
        TextView tvDrink = view.findViewById(R.id.tv_drink);
/*
        tvIdDrink.setText("58325");
        tvDrink.setText("More better drink");
*/

        String name = getActivity().getIntent().getStringExtra(EXTRA_NAME);
        String id_drink = getActivity().getIntent().getStringExtra(EXTRA_ID_DRINK);
        tvIdDrink.setText(id_drink);
        tvDrink.setText(name);
        return view;
    }
}
