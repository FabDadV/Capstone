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

    private String strCategory;
    private String strIBA;
    private String strAlcoholic;
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
/*
    // @return Site description
    public String getThumb() { return strDrinkThumb; }
    // @param desc Site description
    public void setThumb(String strDrinkThumb) { this.strDrinkThumb = strDrinkThumb; }
*/
    public String getStrDrinkThumb() {return strDrinkThumb;}
    public void setStrDrinkThumb(String strDrinkThumb) {this.strDrinkThumb = strDrinkThumb;}

    public String getStrCategory() {return strCategory;}
    public void setStrCategory(String strCategory) {this.strCategory = strCategory;}

    public String getStrIBA() {return strIBA;}
    public void setStrIBA(String strIBA) {this.strIBA = strIBA;}

    public String getStrAlcoholic() {return strAlcoholic;}
    public void setStrAlcoholic(String strAlcoholic) {this.strAlcoholic = strAlcoholic;}

    public String getStrInstructions() {return strInstructions;}
    public void setStrInstructions(String strInstructions) {this.strInstructions = strInstructions;}

    public String getDateModified() {return dateModified;}
    public void setDateModified(String dateModified) {this.dateModified = dateModified;}

    public String getStrIngredient1() {return strIngredient1;}
    public void setStrIngredient1(String strIngredient1) {this.strIngredient1 = strIngredient1;}

    public String getStrIngredient2() {return strIngredient2;}
    public void setStrIngredient2(String strIngredient2) {this.strIngredient2 = strIngredient2;}

    public String getStrIngredient3() {return strIngredient3;}
    public void setStrIngredient3(String strIngredient3) {this.strIngredient3 = strIngredient3;}

    public String getStrMeasure1() {return strMeasure1;}
    public void setStrMeasure1(String strMeasure1) {this.strMeasure1 = strMeasure1;}

    public String getStrMeasure2() {return strMeasure2;}
    public void setStrMeasure2(String strMeasure2) {this.strMeasure2 = strMeasure2;}

    public String getStrMeasure3() {return strMeasure3;}
    public void setStrMeasure3(String strMeasure3) {this.strMeasure3 = strMeasure3;}
}

