package fdv.d;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.google.android.gms.ads.MobileAds;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import fdv.d.data.db.AppDB;
import fdv.d.data.api.QueryApi;
// Android Application class. Used for accessing singletons.
public final class App extends Application {
// Favorite https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic Non_Alcoholic Optional_Alcohol
    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";
    public static final String HEALTHY_TYPE = "Optional_Alcohol";
    public static final String SOFT_TYPE = "Non_Alcoholic";
    public static final String STRONG_TYPE = "Alcoholic";
    public static final String FAVORITE = "Favorite";

    public static AppExecutors appExecutors;
    public static Context appContext;
    public static AppDB appDB;
    public static String drinkType = HEALTHY_TYPE;
    public static boolean doReset = false;
    private static QueryApi queryApi;

    @Override
    public void onCreate() {
        super.onCreate();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер JSON'а в объекты Gson
                .build();
        queryApi = retrofit.create(QueryApi.class); //Создаем объект, при помощи которого будем выполнять запросы

        appContext = getApplicationContext();
        appExecutors = AppExecutors.getInstance();
        Log.d("TAG", "App: Creating new DB instance");
        appDB = AppDB.getInstance();

        Stetho.initializeWithDefaults(this);
//        MobileAds.initialize(this, "ca-app-pub-2448051017659216~5516415096");

    }
    public static QueryApi getApi() { return queryApi; }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }
}