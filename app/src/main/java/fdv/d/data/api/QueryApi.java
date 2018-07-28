package fdv.d.data.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QueryApi {
    // https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic,Non_Alcoholic,Optional_Alcohol
    @GET("filter.php")
    Call<DrinksList> getData(@Query("a") String drinkType);
}