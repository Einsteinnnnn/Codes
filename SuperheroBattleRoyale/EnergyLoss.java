public class EnergyLoss extends GenderAffect {

    public EnergyLoss(String[] fields) { super(fields); }

    public static boolean meetsConditions(String[] fields) { return GenderAffect.meetsConditions(fields) && !LowPower.meetsConditions(fields); }

    public int attack(SuperHero oHero) {
        int damage = super.attack(oHero);

        double energyLossModulus = (((100-super.getStrength())+super.getDurability()*1.1)/200);

        damage += super.attack(oHero) * 0.2;

        damage = (int) (damage * energyLossModulus);

        return damage;

    }


}
