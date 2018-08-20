package fdv.d.data.db;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.util.Log;

import static fdv.d.App.appContext;
import static fdv.d.App.appDB;

@Database(entities = {Drink.class, Ingredient.class, Measure.class}, version = 1, exportSchema = false)
public abstract class AppDB extends RoomDatabase {
    public static final String DATABASE_NAME = "cocktails";
    public abstract DrinkDao drinkDao();
    public abstract IngredientDao ingredientDao();
    public abstract MeasureDao measureDao();
    private final MutableLiveData<Boolean> isDatabaseCreated = new MutableLiveData<>();

    public static AppDB getInstance() {
        if (appDB == null) {
            synchronized (AppDB.class) {
                Log.d("TAG", "AppDB: Creating new DB instance");
                appDB = Room.databaseBuilder(appContext.getApplicationContext(),
                        AppDB.class, AppDB.DATABASE_NAME)
                        .build();
            }
        }
        Log.d("TAG", "AppDB: Getting the DB instance");
        return appDB;
    }
    /* Queries should be done in a separate thread to avoid locking the UI.*/
}
