package fdv.d.data.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QueryApi {
    @GET("filter.php")
    Call<DrinksList> loadData(@Query("a") String drinkType);

    @GET("lookup.php")
    Call<DrinksList> loadById(@Query("i") String drinkId);
}