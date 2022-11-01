package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word
may contain dots '.' where dots can be matched with any letter.

Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

Constraints:
1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 10^4 calls will be made to addWord and search.
 */
public class _98_DesignAddAndSearchWordsDataStructure {
    class WordDictionary {
        class Node {
            boolean root = false;
            boolean terminating = false;

            char c;
            Node[] children = new Node[26];
            Node () {

            }

            Node (char c) {
                this.c = c;
            }
        }

        Node root;

        public WordDictionary() {
            root = new Node();
            root.root = true;
        }

        public void addWord(String word) {
            Node curr = root;
            Node next = null;
            int index = 0;
            while (index < word.length()) {
                char c = word.charAt(index);
                next = curr.children[c - 'a'];
                if (next == null) {
                    next = new Node(c);
                    curr.children[c - 'a'] = next;
                }
                curr = next;
                index += 1;
            }
            curr.terminating = true;
        }

        public boolean search(String word) {
            int index = 0;

            List<Node> curr = new ArrayList<>();
            curr.add(root);
            List<Node> next = new ArrayList<>();
            List<Node> temp;
            while (index < word.length() && curr.size() > 0) {
                char c = word.charAt(index);
                int len = curr.size();
                if (c == '.') {
                    for (int i = 0; i < len; i++) {
                        Node parent = curr.get(i);

                        for (Node child: parent.children) {
                            if (child != null) {
                                next.add(child);
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < len; i++) {
                        Node parent = curr.get(i);

                        if (parent.children[c - 'a'] != null) {
                            next.add(parent.children[c - 'a']);
                        }
                    }
                }
                temp = curr;
                curr = next;
                next = temp;
                next.clear();

                index += 1;
            }

            for (Node parent : curr) {
                if (parent.terminating) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
