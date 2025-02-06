package OwnDataStructures;

import java.util.ArrayList;

public class Stack {
    private final ArrayList<Integer> stack;

    public Stack() {
        stack = new ArrayList();
    }

    public void push(int value) {
        stack.add(value);
    }

    public void push(int value, int multi) {
        for(int i = 0; i < multi; i++) {
            stack.add(value);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.removeLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int length() {
        return stack.size();
    }

    public String toString() {
        return stack.toString();
    }
}
