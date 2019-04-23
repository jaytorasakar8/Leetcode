/*

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0, taskCountOfMax = 0;
        for (char task : tasks) {
            int c = ++count[task - 'A'];
            if (c == max) {
                taskCountOfMax++;
            } else if (c > max) {
                max = c;
                taskCountOfMax = 1;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + taskCountOfMax);
    }
}

/*

Imagine task A appeared 4 times, others less than 4. And n=2. You only need to arrange A in the way that doesn't violate the rule first, then insert other tasks in any order:
A - - A - - A - - A
It's obvious that we need 6 other tasks to fill it. If other tasks are less 6, we need (4 - 1) * (n + 1) + 1 = 10 tasks in total, if other tasks are equal to or more than 6, tasks.length will be our result.
Now if we have more than one tasks have the same max occurrence, the scheduling will look like this:
A B - A B - A B - A B
So we only need to modify the formula by replacing 1 with the different amount of tasks that has the max occurrence: (4 - 1) * (n + 1) + taskCountOfMax = 11    
*/