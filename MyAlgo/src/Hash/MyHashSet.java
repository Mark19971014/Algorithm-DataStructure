package Hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    private final int ARRAY_SIZE = 100;
    private final int MAX_VALUE = 100000;
    List<List<Integer>> parent;
    // we can also use height-balanced binary search tree instead
    public MyHashSet(){
        this.parent = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE;i++){
            parent.add(null);
        }
    }

    public void add(int value){
        int idx = value % ARRAY_SIZE;
        List<Integer> childList = parent.get(idx);
        if (childList == null){
            List<Integer> list = new LinkedList<>();
            list.add(value);
            //what is this
            parent.set(idx,list);
        }else {
            if(!childList.contains(value)){
                childList.add(value);
            }
        }
    }

    public void remove(int value){
        int idx = value % ARRAY_SIZE;
        List<Integer> childList = parent.get(idx);
        // what if we dont have this value do we need add childList != null && childList.contains(value)
        if(childList != null){
            childList.remove(Integer.valueOf(value));
        }

    }

    public boolean contains(int value ){
        int idx = value % ARRAY_SIZE;
        List<Integer> childList = parent.get(idx);
        return childList != null && childList.contains(value);
    }
}
