package leetcode;

import java.util.Arrays;

/*
Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.

Example 1:
Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length
1, so output 5.

Constraints:
1 <= nums.length <= 2000
-10^6 <= nums[i] <= 10^6
 */
public class _83_NumberOfLongestIncreasingSubsequence {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int[] memo = new int[nums.length];
            int[] counts = new int[nums.length];
            Arrays.fill(memo, 1);
            counts[nums.length - 1] = 1;

            int maxLength = 1;
            int maxCount = 1;
            int length = 0;
            int count = 1;
            int index = nums.length - 2;
            while (index >= 0) {
                length = 0;
                count = 1;
                for (int i = index + 1; i < nums.length; i++) {
                    if (nums[i] > nums[index] && memo[i] > length) {
                        length = memo[i];
                        count = counts[i];
                    } else if (nums[i] > nums[index] && memo[i] == length) {
                        count += counts[i];
                    }
                }
                memo[index] += length;
                counts[index] = count;
                if (memo[index] > maxLength) {
                    maxLength = memo[index];
                    maxCount = counts[index];
                } else if (memo[index] == maxLength) {
                    maxCount += counts[index];
                }
                index -= 1;
            }

            return maxCount;
        }
    }
}
