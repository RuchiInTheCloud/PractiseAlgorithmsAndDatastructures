package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _58_FindAllAnagramsInAString {
    class Solution {
        //int frequencyP, frequencyS
        //buildfreq p
        //buildfreq s (0, p.length())
        //isEqual(frequencyP, frequencyS) --> add index 0
        //for i = p.length --> s.length
        //  increment frequencyS at index s.charAt(i)
        //  decrement frequencyS at index s.charAt(i - p.length)
        //  isEqual(frequencyP, frequencyS) --> add index i
        //return index List
        final static int CHARACTER_COUNT = 'Z' - 'A' + 1;
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> indexList = new ArrayList<Integer>();
            if (s.length() < p.length()) {
                return indexList;
            }

            int pLength = p.length();
            int[] frequencyP, frequencyS;
            frequencyP = new int[CHARACTER_COUNT];
            frequencyS = new int[CHARACTER_COUNT];

            buildCharacterFrequency(p, frequencyP);
            buildCharacterFrequency(s.substring(0, pLength), frequencyS);

            if (Arrays.equals(frequencyP, frequencyS)) {
                indexList.add(0);
            }

            for (int i = pLength; i < s.length(); i++) {
                frequencyS[s.charAt(i) - 'a']++;
                frequencyS[s.charAt(i - pLength) - 'a']--;
                if (Arrays.equals(frequencyP, frequencyS)) {
                    indexList.add(i - pLength + 1);
                }
            }
            return indexList;
        }

        private void buildCharacterFrequency(String x, int[] frequency) {
            for (int i = 0; i < x.length(); i++) {
                frequency[x.charAt(i) - 'a']++;
            }
        }
    }
}
