package AI_Test;

import java.util.ArrayList;

public class Atom {
    enum AtomType {
        BoxAt,
        AgentAt,
        GoalAt,
        Free,
        Neighbour,
        Color;

    }

    final AtomType atype;
    final ArrayList<String> params;

    public Atom(AtomType atype, ArrayList<String> params) {
        this.atype = atype;
        this.params = params;
    }

    public AtomType getAtomType() {
        return atype;
    }


}