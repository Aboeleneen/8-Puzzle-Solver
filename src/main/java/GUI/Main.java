package GUI;

import java.util.ArrayList;

import AStar_solver.AStarSolver;
import AStar_solver.AStarState;
import DFS_solver.DFSSolver;
import DFS_solver.State;

public class Main {
    public static void main(String[] args) {
        // String tiles = "012345678";
        // DFSSolver solver = new DFSSolver(new State(tiles));
        // String initial_tiles = "125340678";
        // State reached_state = solver.solve(new State(initial_tiles));
        // int statesNum = 0;
        // while (reached_state.prevState != null) {
        //     statesNum++;
        //     reached_state = reached_state.prevState;
        // }
        // System.out.println("Path cost: " + (statesNum - 1));
        // String tiles = "125340678";
        // AStarState state = new AStarState(tiles, 5);
        // System.out.println(state.getManhattanDistance("012345678"));
        // System.out.println(state.getEuclideanDistance("012345678"));
        // ArrayList<AStarState> l = state.getNeighbors();
        // for(int i=0;i<l.size();++i){
        //     System.out.println(l.get(i).tiles);
        //     System.out.println(l.get(i).costFromInitial);
        // }
        String tiles = "123804765";
        AStarSolver solver = new AStarSolver(new AStarState(tiles));
        String initial_tiles = "364012875";
        State reached_state = solver.solve(new AStarState(initial_tiles), "Euclidean");
        int statesNum = 0;
        while (reached_state != null) {
            statesNum++;
            System.out.println(reached_state.tiles);
            reached_state = reached_state.prevState;
        }
        System.out.println("Path cost: " + (statesNum - 1));
        
    }
}
