package leetcode;

import java.util.Arrays;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without
changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class _82_LongestIncreasingSubsequence {
    class Solution {
        //_ _ _ _
        //[4] = 1
        //[3] = 1 or 2
        public int lengthOfLIS(int[] nums) {
            int[] memo = new int[nums.length];
            Arrays.fill(memo, 1);

            int index = nums.length - 2;
            int maxLength = 1;
            int length = 0;
            while (index >= 0) {
                length = 0;
                for (int i = index + 1; i < nums.length; i++) {
                    if (nums[i] > nums[index] && memo[i] > length) {
                        length = memo[i];
                    }
                }
                memo[index] += length;
                if (memo[index] > maxLength) {
                    maxLength = memo[index];
                }
                index -= 1;
            }
            return maxLength;
        }
    }
}
