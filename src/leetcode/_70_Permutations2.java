package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */
public class _70_Permutations2 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            HashMap<Integer, Integer> numFrequency = new HashMap<>();
            for (int num : nums) {
                numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
            }

            List<List<Integer>> uniquePermutations = new LinkedList<>();
            generateAllPermutations(nums, numFrequency, new ArrayList<Integer>(), uniquePermutations);
            return uniquePermutations;
        }

        private void generateAllPermutations(int[] nums, HashMap<Integer, Integer> numFrequency,
                List<Integer> permutation, List<List<Integer>> uniquePermutations) {
            if (permutation.size() == nums.length) {
                uniquePermutations.add(new LinkedList<>(permutation));
            } else {
                for (int num : numFrequency.keySet()) {
                    if (numFrequency.get(num) > 0) {
                        permutation.add(num);
                        numFrequency.put(num, numFrequency.get(num) - 1);
                        generateAllPermutations(nums, numFrequency, permutation, uniquePermutations);
                        permutation.remove(permutation.size() - 1);
                        numFrequency.put(num, numFrequency.get(num) + 1);
                    }
                }
            }
        }
    }
}
