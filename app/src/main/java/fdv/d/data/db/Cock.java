package fdv.d.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tab_cocks")
public class Cock {
    @PrimaryKey
    private int id;

    private String idDrink;
    private String strDrink;
    private String strDrinkThumb;

    private String strCategory;
    private String strIBA;
    private String strAlcoholic;
    private String strInstructions;
    private String dateModified;

    /* @return The Id */
    public String getId() { return idDrink; }
    /* @param Id */
    public void setId(String idDrink) { this.idDrink = idDrink; }
    /* @return Drink name */
    public String getName() { return strDrink; }
    /* @param strDrink */
    public void setName(String strDrink) { this.strDrink = strDrink; }

    public String getStrDrinkThumb() {return strDrinkThumb;}
    public void setStrDrinkThumb(String strDrinkThumb) {this.strDrinkThumb = strDrinkThumb;}
}

