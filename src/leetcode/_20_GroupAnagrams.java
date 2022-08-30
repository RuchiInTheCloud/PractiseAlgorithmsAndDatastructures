package leetcode;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
No need to sort strings, instead represent a string as a count# b count # ....z count #
 */
public class _20_GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> anagramGroups = new HashMap<>();
            for (String str: strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String sortedString = new String(charArray);
                if (!anagramGroups.containsKey(sortedString)) {
                    anagramGroups.put(sortedString, new LinkedList<>());
                }
                List<String> anagrams = anagramGroups.get(sortedString);
                anagrams.add(str);
            }
            List<List<String>> anagramLists = new LinkedList<>();
            for (String sortedString: anagramGroups.keySet()) {
                List<String> anagrams = anagramGroups.get(sortedString);
                anagramLists.add(anagrams);
            }
            return anagramLists;
        }
    }
}
