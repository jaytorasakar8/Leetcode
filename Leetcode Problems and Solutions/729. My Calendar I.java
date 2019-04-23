/*

Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:

MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
 

Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

*/

class MyCalendar {
    
    class Interval {
        int start;
        int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int getStart() { return start; }
        public int getEnd() { return end; }
    }

    List<Interval> list;
    
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (Interval interval: list) {
            if (start < interval.getEnd() && end > interval.getStart()) {
                return false;
            }
        }
        
        list.add(new Interval(start, end));
        return true;
    }
}

/*
class MyCalendar {

    TreeSet<int[]> books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);// Min sorted based on the start values

    public boolean book(int s, int e) {
        int[] book = new int[] { s, e }, floor = books.floor(book), ceiling = books.ceiling(book);
        
        
        if (floor != null && s < floor[1]) 
            return false; // (s, e) start within floor
        if (ceiling != null && ceiling[0] < e) 
            return false; // ceiling start within (s, e)
        
        books.add(book);
        return true;
    }
}
*/

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */