/**TTTButton Class
 * this class extends button with an extra attribute
 *
 * @author Kevin Fu
 * @since April 1, 2024
*/

// import java.awt.*;
import javax.swing.*;

public class TTTButton extends JButton{
    //instance variables
    int gridVal;    //the positional value of the button in the TTT grid (1-9, left to right top to bottom)

    /**Constructor for TTTButton object
       * @param text The text on the button
       * @param val The grid value of the button
       */
    public TTTButton (String text, int val)
    {
        super(text);
        this.gridVal = val;
    }

    /**Accessor for gridVal
     * @return The grid value of the button
     */
    public int getVal ()
    {
        return this.gridVal;
    }
}
