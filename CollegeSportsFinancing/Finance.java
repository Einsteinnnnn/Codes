package CollegeSportsFinancing;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Finance {
    private int unitid;
    private String instnm;
    private String chronnane;
    private String conference;
    private String city;
    private String state;
    private int year;
    private int fullTimeEnrollment;
    private int ticketSales;
    private int studentFees;
    private int directStateGovtSupport;
    private int directInstitutionalSupport;
    private int indirectFacilAdminSupport;
    private int ncaaDistributions;
    private int royalties;
    private int tvRevenue;
    private int endowments;
    private int athleticRevenues;
    private int otherRevenues;
    private int athleticExpenses;
    private int subsidy;
    private double subsidyProportion;
    private int institutionalSubsidy;
    private double institutionalSubsidyProportion;
    private int netRevenue;
    private int netRevenueBeforeSubsidy;
    private int externalRevenue;
    private int instateTuition;

    public Finance(int unitid, String instnm, String chronnane, String conference, String city, String state, int year, int fullTimeEnrollment, int ticketSales, int studentFees, int directStateGovtSupport, int directInstitutionalSupport, int indirectFacilAdminSupport, int ncaaDistributions, int royalties, int tvRevenue, int endowments, int athleticRevenues, int otherRevenues, int athleticExpenses, int subsidy, double subsidyProportion, int institutionalSubsidy, double institutionalSubsidyProportion, int netRevenue, int netRevenueBeforeSubsidy, int externalRevenue, int instateTuition) {
        this.unitid = unitid;
        this.instnm = instnm;
        this.chronnane = chronnane;
        this.conference = conference;
        this.city = city;
        this.state = state;
        this.year = year;
        this.fullTimeEnrollment = fullTimeEnrollment;
        this.ticketSales = ticketSales;
        this.studentFees = studentFees;
        this.directStateGovtSupport = directStateGovtSupport;
        this.directInstitutionalSupport = directInstitutionalSupport;
        this.indirectFacilAdminSupport = indirectFacilAdminSupport;
        this.ncaaDistributions = ncaaDistributions;
        this.royalties = royalties;
        this.tvRevenue = tvRevenue;
        this.endowments = endowments;
        this.athleticRevenues = athleticRevenues;
        this.otherRevenues = otherRevenues;
        this.athleticExpenses = athleticExpenses;
        this.subsidy = subsidy;
        this.subsidyProportion = subsidyProportion;
        this.institutionalSubsidy = institutionalSubsidy;
        this.institutionalSubsidyProportion = institutionalSubsidyProportion;
        this.netRevenue = netRevenue;
        this.netRevenueBeforeSubsidy = netRevenueBeforeSubsidy;
        this.externalRevenue = externalRevenue;
        this.instateTuition = instateTuition;
    }

    public Finance(String[] fields){
        this.unitid = Integer.parseInt(fields[0]);
        this.instnm = fields[1];
        this.chronnane = fields[2];
        this.conference = fields[3];
        this.city = fields[4];
        this.state = fields[5];
        this.year = Integer.parseInt(fields[6]);
        this.fullTimeEnrollment = Integer.parseInt(fields[7]);
        this.ticketSales = Integer.parseInt(fields[8]);
        this.studentFees = Integer.parseInt(fields[9]);
        this.directStateGovtSupport = Integer.parseInt(fields[10]);
        this.directInstitutionalSupport = Integer.parseInt(fields[11]);
        this.indirectFacilAdminSupport = Integer.parseInt(fields[12]);
        this.ncaaDistributions = Integer.parseInt(fields[13]);
        this.royalties = Integer.parseInt(fields[14]);
        this.tvRevenue = Integer.parseInt(fields[15]);
        this.endowments = Integer.parseInt(fields[16]);
        this.athleticRevenues = Integer.parseInt(fields[17]);
        this.otherRevenues = Integer.parseInt(fields[18]);
        this.athleticExpenses = Integer.parseInt(fields[19]);
        this.subsidy = Integer.parseInt(fields[20]);
        this.subsidyProportion = Double.parseDouble(fields[21]);
        this.institutionalSubsidy = Integer.parseInt(fields[22]);
        this.institutionalSubsidyProportion = Double.parseDouble(fields[23]);
        this.netRevenue = Integer.parseInt(fields[24]);
        this.netRevenueBeforeSubsidy = Integer.parseInt(fields[25]);
        this.externalRevenue = Integer.parseInt(fields[26]);
        this.instateTuition = Integer.parseInt(fields[27]);

    }

    public int getUnitid() { return unitid; }
    public String getInstnm() { return instnm; }
    public String getChronnane() { return chronnane; }
    public String getConference() { return conference; }
    public String getCity() { return city ; }
    public String getState() { return state; }
    public int getYear() { return year; }
    public int getFullTimeEnrollment() { return fullTimeEnrollment; }
    public int getTicketSales() { return ticketSales; }
    public int getStudentFees() { return studentFees; }
    public int getDirectStateGovtSupport() { return directStateGovtSupport; }
    public int getDirectInstitutionalSupport() { return directInstitutionalSupport; }
    public int getIndirectFacilAdminSupport() { return indirectFacilAdminSupport; }
    public int getNcaaDistributions() { return ncaaDistributions; }
    public int getRoyalties() { return royalties; }
    public int getTvRevenue() { return tvRevenue; }
    public int getEndowments() { return endowments; }
    public int getAthleticRevenues() { return athleticRevenues; }
    public int getOtherRevenues() { return otherRevenues; }
    public int getAthleticExpenses() { return athleticExpenses; }
    public int getSubsidy() { return subsidy; }
    public double getSubsidyProportion() { return subsidyProportion; }
    public int getinstitutionalSubsidy() { return institutionalSubsidy; }
    public double getInstitutionalSubsidyProportion() { return institutionalSubsidyProportion; }
    public int getNetRevenue() { return netRevenue; }
    public int getNetRevenueBeforeSubsidy() { return netRevenueBeforeSubsidy; }
    public int getExternalRevenue() { return externalRevenue; }
    public int getInstateTuition() { return instateTuition; }

    public static ArrayList<Finance> readDataFile(String fileName) throws IOException {

        ArrayList<Finance> finances = new ArrayList<>();

        File file = new File(fileName);

        Scanner fileReader = new Scanner(file);

        fileReader.nextLine();

        int fieldCount = 28;


        while (fileReader.hasNextLine()) {
            String[] fields = fileReader.nextLine().split(",");


            if (fields.length != fieldCount) {
                System.out.println("expected 28 fields but counted " + fields.length);
                for (String str : fields)
                    System.out.println(str);
                throw new IOException();
            }

            else {
                Finance newFinance = new Finance(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5], Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]), Integer.parseInt(fields[10]), Integer.parseInt(fields[11]), Integer.parseInt(fields[12]), Integer.parseInt(fields[13]), Integer.parseInt(fields[14]), Integer.parseInt(fields[15]), Integer.parseInt(fields[16]), Integer.parseInt(fields[17]), Integer.parseInt(fields[18]), Integer.parseInt(fields[19]), Integer.parseInt(fields[20]), Double.parseDouble(fields[21]), Integer.parseInt(fields[22]), Double.parseDouble(fields[23]), Integer.parseInt(fields[24]), Integer.parseInt(fields[25]), Integer.parseInt(fields[26]), Integer.parseInt(fields[27]));
                finances.add(newFinance);
            }

        }


        return finances;
    }





}
