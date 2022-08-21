package leetcode.medium;

/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1*/

//create positive and negative bit vector
//for every number, toggle the corresponding bit in the bitvector
//find the bit that is 1, return bitPosition
public class _2_SingleNumber {
    public static int singleNumber(int[] nums) {
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

    private static void toggleBit(int[] bitVector, int num) {
        int mask = (1 << (num % 32));
        if ((bitVector[num / 32] & mask) == 0) {
            bitVector[num / 32] |= mask;
        } else {
            bitVector[num / 32] &= ~mask;
        }
    }

    private static Integer findSingleOccurenceElement(int num) {
        int index = -1;
        for (int x = num; x != 0; x = x >>> 1) {
            index += 1;
            if ((x & 1) == 1) {
                return index;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] num = {-507, -40, 657, -237, 895, -892, 232, -57, 667, 302, -720, 900, 280, -448, -731, 635, -484, 944,
                -531, 95, 349, 681, 583, 474, 450, -81, -458, 869, -730, 892, -537, 118, 138, 699, -469, 276, 831, 948,
                -347, -591, -874, -345, -517, -113, 115, 885, -885, -384, -227, 912, -977, 287, 119, -14, 353, 533, 714,
                -819, -8, 799, 273, 668, 946, -513, 524, -317, 825, 47, -325, 566, 732, -464, -108, -114, 271, -33, 673,
                613, 819, 951, 596, -687, 471, 112, -379, -721, 339, 898, 431, 510, -630, -515, 873, 592, -826, -942,
                579, -568, -327, -802, 643, 844, -889, -845, 877, -80, -579, -772, -99, 85, -934, 614, 928, 922, 941,
                389, -698, 996, 446, -332, -5, 717, -159, 359, -378, -627, 203, -64, -953, 2, -104, -717, -386, -463,
                358, 298, -492, -86, -143, 17, 660, 311, 716, 153, 698, -10, -400, -856, 189, 837, 726, -645, -763,
                -250, 434, -598, -566, 937, -478, 815, 337, -207, 823, -488, 759, -221, 332, -778, 878, -588, 960, 828,
                23, 994, -551, -540, -226, 336, 858, -915, 840, -674, 429, -165, 328, -116, -686, -983, -287, 93, 411,
                632, 366, -35, -694, -438, 437, 487, -194, -512, -501, -53, -277, 360, 390, -456, 461, 213, 94, -850,
                365, -831, 515, -41, 59, -78, -986, 484, -736, -925, 458, -493, -175, -334, -597, 345, -821, 851, -321,
                -669, 830, -162, 344, -952, 577, 320, -682, -85, -949, -111, 972, 812, -282, 626, 945, 565, 669, 288,
                560, -718, 21, -507, -40, 657, -237, 895, -892, 232, -57, 667, 302, -720, 900, 280, -448, -731, 635,
                -484, 944, -531, 95, 349, 681, 583, 474, 450, -81, -458, 869, -730, 892, -537, 118, 138, 699, -469, 276,
                831, 948, -347, -591, -874, -345, -517, -113, 115, 885, -885, -384, -227, 912, -977, 287, 119, -14, 353,
                533, 714, -819, -8, 799, 273, 668, 946, -513, 524, -317, 825, 47, -325, 566, 732, -464, -108, -114, 271,
                -33, 673, 613, 819, 951, 596, -687, 471, 112, -379, -721, 339, 898, 431, 510, -630, -515, 873, 592,
                -826, -942, 579, -568, -327, -802, 643, 844, -889, -845, 877, -80, -579, -772, -99, 85, -934, 614, 928,
                922, 941, 389, -698, 996, 446, -332, -5, 717, -159, 359, -378, -627, 203, -64, -953, 2, -104, -717,
                -386, -463, 358, 298, -492, -86, -143, 17, 660, 311, 716, 153, 698, -10, -400, -856, 189, 837, 726,
                -645, -763, -250, 434, -598, -566, 937, -478, 815, 337, -207, 823, -488, 759, -221, 332, -778, 878,
                -588, 960, 828, 23, 994, -551, -540, -226, 336, 858, -915, 840, -674, 429, -165, 328, -116, -686, -983,
                -287, 93, 411, 632, 366, -35, -694, -438, 437, 487, -194, -512, -501, -53, -277, 360, 390, -456, 461,
                213, 94, -850, 365, -831, 515, -41, 59, -78, -986, 484, -736, -925, 458, -493, -175, -334, -597, 345,
                -821, 851, -321, -669, 830, -162, 344, -952, 577, 320, -682, -85, -949, -111, 972, 812, -282, 626, 945,
                565, 669, 288, 560, -718, 21, 863};
        singleNumber(num);
    }
}
