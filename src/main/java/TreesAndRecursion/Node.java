package TreesAndRecursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class Node {
    private int depth;
    private ArrayList<Node> children;

    public Node(int depth) {
        this(depth, new ArrayList<>());
    }

    public Node(int depth, ArrayList<Node> children) {
        this.depth = depth;
        this.children = children;
    }

    public static void traverse(Node node) {
        System.out.println(node.toString());
        for (Node child : node.children) {
            traverse(child);
        }
    }

    public ArrayList<Integer> getDepths(Node node, int depth) {
        ArrayList<Integer> depths = new ArrayList<>();
        getDepthsHelper(node, depth, depths);
        Collections.sort(depths);
        return depths;
    }

    public void getDepthsHelper(Node node, int depth, ArrayList<Integer> depths) {
        depths.add(depth);
        for (Node child : node.children) {
            getDepthsHelper(child, depth + 1, depths);
        }
    }

    @Override
    public String toString() {
        return toString(0);
    }

    private String toString(int indent) {
        String indentation = "  ".repeat(indent);
        StringBuilder sb = new StringBuilder(indentation + "Node[depth=" + depth + "]\n");

        for (Node child : children) {
            sb.append(child.toString(indent + 1));
        }

        return sb.toString();
    }
}
