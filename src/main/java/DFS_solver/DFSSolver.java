package DFS_solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DFSSolver {
    private State goal_state;
    private Stack<State> frontier;
    private HashSet<String> explored;

    public DFSSolver(State goal_state) {
        this.goal_state = goal_state;
        this.frontier = new Stack<State>();
        this.explored = new HashSet<>();
    }

    public State solve(State initial_state) {
        this.frontier.push(initial_state);

        HashSet<String> frontierTiles = new HashSet<>();
        frontierTiles.add(initial_state.tiles);

        while (!this.frontier.empty()) {
            State state = frontier.pop();
            frontierTiles.remove(state.tiles);

            this.explored.add(state.tiles);

            if (state.tiles.equals(this.goal_state.tiles)) {
                System.out.println("Success");
                this.goal_state = state;
                break;
            }

            ArrayList<State> neighbors = state.get_neighbors();
            for (int i = 0; i < neighbors.size(); ++i) {
                String neighborTiles = neighbors.get(i).tiles;
                if (!this.explored.contains(neighborTiles) && !frontierTiles.contains(neighborTiles)) {
                    neighbors.get(i).prevState = state;
                    frontier.push(neighbors.get(i));
                    frontierTiles.add(neighborTiles);
                }
            }
        }
        return this.goal_state;
    }
}
