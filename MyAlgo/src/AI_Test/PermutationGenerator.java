package AI_Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationGenerator {

    public static void main(String[] args) {
        List<String> agentX = Arrays.asList("actionX0", "actionX1", "actionX2");
        List<String> agentY = Arrays.asList("actionY0", "actionY1", "actionY2");
        List<String> agentZ = Arrays.asList("actionZ0", "actionZ1", "actionZ2");
        List<String> agentA = Arrays.asList("actionA0", "actionA1", "actionA2");

        List<List<String>> agents = new ArrayList<>();
        agents.add(agentX);
        agents.add(agentY);
        agents.add(agentZ);
        agents.add(agentA);


        List<List<String>> permutations = generatePermutations(agents);

        // Print the permutations
        for (List<String> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<List<String>> generatePermutations(List<List<String>> lists) {
        List<List<String>> result = new ArrayList<>();
        // Start with an initial list of an empty list
        result.add(new ArrayList<>());

        for (List<String> list : lists) {
            // List to hold the current set of permutations
            List<List<String>> current = new ArrayList<>();

            for (List<String> permutation : result) {
                for (String item : list) {
                    // Create new permutation by adding the current item to it
                    List<String> newPermutation = new ArrayList<>(permutation);
                    newPermutation.add(item);
                    // Add new permutation to current
                    current.add(newPermutation);
                }
            }
            // Update our result with the current set of permutations
            result = current;
        }
        return result;
    }
}