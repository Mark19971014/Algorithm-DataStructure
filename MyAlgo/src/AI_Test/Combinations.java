package AI_Test;


import AI_Test.Atom;

import java.util.ArrayList;
import java.util.HashSet;

public class Combinations {

    public static HashSet<HashSet<Atom>> generateAtomCombinations(HashSet<Atom> fluids, int length){
        HashSet<HashSet<Atom>> result = new HashSet<>();
        generateCombinationsRecursive(result, new HashSet<>(),new ArrayList<>(fluids),length,0);
        return result;
    }

    private static void generateCombinationsRecursive(HashSet<HashSet<Atom>> result, HashSet<Atom> current, ArrayList<Atom> atoms, int length, int start) {
        // If the current combination is the desired length, add it to the result set
        if (current.size() == length) {
            result.add(new HashSet<>(current));
            return;
        }

        // Go through each atom and try to add it to the current combination
        for (int i = start; i < atoms.size(); i++) {
            current.add(atoms.get(i));
            // Recurse with the next starting index to avoid duplicates
            generateCombinationsRecursive(result, current, atoms, length, i + 1);
            // Remove the last atom to backtrack and try the next one
            current.remove(atoms.get(i));
        }
    }

    public static void main(String[] args) {
        HashSet<Atom> state  = new HashSet<>();
//AgentAt(0,L3),BoxAt(A,L4),GoalAt(a,L1),Free(L2),Free(L1)
        ArrayList<String> atom_par = new ArrayList<String>();
        atom_par.add("0");
        atom_par.add("L3");
        Atom atom1 = new Atom(Atom.AtomType.AgentAt,atom_par);
        state.add(atom1);

        // Create the BoxAt(A,L4) atom
        ArrayList<String> boxAtParams = new ArrayList<>();
        boxAtParams.add("A");
        boxAtParams.add("L4");
        Atom boxAtAtom = new Atom(Atom.AtomType.BoxAt, boxAtParams);

// Add the new atom to the state
        state.add(boxAtAtom);

// Create the GoalAt(a,L1) atom
        ArrayList<String> goalAtParams = new ArrayList<>();
        goalAtParams.add("a");
        goalAtParams.add("L1");
        Atom goalAtAtom = new Atom(Atom.AtomType.GoalAt, goalAtParams);

// Add the new atom to the state
        state.add(goalAtAtom);

// Create the Free(L2) atom
        ArrayList<String> freeL2Params = new ArrayList<>();
        freeL2Params.add("L2");
        Atom freeL2Atom = new Atom(Atom.AtomType.Free, freeL2Params);

// Add the new atom to the state
        state.add(freeL2Atom);

// Create the Free(L1) atom
        ArrayList<String> freeL1Params = new ArrayList<>();
        freeL1Params.add("L1");
        Atom freeL1Atom = new Atom(Atom.AtomType.Free, freeL1Params);

// Add the new atom to the state
        state.add(freeL1Atom);

        HashSet<HashSet<Atom>> res = generateAtomCombinations(state,3);

    }
}
