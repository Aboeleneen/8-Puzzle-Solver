package DFS_solver;

import java.util.ArrayList;

public class State {
    public String tiles;
    public State prevState = null;

    public State(String tiles) {
        this.tiles = tiles;
        prevState = null;
    }

    public ArrayList<State> get_neighbors() {
        int emptyIndex = this.tiles.indexOf('0');

        ArrayList<State> adjecents = new ArrayList<State>();
        // top cell
        if (emptyIndex > 2) {
            StringBuilder adjecentTiles = new StringBuilder(this.tiles);
            adjecentTiles.setCharAt(emptyIndex,adjecentTiles.charAt(emptyIndex - 3));
            adjecentTiles.setCharAt(emptyIndex - 3, '0');
            adjecents.add(new State(adjecentTiles.toString()));
        }
         // move blank cell left
         if (emptyIndex % 3 > 0) {
            StringBuilder adjecentTiles = new StringBuilder(this.tiles);
            adjecentTiles.setCharAt(emptyIndex,adjecentTiles.charAt(emptyIndex - 1));
            adjecentTiles.setCharAt(emptyIndex - 1, '0');
            adjecents.add(new State(adjecentTiles.toString()));
        }
        
        // move blank cell bottom
        if (emptyIndex < 6) {
            StringBuilder adjecentTiles = new StringBuilder(this.tiles);
            adjecentTiles.setCharAt(emptyIndex, adjecentTiles.charAt(emptyIndex + 3));
            adjecentTiles.setCharAt(emptyIndex + 3, '0');
            adjecents.add(new State(adjecentTiles.toString()));
        }
       

        // move blank cell right
        if (emptyIndex % 3 < 2) {
            StringBuilder adjecentTiles = new StringBuilder(this.tiles);
            adjecentTiles.setCharAt(emptyIndex, adjecentTiles.charAt(emptyIndex + 1));
            adjecentTiles.setCharAt(emptyIndex + 1, '0');
            adjecents.add(new State(adjecentTiles.toString()));
        }
        return adjecents;
    }
}
