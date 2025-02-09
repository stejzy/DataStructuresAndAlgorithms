package GraphAlgorithms;

import java.util.*;

public class Graph {
    private int[] nodes;
    private HashMap<Integer, ArrayList<Integer>> adjacencyList;

    public Graph(int[] nodes) {
        this.nodes = nodes;
        adjacencyList = new HashMap<>();

        for (int node : nodes) {
            adjacencyList.put(node, new ArrayList<>());
        }
    }

    public void addEdge(int node1, int node2) {
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }


    //We can do this without recursion, using stack
    //It returns us every node that we can reach from given start node
    public void searchDFSRecursion(int node, HashSet<Integer> visited) {
        if(visited.contains(node)) {
            return;
        }
        visited.add(node);

        for (int nextNode : adjacencyList.get(node)) {
            searchDFSRecursion(nextNode, visited);
        }
    }

    public HashSet<Integer> searchDFS(int node) {
        HashSet<Integer> visited = new HashSet<>();
        searchDFSRecursion(node, visited);
        return visited;
    }

    public int countComponents(int startNode) {
        int counter = 0;
        HashSet<Integer> visited = new HashSet<>();

        for (int node : nodes) {
            if(!(visited.contains(node))) {
                counter++;
                searchDFSRecursion(node, visited);
            }
        }
        return counter;
    }

    public HashSet<Integer> searchBFS(int startNode) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(startNode);

        while(!(queue.isEmpty())) {
            int node = queue.poll();
            if (!(visited.contains(node))) {
                visited.add(node);
                for (int nextNode : adjacencyList.get(node)) {
                    queue.add(nextNode);
                }
            }
        }

        return visited;
    }

    public HashMap<Integer, Integer> calculateDistances(int startNode) {
        HashMap<Integer, Integer> disatnces = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(startNode);
        visited.add(startNode);
        disatnces.put(startNode, 0);

        while(!(queue.isEmpty())) {
            int node = queue.poll();

            for (int nextNode : adjacencyList.get(node)) {
                if(!(visited.contains(nextNode))) {
                    visited.add(nextNode);
                    disatnces.put(nextNode, disatnces.get(node) + 1);
                    queue.add(nextNode);
                }
            }

        }
        return disatnces;
    }

    public ArrayList<Integer> shortestPath(int startNode, int endNode) {
        HashMap<Integer, Integer> distances = new HashMap<>();
        HashMap<Integer, Integer> previous = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(startNode);
        visited.add(startNode);
        distances.put(startNode, 0);

        while(!(queue.isEmpty())) {
            int node = queue.poll();

            for (int nextNode : adjacencyList.get(node)) {
                if(!(visited.contains(nextNode))) {
                    visited.add(nextNode);
                    distances.put(nextNode, distances.get(node) + 1);
                    previous.put(nextNode, node);
                    queue.add(nextNode);
                }
            }
        }

        if (!(distances.containsKey(endNode))) {
            return new ArrayList<>();
        }

        ArrayList<Integer> path = new ArrayList<>();
        int node = endNode;

        while(previous.get(node) != null) {
            path.add(previous.get(node));
            node = previous.get(node);
        }
        Collections.reverse(path);
        path.add(endNode);
        return path;
    }

    //Labyrinth as graph
    public void solveLabyrinth(int[][] originalLabyrinth, int[] startPosition) {
        int rows = originalLabyrinth.length;
        int cols = originalLabyrinth[0].length;
        int[][] labyrinth = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            labyrinth[i] = originalLabyrinth[i].clone();
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startPosition[0], startPosition[1]});
        labyrinth[startPosition[0]][startPosition[1]] = 2;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            System.out.println("Aktualna pozycja: " + position[0] + ", " + position[1]);

            for (int[] dir : directions) {
                int newRow = position[0] + dir[0];
                int newCol = position[1] + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && labyrinth[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol});
                    labyrinth[newRow][newCol] = 2;
                    System.out.println("Dodano do kolejki: " + newRow + ", " + newCol);
                }
            }
        }
        System.out.println("Solved labyrinth: ");
        for (int[] row : labyrinth) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }



    @Override
    public String toString() {
        return new StringJoiner(", ", Graph.class.getSimpleName() + "[", "]")
                .add("nodes=" + Arrays.toString(nodes))
                .add("\nadjacencyList=" + adjacencyList)
                .toString();
    }
}
