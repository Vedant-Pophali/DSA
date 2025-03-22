package DynamicProgramming;
import java.util.ArrayList;
import java.util.List;
public class CoinSum {
    static List<List<Integer>> answers = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3,};
        int target = 5;
        List<List<Integer>> result = findCoinSum(target, candidates);
        System.out.println("Combinations that sum up to " + target + ": " + result);
    }
    private static List<List<Integer>> findCoinSum(int target, int[] candidates) {
        List<Integer> combinations = new ArrayList<>();
        funct(0,target,combinations,candidates);
        return answers.reversed();
    }
    private static void funct(int i, int rem, List<Integer> combinations, int[] candidates) {
        if(i == candidates.length) {
            if(rem == 0) {
                List<Integer> comb = new ArrayList<>(combinations);
                answers.add(comb);
            }
        }
        else{
            int maxItems = rem/candidates[i];
            for(int k=0;k<=maxItems;k++) {
                int newTarget = rem-(k*candidates[i]);
                for(int j=0;j<k;j++){
                    combinations.add(candidates[i]);
                }
                funct(i+1,newTarget,combinations,candidates);
                for (int j=0;j<k;j++){
                    combinations.removeLast();
                }
            }
        }
    }
}