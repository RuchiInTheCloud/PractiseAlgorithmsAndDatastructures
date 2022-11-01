package leetcode;

import java.util.HashMap;

public class _97_ImplementTriePrefixTree {
    class Trie {
        class Node {
            boolean root = false;
            boolean terminating = false;

            char c;
            HashMap<Character, Node> children = new HashMap<>();
            Node () {

            }

            Node (char c) {
                this.c = c;
            }
        }

        Node root;

        public Trie() {
            root = new Node();
            root.root = true;
        }

        public void insert(String word) {
            Node curr = root;
            Node next = null;
            int index = 0;
            while (index < word.length()) {
                char c = word.charAt(index);
                next = curr.children.get(c);
                if (next == null) {
                    next = new Node(c);
                    curr.children.put(c, next);
                }
                curr = next;
                index += 1;
            }
            curr.terminating = true;
        }

        public boolean search(String word) {
            Node curr = root;
            int index = 0;
            while (index < word.length()) {
                char c = word.charAt(index);
                Node next = curr.children.get(c);
                if (next == null) {
                    return false;
                }
                curr = next;
                index += 1;
            }
            return curr.terminating;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            int index = 0;
            while (index < prefix.length()) {
                char c = prefix.charAt(index);
                Node next = curr.children.get(c);
                if (next == null) {
                    return false;
                }
                curr = next;
                index += 1;
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
