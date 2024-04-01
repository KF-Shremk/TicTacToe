/**GUITTT Class
 * This class outputs the view of the Tic Tac Toe game
*
* @author Kevin Fu
* @since April 1, 2024
*/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;               

public class GUITTT extends JPanel
{
     //Instance Variables
     private ModelTTT model;                                 //The model attached to the view
     
     private JLabel gameText = new JLabel("Player 1's Turn");                           //The current game score
     private TTTButton[][] grid = new TTTButton[3][3];                               //Creates a 4x4 grid of buttons
     private JButton newGame = new JButton("New Game");

     private GridLayout gridLay = new GridLayout(3,3);        //4x4 layout for the grid array
     private JPanel gridPanel = new JPanel();     //the panel for the grid
     private JPanel fullPanel = new JPanel();

     /** Constructer for the view
      * @param aModel - The model the view is attached to
      */
     public GUITTT(ModelTTT aModel)
     {
          super();
          this.model = aModel;
          this.model.setGUI(this);
          this.layoutView();
          this.setFocusable(true);
          this.registerControllers();
          this.update();
     }//end of GUITTT Contructor
     
     /** Draws the initial layout for the GUI
      */ 
     private void layoutView()
     {
          newGame.setEnabled(false);
          gridPanel.setLayout(gridLay);
          gridLay.setHgap(10);              
          gridLay.setVgap(10);
          gridPanel.setBorder(new EmptyBorder(20,0,20,0));

          int spot = 1;
          for (int row = 0; row < 3; row++) {
               for (int col = 0; col < 3; col++) {
                    grid[row][col] = new TTTButton("",spot++);
                    grid[row][col].setPreferredSize (new Dimension(100,100));
                    grid[row][col].setFont(new Font (Font.SANS_SERIF, Font.BOLD, 24));
                    gridPanel.add(grid[row][col]);
               }
          }
          
          newGame.setFont(new Font (Font.SANS_SERIF, Font.BOLD, 24));
          gameText.setFont(new Font (Font.SANS_SERIF, Font.BOLD, 24));

          fullPanel.setLayout(new BorderLayout());
          fullPanel.add(gameText,BorderLayout.PAGE_START);
          fullPanel.add(gridPanel,BorderLayout.CENTER);
          fullPanel.add(newGame,BorderLayout.PAGE_END);
          fullPanel.setBorder(new EmptyBorder(20,0,20,0));

          this.add(fullPanel);

     }//End of layoutView method
     
     /**Assigns the controllers to the buttons and keys
      */ 
     private void registerControllers()
     {
          for (int row = 0; row < 3; row++) {
               for (int col = 0; col < 3; col++) {
                    grid[row][col].addActionListener(new MoveController(this.model,this.grid[row][col]));
               }
          }
          newGame.addActionListener(new NewGameController(model, newGame, grid, gameText));
     }//End of registerControllers Method
     
     /** Based on the data provided to the model, the update method redraws the GUI
      */ 
     public void update()
     {
          int valueArr [][] = this.model.getGridValues();
          boolean won = false;

          //text in each button
          for (int row = 0; row < 3; row++) {
               for (int col = 0; col < 3; col++) {
                    if (valueArr[row][col] == 1) {grid[row][col].setText("O");}
                    else if (valueArr[row][col] == 2) {grid[row][col].setText("X");}
                    else {grid[row][col].setText("");}
               }
          }

          if (this.model.getTurn() == 1) {this.gameText.setText("Player 1's Turn");}
          else {this.gameText.setText("Player 2's Turn");}

          if (this.model.getP1WinState() == true) {
               this.gameText.setText("Player 1 Wins! Play Again?");
               won = true;
          }
          if (this.model.getP2WinState() == true) {
               this.gameText.setText("Player 2 Wins! Play Again?");
               won = true;
          }
          if (won || this.model.getTurnCount() == 9) {
               for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                         grid[row][col].setEnabled(false);
                    }
               }
               if (this.model.getTurnCount() == 9) {this.gameText.setText("The game is a draw! Play Again?");}
               newGame.setEnabled(true);
          }
     }//End of update method
     
}//End of GUITTT class