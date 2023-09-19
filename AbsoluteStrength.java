public class AbsoluteStrength extends SuperHero{

    public AbsoluteStrength(String[] fields) { super(fields); }

    public static boolean meetsConditions(String[] fields){ return Integer.parseInt(fields[2]) > 90; }

    public int attack(SuperHero oHero){
        int damage = super.attack(oHero);

        damage += this.getStrength() * 2 - oHero.getStrength() ;

        return damage;
    }

}
