package leetcode;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
 */
public class _49_KThLargestElementInAnArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            return findKthLargest(nums, k, 0, nums.length - 1);
        }

        private int findKthLargest(int[] nums, int k, int l, int r) {
            int pivot = nums[r];
            int p = l;
            for (int i = l; i < r; i++) {
                if (nums[i] <= pivot) {
                    swap(nums, i, p);
                    p += 1;
                }
            }
            swap(nums, p, r);
            if (p == k) {
                return nums[p];
            } else if (p < k) {
                return findKthLargest(nums, k, p + 1, r);
            } else {
                return findKthLargest(nums, k, l, p - 1);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
