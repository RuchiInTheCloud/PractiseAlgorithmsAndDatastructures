package leetcode;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4
Each element in the array appears twice except for one element which appears only once.
*/

//create positive and negative bit vector
//for every number, toggle the corresponding bit in the bitvector
//find the bit that is 1, return bitPosition
public class _2_SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int bitVectorLength = (int) (3 * Math.pow(10, 4)) / 32 + 1;
            int[] positiveBitVector = new int[bitVectorLength];
            int[] negativeBitVector = new int[bitVectorLength];

            for (int x : nums) {
                if (x >= 0) {
                    toggleBit(positiveBitVector, x);
                } else {
                    toggleBit(negativeBitVector, -1 * x);
                }
            }

            for (int i = 0; i < bitVectorLength; i++) {
                Integer singleOccurenceElement = findSingleOccurenceElement(positiveBitVector[i]);
                if (singleOccurenceElement != null) {
                    return i * 32 + singleOccurenceElement;
                }
                singleOccurenceElement = findSingleOccurenceElement(negativeBitVector[i]);
                if (singleOccurenceElement != null) {
                    return -1 * (i * 32 + singleOccurenceElement);
                }
            }
            return 0;
        }

        private void toggleBit(int[] bitVector, int num) {
            int mask = (1 << (num % 32));
            if ((bitVector[num / 32] & mask) == 0) {
                bitVector[num / 32] |= mask;
            } else {
                bitVector[num / 32] &= ~mask;
            }
        }

        private Integer findSingleOccurenceElement(int num) {
            int index = -1;
            for (int x = num; x != 0; x = x >>> 1) {
                index += 1;
                if ((x & 1) == 1) {
                    return index;
                }
            }
            return null;
        }
    }
}
