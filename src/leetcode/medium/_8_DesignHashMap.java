package leetcode.medium;

/*
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

Example 1:
Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]

Constraints:

0 <= key, value <= 10^6
At most 10^4 calls will be made to put, get, and remove.
 */
public class _8_DesignHashMap {
    class MyHashMap {
        class Entry {
            int key;
            int value;

            Entry next;

            public Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int DEFAULT_CAPACITY = 10000;
        Entry[] keyValuePairs;

        public MyHashMap() {
            keyValuePairs = new Entry[DEFAULT_CAPACITY];
        }

        public void put(int key, int value) {
            int hashIndex = hashIndex(key);
            Entry entry = keyValuePairs[hashIndex];
            while (entry != null) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            entry = new Entry(key, value);
            entry.next = keyValuePairs[hashIndex];
            keyValuePairs[hashIndex] = entry;
        }

        public int get(int key) {
            int hashIndex = hashIndex(key);
            Entry entry = keyValuePairs[hashIndex];
            while (entry != null) {
                if (entry.key == key) {
                    return entry.value;
                }
                entry = entry.next;
            }
            return -1;
        }

        public void remove(int key) {
            int hashIndex = hashIndex(key);
            Entry entry = keyValuePairs[hashIndex];

            if (entry == null) {
                return;
            }

            if (entry.key == key) {
                keyValuePairs[hashIndex] = entry.next;
                return;
            }

            Entry prev = entry;
            entry = entry.next;
            while (entry != null) {
                if (entry.key == key) {
                    prev.next = entry.next;
                    entry.next = null;
                    return;
                }
                prev = entry;
                entry = entry.next;
            }
        }

        private int hashIndex(int key) {
            return key % DEFAULT_CAPACITY;
        }
    }
}
