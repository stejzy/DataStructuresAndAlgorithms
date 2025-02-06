package OwnDataStructures;

public class OwnDataStructures {
    public static void main(String[] args) {
        //Implementation of own Stack
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30, 3);

        System.out.println(stack.length());
        System.out.println(stack);

    }
}
