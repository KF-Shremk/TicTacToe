import javax.swing.*;
import java.io.*;

/**TicTacToe Program
 * Creates a game of tic tac toe with GUI
 * 
 * Last Modified: April 1, 2024
 * @author Kevin Fu
 */

public class startupTTT
{
/**The main method
      */
public static void main (String [] args) throws IOException
{
     ModelTTT model = new ModelTTT();  //The 2048 model
     GUITTT main = new GUITTT(model);  //The 2048 view
     
     //Initialize the Frame
     JFrame f = new JFrame("Kevin's Tic Tac Toe");
     f.setSize(500,540);
     f.setLocation(250,25);
     f.setResizable(false);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setContentPane(main);
     f.setVisible(true);
} //end of main method
} //end of startup2048 class