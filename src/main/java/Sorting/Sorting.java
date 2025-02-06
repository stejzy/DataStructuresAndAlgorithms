package Sorting;

import java.util.Arrays;

public class Sorting {

    //Smallest diffrence
    public static int calculateSmallestDiffrence(int[] numbers){
        Arrays.sort(numbers);
        int smallestDiff = Integer.MAX_VALUE;

        for(int i=0; i<numbers.length-1; i++){
            if(smallestDiff > numbers[i + 1] - numbers[i]){
                smallestDiff = numbers[i + 1] - numbers[i];
            }
        }
        return smallestDiff;
    }

    // Restaurant
    public static int calculateMaxCustomerNumber(int[][] numbers){
        int[] arrivals = new int[numbers.length];
        int[] departures = new int[numbers.length];
        int counter = 0;

        for(int i=0; i<numbers.length; i++){
            arrivals[i] = numbers[i][0];
            departures[i] = numbers[i][1];
        }

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int j =0;
        for(int i=0; i<arrivals.length; i++){
            if(arrivals[i] <= departures[j]){
                counter++;
            } else {
                counter--;
                j++;
                i--;
            }
        }

        return counter;
    }

    //Quick Sort
    public static void quickSort(int[] numbers, int start, int end){
        int pivot;

        if(end <= start){
            return;
        }

        pivot = partition(numbers, start, end);
        quickSort(numbers, start, pivot - 1);
        quickSort(numbers, pivot + 1, end);
    }

    public static int partition(int[] numbers, int start, int end){
        int pivot = numbers[end];
        int temp;
        int i = start - 1;
        for(int j=start; j<end; j++){
            if(numbers[j] < pivot){
                i++;
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        i++;
        temp = numbers[i];
        numbers[i] = numbers[end];
        numbers[end] = temp;

        return i;
    }

    //Merge Sort
    public static void mergeSort(int[] numbers){
        int length = numbers.length;
        int mid = numbers.length / 2;

        if (length <= 1){
            return;
        }

        int[] left = Arrays.copyOfRange(numbers, 0, mid);
        int[] right = Arrays.copyOfRange(numbers, mid, numbers.length);

        mergeSort(left);
        mergeSort(right);

        int a = 0;
        int b = 0;
        for(int i = 0; i < length; i++){
            //Really important is order of conditions
            if(b == right.length || (a < left.length && left[a] < right[b])){
                numbers[i] = left[a];
                a++;
            } else {
                numbers[i] = right[b];
                b++;
            }
        }

    }

    public static void main(String[] args) {

        //Smallest diffrence

//        int[] numbers = {4, 1, 7, 3, 9};
//
//        long startTime = System.nanoTime();
//        int result = calculateSmallestDiffrence(numbers);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;  // Time in nanoseconds
//
//        System.out.println("Smallest diffrence:  " + result + ".");
//
//        System.out.println("Time taken: " + duration + " nanoseconds");

        //Restaurant

//        int[][] numbers = {
//                {6, 8},
//                {3, 7},
//                {6, 9},
//                {1, 5},
//                {2, 8}
//        };
//
//        long startTime = System.nanoTime();
//        int result = calculateMaxCustomerNumber(numbers);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;  // Time in nanoseconds
//
//        System.out.println("Most customers at once:  " + result + ".");
//
//        System.out.println("Time taken: " + duration + " nanoseconds");



        //Quick sort

//        int[] numbers = {4,32,6,8,21,2,99,0,2,5,5,12,54};
//        quickSort(numbers, 0, numbers.length - 1);
//        System.out.println(Arrays.toString(numbers));


        //Merge sort

        int[] numbers = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(numbers);

        for(int number : numbers) {
            System.out.println(number);
        }
    }
}
