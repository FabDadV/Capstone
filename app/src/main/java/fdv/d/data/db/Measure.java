package fdv.d.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tab_meas")
public class Measure {
    @PrimaryKey
    private int id;
    private String measure;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getMeasure() {return measure;}
    public void setMeasure(String measure) {this.measure = measure;}
}
