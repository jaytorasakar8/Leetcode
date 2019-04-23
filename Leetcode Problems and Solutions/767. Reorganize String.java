/*

Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
 
*/

class Solution {
    public String reorganizeString(String S) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: S.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1); //Character Frequency count
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        maxHeap.addAll(map.entrySet());//Adding all elements to our heap 
        
        StringBuilder result = new StringBuilder();
        
        //The reason we need "prev" Entry is because we don't want 2 consecutive same characters! 
        Map.Entry<Character, Integer> prev = null; //Since this is the start of the resultant string we have to keep prev = null. We don't want to add anything before the start of the resultant string. 
        
        while(!maxHeap.isEmpty())
        {
            Map.Entry<Character, Integer> curr = maxHeap.poll(); //Get the element with the highest freq from the PQ
            result.append(curr.getKey());//Append the current character
            
            curr.setValue(curr.getValue()-1); //Since we have used one character from the current Entry, we update the frequency count
            if(prev != null)
                maxHeap.offer(prev); //Means that our previous entry still has characters available to use, so add it to the Priority Queue for further processing. 
            
            //After updating the current node's frequency count, if we are still having some characters available, so update the prev with the current value.
            if(curr.getValue() > 0) 
                prev = curr;
            else
                prev = null;
        }
        System.out.println(result);
        
        return result.length() == S.length() ? result.toString() : "";
    }
}