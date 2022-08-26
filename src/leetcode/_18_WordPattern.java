package leetcode;

import java.util.HashMap;

/*
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */
public class _18_WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        HashMap<String, Integer> wordMap = new HashMap<>();
        HashMap<Character, Integer> characterMap = new HashMap<>();

        int index = 0;
        for (String word : words) {
            char c = pattern.charAt(index);
            if (!wordMap.containsKey(word) && !characterMap.containsKey(c)) {
                wordMap.put(word, index);
                characterMap.put(c, index);
            } else if (!wordMap.containsKey(word) || !characterMap.containsKey(c) || !wordMap.get(word).equals(characterMap.get(c))) {
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        wordPattern(
                "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t");
    }
}
