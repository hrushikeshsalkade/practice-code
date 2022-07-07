package com.hsalkade.practice;

public class LocalStack {

	private int[] stack;
	private int currentPointer;

	public static void main(String[] args) {
		LocalStack stack = new LocalStack(5);

		// Test assert full.
		stack.push(1);
		assert !stack.isFull();

		stack.push(2);
		assert !stack.isFull();

		stack.push(3);
		assert !stack.isFull();

		stack.push(4);
		assert !stack.isFull();

		stack.push(5);
		assert stack.isFull();

		// Test assert Empty
		stack = new LocalStack(5);
		assert stack.isEmpty();
		assert !stack.isFull();

		stack.push(1);
		assert stack.peek() == 1;
		assert stack.pop() == 1;
		assert stack.isEmpty();

		System.out.println("Program completed");
	}

	public LocalStack(int capacity) {
		stack = new int[capacity];
		currentPointer = 0;
	}

	public void push(int item) {
		if (currentPointer == stack.length) {
			throw new IllegalArgumentException("Stack is already full");
		}
		stack[currentPointer++] = item;
	}

	public int pop() {
		if (currentPointer == 0) {
			throw new IllegalArgumentException("Stack is already empty");
		}
		return stack[--currentPointer];
	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Stack is already empty");
		}
		return stack[currentPointer - 1];
	}

	public boolean isEmpty() {
		return currentPointer == 0;
	}

	public boolean isFull() {
		return currentPointer == stack.length;
	}
}
