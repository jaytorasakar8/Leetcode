/*
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 */

Approach 1: 

    class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course]) {
            return false;
        } else {
            visited[course] = true;
        };

        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int) graph[course].get(i))) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }

}


Approach 2: 

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int len = prerequisites.length;

        if (numCourses == 0 || len == 0) {
            return true;
        }

        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        //store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }

        // number of courses that have no prerequisites
        int numNoPre = queue.size();

        while (!queue.isEmpty()) {
            int top = queue.remove();
            for (int i = 0; i < len; i++) {
                // if a course's prerequisite can be satisfied by a course in queue
                if (prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return numNoPre == numCourses;
    }

}
