/*

In an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.  

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.

 

Example 1:

Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation: 
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.
 

Note:

1 <= persons.length = times.length <= 5000
0 <= persons[i] <= persons.length
times is a strictly increasing array with all elements in [0, 10^9].
TopVotedCandidate.q is called at most 10000 times per test case.
TopVotedCandidate.q(int t) is always called with t >= times[0]

*/

class TopVotedCandidate {

   private Map<Integer, Integer> map = new HashMap<>(); // time and leading candidate
    private int[] times;
    
public TopVotedCandidate(int[] persons, int[] times)
{
    this.times = times;
    int[] count = new int[persons.length + 1]; // count[i]: count of votes for persons[i]
    
    for (int i = 0, winner = -1; i < times.length; ++i) 
    {
        ++count[persons[i]]; // at times[i], persons[i] got a vote.
        // is persons[i] leading? update winner.
        if (map.isEmpty() || count[winner] <= count[persons[i]]) 
        { 
            winner = persons[i];
        } 
        
        map.put(times[i], winner); // update time and winner.
    }
}
public int q(int t) 
{
    int idx = Arrays.binarySearch(times, t); // search for the time slot.
    
    //We have a problem when we do Arrays.binarySearch()
    //If the element is present in the array then we return that index
    //Otherwise we return the index = { -(insertion point) - 1}
    //Source: https://stackoverflow.com/questions/13734694/array-binarysearch-returning-negative-numbers
    //So inorder to counter the negative index that we are getting, we need to make it positive by using (-idx - 2)
    return map.get(times[idx < 0 ? -idx - 2 : idx]); // fetch the corresponding information.
}
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */