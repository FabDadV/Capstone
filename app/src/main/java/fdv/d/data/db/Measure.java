package fdv.d.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tab_meas")
public class Measure {
    @PrimaryKey
    private int id;
    private int idDrink;
    private int idIngredient;
    private String measure;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getIdDrink() {return idDrink;}
    public void setIdDrink(int idDrink) {this.idDrink = idDrink;}

    public int getIdIngredient() {return idIngredient;}
    public void setIdIngredient(int idIngredient) {this.idIngredient = idIngredient;}

    public String getMeasure() {return measure;}
    public void setMeasure(String measure) {this.measure = measure;}
}
