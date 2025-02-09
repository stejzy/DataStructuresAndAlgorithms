package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(new int[]{1, 2, 3, 4, 5});

        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(4,5);

//        HashSet<Integer> allNodesInComponent = graph.searchDFS(1);
//        System.out.println(path);

//        HashSet<Integer> allNodesInComponent = graph.searchBFS(1);
//        System.out.println(path);

//        int count = graph.countComponents(1);
//        System.out.println(count);

//        ArrayList<Integer> path = graph.shortestPath(1, 4);
//        System.out.println(path);


        int[][] labyrinth = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        int[] startPosition = {1, 1};

        graph.solveLabyrinth(labyrinth, startPosition);
    }
}
