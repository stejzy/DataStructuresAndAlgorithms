package DynamicProgramming;

import java.util.*;

public class DynamicProgramming {

    public static int minCoins(int x, int[] coins) {
        HashMap<Integer, Integer> results = new HashMap<>();
        results.put(0, 0);
        for (int i = 1; i < x + 1; i++) {
            results.put(i, i);
            for (int coin : coins) {
                if (i - coin >= 0){
                    int min = Math.min(results.get(i - coin) + 1, results.get(i));
                    results.put(i, min);
                }
            }
        }
        return results.get(x);
    }

    public static int allSolutions(int x, int[] coins) {
        HashMap<Integer, Integer> results = new HashMap<>();
        results.put(0, 1);
        for (int i = 1; i < x + 1; i++) {
            results.put(i, 0);
            for (int coin : coins) {
                if (i - coin >= 0){
                    int sum = results.get(i) + results.get(i - coin);
                    results.put(i, sum);
                }
            }
        }
        return results.get(x);
    }

    public static List<Integer> sol_coins(int x, int[] coins) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 1; i < x + 1; i++) {
            results.add(new ArrayList<>());
            for (int j = i; j > 0; j--) {
                results.get(i).add(1);
            }
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (results.get(i).size() > results.get(i - coin).size()){
                        List<Integer> newSol = new ArrayList<>(results.get(i-coin));
                        newSol.add(coin);
                        results.get(i).clear();
                        results.get(i).addAll(newSol);
                    }
                }
            }

        }
        return results.getLast();
    }

    //Subsequences
    public  static int longestSubsequence(int[] sequence) {
        int currentLength;
        int maxLength = 0;
        List<Integer> lengths = new ArrayList<>();

        lengths.add(1);
        for (int i = 1; i < sequence.length; i++){
            lengths.add(1);
            currentLength = 1;
            for (int j = i-1; j >= 0; j--) {
                if(sequence[i] > sequence[j]) {
                    currentLength = Math.max(currentLength, lengths.get(j) + 1);
                    lengths.set(i, currentLength);
                    maxLength = Math.max(maxLength, currentLength);
                }
            }

        }
        System.out.println(lengths);

        return maxLength;
    }

    public static void main(String[] args) {
        // Smallest number of coins
//        int result = min_coins(13, new int[] {1,2,4,5});
//        System.out.println(result);


        //Solution coins
//        List<Integer> results = sol_coins(13, new int[] {1,2,4,5});
//        System.out.println(results);

        //Number of all solutions
//        int results = allSolutions(13, new int[] {1,2,5});
//        System.out.println(results);

        //Subsequences
        int result = longestSubsequence(new int[] {4,1,5,6,3,4,3,8});
        System.out.println(result);
    }
}
