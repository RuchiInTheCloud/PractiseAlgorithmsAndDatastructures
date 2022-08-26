package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.

Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]

Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: s = "eccbbbbdec"
Output: [10]

Constraints:
1 <= s.length <= 500
s consists of lowercase English letters.
 */
public class _19_PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> partitionSizes = new LinkedList<Integer>();
            HashMap<Character, Integer> characterLastIndex = new HashMap<>();
            int index = 0;
            for (char c: s.toCharArray()) {
                characterLastIndex.put(c, index);
                index++;
            }

            int prev = 0;
            int max = Integer.MIN_VALUE;
            index = 0;
            for (char c: s.toCharArray()) {
                max = Math.max(characterLastIndex.get(c), max);
                if (max == index) {
                    partitionSizes.add(max - prev + 1);
                    prev = max + 1;
                }
                index++;
            }
            return partitionSizes;
        }
    }
}
