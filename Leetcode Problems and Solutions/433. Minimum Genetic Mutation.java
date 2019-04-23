/*
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 *
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 *
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 *
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 *
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 *
 * Note:
 *
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 *
 *
 * Example 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * return: 1
 *
 *
 * Example 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * return: 2
 *
 *
 * Example 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * return: 3
 *
 */
class Solution {

    public int minMutation(String start, String end, String[] bank) {

        HashSet<String> set = new HashSet<String>();
        for (String s : bank) {
            set.add(s);
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int steps = 0;
        char[] charSet = {'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {
            int size = queue.size(); //We need a special variable to store size because later we are adding elements in the queue, which is changing the size of the queue, which we don't want to happen. So use an extra size variable instead of for(int i=0;i<queue.size();i++)
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(end)) {
                    return steps;
                }

                for (int j = 0; j < current.length(); j++) {
                    for (char ch : charSet) {
                        char[] chars = current.toCharArray();
                        chars[j] = ch;
                        String temp = new String(chars);
                        if (set.contains(temp)) {
                            queue.offer(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
