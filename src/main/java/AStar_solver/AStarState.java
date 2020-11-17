package AStar_solver;

import java.util.ArrayList;

import DFS_solver.State;

public class AStarState extends State {
    public int costFromInitial;
    public double estimateToGoal;

    public AStarState(String tiles) {
        super(tiles);
    }

    public ArrayList<AStarState> getNeighbors() {

        int emptyIndex = this.tiles.indexOf('0');

        ArrayList<AStarState> adjecents = new ArrayList<AStarState>();
        // top cell
        String top = topTiles(emptyIndex);
        if (top != null) {
            adjecents.add(new AStarState(top));
        }
        String left = leftTiles(emptyIndex);
        // move blank cell left
        if (left != null) {
            adjecents.add(new AStarState(left));
        }

        // move blank cell bottom
        String bottom = bottomTiles(emptyIndex);
        if (bottom != null) {
            adjecents.add(new AStarState(bottom));
        }

        // move blank cell right
        String right = rightTiles(emptyIndex);
        if (right != null) {
            adjecents.add(new AStarState(right));
        }
        return adjecents;
    }
}
