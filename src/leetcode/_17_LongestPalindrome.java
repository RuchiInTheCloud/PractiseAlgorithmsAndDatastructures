package leetcode;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.

Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
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
