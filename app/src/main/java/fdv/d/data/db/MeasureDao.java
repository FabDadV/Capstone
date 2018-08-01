package fdv.d.data.db;

import java.util.List;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface MeasureDao {
    @Query("SELECT * FROM tab_meas")
    List<Measure> getAll();

    @Query("SELECT * FROM tab_meas WHERE id = :id")
    LiveData<Measure> loadById(int id);

    @Query("SELECT * FROM tab_meas WHERE id = :id")
    Measure getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Drink> measuresList);
}
