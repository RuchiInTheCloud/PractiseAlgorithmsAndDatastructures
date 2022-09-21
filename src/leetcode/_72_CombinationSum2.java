package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */
public class _72_CombinationSum2 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> combinations = new ArrayList<>();
            List<Integer> combination = new ArrayList<>();
            generateCombinations(candidates, 0, target, combination, combinations);
            return combinations;
        }

        private void generateCombinations(int[] candidates, int index, int target, List<Integer> combination,
                List<List<Integer>> combinations) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination));
            } else if (target > 0) {
                for (int i = index; i < candidates.length; i++) {
                    if (i > index && candidates[i] == candidates[i - 1])
                        continue;
                    combination.add(candidates[i]);
                    generateCombinations(candidates, i + 1, target - candidates[i], combination, combinations);
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }
}
