package stacks;

import java.util.Stack;

public class Worker {

    public static void main(String[] args) {
        var stack = new Stack<Integer>();
        stack.push(13);
        stack.push(31);
        stack.push(541);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }


}
