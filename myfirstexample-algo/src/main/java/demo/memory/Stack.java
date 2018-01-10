package demo.memory;

import java.util.EmptyStackException;

class Stack {

    // keep these two fields as they​​​​​​​​‌‌‌‌​‌‌‌​‌‌‌​​​​‌‌​‌​‌‌ are
    private Object[] elements;
    private int size = 0;

	public Stack(int initialCapacity) {
		elements = new Object[initialCapacity];
	}

	public void push(Object object) {
		ensureCapacity();
		elements[size++] = object;
	}

	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		return elements[--size];
	}

	private void ensureCapacity() {
		if (elements.length == size) {
			Object[] old = elements;
			elements = new Object[2 * size + 1];
			System.arraycopy(old, 0, elements, 0, size);
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(10000);
		//showMemoryUse(); // before using the stack

		for (int i = 0; i < 10000; i++) { // fill the stack
			stack.push("a large, large, large, large, string " + i);
		}
		for (int i = 0; i < 10000; i++) { // empty the stack
			System.out.println(stack.pop());
		}

		//showMemoryUse(); // after using the stack
	}
}