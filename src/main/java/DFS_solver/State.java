package main.java.DFS_solver;

import java.util.ArrayList;

public class State {
    public int[] tiles;
    public State prevState = null;

    public State(int[] tiles) {
        this.tiles = tiles;
        prevState = null;
    }

    public ArrayList<State> get_neighbors() {
        int emptyIndex = 0;
        for (int i = 0; i < this.tiles.length; ++i) {
            if (this.tiles[i] == 0) {
                emptyIndex = i;
            }
        }
        ArrayList<State> adjecents = new ArrayList<State>();
        // move blank cell top
        if (emptyIndex - 3 >= 0) {
            int[] adjecentTiles = this.tiles.clone();
            adjecentTiles[emptyIndex] = adjecentTiles[emptyIndex - 3];
            adjecentTiles[emptyIndex - 3] = 0;
            adjecents.add(new State(adjecentTiles));
        }
        // move blank cell bottom
        if (emptyIndex + 3 <= 8) {
            int[] adjecentTiles = this.tiles.clone();
            adjecentTiles[emptyIndex] = adjecentTiles[emptyIndex + 3];
            adjecentTiles[emptyIndex + 3] = 0;
            adjecents.add(new State(adjecentTiles));
        }
        // move blank cell left
        if (emptyIndex % 3 > 0) {
            int[] adjecentTiles = this.tiles.clone();
            adjecentTiles[emptyIndex] = adjecentTiles[emptyIndex - 1];
            adjecentTiles[emptyIndex - 1] = 0;
            adjecents.add(new State(adjecentTiles));
        }

        // move blank cell right
        if (emptyIndex % 3 < 2) {
            int[] adjecentTiles = this.tiles.clone();
            adjecentTiles[emptyIndex] = adjecentTiles[emptyIndex + 1];
            adjecentTiles[emptyIndex + 1] = 0;
            adjecents.add(new State(adjecentTiles));
        }
        return adjecents;
    }
}
