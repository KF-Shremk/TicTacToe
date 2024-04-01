/**MoveController Class
 * this class processes button inputs
 *
 * @author Kevin Fu
 * @since April 1, 2024
*/

// import java.io.*;
// import javax.swing.*;
import java.awt.event.*;

public class MoveController implements ActionListener
{
     //instance variables
     private ModelTTT model; //The model attatched to the controller
     private TTTButton button; //The button associated with the controller
     
     /**Constructor for MoveController object
       * @param aModel The model the controller is attatched to
       */
     public MoveController (ModelTTT aModel, TTTButton aButton)
     {
          this.model = aModel;
          this.button = aButton;
     } //End of MoveController constructor
     
     /**Triggers actions when movement buttons are used
       * @param e The ActionEvent generated by the component used
       */
     public void actionPerformed (ActionEvent e)
     {
          // System.out.println(this.button.getVal()); //debug
          this.model.processMove(this.button.getVal());
     } //End of actionPerformed method
     
} //MoveController class