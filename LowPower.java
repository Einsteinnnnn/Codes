public class LowPower extends SuperHero {

    public LowPower(String[] fields) {super(fields);}

    public static boolean meetsConditions(String[] fields) { return Integer.parseInt(fields[5]) < 30; }

    public int attack(SuperHero oHero){
        int damage = super.attack(oHero);

        damage -= super.attack(oHero) * 0.3 ;

        return damage;
    }

}
