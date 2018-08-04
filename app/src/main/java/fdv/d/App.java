package fdv.d;

import android.app.Application;
import com.facebook.stetho.Stetho;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import fdv.d.data.api.QueryApi;

public final class App extends Application {
    // https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic Non_Alcoholic Optional_Alcohol
    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private static QueryApi queryApi;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер JSON'а в объекты Gson
                .build();
        queryApi = retrofit.create(QueryApi.class); //Создаем объект, при помощи которого будем выполнять запросы
    }
    public static QueryApi getApi() { return queryApi; }
}