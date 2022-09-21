package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
public class _73_LetterCombinationsOfAPhoneNumber {
    class Solution {
        final char[][] digitToLetter = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<>();
            if (digits.length() == 0) {
                return combinations;
            } else {
                StringBuffer combination = new StringBuffer();
                prepareLetterCombinations(digits, 0, combination, combinations);
                return combinations;
            }
        }

        private void prepareLetterCombinations(String digits, int index, StringBuffer combination,
                List<String> combinations) {
            if (index == digits.length()) {
                combinations.add(combination.toString());
            } else {
                int digit = digits.charAt(index) - '0';
                for (char c : digitToLetter[digit]) {
                    combination.append(c);
                    prepareLetterCombinations(digits, index + 1, combination, combinations);
                    combination.deleteCharAt(combination.length() - 1);
                }
            }
        }
    }
}
