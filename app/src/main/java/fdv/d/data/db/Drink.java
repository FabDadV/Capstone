package fdv.d.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tab_drinks")
public class Drink {
    @PrimaryKey
    private int id;

    private String idDrink;
    private String strDrink;
    private String strDrinkThumb;

    private Object strVideo;
    private String strCategory;
    private String strIBA;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
    private String dateModified;

    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;

    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;

    /* @return The Id */
    public String getId() { return idDrink; }
    /* @param Id */
    public void setId(String idDrink) { this.idDrink = idDrink; }
    /* @return Drink name */
    public String getName() { return strDrink; }
    /* @param strDrink */
    public void setName(String strDrink) { this.strDrink = strDrink; }
    /* @return Site description */
    public String getThumb() { return strDrinkThumb; }
    /* @param desc Site description */
    public void setThumb(String strDrinkThumb) { this.strDrinkThumb = strDrinkThumb; }
}

