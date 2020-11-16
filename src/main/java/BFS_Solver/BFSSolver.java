/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS_Solver;

import DFS_solver.State ;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 *
 * @author Lenovo
 */
public class BFSSolver {
    private State goal_state ;
    
    public BFSSolver(State goal_state){
        this.goal_state = goal_state ;
    }
    
    public void solve(State inital_state){
        Queue<State> frontier = new LinkedList<>();
        HashSet<String> explored = new HashSet<>();
        
        frontier.add(inital_state);
        explored.add(inital_state.tiles);
        
        while(!frontier.isEmpty()){
            State current_state = frontier.remove();
            
            if(current_state.tiles.equals(goal_state.tiles)){
                System.out.println("Success");
                this.goal_state=current_state;
                break;
            }
            
            ArrayList<State> neighbors = current_state.get_neighbors() ;
            for(State state:neighbors){
                if(explored.contains(state.tiles)){
                    continue;
                }
                frontier.add(state);
                explored.add(state.tiles);
                state.prevState=current_state;
            }
        }
    }
    
    public Stack<State> get_moves(){
          Stack<State> moves  = new Stack<>();
          State current_state = this.goal_state;
          moves.push(current_state);
          while(current_state.prevState != null){
              moves.push(current_state.prevState);
              current_state = current_state.prevState ;
          }
          return moves ;
    }
}
