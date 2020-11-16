package GUI;

import DFS_solver.DFSSolver;
import DFS_solver.State;

import BFS_Solver.BFSSolver;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String tiles = "012345678";
        BFSSolver solver = new BFSSolver(new State(tiles));
        String initial_tiles = "125340678";
        solver.solve(new State(initial_tiles));
        Stack<State> moves = solver.get_moves();
        System.out.println("Path cost: " + (moves.size() - 1));
        while(!moves.isEmpty()){
            State s = moves.pop();
            System.out.println(s.tiles);
        }
        
    }
}
