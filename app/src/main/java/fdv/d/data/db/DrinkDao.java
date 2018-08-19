package fdv.d.data.db;

import java.util.List;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface DrinkDao {
    @Query("SELECT * FROM tab_drinks")
    LiveData<List<Drink>> loadAll();

    @Query("SELECT * FROM tab_drinks WHERE id = :id")
    Drink getById(int id);

    @Query("SELECT * FROM tab_drinks WHERE idDrink = :idDrink")
    Drink getByIdDrink(String idDrink);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Drink> drinksList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDrink(Drink drink);
}