package leetcode.medium;

public class _17_LongestPalindrome {
    class Solution {
        final int LETTERCOUNT = ('z' - 'a' + 1);
        public int longestPalindrome(String s) {
            int letterCount = LETTERCOUNT * 2;
            int[] charFrequency = new int[letterCount];

            for (char c: s.toCharArray()) {
                int index = charToDigit(c);

                if (index < 0 || index >= letterCount) {
                    return -1;
                }

                charFrequency[index]++;
            }
            boolean hasOdd = false;
            int maxLength = 0;
            for (int x: charFrequency) {
                if (x % 2 == 1) {
                    hasOdd = true;
                    maxLength += (x - 1);
                } else if (x % 2 == 0) {
                    maxLength += x;
                }
            }
            maxLength += (hasOdd ? 1 : 0);
            return maxLength;
        }

        private int charToDigit(char c) {
            if (c >= 'A' && c <= 'Z') {
                return (c - 'A');
            }

            if (c >= 'a' && c <= 'z') {
                return LETTERCOUNT + (c - 'a');
            }

            return -1;
        }
    }
}
