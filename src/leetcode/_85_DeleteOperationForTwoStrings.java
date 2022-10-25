package leetcode;

import java.util.Arrays;

/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
In one step, you can delete exactly one character in either string.

Example 1:
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Example 2:
Input: word1 = "leetcode", word2 = "etco"
Output: 4

Constraints:
1 <= word1.length, word2.length <= 500
word1 and word2 consist of only lowercase English letters.
 */
public class _85_DeleteOperationForTwoStrings {
    class Solution {
        public int minDistance(String word1, String word2) {
            int[] lengths = new int[word2.length()];
            int[] prevLengths = new int[word2.length()];
            Arrays.setAll(prevLengths, i -> word2.length() - i);

            int[] temp;
            for (int i = word1.length() - 1; i >= 0; i--) {
                for (int j = word2.length() - 1; j >= 0; j--) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        lengths[j] = (j + 1 < word2.length() ? prevLengths[j + 1] : word1.length() - 1 - i);
                    } else {
                        lengths[j] = 1 + Math.min((j + 1 < word2.length() ? lengths[j + 1] : word1.length() - i),
                                prevLengths[j]);
                    }
                }
                temp = lengths;
                lengths = prevLengths;
                prevLengths = temp;
                Arrays.fill(lengths, 0);
            }
            return prevLengths[0];
        }
    }
}
