package Question3_1;

public class QuestionB {
	public static int stackSize = 300;
	public static int indexUsed = 0;
	public static int[] stackPointer = {-1,-1,-1};
	public static StackNode[] buffer = new StackNode[stackSize * 3];
	
	public static void main(String [] args){
		push(2, 4);
		System.out.println(peek(2));
		push(0, 3);
		push(0, 7);
		push(0, 5);
		System.out.println(peek(0));
		pop(0);
		System.out.println(peek(0));
		pop(0);
		System.out.println(peek(0));		
	}

	public static void push(int stackNum, int value) {
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum] = indexUsed;
		indexUsed++;
		buffer[stackPointer[stackNum]]=new StackNode(lastIndex,value);
	}

	public static int pop(int stackNum) {
		int value = buffer[stackPointer[stackNum]].value;
		int lastIndex = stackPointer[stackNum];
		stackPointer[stackNum]	=
			buffer[stackPointer[stackNum]].previous;
		buffer[lastIndex] = null;
		indexUsed--;
		return value;
	}

	public static int peek(int stackNum) {
		return buffer[stackPointer[stackNum]].value;
	}

	public static boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}
		
}
