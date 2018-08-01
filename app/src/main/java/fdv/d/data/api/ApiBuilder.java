package fdv.d.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {
    // https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic Non_Alcoholic Optional_Alcohol
    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";
    public static final String DRINK_TYPE = "Non_Alcoholic";
    private static Retrofit retrofit = null;

    private ApiBuilder() { }

    public static Retrofit getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
