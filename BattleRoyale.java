import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class BattleRoyale {
    public static void main(String[] args) throws IOException {

        ArrayList<SuperHero> theHeroes = SuperHero.readDataFile("SuperheroDataset.csv");
        PrintWriter writer;
        writer = new PrintWriter("results.txt");

        int goodWin = 0, goodLose = 0, goodTie = 0;
        int badWin = 0, badLose = 0, badTie = 0;
        int neutralWin = 0, neutralLose = 0, neutralTie = 0;

        int size = 7;
        int[] subClassWin = new int[size];
        int[] subClassLose = new int[size];
        int[] subClassTie = new int[size];

        String[] subClassName = new String[size];
        subClassName[0] = "IronManAncientMagicPower";
        subClassName[1] = "AttackEfficiency";
        subClassName[2] = "AbsoluteStrength";
        subClassName[3] = "SuperSpeed";
        subClassName[4] = "EnergyLoss";
        subClassName[5] = "GenderAffect";
        subClassName[6] = "LowPower";

        int heroSize = theHeroes.size();
        String[] heroName = new String[heroSize];
        int[] heroWin = new int[heroSize];
        int[] heroLose = new int[heroSize];
        int[] heroTie = new int[heroSize];

        for (int i = 0; i <theHeroes.size(); i++ ){
            heroName[i] = theHeroes.get(i).getName();
        }

        try {
                for (int i = 0; i < theHeroes.size(); i++) {

                    for (int j = i + 1; j < theHeroes.size(); j++) {
                    double number;
                    String alignmentI = theHeroes.get(i).getAlignment();
                    String alignmentJ = theHeroes.get(j).getAlignment();

                    if (String.valueOf(theHeroes.get(i).getAlignment()).equals("good") && String.valueOf(theHeroes.get(j).getAlignment()).equals("good")) { continue; }
                    else { number = theHeroes.get(i).attack(theHeroes.get(j)) - theHeroes.get(j).attack(theHeroes.get(i)) ; }

                    if (number > 0) {

                        switch (alignmentI) {
                            case "good" -> {
                                goodWin++;
                                heroWin[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassWin[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassWin[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassWin[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassWin[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassWin[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassWin[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassWin[6] ++;}

                            }
                            case "bad" -> {
                                badWin++;
                                heroWin[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassWin[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassWin[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassWin[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassWin[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassWin[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassWin[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassWin[6] ++;}

                            }
                            case "neutral" -> {
                                neutralWin++;
                                heroWin[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassWin[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassWin[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassWin[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassWin[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassWin[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassWin[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassWin[6] ++;}

                            }
                        }

                        switch (alignmentJ) {
                            case "good" -> {
                                goodLose++;
                                heroLose[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassLose[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassLose[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassLose[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassLose[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassLose[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassLose[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassLose[6] ++;}


                            }
                            case "bad" -> {
                                badLose++;
                                heroLose[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassLose[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassLose[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassLose[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassLose[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassLose[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassLose[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassLose[6] ++;}

                            }

                            case "neutral" -> {
                                neutralLose++;
                                heroLose[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassLose[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassLose[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassLose[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassLose[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassLose[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassLose[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassLose[6] ++;}
                            }
                        }

                    }


                    if (number < 0) {

                        switch (alignmentJ) {
                            case "good" -> {
                                goodWin++;
                                heroWin[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassWin[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassWin[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassWin[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassWin[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassWin[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassWin[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassWin[6] ++;}
                            }

                            case "bad" -> {
                                badWin++;
                                heroWin[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassWin[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassWin[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassWin[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassWin[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassWin[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassWin[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassWin[6] ++;}
                            }

                            case "neutral" -> {
                                neutralWin++;
                                heroWin[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassWin[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassWin[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassWin[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassWin[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassWin[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassWin[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassWin[6] ++;}
                            }
                        }

                        switch (alignmentI) {
                            case "good" -> {
                                goodLose++;
                                heroLose[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassLose[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassLose[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassLose[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassLose[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassLose[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassLose[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassLose[6] ++;}
                            }

                            case "bad" -> {
                                badLose++;
                                heroLose[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassLose[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassLose[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassLose[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassLose[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassLose[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassLose[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassLose[6] ++;}
                            }

                            case "neutral" -> {
                                neutralLose++;
                                heroLose[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassLose[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassLose[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassLose[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassLose[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassLose[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassLose[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassLose[6] ++;}
                            }
                        }

                      }


                    if (number == 0){

                        switch (alignmentI) {
                            case "good" -> {
                                goodTie++;
                                heroTie[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassTie[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassTie[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassTie[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassTie[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassTie[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassTie[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassTie[6] ++;}
                            }

                            case "bad" -> {
                                badTie++;
                                heroTie[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassTie[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassTie[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassTie[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassTie[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassTie[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassTie[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassTie[6] ++;}
                            }

                            case "neutral" -> {
                                neutralTie++;
                                heroTie[i]++;

                                if (theHeroes.get(i) instanceof IronManAncientMagicPower ) {subClassTie[0] ++;}
                                else if (theHeroes.get(i) instanceof AttackEfficiency ) {subClassTie[1] ++;}
                                else if (theHeroes.get(i) instanceof AbsoluteStrength ) {subClassTie[2] ++;}
                                else if (theHeroes.get(i) instanceof SuperSpeed ) {subClassTie[3] ++;}
                                else if (theHeroes.get(i) instanceof EnergyLoss ) {subClassTie[4] ++;}
                                else if (theHeroes.get(i) instanceof GenderAffect ) {subClassTie[5] ++;}
                                else if (theHeroes.get(i) instanceof LowPower ) {subClassTie[6] ++;}
                            }
                        }

                        switch (alignmentJ) {
                            case "good" -> {
                                goodTie++;
                                heroTie[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassTie[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassTie[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassTie[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassTie[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassTie[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassTie[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassTie[6] ++;}
                            }
                            case "bad" -> {
                                badTie++;
                                heroTie[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassTie[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassTie[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassTie[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassTie[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassTie[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassTie[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassTie[6] ++;}
                            }
                            case "neutral" -> {
                                neutralTie++;
                                heroTie[j]++;

                                if (theHeroes.get(j) instanceof IronManAncientMagicPower ) {subClassTie[0] ++;}
                                else if (theHeroes.get(j) instanceof AttackEfficiency ) {subClassTie[1] ++;}
                                else if (theHeroes.get(j) instanceof AbsoluteStrength ) {subClassTie[2] ++;}
                                else if (theHeroes.get(j) instanceof SuperSpeed ) {subClassTie[3] ++;}
                                else if (theHeroes.get(j) instanceof EnergyLoss ) {subClassTie[4] ++;}
                                else if (theHeroes.get(j) instanceof GenderAffect ) {subClassTie[5] ++;}
                                else if (theHeroes.get(j) instanceof LowPower ) {subClassTie[6] ++;}
                            }
                        }

                    }

                }
            }

                writer.println("***************************First Part***************************");
                writer.printf("%n");
                writer.printf("%-40s" + "%-10s" + "%-10s" + "%-10s%n", "Alignment", "Win", "Lose", "Tie" );
                writer.printf("%n%n");
                writer.printf("%-40s" + "%-10s" + "%-10s" + "%-10s%n", "Good", goodWin, goodLose, goodTie);
                writer.printf("%-40s" + "%-10s" + "%-10s" + "%-10s%n", "Bad", badWin, badLose, badTie);
                writer.printf("%-40s" + "%-10s" + "%-10s" + "%-10s%n", "Neutral", neutralWin, neutralLose, neutralTie);

                if (goodWin > badWin && goodWin > neutralWin) {
                writer.printf("%-40s", "Good superhero wins the most.");}

                else if (badWin > goodWin && badWin > neutralWin) {
                    writer.printf("%-40s", "Bad superhero wins the most.");}

                else if (neutralWin > badWin && neutralWin > goodWin) {
                    writer.printf("%-40s", "Neutral superhero wins the most.");}

                writer.printf("%n%n");
                writer.println("***************************Second Part***************************");
                writer.printf("%n");

                writer.printf("%-40s" + "%-10s" + "%-10s" + "%-10s%n", "Subclass name", "Win", "Lose", "Tie");
                writer.printf("%n%n");

                int maxNumber = 0;
                for (int i = 0; i < 7; i++) {
                    writer.printf("%-40s" + "%-10s" + "%-10s" + "%-10s%n", subClassName[i], subClassWin[i], subClassLose[i], subClassTie[i]);

                    if (subClassWin[i] > subClassWin[maxNumber]) { maxNumber = i; }
                }

                writer.println(subClassName[maxNumber] + " class wins the most.");


                writer.printf("%n%n");
                writer.println("***************************Third Part***************************");
                writer.printf("%n");
                writer.printf("%-40s" + "%-10s" + "%-10s" + "%-10s%n", "Hero name", "Win", "Lose", "Tie");
                writer.printf("%n%n");

                for (int i = 0; i < theHeroes.size(); i++) { writer.printf("%-40s" + "%-10s" + "%-10s" + "%-10s%n", heroName[i], heroWin[i], heroLose[i], heroTie[i]); }

                writer.close();
            } catch (Exception ex) {
                System.out.println("File write error");
            }

        }

}
