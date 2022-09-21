package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8
 */
public class _74_GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> parenthesisList = new ArrayList<String>();
            StringBuffer parenthesis = new StringBuffer();
            generateParenthesisHelper(n, n, parenthesis, parenthesisList);
            return parenthesisList;
        }

        private void generateParenthesisHelper(int leftRemaining, int rightRemaining, StringBuffer parenthesis,
                List<String> parenthesisList) {
            if (rightRemaining == 0 && leftRemaining == 0) {
                parenthesisList.add(parenthesis.toString());
            }

            if (leftRemaining > 0) {
                parenthesis.append("(");
                generateParenthesisHelper(leftRemaining - 1, rightRemaining, parenthesis, parenthesisList);
                parenthesis.deleteCharAt(parenthesis.length() - 1);
            }

            if (rightRemaining > leftRemaining) {
                parenthesis.append(")");
                generateParenthesisHelper(leftRemaining, rightRemaining - 1, parenthesis, parenthesisList);
                parenthesis.deleteCharAt(parenthesis.length() - 1);
            }
        }
    }
}
