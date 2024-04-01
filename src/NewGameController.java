/**NewGameController Class
 * This class processes the newGame button to start a new game
 *
 * @author Kevin Fu
 * @since April 1, 2024
*/

import javax.swing.*;
import java.awt.event.*;

public class NewGameController implements ActionListener
{
     //instance variables
     private ModelTTT model;        //The model attached to the controller
     private JButton reset;      //The OK button with the users input
     private TTTButton [][] grid;    //The grid for tic tac toe
     private JLabel label;           //the game text
     
     /**Constructor for NewGameController object
       * @param aModel ---------- The model the controller is attatched to
       * @param aUserDataPanel -- The panel with the users information
       * @param aUserInput ------ The button pressed after user inputs data
       * @param sStatus --------- The win/loss status of the game
       * @param aPane ----------- The Tabbed Pane with the leaderboard and results
       */
     public NewGameController (ModelTTT aModel, JButton aReset, TTTButton[][] aGrid, JLabel aLabel)
     {
          this.model = aModel;
          this.reset = aReset;
          this.grid = aGrid;
          this.label = aLabel;
     }//End of NewGameController constructor
     
     /**Triggers actions when the new game button is used
       * @param e The ActionEvent generated by the component used
       */
     public void actionPerformed (ActionEvent e)
     {
          this.model.resetGame();
          for (int row = 0; row < 3; row++) {
               for (int col = 0; col < 3; col++) {
                    grid[row][col].setEnabled(true);
               }
          }
          this.reset.setEnabled(false);
          this.label.setText("Player 1's Turn");

     }//End of actionPerformed method
     
}//End of NewGameController class