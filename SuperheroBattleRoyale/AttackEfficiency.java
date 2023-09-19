public class AttackEfficiency extends AbsoluteStrength {

    public AttackEfficiency(String[] fields) { super(fields); }

    public static boolean meetsConditions(String[] fields){ return AbsoluteStrength.meetsConditions(fields) && SuperSpeed.meetsConditions(fields); }

    public int attack(SuperHero oHero){
        int damage = super.attack(oHero);

        int speed = super.getSpeed();
        int strength = super.getStrength();

        double attackEfficiency = (speed * strength / 10000);

        damage += this.getStrength() * 2 - oHero.getStrength();

        damage = (int) (attackEfficiency * damage);

        damage += damage;

        return damage;
    }


}
