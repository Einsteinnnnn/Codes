import java.util.ArrayList;

public class GetNetRevenue extends Finance {

    public GetNetRevenue(String[] fields) {super(fields);}

    public static int getMin(ArrayList<Finance> fins){
        int min = 0;
        for(int i=0; i <= fins.size()-1; i++ ){
            if (fins.get(i).getNetRevenue() < min){
                min = fins.get(i).getNetRevenue();
            }
        }
        return min;
    }
    public static int getMax(ArrayList<Finance> fins){
        int max = 0;
        for(int i=0; i <= fins.size()-1; i++ ){
            if (fins.get(i).getNetRevenue() > max){
                max = fins.get(i).getNetRevenue();
            }
        }
        return max;
    }
    public static int getAverage(ArrayList<Finance> fins){
        int sum = 0;
        int number = 0;
        for(int i=0; i <= fins.size()-1; i++ ){
            sum += fins.get(i).getNetRevenue();
            number += 1;
        }
        int avg = sum / number;

        return avg;
    }

}
