/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import DFS_solver.State;
import BFS_Solver.BFSSolver;
import java.io.IOException;
import java.util.Stack;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML private TextField tile1 ;
    @FXML private TextField tile2 ;
    @FXML private TextField tile3 ;
    @FXML private TextField tile4 ;
    @FXML private TextField tile5 ;
    @FXML private TextField tile6 ;
    @FXML private TextField tile7 ;
    @FXML private TextField tile8 ;
    @FXML private TextField tile9 ;
    @FXML private ChoiceBox choiceBox ;
    
    @FXML
    private void handleSolve(ActionEvent event) throws IOException {
        String inital_state = "" ;
        inital_state+=tile1.getText();
        inital_state+=tile2.getText();
        inital_state+=tile3.getText();
        inital_state+=tile4.getText();
        inital_state+=tile5.getText();
        inital_state+=tile6.getText();
        inital_state+=tile7.getText();
        inital_state+=tile8.getText();
        inital_state+=tile9.getText();
        
        System.err.println(inital_state);
        String tiles = "012345678";
        BFSSolver solver = new BFSSolver(new State(tiles));
        solver.solve(new State(inital_state));
        Stack<State> moves = solver.get_moves(); 
        System.out.println("Path cost: " + (moves.size() - 1));
        change_scene(event , moves);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void change_scene(ActionEvent event ,  Stack<State> moves) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Solution.fxml"));
        Parent newView = loader.load();
        
        // pass information to waitingCustomers scene
        SolutionController controller = loader.getController();
        controller.set_moves(moves);
        
        Scene scene = new Scene(newView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    } 
    
}
