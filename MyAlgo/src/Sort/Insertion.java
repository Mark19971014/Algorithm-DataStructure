package Sort;

import java.util.Arrays;

public class Insertion {
    public void insertionSort1D(int[] arr){
        int len = arr.length;
        for(int i = 1 ; i < len; i++){

            int key = arr[i];
            int j = i - 1;
            //如果当前比较的数字比key大
            while (j >= 0 && arr[j] > key){
              //把当前数字往后放一位
                arr[j + 1] = arr[j];
               // 向前继续比较 当前数字与key
               j--;
            }
            // key 比当前数小 将当前数字插入至当前后数字一位
            //因为退出while的条件，是当前数字的前一位，所以 + 1 即把数字放到当前比较位置
            arr[j + 1] = key;
        }
    }

    public void sort(int[][] interval){
        int length = interval.length;

        for(int i  = 1; i < length; i++){
            int key = interval[i][0];
            int j = i - 1;
            int[] keyInterval = interval[i];

            while(j >= 0 && interval[j][0] > key ){
                interval[j + 1] = interval[j];
                j--;
            }
            interval[j + 1] = keyInterval;
        }
    }

    public static void main(String[] args) {
        Insertion test = new Insertion();
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        test.sort(arr);
        for (int[] i : arr){
            System.out.println(Arrays.toString(i));
        }
    }
}
