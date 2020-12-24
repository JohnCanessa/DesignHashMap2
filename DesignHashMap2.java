/**
 * LeetCode 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/
 */


/**
 * Auxiliary class used to track hashmap key:value pairs.
 */
class KVNode {

    // **** members ****
    public int key;
    public int value;

    // **** constructor ****
    public KVNode(int key, int value) {
        this.key    = key;
        this.value  = value;
    }
}


/**
 * Designs and implements a HashMap without using 
 * any built-in hash table libraries.
 *
 * Runtime: 11 ms, faster than 99.41% of Java online submissions.
 * emory Usage: 43.4 MB, less than 70.92% of Java online submissions.
 */
class MyHashMap {
 
    // **** constant ****
    final int INITIAL_CAPACITY = 100000;
 
    // **** class variables ****
    private KVNode[] map;
    public int capacity;
 
    // **** constructor ****
    public MyHashMap() {
        this.map        = new KVNode[INITIAL_CAPACITY];
        this.capacity   = INITIAL_CAPACITY;
    }

    // **** map a key to a bucket number ****
    private int hashFc(int key) {
        return key % capacity;
    }
 
    // **** value will always be non-negative ****
    public void put(int key, int value) {

        // **** compute the bucket number ****
        int bucket = hashFc(key);

        // **** set the key value pair in the map ****
        if (this.map[bucket] == null) {
            this.map[bucket] = new KVNode(key, value);
        } else {
            this.map[bucket].key    = key;
            this.map[bucket].value  = value;
        }
    }
 
    // **** returns the value to which the specified key is mapped, 
    //      or -1 if this map contains no mapping for the key ****
    public int get(int key) {

        // **** compute the bucket number ****
        int bucket = hashFc(key);

        // **** return the associated value ****
        if (this.map[bucket] == null) {
            return -1;
        } else {
            return this.map[bucket].value;
        }
    }

    // **** remove the mapping of the specified value key 
    //      if this map contains a mapping for the key ****
    public void remove(int key) {

        // **** compute the bucket number ****
        int bucket = hashFc(key);
        
        // **** remove key value pair from map ****
        this.map[bucket] = null;
    }
 
    // **** for testing purpose only ****
    @Override
    public String toString() {
 
        // **** initialization ****
        StringBuilder sb = new StringBuilder();
 
        // **** traverse the map collecting key value pairs ****
        for (int i = 0; i < this.map.length; i++) {
            if (this.map[i] != null) {
                sb.append(this.map[i].key + "=" + this.map[i].value + " ");
            }
        }
 
        // **** return string ****
        return sb.toString();
    }
}


/**
 * Test scaffolding
 */
public class DesignHashMap2 {

    /**
     * Test scaffolding
     */
    public static void main(String[] args) {
        
        // **** create my hash map ****
        MyHashMap hm = new MyHashMap();
    
        // **** put key:value pair ****
        hm.put(1, 1);
    
        // **** put key:value pair ****
        hm.put(2, 2);
    
        // ???? ????
        System.out.println("main <<< hm: " + hm.toString());
    
        // **** get value for specified key ****
        System.out.println("main <<< hm.get(1): " + hm.get(1));
    
        // **** get value for specified key ****
        System.out.println("main <<< hm.get(3): " + hm.get(3));
    
        // **** put key:value pair ****
        hm.put(2, 1);
    
        // ???? ????
        System.out.println("main <<< hm: " + hm.toString());
    
        // **** get value for specified key ****
        System.out.println("main <<< hm.get(2): " + hm.get(2));
    
        // *** remove key value pair for specified key ****
        hm.remove(2);
    
        // ???? ????
        System.out.println("main <<< hm: " + hm.toString());
    
        // **** get value for specified key ****
        System.out.println("main <<< hm.get(2): " + hm.get(2));
    }
}