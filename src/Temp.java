package src;

import java.util.Stack;

public class Temp {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        stack.push(1);
        System.out.println(stack.size());

        while(!stack.isEmpty()) stack.pop();
        System.out.println(stack.size());

    }
}