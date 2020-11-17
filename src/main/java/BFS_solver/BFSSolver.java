package BFS_solver;

import DFS_solver.State;
import DFS_solver.Solver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSSolver extends Solver {

    public BFSSolver(State goal_state) {
        super(goal_state);
    }

    public void solve(State inital_state) {
        Queue<State> frontier = new LinkedList<>();
        HashSet<String> explored = new HashSet<>();

        frontier.add(inital_state);
        explored.add(inital_state.tiles);

        while (!frontier.isEmpty()) {
            State current_state = frontier.remove();

            if (current_state.tiles.equals(this.goal_state.tiles)) {
                this.goal_state = current_state;
                break;
            }

            ArrayList<State> neighbors = current_state.get_neighbors();
            for (State state : neighbors) {
                if (explored.contains(state.tiles)) {
                    continue;
                }
                frontier.add(state);
                explored.add(state.tiles);
                state.prevState = current_state;
            }
        }
    }
}
