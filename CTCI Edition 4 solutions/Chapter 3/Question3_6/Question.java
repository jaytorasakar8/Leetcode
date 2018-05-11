package Question3_6;

import java.util.Stack;

public class Question {
	
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
		
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(2);
		s.push(24);
		s.push(34);
		s.push(19);
		s.push(3);
		s.push(4);
		s = sort(s);
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
