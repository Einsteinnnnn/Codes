package CollegeSportsFinancing;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {

        ArrayList<Finance> financesData = Finance.readDataFile("data/pubDataRepo.csv");


        //Q1 test

        int index = 0;

        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[0]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[1]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[2]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[3]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[4]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[5]);

        index = 100;

        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[0]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[1]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[2]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[3]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[4]);
        System.out.println(ReturnProfit.returnAllData(financesData.get(index))[5]);



        //Q2 test

        System.out.println(GetNetRevenue.getMax(financesData));
        System.out.println(GetNetRevenue.getMin(financesData));
        System.out.println(GetNetRevenue.getAverage(financesData));



        //Q3  test

       System.out.println(HealthyProfit.startCompare(financesData,100,0)[0]);
       System.out.println(HealthyProfit.startCompare(financesData,100,0)[1]);
       System.out.println(HealthyProfit.startCompare(financesData,100,0)[2]);



        System.out.println(HealthyProfit.startCompare(financesData,0,0.1)[0]);
        System.out.println(HealthyProfit.startCompare(financesData,0,0.1)[1]);
        System.out.println(HealthyProfit.startCompare(financesData,0,0.1)[2]);


    }




}
