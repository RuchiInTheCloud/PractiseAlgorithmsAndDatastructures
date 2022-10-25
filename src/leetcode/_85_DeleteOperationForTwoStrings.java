package leetcode;

import java.util.Arrays;

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
