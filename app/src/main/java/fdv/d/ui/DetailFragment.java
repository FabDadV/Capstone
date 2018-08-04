package fdv.d.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.squareup.picasso.Picasso;

import fdv.d.App;
import fdv.d.R;
import fdv.d.data.db.Drink;
import fdv.d.data.api.DrinksList;

public class DetailFragment extends Fragment {
    public static final String EXTRA_ID_DRINK = "id_drink";
    public static final String EXTRA_PATH = "path_drink";
    private TextView tvDrink;
    private TextView tvCategory;
    private TextView tvInstruction;

    public DetailFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        ImageView drinkView = view.findViewById(R.id.iv_drink);
        TextView tvIdDrink = view.findViewById(R.id.tv_id_drink);
        tvDrink = view.findViewById(R.id.tv_drink);
        tvCategory = view.findViewById(R.id.tv_cat);
        tvInstruction = view.findViewById(R.id.tv_text);

        String id_drink = getActivity().getIntent().getStringExtra(EXTRA_ID_DRINK);
        String path_drink = getActivity().getIntent().getStringExtra(EXTRA_PATH);
// https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=13060
        App.getApi().loadById(id_drink).enqueue(new Callback<DrinksList>() {
            @Override
            public void onResponse(Call<DrinksList> call, Response<DrinksList> response) {
                if (response.isSuccessful()) {
                    Log.d("API_ID"," is Ok");
                    Drink drink = response.body().getList().get(0);
                    tvDrink.setText(drink.getName());
                    tvCategory.setText(drink.getStrCategory());
                    tvInstruction.setText(drink.getStrInstructions());
                } else {
                    Log.e("API", "response code " + response.code());
                }
            }
            @Override
            public void onFailure(Call<DrinksList> call, Throwable t) {
                Log.e("API_ID", "Error: " + t.toString());
            }
        });
        tvIdDrink.setText(id_drink);
        Picasso.get()
                .load(path_drink)
                .placeholder(R.drawable.no_drink)
                .error(R.drawable.err_drink)
                .into(drinkView);
        return view;
    }
}
