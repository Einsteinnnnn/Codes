public class SuperSpeed extends SuperHero{

    public SuperSpeed(String[] fields) {
        super(fields);
    }

    public static boolean meetsConditions(String[] fields){
        return Integer.parseInt(fields[3]) > 90;
    }

    public int attack(SuperHero oHero){
        int damage = super.attack(oHero);

        damage += this.getCombat();

        return damage;
    }

}