import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SuperHero {
    private String name;
    private int intelligence;
    private int strength;
    private int speed;
    private int durability;
    private int power;
    private int combat;
    private String fullName;
    private String alignment;
    private String gender;
    private String race;
    private String height;
    private String weight;
    private String eyeColor;
    private String hairColor;
    private String occupation;


    public SuperHero(String name, int intelligence, int strength, int speed, int durability, int power, int combat, String fullName, String alignment, String gender, String race, String height, String weight, String eyeColor, String hairColor, String occupation) {
        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
        this.fullName = fullName;
        this.alignment = alignment;
        this.gender = gender;
        this.race = race;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.occupation = occupation;
    }

    public SuperHero(String[] fields){
        this.name = fields[0];
        this.intelligence = Integer.parseInt(fields[1]);
        this.strength = Integer.parseInt(fields[2]);
        this.speed = Integer.parseInt(fields[3]);
        this.durability = Integer.parseInt(fields[4]);
        this.power = Integer.parseInt(fields[5]);
        this.combat = Integer.parseInt(fields[6]);
        this.fullName = fields[7];
        this.alignment = fields[8];
        this.gender = fields[9];
        this.race = fields[10];
        this.height = fields[11];
        this.weight = fields[12];
        this.eyeColor = fields[13];
        this.hairColor = fields[14];
        this.occupation = fields[15];
    }

    public String getName() {
        return name;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDurability() {
        return durability;
    }

    public int getPower() {
        return power;
    }

    public int getCombat() {
        return combat;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAlignment() {
        return alignment;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getOccupation() { return occupation; }

    public int attack(SuperHero oHero){ return this.combat; }

    public static boolean meetsConditions(String[] fields){
        return true;
    }


    public static ArrayList<SuperHero> readDataFile(String fileName) throws IOException {

        ArrayList<SuperHero> heroes = new ArrayList<>();

        File file = new File(fileName);

        Scanner fileReader = new Scanner(file);

        fileReader.nextLine(); //skip headers

        int fieldCount = 16;

        while(fileReader.hasNextLine()){
            String[] fields = fileReader.nextLine().split(",");

            if(fields.length != fieldCount){ //parsing error or problem with file
                System.out.println("expected 16 fields but counted " + fields.length);
                for(String str : fields)
                    System.out.println(str);
                throw new IOException();
            }

            SuperHero hero;

            if(IronManAncientMagicPower.meetsConditions(fields))
                hero = new IronManAncientMagicPower(fields);

            else if(AttackEfficiency.meetsConditions(fields))
                hero = new AttackEfficiency(fields);

            else if(AbsoluteStrength.meetsConditions(fields))
                hero = new AbsoluteStrength(fields);

            else if(SuperSpeed.meetsConditions(fields))
                hero = new SuperSpeed(fields);

            else if(EnergyLoss.meetsConditions(fields))
                hero = new EnergyLoss(fields);

            else if(GenderAffect.meetsConditions(fields))
                hero = new GenderAffect(fields);

            else if(LowPower.meetsConditions(fields))
                hero = new LowPower(fields);

            else if(MasterMind.meetsConditions(fields))
                hero = new MasterMind(fields);

            else
                hero = new SuperHero(fields);

            heroes.add(hero);


        }



        return heroes;
    }
}
