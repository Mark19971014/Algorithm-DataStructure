package Hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Entry{
    int key;
    int val;
    public Entry(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class Bucket {
    private List<Entry> container;

    public Bucket() {
        this.container = new LinkedList<>();
    }

    public void delete(Integer key) {
        this.container.removeIf(Entry -> Entry.key == key);

    }

    public void insert(Integer key, Integer val) {
        for (Entry entry : this.container) {
            if (key == entry.key) {
                entry.val = val;
            }
        }

        this.container.add(new Entry(key, val));
    }

    public int get(Integer key) {
        for (Entry entry : this.container) {
            if (key == entry.key) {
                return entry.val;
            }
        }
        return -1;
    }
}

public class MyHashMap_706 {
    private Bucket[] bucket;
    private int keyRange;
    public MyHashMap_706(){
        this.keyRange = 769;
        this.bucket = new Bucket[keyRange];
    //initialize the entry of bucket list as null bucket initially
    for (int i = 0; i < keyRange; i++){
        bucket[i] = new Bucket();
        }
    }

    public int  hashcode(int key){
        return key % keyRange;
    }

    public int get(int key){
        int idx = this.hashcode(key);
       return this.bucket[idx].get(key);
    }

    public void remove(int key){
        int idx = this.hashcode(key);

        this.bucket[idx].delete(key);
    }

    public void put(int key, int val){
        int idx = this.hashcode(key);
        this.bucket[idx].insert(key,val);
    }

    public static void main(String[] args) {
        MyHashMap_706 myHashMap = new MyHashMap_706();

        // Test put and get methods
        myHashMap.put(1, 100);
        myHashMap.put(2, 200);
        System.out.println("The value for key 1 should be 100: " + myHashMap.get(1));
        System.out.println("The value for key 2 should be 200: " + myHashMap.get(2));

        // Test updating an existing key
        myHashMap.put(1, 101);
        System.out.println("The value for key 1 after update should be 101: " + myHashMap.get(1));

        // Test removing a key
        myHashMap.remove(1);
        System.out.println("The value for key 1 after removal should be -1: " + myHashMap.get(1));

        // Test a key that does not exist
        System.out.println("The value for a non-existent key should be -1: " + myHashMap.get(3));
    }
}

