public class MasterMind extends SuperHero{

    public MasterMind(String[] fields) {
        super(fields);
    }

    public static boolean meetsConditions(String[] fields){ return Integer.parseInt(fields[1]) > 90; }

    public int attack(SuperHero oHero){
        int damage = super.attack(oHero);

        damage += this.getIntelligence() * 1.5 - oHero.getIntelligence();

        return damage;
    }

}
