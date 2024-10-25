package telran.interview;

import java.util.EmptyStackException;
import java.util.Stack;

//All methods should have complexity O[1]
public class MyStackInt {
	private Stack<Integer> stack;        
	private Stack<Integer> maxStack; 

	public MyStackInt() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
   
	public void push(int num) {
		stack.push(num);
        if (maxStack.isEmpty() || num >= maxStack.peek()) {
            maxStack.push(num);
        }
	}
	public int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        int num = stack.pop();

        if (num == maxStack.peek()) {
            maxStack.pop();
        }
        return num;
	}
    public int peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public int getMaxElement() {
        if (maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.peek();
    }
}