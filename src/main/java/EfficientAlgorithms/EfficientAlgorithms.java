package EfficientAlgorithms;

public class EfficientAlgorithms {

    //Stock trading
    public static int[] stockTrading(int[] stock) {
        int lowIndex = 0;
        int highIndex;
        int resultLowIndex = 0;
        int resultHighIndex = 0;
        int profit = 0;

        for(int i=1; i<stock.length; i++){
            if(stock[lowIndex] < stock[i]){
                highIndex = i;
                if(profit < stock[highIndex]-stock[lowIndex]){
                    resultLowIndex = lowIndex;
                    resultHighIndex = highIndex;
                    profit = stock[resultHighIndex] - stock[resultLowIndex];
                }
            } else {
                lowIndex = i;
            }
        }

        return new int[]{resultLowIndex, resultHighIndex, profit};
    }

    //Bit String
    public static int bitString(int[] bits) {
        int sum = 0;
        int counter = 0;
        for (int j : bits) {
            if (j == 0) {
                counter++;
            }
            if (j == 1) {
                sum += counter;
            }
        }
        return sum;
    }

    //List splitting
    public static int listSplitting(int[] listElements) {
        int totalSum = 0;
        int leftSide = 0;
        int counter = 0;

        for(int i : listElements) {
            totalSum += i;
        }

        for(int i = 0; i < listElements.length - 1; i++) {
            leftSide += listElements[i];
            int rightSide = totalSum - leftSide;

            if(leftSide == rightSide) {
                counter++;
            }
        }

        return counter;
    }

    //Sublists
    public static int getSublists(int[] listElements) {
        int a = -1;
        int b = -1;
        int counter = 0;

        for(int i = 1; i < listElements.length; i++) {
            if(listElements[i] != listElements[i - 1]) {
                if(a != -1) {
                    if(listElements[i] != listElements[a]) {
                        b = a;
                    }
                }
                a = i - 1;
            }
            counter += a - b;
        }

        return counter;
    }

    public static void main(String[] args) {
        // Uncomment code fragments one at a time
        // because the variable names are repeated



        //Stock trading

//        int[] stock = {100, 180, 260, 310, 40, 535, 695};
//
//        long startTime = System.nanoTime();
//        int[] result = stockTradingMySolution(stock);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;  // Time in nanoseconds
//
//        System.out.println("When to buy: " + result[0]
//                + ", when to sell: " + result[1]
//                + ", best profit: " + result[2]);
//
//        System.out.println("Time taken: " + duration + " nanoseconds");



        //Bit String

//        int[] bits = {0, 1, 0, 0, 1, 0, 1, 1};
//
//       long startTime = System.nanoTime();
//        int result = bitString(bits);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;
//
//        System.out.println("Here there are " + result + " such pairs of positions.");
//        System.out.println("Time taken: " + duration + " nanoseconds");



        //List splitting

//        int[] listElements = {1, -1, 1, -1, 1, -1, 1, -1};
//
//        long startTime = System.nanoTime();
//        int result = listSplitting(listElements);
//        long endTime = System.nanoTime();
//
//        long duration = endTime - startTime;
//
//        System.out.println("Here there are " + result + " such pairs of positions.");
//        System.out.println("Time taken: " + duration + " nanoseconds");



        //Sublists

        int[] listElements = {1, 2, 3, 3, 2, 2, 4, 2};

        long startTime = System.nanoTime();
        int result = getSublists(listElements);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Here there are " + result + " such pairs of positions.");
        System.out.println("Time taken: " + duration + " nanoseconds");
    }


}
