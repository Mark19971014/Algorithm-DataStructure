package Graph;

import java.util.*;

public class GeneMutation_433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (!Arrays.asList(bank).contains(endGene)) return -1;
        char[] letters = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new ArrayDeque<>();
        queue.add(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i <  size;i++){
             String cur = queue.poll();
             char[] curGene = cur.toCharArray();
             for(int j = 0; j < curGene.length;j++){
                 char oldChar = curGene[j];
                 for(char letter : letters){
                     curGene[j] = letter;
                     String  newGene = new String(curGene);// what is this
                    if(!visited.contains(newGene) && bankSet.contains(newGene)){
                        queue.add(newGene);
                        visited.add(newGene);
                    }
                 }
                curGene[j] = oldChar;
             }
            }
            depth++; // Increment the depth after exploring all possible mutations at the current level.
        }
        return -1;
    }

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
       String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
       GeneMutation_433 test = new GeneMutation_433();
       test.minMutation(startGene,endGene,bank);

    }
}
