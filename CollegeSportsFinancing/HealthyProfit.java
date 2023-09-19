package CollegeSportsFinancing;
import java.util.ArrayList;

public class HealthyProfit extends Finance {

    public HealthyProfit(String[] fields) {super(fields);}

    public static double[] healthyRate(int ina, double yla){
        int size = 7;
        double[] rate = new double[size];


        //  0: ticket sales, 1: student fees, 2: direct state govt support, 3: royalties, 4: tv revenue, 5: endowments, 6: subsidy
        if(ina == 100){
        rate[0] = 0.9;
        rate[1] = 0.5;
        rate[2] = 0.3;
        rate[3] = 0.9;
        rate[4] = 0.8;
        rate[5] = 0.4;
        rate[6] = 0.4;}

        else{
            rate[0] = 0.9;
            rate[1] = 0.5;
            rate[2] = 0.3;
            rate[3] = 0.9;
            rate[4] = 0.8;
            rate[5] = 0.4;
            rate[6] = 0.4;
            rate[ina] = yla;
        }


        return rate;
    }



    public static String[] startCompare(ArrayList<Finance> fins, int ina, double yla) {
        int size = 3;
        String[] top = new String[size];
        double max = 0;
        double max1 = -1000000000;
        double max2 = -1000000000;

        for (int i = 0; i <= fins.size() - 1; i++) {

            double result = fins.get(i).getTicketSales() * healthyRate(ina,yla)[0] + fins.get(i).getStudentFees() * healthyRate(ina,yla)[1] +
                    fins.get(i).getDirectStateGovtSupport() * healthyRate(ina,yla)[2] + fins.get(i).getRoyalties() * healthyRate(ina,yla)[3] +
                    fins.get(i).getTvRevenue() * healthyRate(ina,yla)[4] + fins.get(i).getEndowments() * healthyRate(ina,yla)[5] +
                    fins.get(i).getSubsidy() * healthyRate(ina,yla)[6];
            if (result > max && result > max1 && result > max2) {
                top[0] = fins.get(i).getInstnm();
                max = result;
            } else if (result > max1) {
                top[1] = fins.get(i).getInstnm();
                max1 = result;
            } else if (result > max2) {
                top[2] = fins.get(i).getInstnm();
                max2 = result;
            }
        }
        return top;
    }





}
