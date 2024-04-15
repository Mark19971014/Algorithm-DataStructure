package DataStructure;

import java.util.HashMap;
import java.util.List;

/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.*/
class ListNode{
    int val;
    int key;
    ListNode next;
    ListNode prev;

    public ListNode(int val,int key){
        this.val = val;
        this.key = key;
    }
}
public class LRUCache_146 {

    ListNode head;
    ListNode tail;
    int capacity;
    HashMap<Integer,ListNode> map;
    public LRUCache_146(int capacity){
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail; // build the initial double linkedList;
        tail.prev = head;
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            remove(node);
            insertAtHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            cur.val = val;
            remove(cur);
            insertAtHead(cur);
        }else {
            if(map.size() == capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            ListNode cur = new ListNode(key,val);
            map.put(key,cur);
            insertAtHead(cur);
        }
    }

    public void remove(ListNode node){
        //bypass the node
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void insertAtHead(ListNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;

    }
}
