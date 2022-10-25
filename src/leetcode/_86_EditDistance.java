package leetcode;

import java.util.Arrays;

/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

Constraints:
0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
 */
public class _86_EditDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            if (word1.equals("") || word2.equals("")) {
                return Math.max(word1.length(), word2.length());
            }

            int[] lengths = new int[word2.length()];
            int[] prevLengths = new int[word2.length()];
            Arrays.setAll(prevLengths, i -> word2.length() - i);

            int[] temp;
            for (int i = word1.length() - 1; i >= 0; i--) {
                for (int j = word2.length() - 1; j >= 0; j--) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        lengths[j] = (j + 1 < word2.length() ? prevLengths[j + 1] : word1.length() - i - 1);
                    } else {
                        lengths[j] =
                                1 + min((j + 1 < word2.length() ? lengths[j + 1] : word1.length() - i), prevLengths[j],
                                        (j + 1 < word2.length() ? prevLengths[j + 1] : word1.length() - i - 1));
                    }
                }
                temp = lengths;
                lengths = prevLengths;
                prevLengths = temp;
                Arrays.fill(lengths, 0);
            }
            return prevLengths[0];
        }

        private int min(int a, int b, int c) {
            return a < b ? (a < c ? a : c) : (b < c ? b : c);
        }
    }
}
