package Array;

import java.util.Arrays;

public class H_index_274 {
    public int hIndex (int[] citations){
       if(citations.length == 0) return 0;
       Arrays.sort(citations);
       int h = 0;
       for(int i = citations.length - 1; i >= 0; i-- ){
           if(citations[i] > h){
               h++;
           }else {
               break;
           }
       }

       return h;
    }

    public static void main(String[] args) {
        H_index_274 test = new H_index_274();
        int[] citations = {11,15};
        System.out.println(test.hIndex(citations));
    }
}
