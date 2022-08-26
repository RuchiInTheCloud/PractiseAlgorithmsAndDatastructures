package leetcode;
/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:
Input: num1 = "0", num2 = "0"
Output: "0"

Constraints:
1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
*/
public class _16_AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            int num1Index, num2Index;
            num1Index = num1.length() - 1;
            num2Index = num2.length() - 1;

            int digitA, digitB;
            int carry = 0;

            StringBuilder result = new StringBuilder();

            while (num1Index >= 0 || num2Index >= 0) {
                digitA = num1Index >= 0 ? convertCharToDigit(num1.charAt(num1Index)) : 0;
                digitB = num2Index >= 0 ? convertCharToDigit(num2.charAt(num2Index)) : 0;

                if (digitA == -1 || digitB == -1) {
                    return null;
                }

                result.append(((digitA + digitB + carry) % 10));
                carry = (digitA + digitB + carry) / 10;
                num1Index--;
                num2Index--;
            }

            if (carry > 0) {
                result.append(carry);
            }

            return result.reverse().toString();
        }

        private int convertCharToDigit(char c) {
            if (c < '0' || c > '9') {
                return -1;
            }
            return c - '0';
        }
    }
}
