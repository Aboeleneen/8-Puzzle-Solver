package AStar_solver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSolver {
    private AStarState goal_state;
    private ArrayList<String> heuristic_types;

    public AStarSolver(AStarState goal_state) {
        this.goal_state = goal_state;
        heuristic_types = new ArrayList<String>(List.of("Manhattan", "Euclidean"));
    }

    public AStarState solve(AStarState initial_state, String heuristic_type) {
        if(!this.heuristic_types.contains(heuristic_type)){
            System.out.println("invalide heuristic method");
            return null;
        }
        PriorityQueue<AStarState> frontier = new PriorityQueue<AStarState>(9, new StateComparator());
        HashSet<String> frontierTiles = new HashSet<>();
        HashSet<String> explored = new HashSet<>();

        initial_state.costFromInitial = 0;
        initial_state.estimateToGoal = getHeuristicDistance(initial_state.tiles, heuristic_type);

        frontier.add(initial_state);
        frontierTiles.add(initial_state.tiles);

        while (frontier.size() != 0) {
            AStarState state = frontier.poll();
            frontierTiles.remove(state.tiles);

            explored.add(state.tiles);

            if (state.tiles.equals(this.goal_state.tiles)) {
                System.out.println("Success");
                System.out.println("number of expored states: " + explored.size());
                this.goal_state = state;
                break;
            }

            ArrayList<AStarState> neighbors = state.getNeighbors();

            for (int i = 0; i < neighbors.size(); ++i) {
                AStarState neighbor = neighbors.get(i);
                if (!explored.contains(neighbor.tiles) && !frontierTiles.contains(neighbor.tiles)) {
                    neighbor.prevState = state;
                    neighbor.costFromInitial = state.costFromInitial + 1;
                    neighbor.estimateToGoal = getHeuristicDistance(initial_state.tiles, heuristic_type);
                    frontier.add(neighbor);
                    frontierTiles.add(neighbor.tiles);
                }else if(frontierTiles.contains(neighbor.tiles)){
                    if(neighbor.costFromInitial > state.costFromInitial + 1){
                        frontier.remove(neighbor);
                        neighbor.costFromInitial = state.costFromInitial + 1;
                        frontier.add(neighbor);
                    }
                }
            }
        }
        return this.goal_state;
    }

    private double getHeuristicDistance(String currectTiles, String heuristic_type){
        if(heuristic_type == "Manhattan"){
            return getManhattanDistance(currectTiles);
        }else if(heuristic_type == "Euclidean"){
            return getEuclideanDistance(currectTiles);
        }
        return 0;
    }

    public double getManhattanDistance(String currectTiles) {
        String goalTiles = this.goal_state.tiles;
        double distance = 0;
        int goalIndex;
        for (int i = 0; i < currectTiles.length(); ++i) {
            goalIndex = goalTiles.indexOf(currectTiles.charAt(i));
            // index / 3 ==> x coordinate, and index % 3 ==> y coordinate
            distance += Math.abs(i % 3 - goalIndex % 3) + Math.abs(i / 3 - goalIndex / 3);
        }
        return distance;
    }

    public double getEuclideanDistance(String currectTiles) {
        String goalTiles = this.goal_state.tiles;
        double distance = 0;
        int goalIndex;
        for (int i = 0; i < currectTiles.length(); ++i) {
            goalIndex = goalTiles.indexOf(currectTiles.charAt(i));
            // index / 3 ==> x coordinate, and index % 3 ==> y coordinate
            distance += Math.sqrt(Math.pow(i % 3 - goalIndex % 3, 2) + Math.pow(i / 3 - goalIndex / 3, 2));
        }
        return distance;
    }

    class StateComparator implements Comparator<AStarState> {
        @Override
        public int compare(AStarState s1, AStarState s2) {
            double s1Fun = s1.costFromInitial + s1.estimateToGoal;
            double s2Fun = s2.costFromInitial + s2.estimateToGoal;
            if (s1Fun > s2Fun)
                return 1;
            else if (s1Fun < s2Fun)
                return -1;
            return 0;
        }
    }
}
