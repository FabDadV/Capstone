package fdv.d.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tab_ings")
public class Ingredient {
    @PrimaryKey
    private int id;
    private String ingName;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getIngName() {return ingName;}
    public void setIngName(String ingName) {this.ingName = ingName;}
}
