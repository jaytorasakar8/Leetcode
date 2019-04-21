/*
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

/*
 * Method 1: By sorting based on the start value and then comparing two consecutive intervals to check if they could be merged or not
 */
class Solution {

    public List<Interval> merge(List<Interval> list) {
        if (list.size() == 0) {
            return new ArrayList<Interval>();
        }

        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        List<Interval> res = new ArrayList();
        Interval prev = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            Interval current = list.get(i);
            if (current.start <= prev.end) {
                Interval merged = new Interval(prev.start, Math.max(current.end, prev.end));
                prev = merged;
            } else {
                res.add(prev);
                prev = current;
            }
        }
        res.add(prev);
        return res;
    }
}


/*
 * Method 2: First sort the intervals and then Using Stack compare 2 consecutive
 * intervals can be merged or not
 */
class Solution {

    public List<Interval> merge(List<Interval> list)
    if (list.size() <= 0)  
            return new ArrayList<Interval>();  
        
        List<Interval> res = new ArrayList<>();

    // Create an empty stack of intervals  
    Stack<Interval> stack = new Stack<>();

    // sort the intervals in increasing order of start time  
    Collections.sort (list,  new Comparator<Interval>(){ 
            

    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }
}
); 
    
        // push the first interval to stack  
        stack.push(list.get(0));
        
        for (int i = 1 ; i < list.size(); i++)  
        {  
            // get interval from stack top  
            Interval current = stack.peek();  
    
            // if current interval is not overlapping with stack top,  
            // push it to the stack  
            if (current.end < list.get(i).start)  
                stack.push(list.get(i));  
    
            // Otherwise update the ending time of top if ending of current  
            // interval is more  
            else if (current.end < list.get(i).end)  
            {  
                current.end = list.get(i).end;  
                stack.pop();  
                stack.push(current);  
            }  
        }  
        
        while (!stack.isEmpty())  
        {  
            Interval t = stack.pop(); 
            res.add(t);
        }  
    return res;
    }
}
