package Question3_5;

import java.util.Stack;

public class MyQueue<T> {
	Stack<T> s1, s2;
	
	public MyQueue() {
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public int size() {
		return s1.size() + s2.size();
	}
	
	public void add(T value) {
		// Push onto stack1
		s1.push(value);
	}
	
	public T peek() {
		if (!s2.empty()) { 
			/* stack2 was already filled by previous calls of dequeue,
			 * so just retrieve the next item. */
			return s2.peek();
		}

		while (!s1.empty()) {
			/* We know that stack2 is empty, so fill it with the next 
			 * portion of data. */
			s2.push(s1.pop());
		}
		return s2.peek(); // retrieve the next item.
	}
	
	public T remove() {
		if (!s2.empty()) { 
			/* stack2 was already filled by previous calls of dequeue,
			 * so just retrieve the next item. */
			return s2.pop();
		}

		while (!s1.empty()) {
			/* We know that stack2 is empty, so fill it with the next 
			 * portion of data. */
			s2.push(s1.pop());
		}
		return s2.pop(); // retrieve the next item.
	}
}
