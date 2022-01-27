public class GenderAffect extends SuperHero{

    public GenderAffect(String[] fields) {super(fields);}

    public static boolean meetsConditions(String[] fields){ return String.valueOf(fields[9]).equals("Male"); }

    public int attack(SuperHero oHero){
        int damage = super.attack(oHero);

        damage += super.attack(oHero) * 0.2 ;

        return damage;
    }

}
