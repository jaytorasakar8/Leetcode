package Question9_7;

import java.util.ArrayList;
import java.util.*;

public class Question {
	ArrayList<HtWt> items;
	ArrayList<HtWt> lastFoundSeq;
	ArrayList<HtWt> maxSeq;

	// Returns longer sequence
	ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}

	// Fills next seq w decreased wts - returns index of 1st unfit item.
	int fillNextSeq(int startFrom, ArrayList<HtWt> seq) {
		int firstUnfitItem = startFrom;
		if (startFrom < items.size()) {
			for (int i = 0; i < items.size(); i++) {
				HtWt item = items.get(i);
				if (i == 0 || items.get(i-1).isBefore(item)) {
					seq.add(item);
				} else {
					firstUnfitItem = i;
				}
			}
		}
		return firstUnfitItem;
	}

	// Find the maximum length sequence
	void findMaxSeq() {
		Collections.sort(items);
		
		int currentUnfit = 0;
		while (currentUnfit < items.size()) {
			ArrayList<HtWt> nextSeq = new ArrayList<HtWt>();
			int nextUnfit = fillNextSeq(currentUnfit, nextSeq);
			maxSeq = seqWithMaxLength(maxSeq, nextSeq);
			if (nextUnfit == currentUnfit) break;
			else currentUnfit = nextUnfit;
		}
	} 
	
	public void initialize() {
		items = new ArrayList<HtWt>();
		lastFoundSeq = new ArrayList<HtWt>();
		maxSeq = new ArrayList<HtWt>();
		
		HtWt item = new HtWt(65, 60);
		items.add(item);
		
		item = new HtWt(70, 150);
		items.add(item);
		
		item = new HtWt(56, 90);
		items.add(item);
		
		item = new HtWt(75, 190);
		items.add(item);
		
		item = new HtWt(60, 95);
		items.add(item);
		
		item = new HtWt(68, 110);
		items.add(item);
	}
	
	public void printList(ArrayList<HtWt> list) {
		for (HtWt item : list) {
			System.out.println(item.toString() + " ");
		}
	}
	
	public void printResult() {
		printList(maxSeq);
	}
	
	public static void main(String[] args) {
		
		Question q = new Question();
		q.initialize();
		q.findMaxSeq();
		q.printResult();
	}

}
