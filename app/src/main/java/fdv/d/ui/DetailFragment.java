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

import com.squareup.picasso.Picasso;

import fdv.d.App;
import fdv.d.R;
import fdv.d.data.api.ApiBuilder;
import fdv.d.data.db.Drink;
import fdv.d.vm.ListViewModel;
import fdv.d.data.api.QueryApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFragment extends Fragment {
//    public static final String BASE_URL = "https://"
    public static final String EXTRA_ID_DRINK = "id_drink";
    public static final String EXTRA_NAME = "name";
    private QueryApi queryApi;
    private Drink drink;

    public DetailFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        TextView tvIdDrink = view.findViewById(R.id.tv_id_drink);
        TextView tvDrink = view.findViewById(R.id.tv_drink);
        ImageView imageView = view.findViewById(R.id.imageView);
        String name = getActivity().getIntent().getStringExtra(EXTRA_NAME);
        String id_drink = getActivity().getIntent().getStringExtra(EXTRA_ID_DRINK);
        drink = new Drink();

        queryApi = ApiBuilder.getApi().create(QueryApi.class);
        queryApi.loadById(id_drink).enqueue(new Callback<Drink>() {
            @Override
            public void onResponse(Call<Drink> call, Response<Drink> response) {
                if (response.isSuccessful()) {
                    Log.d("API_ID"," is Successful");
                    drink.setName(response.body().getName());
                    drink.setThumb(response.body().getThumb());
                } else {
                    Log.e("API", "response code " + response.code());
                }
            }
            @Override
            public void onFailure(Call<Drink> call, Throwable t) {
                Log.e("API_ID", "Error: " + t.toString());
            }
        });
        String thumpURL = "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg";
        Picasso.get()
                .load(thumpURL)
                .error(R.drawable.bon_appetit)
                .into(imageView);
        tvIdDrink.setText(id_drink);
        tvDrink.setText(name);
/*
        String posterUrl = BASE_URL + thumbDrink;
        Picasso.get()
                .load(drink.getThumb())
                .placeholder(R.drawable.bon_appetit)
                .error(R.drawable.bon_appetit)
                .into(ivPoster);
*/
        return view;
    }
}
