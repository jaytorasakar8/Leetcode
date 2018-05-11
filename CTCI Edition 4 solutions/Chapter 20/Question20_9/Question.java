package Question20_9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question {
	private static Comparator<Integer> maxHeapComparator;
	private static Comparator<Integer> minHeapComparator;
	private static PriorityQueue<Integer> maxHeap;
	private static PriorityQueue<Integer> minHeap;

	public static void addNewNumber(int randomNumber) {
		if (maxHeap.size() == minHeap.size()) {
			if ((minHeap.peek() != null) && 
					randomNumber > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		}
		else {
			if(randomNumber < maxHeap.peek()){
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			}
			else {
				minHeap.offer(randomNumber);
			}
		}
	}

	public static double getMedian() {
		if (maxHeap.isEmpty()) {
			return minHeap.peek();
		} else if (minHeap.isEmpty()) {
			return maxHeap.peek();
		}
		if (maxHeap.size() == minHeap.size()) {
			return ((double)minHeap.peek() + (double) maxHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else {
			return minHeap.peek();
		}
	}

	public static void addNewNumberAndPrintMedian(int randomNumber) {
		addNewNumber(randomNumber);
		System.out.println("Random Number = " + randomNumber);
		printMinHeapAndMaxHeap();
		System.out.println("\nMedian = " + getMedian() + "\n");
	}

	public static void printMinHeapAndMaxHeap(){
		Integer[] minHeapArray = minHeap.toArray(
				new Integer[minHeap.size()]);
		Integer[] maxHeapArray = maxHeap.toArray(
				new Integer[maxHeap.size()]);

		Arrays.sort(minHeapArray, maxHeapComparator);
		Arrays.sort(maxHeapArray, maxHeapComparator);
		System.out.print("MinHeap =");
		for (int i = minHeapArray.length - 1; i >= 0 ; i--){
			System.out.print(" " + minHeapArray[i]);
		}
		System.out.print("\nMaxHeap =");
		for (int i = 0; i < maxHeapArray.length; i++){
			System.out.print(" " + maxHeapArray[i]);
		}
	}

	public static void main(String[] args) {
		int arraySize = 10;
		int range = 7;

		maxHeapComparator = new MaxHeapComparator();
		minHeapComparator = new MinHeapComparator();
		maxHeap = new PriorityQueue<Integer>(arraySize - arraySize/2, maxHeapComparator);
		minHeap = new PriorityQueue<Integer>(arraySize/2, minHeapComparator);

		for(int i = 0; i < arraySize; i++) {
			int randomNumber = (int) (Math.random( ) * (range+1));
			addNewNumberAndPrintMedian(randomNumber);
		}
	}

}
