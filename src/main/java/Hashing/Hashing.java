package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hashing {

    // How many distinct numbers
    public static int calculateDistinctNumbers(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {
            set.add(number);
        }

        return set.size();
    }

    // Mode
    public static int calculateMostFrequentNumber(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int frequency = 10;
        int mostFrequentNumber = numbers[0];

        for (int number : numbers) {
            map.compute(number, (k, v) -> (v == null) ? 1 : v + 1);

            if (map.get(number) > frequency) {
                frequency = map.get(number);
                mostFrequentNumber = number;
            }
        }
        return mostFrequentNumber;
    }


    // Rounds
    public static int calculateRounds(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i+1);
        }

        for (int i = 1; i <= numbers.length - 1; i++) {
            if (map.get(i) > map.get(i+1)) {
                counter++;
            }
        }
        return counter;
    }


    // Play list
    public static int calculateLongestPlaylist(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                start = Math.max(start, map.get(numbers[i]) + 1);
            }
            length = Math.max(length, i -  start + 1);
            map.put(numbers[i], i);
        }
        return length;
    }

    public static int calculateListSums(int[] numbers, int x) {
        HashMap<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        int result = 0;
        int sumPrefix = 0;

        for (int number : numbers) {
            sumPrefix += number;
            if (map.containsKey(sumPrefix - x)) {
                result += map.get(sumPrefix - x);
            } else {
                map.put(sumPrefix, 0);
            }

            map.compute(sumPrefix, (k, v) -> (v == null) ? 1 : v + 1);
        }
        return result;
    }

    public static void main(String[] args) {

        //How many distinct numbers

//        int[] numbers = {3, 1, 2, 1, 5, 2, 2, 3};
//
//        long startTime = System.nanoTime();
//        int result = calculateDistinctNumbers(numbers);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;  // Time in nanoseconds
//
//        System.out.println("There are " + result + " distinct numbers.");
//
//        System.out.println("Time taken: " + duration + " nanoseconds");



        //Mode

//        int[] numbers = {1, 2, 3, 2, 2, 3, 2, 2};
//
//        long startTime = System.nanoTime();
//        int result = calculateMostFrequentNumber(numbers);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;  // Time in nanoseconds
//
//        System.out.println("Most frequent number is " + result + ".");
//
//        System.out.println("Time taken: " + duration + " nanoseconds");


        //Rounds

//        int[] numbers = {3, 6, 1, 7, 5, 2, 4, 8};
//
//        long startTime = System.nanoTime();
//        int result = calculateRounds(numbers);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;  // Time in nanoseconds
//
//        System.out.println("Nuber of rounds:  " + result + ".");
//
//        System.out.println("Time taken: " + duration + " nanoseconds");


        // Play list

//        int[] numbers = {1, 2, 1, 3, 5, 4, 3, 1};
//
//        long startTime = System.nanoTime();
//        int result = calculateLongestPlaylist(numbers);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;  // Time in nanoseconds
//
//        System.out.println("Nuber of rounds:  " + result + ".");
//
//        System.out.println("Time taken: " + duration + " nanoseconds");


        //List sums

        int[] numbers = {2, 3, 5, -3, 4, 4, 6, 2};
        int x = 5;

        long startTime = System.nanoTime();
        int result = calculateListSums(numbers, x);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;  // Time in nanoseconds

        System.out.println("Desire answer:  " + result + ".");

        System.out.println("Time taken: " + duration + " nanoseconds");
    }
}
