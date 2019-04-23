/*
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 */

class Solution {

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0 || amount < 1) {
            return 0;
        }

        Deque<Integer> queue = new ArrayDeque<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.addFirst(amount);
        visited.add(amount);
        int level = 0;

        //We are going to explore every amount possible in  terms of level
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.removeLast();
                if (curr == 0) {
                    return level;
                }

                if (curr < 0) {
                    continue;
                }

                for (int coin : coins) {
                    int next = curr - coin;
                    if (next >= 0 && !visited.contains(next)) {
                        queue.addFirst(next);
                        visited.add(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
    //For example, first we have 11 as amount.
    /*            11
              /   |    \
           10     9      6
          /|\    /|\    /|\
         9 8 5  8 9 4  5 4 1 ..... so on
         We explore the amount in this way using a BFS
    
    */
    
    
    /*
    public static int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount <= 0)
        return 0;
    int[] minNumber = new int[amount + 1];
    Arrays.fill(minNumber, Integer.MAX_VALUE );
    minNumber[0] = 0;

    for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
        }
    }
    if (minNumber[amount] == Integer.MAX_VALUE)
        return -1;
    else
        return minNumber[amount];
}*/
