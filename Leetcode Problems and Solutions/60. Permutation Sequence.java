/*
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 */

class Solution {

    public String getPermutation(int n, int k) {
        int[] numbers = new int[n];
        for (int i = 1; i <= n; i++) {
            numbers[i - 1] = i;
        }
        return perm(numbers, k);
    }

    private String perm(int[] input, int k) {
        if (input.length == 0) {
            return "";
        }
        int len = input.length - 1;
        int cnt = factorial(len);
        int pos = 0;
        while (k - cnt > 0) {
            k -= cnt;
            pos++;
        }

        String result = Integer.toString(input[pos]);
        int[] rem = new int[len];
        int ix = 0;
        for (int i = 0; i <= len; i++) {
            if (i == pos) {
                continue;
            }
            rem[ix++] = input[i];
        }
        result += perm(rem, k);
        return result;
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

/*
Explanation: 

Let's say n = 5 and k = 40;
Currently we have the following individual numbers:

1 2 3 4 5
Among n! = 120 permutations (n-1)! = 24 of them will begin with "1", the next 24 of them will begin with "2", the next 24 will begin with "3" and so on.
In which case 40th element will begin with "2".

Now the problem becomes among the following numbers, what is the 40 - 24 = 16th permutation:

1 3 4 5
The length of this set is 4, so (4-1)! = 6 of them will begin with "1", the next 6 will begin with "3" and the next 6 wil begin with "4".
In which case 16th element will begin with a "4".

Now the problem is what is the 16 - 12 = 4th permutation of the following set:

1 3 5
2 of them will begin with a "1" and 3rd and 4th permutation will begin with a "3" and we need the 2nd permutation from the remaining set which is:

1 5
1st permutation will begin with a "1" and 2nd will begin with "5".

Overall result is:

24351
*/
