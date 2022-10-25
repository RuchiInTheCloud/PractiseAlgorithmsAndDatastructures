package leetcode;

/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the
mapping above (there may be multiple ways). For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
Given a string s containing only digits, return the number of ways to decode it.
The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */
public class _80_DecodeWays {
    //case size 1
    //case size 2: collective + individual
    //case size >=3:
    //_ --> a
    //_ _ --> b = isFirstValid ? a : 0 + areBothValid ? 1 : 0
    //_ _ _ --> c = isFirstValid ? b : 0 + areBothValid ? a : 0
    //_ _ _ _ --> d = isFirstValid ? c : 0 + areBothValid ? b : 0
    class Solution {
        public int numDecodings(String s) {
            int a = 1;
            int b = 1;
            int c = 0;
            int index = s.length() - 1;
            while(index >= 0) {
                c = (isDigitValid(s, index) ? b : 0) + (areDigitsValid(s, index + 1, index) ? a : 0);
                a = b;
                b = c;
                index -= 1;
            }
            return b;
        }
        private boolean isDigitValid(String s, int index) {
            if (index < 0 || index >= s.length()) {
                return false;
            }
            char c = s.charAt(index);
            return c >= '1' && c <= '9';
        }
        private boolean areDigitsValid(String s, int index1, int index2) {
            if (index1 < 0 || index1 >= s.length() || index2 < 0 || index2 >= s.length()) {
                return false;
            }
            char c1 = s.charAt(index1);
            char c2 = s.charAt(index2);
            return (c1 >= '0' && c1 <= '9' && c2 == '1') || (c1 >= '0' && c1 <= '6' && c2 == '2');
        }
    }
}
