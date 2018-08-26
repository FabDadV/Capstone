package fdv.d.data.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;

@Entity(tableName = "tab_drinks")
public class Drink implements Parcelable {
/*
    @PrimaryKey(autoGenerate = true)
    private int id;
*/
    @PrimaryKey
    @NonNull
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

    /* @return The IdDrink */
    public String getIdDrink() { return idDrink; }
    /* @param IdDrink */
    public void setIdDrink(String idDrink) { this.idDrink = idDrink; }
    /* @return Drink name */
    public String getStrDrink() { return strDrink; }
    /* @param strDrink */
    public void setStrDrink(String strDrink) { this.strDrink = strDrink; }

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

    public String getStrIngredient4() {return strIngredient4;}
    public void setStrIngredient4(String strIngredient4) {this.strIngredient4 = strIngredient4;}

    public String getStrIngredient5() {return strIngredient5;}
    public void setStrIngredient5(String strIngredient5) {this.strIngredient5 = strIngredient5;}

    public String getStrIngredient6() {return strIngredient6;}
    public void setStrIngredient6(String strIngredient6) {this.strIngredient6 = strIngredient6;}

    public String getStrIngredient7() {return strIngredient7;}
    public void setStrIngredient7(String strIngredient7) {this.strIngredient7 = strIngredient7;}

    public String getStrIngredient8() {return strIngredient8;}
    public void setStrIngredient8(String strIngredient8) {this.strIngredient8 = strIngredient8;}

    public String getStrIngredient9() {return strIngredient9;}
    public void setStrIngredient9(String strIngredient9) {this.strIngredient9 = strIngredient9;}

    public String getStrIngredient10() {return strIngredient10;}
    public void setStrIngredient10(String strIngredient10) {this.strIngredient10 = strIngredient10;}

    public String getStrIngredient11() {return strIngredient11;}
    public void setStrIngredient11(String strIngredient11) {this.strIngredient11 = strIngredient11;}

    public String getStrIngredient12() {return strIngredient12;}
    public void setStrIngredient12(String strIngredient12) {this.strIngredient12 = strIngredient12;}

    public String getStrIngredient13() {return strIngredient13;}
    public void setStrIngredient13(String strIngredient13) {this.strIngredient13 = strIngredient13;}

    public String getStrIngredient14() {return strIngredient14;}
    public void setStrIngredient14(String strIngredient14) {this.strIngredient14 = strIngredient14;}

    public String getStrIngredient15() {return strIngredient15;}
    public void setStrIngredient15(String strIngredient15) {this.strIngredient15 = strIngredient15;}

    public String getStrMeasure1() {return strMeasure1;}
    public void setStrMeasure1(String strMeasure1) {this.strMeasure1 = strMeasure1;}

    public String getStrMeasure2() {return strMeasure2;}
    public void setStrMeasure2(String strMeasure2) {this.strMeasure2 = strMeasure2;}

    public String getStrMeasure3() {return strMeasure3;}
    public void setStrMeasure3(String strMeasure3) {this.strMeasure3 = strMeasure3;}

    public String getStrMeasure4() {return strMeasure4;}
    public void setStrMeasure4(String strMeasure4) {this.strMeasure4 = strMeasure4;}

    public String getStrMeasure5() {return strMeasure5;}
    public void setStrMeasure5(String strMeasure5) {this.strMeasure5 = strMeasure5;}

    public String getStrMeasure6() {return strMeasure6;}
    public void setStrMeasure6(String strMeasure6) {this.strMeasure6 = strMeasure6;}

    public String getStrMeasure7() {return strMeasure7;}
    public void setStrMeasure7(String strMeasure7) {this.strMeasure7 = strMeasure7;}

    public String getStrMeasure8() {return strMeasure8;}
    public void setStrMeasure8(String strMeasure8) {this.strMeasure8 = strMeasure8;}

    public String getStrMeasure9() {return strMeasure9;}
    public void setStrMeasure9(String strMeasure9) {this.strMeasure9 = strMeasure9;}

    public String getStrMeasure10() {return strMeasure10;}
    public void setStrMeasure10(String strMeasure10) {this.strMeasure10 = strMeasure10;}

    public String getStrMeasure11() {return strMeasure11;}
    public void setStrMeasure11(String strMeasure11) {this.strMeasure11 = strMeasure11;}

    public String getStrMeasure12() {return strMeasure12;}
    public void setStrMeasure12(String strMeasure12) {this.strMeasure12 = strMeasure12;}

    public String getStrMeasure13() {return strMeasure13;}
    public void setStrMeasure13(String strMeasure13) {this.strMeasure13 = strMeasure13;}

    public String getStrMeasure14() {return strMeasure14;}
    public void setStrMeasure14(String strMeasure14) {this.strMeasure14 = strMeasure14;}

    public String getStrMeasure15() {return strMeasure15;}
    public void setStrMeasure15(String strMeasure15) {this.strMeasure15 = strMeasure15;}

    public Drink getDrink(Drink drink) {return drink;}

    public Drink() {}

    public Drink(@NonNull String idDrink, String srtDrink, String strDrinkThumb, String strCategory,
                 String strIBA, String strAlcoholic, String strInstructions, String dateModified,
                 String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4,
                 String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8,
                 String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12,
                 String strIngredient13, String strIngredient14, String strIngredient15,
                 String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4,
                 String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8,
                 String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12,
                 String strMeasure13, String strMeasure14, String strMeasure15) {

        this.idDrink = idDrink;
        this.strDrink = srtDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.strCategory = strCategory;
        this.strIBA = strIBA;
        this.strAlcoholic = strAlcoholic;
        this.strInstructions = strInstructions;
        this.dateModified = dateModified;

        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
    }

    private Drink(Parcel in) {
        this.idDrink = in.readString();
        this.strDrink = in.readString();
        this.strDrinkThumb = in.readString();
        this.strCategory = in.readString();
        this.strIBA = in.readString();
        this.strAlcoholic = in.readString();
        this.strInstructions = in.readString();
        this.dateModified = in.readString();

        this.strIngredient1 = in.readString();
        this.strIngredient2 = in.readString();
        this.strIngredient3 = in.readString();
        this.strIngredient4 = in.readString();
        this.strIngredient5 = in.readString();
        this.strIngredient6 = in.readString();
        this.strIngredient7 = in.readString();
        this.strIngredient8 = in.readString();
        this.strIngredient9 = in.readString();
        this.strIngredient10 = in.readString();
        this.strIngredient11 = in.readString();
        this.strIngredient12 = in.readString();
        this.strIngredient13 = in.readString();
        this.strIngredient14 = in.readString();
        this.strIngredient15 = in.readString();
        
        this.strMeasure1 = in.readString();
        this.strMeasure2 = in.readString();
        this.strMeasure3 = in.readString();
        this.strMeasure4 = in.readString();
        this.strMeasure5 = in.readString();
        this.strMeasure6 = in.readString();
        this.strMeasure7 = in.readString();
        this.strMeasure8 = in.readString();
        this.strMeasure9 = in.readString();
        this.strMeasure10 = in.readString();
        this.strMeasure11 = in.readString();
        this.strMeasure12 = in.readString();
        this.strMeasure13 = in.readString();
        this.strMeasure14 = in.readString();
        this.strMeasure15 = in.readString();

/*
        in.readStringArray(new String[]{this.idDrink, this.strDrink, this.strDrinkThumb,
                this.strCategory, this.strIBA, this.strAlcoholic, this.strInstructions, this.dateModified,
                strIngredient1, this.strIngredient2, this.strIngredient3, this.strIngredient4,
                this.strIngredient5, this.strIngredient6, this.strIngredient7, this.strIngredient8,
                strIngredient9, this.strIngredient10, this.strIngredient11, this.strIngredient12,
                this.strIngredient13, this.strIngredient14, this.strIngredient15,
                strMeasure1, this.strMeasure2, this.strMeasure3, this.strMeasure4,
                this.strMeasure5, this.strMeasure6, this.strMeasure7, this.strMeasure8,
                strMeasure9, this.strMeasure10, this.strMeasure11, this.strMeasure12,
                this.strMeasure13, this.strMeasure14, this.strMeasure15});
*/
        Log.d("TAG", "in: " + this.idDrink + " : " + this.strDrink);
    }
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(idDrink);
        out.writeString(strDrink);
        out.writeString(strDrinkThumb);
        out.writeString(strCategory);
        out.writeString(strIBA);
        out.writeString(strAlcoholic);
        out.writeString(strInstructions);
        out.writeString(dateModified);
        out.writeString(strIngredient1);
        out.writeString(strIngredient2);
        out.writeString(strIngredient3);
        out.writeString(strIngredient4);
        out.writeString(strIngredient5);
        out.writeString(strIngredient6);
        out.writeString(strIngredient7);
        out.writeString(strIngredient8);
        out.writeString(strIngredient9);
        out.writeString(strIngredient10);
        out.writeString(strIngredient11);
        out.writeString(strIngredient12);
        out.writeString(strIngredient13);
        out.writeString(strIngredient14);
        out.writeString(strIngredient15);
        out.writeString(strMeasure1);
        out.writeString(strMeasure2);
        out.writeString(strMeasure3);
        out.writeString(strMeasure4);
        out.writeString(strMeasure5);
        out.writeString(strMeasure6);
        out.writeString(strMeasure7);
        out.writeString(strMeasure8);
        out.writeString(strMeasure9);
        out.writeString(strMeasure10);
        out.writeString(strMeasure11);
        out.writeString(strMeasure12);
        out.writeString(strMeasure13);
        out.writeString(strMeasure14);
        out.writeString(strMeasure15);
/*
        out.writeStringArray(new String[] {idDrink, strDrink, strDrinkThumb, strCategory,
                strIBA, strAlcoholic, strInstructions, dateModified,
                strIngredient1, strIngredient2, strIngredient3, strIngredient4,
                strIngredient5, strIngredient6, strIngredient7, strIngredient8,
                strIngredient9, strIngredient10, strIngredient11, strIngredient12,
                strIngredient13, strIngredient14, strIngredient15,
                strMeasure1, strMeasure2, strMeasure3, strMeasure4,
                strMeasure5, strMeasure6, strMeasure7, strMeasure8,
                strMeasure9, strMeasure10, strMeasure11, strMeasure12,
                strMeasure13, strMeasure14, strMeasure15});
*/
    }
    @Override
    public int describeContents() {
        return 0;
    }
    // Creator for Parcelable object
    public static final Parcelable.Creator<Drink> CREATOR = new Parcelable.Creator<Drink>() {
            @Override
            public Drink createFromParcel(Parcel parcel) {
                return new Drink(parcel);
            }
            @Override
            public Drink[] newArray(int size) {
                return new Drink[size];
            }
        };
}