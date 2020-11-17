package DFS_solver;

import java.util.ArrayList;

public class State {
    public String tiles;
    public State prevState = null;
    public int costFromInitial;
    public double estimateToGoal;

    public State(String tiles) {
        this.tiles = tiles;
        prevState = null;
    }

    public ArrayList<State> get_neighbors() {
        int emptyIndex = this.tiles.indexOf('0');

        ArrayList<State> adjecents = new ArrayList<State>();
        // top cell
        String top = topTiles(emptyIndex);
        if (top != null) {
            adjecents.add(new State(top));
        }
        String left = leftTiles(emptyIndex);
         // move blank cell left
         if (left != null) {
            adjecents.add(new State(left));
        }
        
        // move blank cell bottom
        String bottom = bottomTiles(emptyIndex);
        if (bottom != null) {
            adjecents.add(new State(bottom));
        }
       

        // move blank cell right
        String right = rightTiles(emptyIndex);
        if (right != null) {
            adjecents.add(new State(right));
        }
        return adjecents;
    }

    protected String topTiles(int emptyIndex){
        if (emptyIndex > 2) {
            StringBuilder adjecentTiles = new StringBuilder(this.tiles);
            adjecentTiles.setCharAt(emptyIndex,adjecentTiles.charAt(emptyIndex - 3));
            adjecentTiles.setCharAt(emptyIndex - 3, '0');
            return adjecentTiles.toString();
        }
        return null;
    }

    protected String bottomTiles(int emptyIndex){
        if (emptyIndex < 6) {
            StringBuilder adjecentTiles = new StringBuilder(this.tiles);
            adjecentTiles.setCharAt(emptyIndex, adjecentTiles.charAt(emptyIndex + 3));
            adjecentTiles.setCharAt(emptyIndex + 3, '0');
            return adjecentTiles.toString();
        }
        return null;
    }

    protected String leftTiles(int emptyIndex){
        if (emptyIndex % 3 > 0) {
            StringBuilder adjecentTiles = new StringBuilder(this.tiles);
            adjecentTiles.setCharAt(emptyIndex,adjecentTiles.charAt(emptyIndex - 1));
            adjecentTiles.setCharAt(emptyIndex - 1, '0');
            return adjecentTiles.toString();
        }
        return null;
    }

    protected String rightTiles(int emptyIndex){
        if (emptyIndex % 3 < 2) {
            StringBuilder adjecentTiles = new StringBuilder(this.tiles);
            adjecentTiles.setCharAt(emptyIndex, adjecentTiles.charAt(emptyIndex + 1));
            adjecentTiles.setCharAt(emptyIndex + 1, '0');
            return adjecentTiles.toString();
        }
        return null;
    }
}
