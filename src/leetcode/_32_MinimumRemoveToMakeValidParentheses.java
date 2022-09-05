package leetcode;

/*
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

Constraints:
1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
 */
public class _32_MinimumRemoveToMakeValidParentheses {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            StringBuffer validString = new StringBuffer();
            int count = 0;
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '(') {
                    count++;
                } else if (charArray[i] == ')') {
                    if (count == 0) {
                        charArray[i] = '#';
                    } else {
                        count--;
                    }
                }
            }
            for (int i = charArray.length - 1; i >= 0; i--) {
                if (count > 0 && charArray[i] == '(') {
                    charArray[i] = '#';
                    count--;
                }
            }
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] != '#') {
                    validString.append(charArray[i]);
                }
            }
            return validString.toString();
        }
    }
}
