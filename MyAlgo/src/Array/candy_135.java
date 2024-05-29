package Array;

public class candy_135 {
    public int candy(int[] ratings) {
        int num = ratings.length;
        int[] res = new int[num];
        for (int i = 0; i < num; i++){
            res[i] = 1;
        }

        // check left to right , compare to left neighbour
        for(int i = 1; i < ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1] +1;
            }
        }
        // right to left, compare to right neighbour
        for(int j = ratings.length - 2; j >= 0; j--){
            if(ratings[j] > ratings[j + 1]){
                res[j] = Math.max(res[j], res[j + 1] + 1);
            }
        }

        int sum = 0;
        for(int candy : res){
            sum += candy;
        }

        return sum;
    }

    public static void main(String[] args) {
        candy_135 test = new candy_135();
        int[] ratings = {1,0,2};
        System.out.println(test.candy(ratings));
    }
}
