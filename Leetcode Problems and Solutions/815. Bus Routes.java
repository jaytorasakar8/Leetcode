/*

We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.

Example:
Input: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Note:

1 <= routes.length <= 500.
1 <= routes[i].length <= 500.
0 <= routes[i][j] < 10 ^ 6.

*/

class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
    
    //Map stores the routes(key) that a particular bus(value) follows
    //That is Bus0 goes on route0 with stops = [1,2,7]
    //Map = {1=[0], 2=[0], 3=[1], 6=[1], 7=[0, 1]}
    //Just to avoid repetition of a particular bus's number we can take it as BusA instead of Bus0, so that it doesn't interfere with our bus stop numbers to create confusion
    //Map can be seen as : 
    // Map = {  1=[A], 2=[A],
    //          3=[B], 6=[B], 
    //          7=[A,B]  }
        
    HashMap<Integer, Set<Integer>> map = new HashMap();
    for(int i = 0; i < routes.length; i++){            
        for(int j = 0; j < routes[i].length; j++){ 
            Set set = map.getOrDefault(routes[i][j], new HashSet());
            set.add(i);
            map.put(routes[i][j], set);
        }
    }
        
    Queue<Integer> queue = new LinkedList();
    Set<Integer> seen = new HashSet();
    
    //Add the starting point in the queue for processing 
    //Add starting point to the visited set, because we are having the routes[i] in a repeated order, so that we have don't keep on visiting the same route's bus stop
    queue.add(S);
    seen.add(S);
    int level = 0;
        
    while(!queue.isEmpty()){
        int count = queue.size();  
        
        while(count-- > 0){
            int busStop = queue.poll();//First we get busStop = 1
            if (busStop == T)
                return level;
            
            //When we do map.get(1), we get get the busNumber=0, and subsequently we traverse the remaining stops by that particular busNumber(here bus0), so add 2 and 7 to queue(since they are not visited)
            for(int bus : map.get(busStop)){
                //Explore all the busStops on the particular bus route
                for(int j = 0 ; j < routes[bus].length; j++){
                    if(!seen.contains(routes[bus][j])){
                        queue.add(routes[bus][j]);
                        seen.add(routes[bus][j]);
                    }
                }
            }
        }
        level++;
    }
    return -1;
}
}

/*
    The way we explore the BFS is:
    routes = [[1, 2, 7], [3, 6, 7]], S = 1, T = 6
                  |          |
              Bus0/BusA   Bus1/BusB
                  
    
            1
          /   \
         2     7     <--- Level 1
             /  \
            3    6(Target)   <--- Level 2
            
    One more case:
    [[1,2,7],[3,6,7], [4,5,6]], S=2, T = 4
    
            1
          /   \
         2     7     <--- Level 1
             /  \
            3    6   <--- Level 2
                /  \
          4(Target)  5  <--- Level 3

*/