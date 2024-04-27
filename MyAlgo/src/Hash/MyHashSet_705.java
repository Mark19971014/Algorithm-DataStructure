package Hash;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet_705 {

    private bucket[] bucket;
    private int keyRange;
    public MyHashSet_705(){
       this.keyRange = 769;
       this.bucket = new bucket[this.keyRange];
       for(int i = 0; i < bucket.length;i++){
           bucket[i] = new bucket();
       }
    }

    protected int _hash(int key){
        return key%keyRange;
    }
    public void add(int val){
        int index = this._hash(val);
        this.bucket[index].insert(val);
    }

    public boolean contains(int val){
        int index = this._hash(val);
        return this.bucket[index].contains(val);
    }

    public void remove(int val){
        int index = this._hash(val);
        this.bucket[index].delete(val);
    }
}

class bucket{
    LinkedList<Integer> Container;
    public bucket(){
        this.Container = new LinkedList<>();
    }


    public void delete(int val){
        this.Container.remove(val);
    }

    public void insert(Integer val){
        if(!this.Container.contains(val)){
            this.Container.addFirst(val);
        }
    }

    public boolean contains(Integer val){
        return this.Container.contains(val);
    }
}