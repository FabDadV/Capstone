package fdv.d.data.db;

import java.util.List;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.util.Log;

@Dao
public interface DrinkDao {
/*
    @Query("SELECT * FROM tab_drinks WHERE id = :id")
    Drink getById(int id);
*/
    @Query("SELECT * FROM tab_drinks ORDER BY strDrink")
    List<Drink> getAll();

    @Query("SELECT * FROM tab_drinks")
    LiveData<List<Drink>> loadAll();

    @Query("SELECT * FROM tab_drinks WHERE idDrink = :idDrink")
    Drink getByIdDrink(String idDrink);

    @Query("SELECT idDrink FROM tab_drinks WHERE idDrink LIKE :s ORDER BY idDrink")
    List<String> getListIdDrink(String s);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Drink> drinksList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDrink(Drink drink);

    @Delete
    void deleteDrink(Drink drink);
}