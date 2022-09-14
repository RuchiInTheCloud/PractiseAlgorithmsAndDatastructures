package leetcode;

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.

Follow up: Can you solve it in O(n) time and O(1) space?*/
public class _55_BackspaceStringCompare {
    class Solution {
        /*
        i1, i2, skip1, skip2 -> unequal character
        i1 = S.length() - 1
        i2 = T.length() - 1
        while (i1 >= 0 || i2 >= 0) {
            while (i1 >= 0) {
                if (S.charAt(i1) == '#') i1 --, skip1 ++
                else if skip1 > 0, i1--, skip1 --
                else break;
            }
            while (i2 >= 0) {
                if (T.charAt(i2) == '#') i2 --, skip2 ++
                else if skip2 > 0, i2--, skip2 --
                else break;
            }
            if (i1 >= 0 && i2 >= 0 && S.charAt(i1) != T.charAt(i2)) --> false
            else if (i1 >= 0) != (i2 >= 0) --> false

            i1--, i2--
        }
        */
        public boolean backspaceCompare(String s, String t) {
            int i1, i2;
            i1 = s.length() - 1;
            i2 = t.length() - 1;
            int skip1 = 0, skip2 = 0;
            while (i1 >= 0 || i2 >= 0) {
                while (i1 >= 0) {
                    if (s.charAt(i1) == '#') {
                        i1--;
                        skip1++;
                    } else if (skip1 > 0) {
                        skip1--;
                        i1--;
                    } else
                        break;
                }
                while (i2 >= 0) {
                    if (t.charAt(i2) == '#') {
                        i2--;
                        skip2++;
                    } else if (skip2 > 0) {
                        skip2--;
                        i2--;
                    } else
                        break;
                }
                if (i1 >= 0 && i2 >= 0 && s.charAt(i1) != t.charAt(i2)) {
                    return false;
                } else if ((i1 >= 0) != (i2 >= 0)) {
                    return false;
                }

                i1--;
                i2--;
            }
            return true;
        }
    }
}
