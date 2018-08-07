package fdv.d.data.db;

import java.util.List;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface IngredientDao {
    @Query("SELECT * FROM tab_ings")
    List<Ingredient> getAll();

    @Query("SELECT * FROM tab_ings WHERE id = :id")
    Ingredient getById(int id);
/*
    @Query("SELECT * FROM tab_ings WHERE id = :id")
    LiveData<Ingredient> loadById(int id);
*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Ingredient> ingredientsList);
}
