package TreesAndRecursion;

import java.util.ArrayList;

public class TreesAndRecursion {

    //Queens
    public static int countQueens(int n) {
        return count(n, 0, new ArrayList<>());
    }

    public static int count(int n, int row, ArrayList<int[]> queens) {
        if (row == n) {
            return 1;
        }

        int result = 0;

        for (int col = 0; col < n; col++) {
            boolean isSafe = true;

            for(int[] queen : queens) {
                if (collision(queen, new int[]{row, col})) {
                    isSafe = false;
                    break;
                }
            }

            if (isSafe) {
                queens.add(new int[]{row, col});
                result += count(n, row + 1, queens);
                queens.remove(queens.size() - 1);
            }
        }
        return result;
    }

    public static boolean collision(int[] queen1, int[] queen2) {
        return (queen1[0] == queen2[0]) ||
                (queen1[1] == queen2[1]) ||
                (Math.abs(queen1[0] - queen2[0]) == Math.abs(queen1[1] - queen2[1]));
    }

    public static void main(String[] args) {
        //Playing around with tree, trying to understand it

//        Node branch1 = new Node(1, new ArrayList<>(List.of(new Node(2))));
//        Node branch2 = new Node(1, new ArrayList<>(List.of(new Node(2), new Node(2))));
//        Node root = new Node(0, new ArrayList<>(List.of(branch1, branch2)));
//
//        Node.traverse(root);
//        ArrayList<Integer> depth;
//        depth = root.getDepths(root, 0);
//        System.out.println(depth);

        //Queens
        System.out.println(countQueens(4));
        System.out.println(countQueens(8));
    }
}
