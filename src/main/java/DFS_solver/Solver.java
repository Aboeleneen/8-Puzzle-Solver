package DFS_solver;

import java.util.Stack;

public abstract class Solver {
    protected State goal_state;

    public Solver(State goal_state){
        this.goal_state = goal_state ;
    }

    public abstract void solve(State inital_state);

    public Stack<String> get_path(){
        Stack<String> moves  = new Stack<>();
        State current_state = this.goal_state;
        moves.push(current_state.tiles);
        while(current_state.prevState != null){
            moves.push(current_state.prevState.tiles);
            current_state = current_state.prevState ;
        }
        return moves;
    }
}
