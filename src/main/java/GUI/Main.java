package GUI;

import DFS_solver.DFSSolver;
import DFS_solver.State;

public class Main {
    public static void main(String[] args) {
        String tiles = "012345678";
        DFSSolver solver = new DFSSolver(new State(tiles));
        String initial_tiles = "125340678";
        State reached_state = solver.solve(new State(initial_tiles));
        int statesNum = 0;
        while (reached_state.prevState != null) {
            statesNum++;
            reached_state = reached_state.prevState;
        }
        System.out.println("Path cost: " + (statesNum - 1));
    }
}
