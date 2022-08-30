package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
//Complexity: M (N + M)
public class _21_MultiplyStrings {
    class Solution {
        public String multiply(String num1, String num2) {
            List<String> subProductList = new LinkedList<>();

            for (int i = num2.length() - 1; i >= 0; i--) {
                char num2Char = num2.charAt(i);
                int num2Digit = convertCharToDigit(num2Char);
                if (num2Digit == -1) {
                    return null;
                }

                StringBuffer productSb = new StringBuffer();
                int carry = 0;

                int digitIndex = num1.length() - 1;
                while (digitIndex >= 0) {
                    char num1Char = num1.charAt(digitIndex);
                    int num1Digit = convertCharToDigit(num1Char);
                    if (num1Digit == -1) {
                        return null;
                    }
                    int product = num1Digit * num2Digit;
                    int digit = (product + carry) % 10;
                    productSb.append(digit);
                    carry = (product + carry) / 10;
                    digitIndex -= 1;
                }
                if (carry > 0) {
                    productSb.append(carry);
                }

                int[] zeros = new int[num2.length() - 1 - i];
                productSb.reverse().append(Arrays.toString(zeros).replace(",", "").replace("[", "").replace("]", "")
                        .replace(" ", "").trim());

                subProductList.add(productSb.toString());
            }

            String sum = subProductList.get(0);
            for (int i = 1; i < subProductList.size(); i++) {
                sum = add(sum, subProductList.get(i));
            }

            int[] zeros = new int[sum.length()];
            String zero = Arrays.toString(zeros).replace(",", "").replace("[", "").replace("]", "").replace(" ", "")
                    .trim();
            return sum.equals(zero) ? "0" : sum;
        }

        public int convertCharToDigit(char c) {
            if (c < '0' || c > '9') {
                return -1;
            }
            return c - '0';
        }

        public String add(String num1, String num2) {
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
    }
}
