package SearchProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        String basicString = "()";



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
        ArrayList<String> result = new ArrayList<>();
        balancedParenthesis(6, result);

        for (String res : result) {
            System.out.println(res);
        }
    }
}
