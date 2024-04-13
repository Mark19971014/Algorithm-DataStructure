package Set;

import java.util.HashSet;
import java.util.Set;

public class Micro_test01 {

    public int solution(int[] A, int[] B) {
        // Sets to store unique candy types
        Set<Integer> uniqueA = new HashSet<>();
        Set<Integer> uniqueB = new HashSet<>();
        Set<Integer> common = new HashSet<>();
        int N = A.length;
        int count = 0;
        int sum = 0;
        // Fill sets with unique candy types for each shop
        for (int candyType : A) {
            uniqueA.add(candyType);
        }
        for (int candyType : B) {
            uniqueB.add(candyType);
        }

        for(int c : uniqueA){
            if(uniqueB.contains(c)){
                common.add(c);
                count++;
            }
        }

        sum = uniqueB.size() + (uniqueA.size() - count);


        return  sum;

    }

    public static void main(String[] args) {
        int[] A = {1,1,1,3,4,5,5,5};
        int[] B = {1,1,2,3,4,5,5,5};

        Micro_test01 solution = new Micro_test01();
        System.out.println(solution.solution(A,B));
    }
}
