package leetcode;

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
 are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?*/
public class _6_SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            final int red = 0;
            final int white = 1;
            final int blue = 2;

            int redCount = 0;
            int whiteCount = 0;
            int blueCount = 0;
            for (int i = 0; i < nums.length; i++) {
                switch (nums[i]) {
                    case red:
                        redCount++;
                        break;
                    case white:
                        whiteCount++;
                        break;
                    case blue:
                        blueCount++;
                        break;
                    default:
                        break;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (redCount > 0) {
                    nums[i] = red;
                    redCount--;
                } else if (whiteCount > 0) {
                    nums[i] = white;
                    whiteCount--;
                } else if (blueCount > 0) {
                    nums[i] = blue;
                    blueCount--;
                }
            }
        }
    }
}
