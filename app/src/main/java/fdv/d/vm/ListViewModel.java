package fdv.d.vm;

import java.util.List;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import fdv.d.data.api.ApiBuilder;
import fdv.d.data.api.DrinksList;
import fdv.d.data.api.QueryApi;
import fdv.d.data.db.Drink;

public class ListViewModel extends AndroidViewModel {
    private MutableLiveData<List<Drink>> listLiveData;
    private QueryApi queryApi;

    public ListViewModel(@NonNull Application application) {
        super(application);
        queryApi = ApiBuilder.getApi().create(QueryApi.class);
    }

    public LiveData<List<Drink>> getList() {
        if (listLiveData == null) {
            listLiveData = new MutableLiveData<>();

            queryApi.getData("Optional_Alcohol").enqueue(new Callback<DrinksList>() {
                @Override
                public void onResponse(Call<DrinksList> call, Response<DrinksList> response) {
                    //Данные успешно пришли, но надо проверить response.body() на null
                    if (response.isSuccessful()) {
                        Log.d("TAG", "API is Successful");
                        listLiveData.setValue(response.body().getDrinks());
                    } else {
                        Log.e("TAG", "response code " + response.code());
                    }
                }
                @Override
                public void onFailure(Call<DrinksList> call, Throwable t) {
                    //Проверка на ошибку
                    Log.e("TAG", "Error: " + t.toString());
//                    Toast.makeText(getContext(),"An error occurred during networking", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return listLiveData;
    }
}
