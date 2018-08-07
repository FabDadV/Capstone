package fdv.d.data.db;

import java.util.List;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface MeasureDao {
    @Query("SELECT * FROM tab_meas WHERE idDrink = :idDrink")
    List<Measure> getAll(int idDrink);

    @Query("SELECT * FROM tab_meas WHERE idDrink = :idDrink and idIngredient = :idIng")
    Measure getById(int idDrink, int idIng);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Drink> measuresList);
}
