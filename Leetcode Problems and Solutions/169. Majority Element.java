/*
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 */


 /*
 *
 * Approach 1: Brute Force
 * Intuition
 *
 * We can exhaust the search space in quadratic time by checking whether each element is the majority element.
 *
 * Algorithm
 *
 * The brute force algorithm iterates over the array, and then iterates again for each number to count its occurrences. As soon as a number is found to have appeared more than any other can possibly have appeared, return it.
 *
 */
class Solution {

    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;
    }
}

/*
 *
 * Complexity Analysis
 *
 * Time complexity : O(n^2)
 *
 * The brute force algorithm contains two nested for loops that each run for nn
 * iterations, adding up to quadratic time complexity.
 *
 * Space complexity : O(1)
 *
 * The brute force solution does not allocate additional space proportional to
 * the input size.
 *
 */

 /*
 *
 * Approach 2: HashMap Intuition
 *
 * We know that the majority element occurs more than floor(n/2) times, and a
 * HashMap allows us to count element occurrences efficiently.
 *
 * Algorithm
 *
 * We can use a HashMap that maps elements to counts in order to count
 * occurrences in linear time by looping over nums. Then, we simply return the
 * key with maximum value.
 *
 */
class Solution {

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
}

/*
 *
 * Complexity Analysis
 *
 * Time complexity : O(n)
 *
 * We iterate over nums once and make a constant time HashMap insertion on each
 * iteration. Therefore, the algorithm runs in O(n) time.
 *
 * Space complexity : O(n)
 *
 * At most, the HashMap can contain n - floor(n/2) associations, so it occupies
 * O(n) space. This is because an arbitrary array of length nn can contain nn
 * distinct values, but nums is guaranteed to contain a majority element, which
 * will occupy (at minimum) floor(n/2) + 1 array indices. Therefore, n -
 * (floor(n/2) + 1) indices can be occupied by distinct, non-majority elements
 * (plus 1 for the majority element itself), leaving us with (at most) n -
 * floor(n/2) distinct elements.
 *
 */
 /*
 * Approach 3: Sorting Intuition
 *
 * If the elements are sorted in monotonically increasing (or decreasing) order,
 * the majority element can be found at index floor(n/2) (and floor(n/2) + 1,
 * incidentally, if n is even).
 *
 * Algorithm
 *
 * For this algorithm, we simply do exactly what is described: sort nums, and
 * return the element in question. To see why this will always return the
 * majority element (given that the array has one), consider the figure below
 * (the top example is for an odd-length array and the bottom is for an
 * even-length array):
 *
 * Sorting middle index overlap
 *
 * For each example, the line below the array denotes the range of indices that
 * are covered by a majority element that happens to be the array minimum. As
 * you might expect, the line above the array is similar, but for the case where
 * the majority element is also the array maximum. In all other cases, this line
 * will lie somewhere between these two, but notice that even in these two most
 * extreme cases, they overlap at index floor(n/2) for both even- and odd-length
 * arrays. Therefore, no matter what value the majority element has in relation
 * to the rest of the array, returning the value at floor(n/2) will never be
 * wrong.
 *
 */
class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/*
 *
 * Complexity Analysis
 *
 * Time complexity : O(nlgn)
 *
 * Sorting the array costs O(nlgn) time in Python and Java, so it dominates the
 * overall runtime.
 *
 * Space complexity : O(1) or (O(n))
 *
 * We sorted nums in place here - if that is not allowed, then we must spend
 * linear additional space on a copy of nums and sort the copy instead.
 *
 */

 /*
 *
 * Approach 4: Randomization Intuition
 *
 * Because more than floor(n/2) array indices are occupied by the majority
 * element, a random array index is likely to contain the majority element.
 *
 * Algorithm
 *
 * Because a given index is likely to have the majority element, we can just
 * select a random index, check whether its value is the majority element,
 * return if it is, and repeat if it is not. The algorithm is verifiably correct
 * because we ensure that the randomly chosen value is the majority element
 * before ever returning.
 *
 */
class Solution {

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
}


/*
 *
 * Approach 5: Divide and Conquer Intuition
 *
 * If we know the majority element in the left and right halves of an array, we
 * can determine which is the global majority element in linear time.
 *
 * Algorithm
 *
 * Here, we apply a classical divide & conquer approach that recurses on the
 * left and right halves of an array until an answer can be trivially achieved
 * for a length-1 array. Note that because actually passing copies of subarrays
 * costs time and space, we instead pass lo and hi indices that describe the
 * relevant slice of the overall array. In this case, the majority element for a
 * length-1 slice is trivially its only element, so the recursion stops there.
 * If the current slice is longer than length-1, we must combine the answers for
 * the slice's left and right halves. If they agree on the majority element,
 * then the majority element for the overall slice is obviously the same[1]. If
 * they disagree, only one of them can be "right", so we need to count the
 * occurrences of the left and right majority elements to determine which
 * subslice's answer is globally correct. The overall answer for the array is
 * thus the majority element between indices 0 and nn.
 *
 */
class Solution {

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }
}

/*

Complexity Analysis

Time complexity : O(nlgn)

Each recursive call to majority_element_rec performs two recursive calls on subslices of size n/2 and two linear scans of length nn. Therefore, the time complexity of the divide & conquer approach can be represented by the following recurrence relation:

T(n) = 2T(n/2) + 2n

Space complexity : O(lgn)

Although the divide & conquer does not explicitly allocate any additional memory, it uses a non-constant amount of additional memory in stack frames due to recursion. Because the algorithm "cuts" the array in half at each level of recursion, it follows that there can only be O(lgn)O(lgn) "cuts" before the base case of 1 is reached. It follows from this fact that the resulting recursion tree is balanced, and therefore all paths from the root to a leaf are of length O(lgn)O(lgn). Because the recursion tree is traversed in a depth-first manner, the space complexity is therefore equivalent to the length of the longest path, which is, of course, O(lgn)

*/
