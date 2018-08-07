package fdv.d.data.db;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

@Database(entities = {Drink.class, Ingredient.class, Measure.class}, version = 1, exportSchema = false)
public abstract class AppDB extends RoomDatabase {
    public static final String DATABASE_NAME = "cocktails";
    public abstract DrinkDao drinkDao();
    public abstract IngredientDao ingredientDao();
    public abstract MeasureDao measureDao();
    private final MutableLiveData<Boolean> isDatabaseCreated = new MutableLiveData<>();
    private static AppDB sInstance;

    public static AppDB getInstance(Context context) {
        if (sInstance == null) {
            synchronized (AppDB.class) {
                Log.d("TAG", " Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDB.class, AppDB.DATABASE_NAME)
                        .build();
            }
        }
        Log.d("TAG", " Getting the database instance");
        return sInstance;
    }
    /* Queries should be done in a separate thread to avoid locking the UI.*/
}
