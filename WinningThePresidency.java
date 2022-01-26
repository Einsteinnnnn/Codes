import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WinningThePresidency {

    // Constant representing that there is no way to win the election with the given number of votes.
    public static final int kNotPossible = 1000000000;
    public static MinInfo [] [] memo = new MinInfo[538][52];


    public static void main(String[] args){
        try{
            ElectionTest test = readDataFile("data/2004.csv", false);
            System.out.println(test);

            MinInfo info = minPopularVoteToWin(test.allStates);
            System.out.println(info);

            int diff = info.popularVotesNeeded - test.minPopularVoteNeeded;
            System.out.printf("%10s %8d %10s %8d\n", "Optimal:", test.minPopularVoteNeeded, "Yours:", info.popularVotesNeeded);
            System.out.println("Difference from optimal solution: " + diff);
            if(diff == 0) {
                System.out.println("Nice Work!");
            }
            else if(diff  < 0)
                System.out.println("Beat the optimal? That's probably not right...");
            else
                System.out.println("Bigger than the optimal. Keep at it - you'll get there!");
        }
        catch(Exception ex){
            System.out.println("File Read Error");
            ex.printStackTrace();
        }
    }

    public static MinInfo minPopularVoteToWin(ArrayList<State> states){
        ArrayList<State> includedStates = new ArrayList<>();

        MinInfo info = new MinInfo(kNotPossible, includedStates); // default value for no states included and no solution

        //implement method here.
        int electoralVotesSum = 0;
        int startIndex = 0;

        for (int i = 0; i <states.size(); i++){
            electoralVotesSum += states.get(i).electoralVotes;
        }
        int electoralVotes = (electoralVotesSum + 2) / 2;

        info = minPopularVoteToGetAtLeast(electoralVotes,startIndex,states);

        return info;
    }

    public static ElectionTest readDataFile(String filename, boolean simplified) throws IOException{
        int simplifiedLinesToRead = 10; //if the simplified flag is true, then only read 10 lines.
        int minPopularVotesNeeded = -1, year = -1;
        ArrayList<State> states = new ArrayList<>();
        Scanner fileReader = new Scanner(new File(filename));
        String[] firstLine = fileReader.nextLine().split(",");
        int votes = simplified ? 2 : 1;

        year = Integer.parseInt(firstLine[0]);
        minPopularVotesNeeded = Integer.parseInt(firstLine[votes]);

        int linesRead = 0;
        while(fileReader.hasNextLine() && (!simplified || linesRead < simplifiedLinesToRead)){
            String[] fields = fileReader.nextLine().split(",");
            State state = new State(fields[0], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
            states.add(state);
            linesRead++;
        }

        ElectionTest test = new ElectionTest(states, minPopularVotesNeeded, year);
        return test;
    }


    public static MinInfo minPopularVoteToGetAtLeast(int electoralVotes, int startIndex, ArrayList<State> states) {


        if (electoralVotes <= 0) {
            return new MinInfo(0, new ArrayList<>());
        }

        else if(startIndex == states.size()){
            return new MinInfo(kNotPossible, new ArrayList<>());
        }

        if (memo[electoralVotes][startIndex] != null){
            return memo[electoralVotes][startIndex];
        }

        MinInfo temp = minPopularVoteToGetAtLeast(electoralVotes - states.get(startIndex).electoralVotes, startIndex + 1, states);
        MinInfo temp1 = minPopularVoteToGetAtLeast(electoralVotes, startIndex + 1, states);

        int tempPop = temp.popularVotesNeeded + ((states.get(startIndex).popularVotes + 2) / 2);
        int tempPop1 = temp1.popularVotesNeeded;

        if (tempPop <  tempPop1) {

            ArrayList<State> statesUsed = new ArrayList<>(temp.statesUsed);

            temp.statesUsed.add(states.get(startIndex));

            MinInfo answer = new MinInfo(tempPop, statesUsed);

            memo[electoralVotes][startIndex] = answer;

            return answer;
        }

        else  {
            ArrayList<State> statesUsed1 = new ArrayList<>(temp1.statesUsed);

            MinInfo answer1 = new MinInfo(tempPop1, statesUsed1);

            memo[electoralVotes][startIndex] = answer1;

            return answer1;
        }

    }
}
