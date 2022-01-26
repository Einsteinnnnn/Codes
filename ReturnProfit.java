public class ReturnProfit extends Finance {

    public ReturnProfit(String[] fields) { super(fields); }

    public static int[] returnAllData(Finance fin) {
        int size = 6;
        int[] data = new int[size];

        data[0] = fin.getRoyalties();
        data[1] = fin.getTvRevenue();
        data[2] = fin.getEndowments();
        data[3] = fin.getAthleticRevenues();
        data[4] = fin.getOtherRevenues();
        data[5] = fin.getNetRevenue();

        return data;

    }
}

