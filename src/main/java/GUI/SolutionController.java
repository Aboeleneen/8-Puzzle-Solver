/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;

import DFS_solver.State;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SolutionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private TextField tile1 ;
    @FXML private TextField tile2 ;
    @FXML private TextField tile3 ;
    @FXML private TextField tile4 ;
    @FXML private TextField tile5 ;
    @FXML private TextField tile6 ;
    @FXML private TextField tile7 ;
    @FXML private TextField tile8 ;
    @FXML private TextField tile9 ;
    @FXML private Label moves_label ;
    @FXML private Text steps_label ;
    
    private ArrayList<State> moves ;
    private int step = 0 ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     // TODO
    }
    
    public void set_moves(Stack<State> sol){
        moves = new ArrayList<>();
        while(!sol.isEmpty())
        {
            State move = sol.pop();
            System.out.println(move);
            this.moves.add(move);
        }
        moves_label.setText(Integer.toString(this.moves.size()-1));
        set_tiles();
    }
    
    private void set_tiles(){
        String tiles = moves.get(step).tiles;
        tile1.setText(Character.toString(tiles.charAt(0)));
        tile2.setText(Character.toString(tiles.charAt(1)));
        tile3.setText(Character.toString(tiles.charAt(2)));
        tile4.setText(Character.toString(tiles.charAt(3)));
        tile5.setText(Character.toString(tiles.charAt(4)));
        tile6.setText(Character.toString(tiles.charAt(5)));
        tile7.setText(Character.toString(tiles.charAt(6)));
        tile8.setText(Character.toString(tiles.charAt(7)));
        tile9.setText(Character.toString(tiles.charAt(8)));
        steps_label.setText(Integer.toString(step));
        
    }
    @FXML
    private void handlePrev(ActionEvent event) throws IOException {
        this.step = Math.max(0, this.step-1);
        set_tiles();
    }
    
    @FXML
    private void handleNext(ActionEvent event) throws IOException {
        this.step = Math.min(moves.size()-1, step+1);
        set_tiles();
    }
    
}
