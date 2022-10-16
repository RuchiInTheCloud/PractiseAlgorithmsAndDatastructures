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
//Complexity: M * N
public class _21_MultiplyStrings {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return String.valueOf(0);
            }

            int len1 = num1.length() - 1;
            int len2 = num2.length() - 1;
            int i1, i2;
            i1 = len1;
            i2 = len2;

            int a;
            int b;

            int[] num = new int[i1 + i2 + 2];
            Arrays.fill(num, 0);
            while (i1 >= 0) {
                a = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
                b = i2 >= 0 ? num2.charAt(i2) - '0': 0;
                num[len1 + len2 - i1 - i2] += (a * b) % 10;
                num[len1 + len2 - i1 - i2 + 1] += (a * b) / 10;

                i2 -= 1;
                if (i2 == -1) {
                    i1 -= 1;
                    i2 = num2.length() - 1;
                }
            }

            StringBuffer numString = new StringBuffer();
            int sum = 0;
            int carry = 0;
            for (int i = 0; i < num.length; i++) {
                if (i == num.length - 1 && num[i] == 0) continue;
                if (num[i] > 9) {
                    sum = num[i] % 10;
                    carry = num[i] / 10;
                    num[i] = sum;
                    num[i + 1] += carry;
                }
                numString.append(String.valueOf(num[i]));
            }
            return numString.reverse().toString();
        }
    }
}
