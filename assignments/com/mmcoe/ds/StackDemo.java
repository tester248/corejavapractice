package com.mmcoe.ds;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("Stack: " + stack);
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Size: " + stack.size());
		System.out.println("Is empty: " + stack.isEmpty());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Is empty: " + stack.isEmpty());
	}
}
