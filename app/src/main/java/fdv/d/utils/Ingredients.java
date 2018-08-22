package fdv.d.utils;

import android.util.Log;
import fdv.d.data.db.Drink;

public class Ingredients {

    public static String getIngregientsList(Drink drink) {
        String s = new String();
        s = s + drink.getStrIngredient1() + "   " + drink.getStrMeasure1() + "\n";
        Log.d("TAG"," Ing:" + s);
        if(drink.getStrIngredient2().isEmpty()) return s;
        s = s + drink.getStrIngredient2() + "   " + drink.getStrMeasure2() + "\n";
        if(drink.getStrIngredient3().isEmpty()) return s;
        s = s + drink.getStrIngredient3() + "   " + drink.getStrMeasure3() + "\n";
        if(drink.getStrIngredient4().isEmpty()) return s;
        s = s + drink.getStrIngredient4() + "   " + drink.getStrMeasure4() + "\n";
        if(drink.getStrIngredient5().isEmpty()) return s;
        s = s + drink.getStrIngredient5() + "   " + drink.getStrMeasure5() + "\n";
        if(drink.getStrIngredient6().isEmpty()) return s;
        s = s + drink.getStrIngredient6() + "   " + drink.getStrMeasure6() + "\n";
        if(drink.getStrIngredient7().isEmpty()) return s;
        s = s + drink.getStrIngredient7() + "   " + drink.getStrMeasure7() + "\n";
        if(drink.getStrIngredient8().isEmpty()) return s;
        s = s + drink.getStrIngredient8() + "   " + drink.getStrMeasure8() + "\n";
        if(drink.getStrIngredient9().isEmpty()) return s;
        s = s + drink.getStrIngredient9() + "   " + drink.getStrMeasure9() + "\n";
        if(drink.getStrIngredient10().isEmpty()) return s;
        s = s + drink.getStrIngredient10() + "   " + drink.getStrMeasure10() + "\n";
        if(drink.getStrIngredient11().isEmpty()) return s;
        s = s + drink.getStrIngredient11() + "   " + drink.getStrMeasure11() + "\n";
        if(drink.getStrIngredient12().isEmpty()) return s;
        s = s + drink.getStrIngredient12() + "   " + drink.getStrMeasure12() + "\n";
        if(drink.getStrIngredient13().isEmpty()) return s;
        s = s + drink.getStrIngredient13() + "   " + drink.getStrMeasure13() + "\n";
        if(drink.getStrIngredient14().isEmpty()) return s;
        s = s + drink.getStrIngredient14() + "   " + drink.getStrMeasure14() + "\n";
        if(drink.getStrIngredient15().isEmpty()) return s;
        s = s + drink.getStrIngredient15() + "   " + drink.getStrMeasure15() + "\n";
    return s;
    }


}
