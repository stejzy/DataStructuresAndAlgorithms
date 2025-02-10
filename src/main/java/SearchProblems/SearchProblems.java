package SearchProblems;

import java.util.*;

public class SearchProblems {

    //Permutations
    public static void generatePermutations(List<Integer> nums, int start, List<List<Integer>> result) {
        if(start == nums.size() - 1) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for(int i = start; i < nums.size(); i++) {
            Collections.swap(nums, start, i);
            generatePermutations(nums, start + 1, result);
            Collections.swap(nums, start, i);
        }
    }

    //Orderings
    public static void orderings(List<Integer> nums, int start, List<List<Integer>> result) {
        if(start == nums.size() - 1) {
            for (int i = 0; i < nums.size() - 1; i++) {
                if(Math.abs(nums.get(i + 1) - nums.get(i)) <= 1 ) {
                    return;
                }
            }
            result.add(new ArrayList<>(nums));
            return;
        }

        for(int i = start; i < nums.size(); i++) {
            Collections.swap(nums, start, i);
            orderings(nums, start + 1, result);
            Collections.swap(nums, start, i);
        }
    }

    //Balanced parenthesis
    public static void balancedParenthesis(int n, ArrayList<String> result) {
        if(n%2 == 1) {
            System.out.println("Input must be even");
        }


        balancedParenthesisHelper(n, "", 0, result);

    }

    public static void balancedParenthesisHelper(int n, String currentString, int valid, ArrayList<String> result) {

        if(valid < 0) {
            return;
        }

        if (currentString.length() == n) {
            int counter = 0;
            for (int i = 0; i < currentString.length(); i++) {
                if (currentString.charAt(i) == '(') {
                    counter++;
                } else {
                    counter--;
                }
                if (counter < 0) {
                    return;
                }
            }
            if (counter != 0) {
                return;
            }

            result.add(currentString);
            return;
        }

        balancedParenthesisHelper(n, currentString + "(",valid + 1, result);
        balancedParenthesisHelper(n, currentString + ")", valid - 1, result);

    }

    public static int countBalancedParenthesis(int n) {
        return countBalancedParenthesis(n, 0);
    }

    public static int countBalancedParenthesis(int n, int d) {
        if (d < 0 || d > n) {
            return 0;
        }
        if (n == 0) {
            return  1;
        }
        return countBalancedParenthesis(n - 1, d + 1) + countBalancedParenthesis(n - 1, d -1);
     }

     public static int greedyCoins(int x, int[] paramCoins) {
        int[] coins = new int[paramCoins.length];
        System.arraycopy(paramCoins, 0, coins, 0, paramCoins.length);
        reverseArray(coins);
        for(int coin : coins) {
            System.out.println(coin);        }
        int sum = 0;
        int counter = 0;
        int i = 0;

        while (sum < x) {
            if(sum + coins[i] <= x){
                sum += coins[i];
                counter++;
            }else{
                i++;
            }
        }
        return counter;
     }

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

     public static int bruteForceCoins(int x, int[] coins) {
         Queue<List<Integer>> queue = new ArrayDeque<>();
         queue.add(List.of(coins[0]));
         queue.add(List.of(coins[1]));
         queue.add(List.of(coins[2]));
         while (!(queue.isEmpty())) {
             List<Integer> solution = queue.poll();

             int sum = 0;
             for (int num : solution) {
                 sum += num;
             }

            if(sum == x){
                return solution.size();
            }
            else {
                for (int coin : coins) {
                    List<Integer> newSolution = new ArrayList<>(solution);
                    newSolution.add(coin);
                    queue.add(newSolution);
                }
            }
        }
         return 0;
     }


    public static void main(String[] args) {

        //Orderings
//        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
//        List<List<Integer>> result = new ArrayList<>();
//
//        orderings(new ArrayList<>(nums), 0, result);
//
//        for (List<Integer> res : result) {
//            System.out.println(res);
//        }


        //Balanced
//        ArrayList<String> result = new ArrayList<>();
//        balancedParenthesis(6, result);
//
//        for (String res : result) {
//            System.out.println(res);
//        }


        // Count number of balanced parenthesis
//        int amount = countBalancedParenthesis(6);
//        System.out.println(amount);

        //Greedy algorithms
//        int counter = greedyCoins(13, new int[] {1, 2, 5});
//        System.out.println(counter);

        //Bruto force
        int counter = bruteForceCoins(13, new int[] {1, 4, 5});
        System.out.println(counter);
    }
}
