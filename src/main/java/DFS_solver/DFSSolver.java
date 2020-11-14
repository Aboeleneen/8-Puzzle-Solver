package main.java.DFS_solver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class DFSSolver {
    private State goal_state;
    private Stack<State> frontier;
    private ArrayList<State> explored;

    public DFSSolver(State goal_state) {
        this.goal_state = goal_state;
        this.frontier = new Stack<State>();
        this.explored = new ArrayList<>();
    }

    public State solve(State initial_state) {
        this.frontier.push(initial_state);
        while (!this.frontier.empty()) {
            State state = frontier.pop();
            this.explored.add(state);
            if (this.similarStates(state, this.goal_state)) {
                break;
            }
            this.printState(state);
            ArrayList<State> neighbors = state.get_neighbors();
            System.out.println(neighbors.size());
            for (int i = 0; i < neighbors.size(); ++i) {
                if (!this.IsStateExistInExpored(neighbors.get(i)) && !this.IsStateExistInFronteir(neighbors.get(i))) {
                    neighbors.get(i).prevState = state;
                    frontier.push(neighbors.get(i));
                }
            }
        }
        return this.goal_state;
    }

    private boolean similarStates(State state1, State state2) {
        for (int i = 0; i < state1.tiles.length; ++i) {
            if (state1.tiles[i] != state2.tiles[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean IsStateExistInFronteir(State state) {
        Iterator<State> iterator = this.frontier.iterator();
        while (iterator.hasNext()) {
            if (this.similarStates(state, iterator.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean IsStateExistInExpored(State state) {
        for (int i = 0; i < this.explored.size(); ++i) {
            if (this.similarStates(state, this.explored.get(i))) {
                return true;
            }
        }
        return false;
    }

    private void printState(State state) {
        System.out.print("state on the path: ");
        for (int j = 0; j < 9; ++j) {
            System.out.print(state.tiles[j] + ", ");
        }
        System.out.println("");
    }
}
