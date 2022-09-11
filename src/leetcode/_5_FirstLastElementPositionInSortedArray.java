package leetcode;

import java.util.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
*/
public class _5_FirstLastElementPositionInSortedArray {
    /*
    Binary search the element
    Boundary condition:
    - Not found --> return -1, -1
    Search the left to find the first position
    Search the right to find the last position
    */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = Arrays.binarySearch(nums, target);
            if (index < 0) {
                return new int[]{-1, -1};
            }

            int left = index;
            while (left > 0 && nums[left - 1] == nums[left]) {
                left--;
            }
            int right = index;
            while (right < nums.length - 1 && nums[right + 1] == nums[right]) {
                right++;
            }
            return new int[]{left, right};
        }
    }
}
