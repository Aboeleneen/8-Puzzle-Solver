package main.java.GUI;

import java.util.ArrayList;

import main.java.DFS_solver.DFSSolver;
import main.java.DFS_solver.State;

public class Main {
    public static void main(String[] args) {
        int[] tiles = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        // State state = new State(tiles);
        // ArrayList<State> adjecents = state.get_neighbors();
        // for(int i=0;i<adjecents.size();++i){
        // System.out.print("first adjecent: ");
        // for(int j=0;j<9;++j){
        // System.out.print(adjecents.get(i).tiles[j] + ", ");
        // }
        // System.out.println("");
        // }
        DFSSolver solver = new DFSSolver(new State(tiles));
        int[] initial_tiles = { 1, 2, 5, 3, 4, 0, 6, 7, 8 };
        State reached_state = solver.solve(new State(initial_tiles));
        while (reached_state.prevState != null) {
            System.out.print("state on the path: ");
            for (int j = 0; j < 9; ++j) {
                System.out.print(reached_state.tiles[j] + ", ");
            }
            System.out.println("");
            reached_state = reached_state.prevState;
        }
    }
}
