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
    int row;    //the row that the button is in
    int col;     //the column that the button is in

    /**Constructor for TTTButton object
       * @param text The text on the button
       * @param aRow The row fo the button
       * @param aColumn The column of the button
       */
    public TTTButton (String text, int aRow, int aColumn)
    {
        super(text);
        this.row = aRow;
        this.col = aColumn;
    }

    /**
     * @return The row of the button
     */
    public int getRow ()
    {
        return this.row;
    }

    /**
     * @return The column of the button
     */
    public int getCol ()
    {
        return this.col;
    }
}
