package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */
public class _68_Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int size = 1 << nums.length;
            List<List<Integer>> subsets = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = createSubset(nums, i);
                subsets.add(subset);
            }
            return subsets;
        }

        private List<Integer> createSubset(int[] nums, int num) {
            int index = 0;
            List<Integer> subset = new LinkedList<>();
            for (int i = num; i != 0; i = (i >> 1)) {
                if ((i & 1) != 0) {
                    subset.add(nums[index]);
                }
                index++;
            }
            return subset;
        }
    }
}
