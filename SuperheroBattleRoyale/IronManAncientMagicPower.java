
public class IronManAncientMagicPower extends SuperHero {

    public IronManAncientMagicPower(String[] fields) {super(fields);}

    public static boolean meetsConditions(String[] fields){ return String.valueOf(fields[0]).equals("Iron Man"); }

    public static boolean whetherHavePower() {

        double a = 100 * Math.random();

        return a <= 33.333333;

    }

    public int attack(SuperHero oHero){
        int damage = super.attack(oHero);

        if (whetherHavePower()) {
            damage = 300;
        }

        return damage;
    }




}
