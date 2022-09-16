package leetcode;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class _60_MinimumSizeSubarraySum {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int smallestSize = Integer.MAX_VALUE;
            int contSum = 0;
            for (int right = 0; right < nums.length; right++) {
                contSum += nums[right];
                while (contSum >= target) {
                    smallestSize = Math.min(smallestSize, right - left + 1);
                    contSum -= nums[left++];
                }
            }
            return smallestSize == Integer.MAX_VALUE ? 0 : smallestSize;
        }
    }
}
