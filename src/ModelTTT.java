    /**ModelTTT Class
     * This class processes the functions of Tic Tac Toe.
     *
     * @author Kevin Fu
     * @since April 1, 2024
    */

    // import java.util.*;
    // import java.io.*;

    public class ModelTTT extends Object {
        
        //Instance Variables
        private GUITTT view;                      //The view attatched to the model
        private int [][] values = new int [3][3];  //Stores values of all spots in the grid, 0 = none, 1 = player 1, 2 = player 2
        
        private boolean p1win = false;               //Stores if the game has been won
        private boolean p2win = false;              //Stores if the game has been lost
        private int turn = 1;               //stores whose turn it is (false is p1, true is p2)

        private int turnCount = 0;
        
        /**Constructor for the model; loads the leaderboard and creates a new value on the grid
         */
        public ModelTTT (){
            super ();
            // this.resetGame();
        } //end of constructor
        
        /**Sets the GUI of the model.
         * @param view1 The view to be attatched to this model
         */
        public void setGUI (GUITTT view1) {
            this.view = view1;
        } //end of setGUI method
        
        //---------------------------------------------------------------------------------------------------SETUP AND RESET METHODS
        
        /**Sets up the game
         * @param userName The name of the user playing
         * @param rounds The maximum number of rounds input by the user
         */
        public void resetGame () { 
            for (int row = 0; row < 3; row++){
                for (int column = 0; column < 3; column++) {
                    this.values[row][column] = 0;
                }
            }
            this.p1win = false;
            this.p2win = false;
            this.turn = 1;
            this.turnCount = 0;

            this.updateView();
        } //end of resetGame method
        
        //---------------------------------------------------------------------------------------------------ACCESSOR METHODS
        
        /**
         * @return Copy of the contents in the values array attribute
         */
        public int [][] getGridValues () {
            int [][] array = new int [3][3]; //stores a copy of the values array to be returned
            
            //copies grid values to new array and returns it
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++)
                        array [row][col] = this.values[row][col];
            }
            return array;
        } //end of getGridValues method
        
        /**
         * @return Boolean of player 1 has won
         */
        public boolean getP1WinState () {
            return this.p1win;
        } //end of getWinState method
        
        /**
         * @return Boolean of if player 2 has won
         */
        public boolean getP2WinState () {
            return this.p2win;
        } //end of getLossState method   

        /**
         * @return integer of whose turn it is (false is p1, true is p2)
         */
        public int getTurn () {
            return this.turn;
        } //end of getLossState method   

        /**
         * @return integer of the turn number
         */
        public int getTurnCount () {
            return this.turnCount;
        } //end of getLossState method   
        
        //---------------------------------------------------------------------------------------------------MOVE PROCESSING METHODS
        
        /**Processes the move made by the players
         * @param move the spot on the grid to update (integers 1-9 representing 3x3 grid locations, left to right top to bottom)
         */
        public void processMove (int move) {
            boolean changed = false;
            switch (move) {
                case 1:
                    if (this.values[0][0] == 0) {
                        this.values[0][0] = this.turn;
                        changed = true;
                    }
                    break;
                case 2:
                    if (this.values[0][1] == 0) {
                        this.values[0][1] = this.turn;
                        changed = true;
                    }
                    break;
                case 3:
                    if (this.values[0][2] == 0) {
                        this.values[0][2] = this.turn;
                        changed = true;
                    }
                    break;
                case 4:
                    if (this.values[1][0] == 0) {
                        this.values[1][0] = this.turn;
                        changed = true;
                    }
                    break;
                case 5:
                    if (this.values[1][1] == 0) {
                        this.values[1][1] = this.turn;
                        changed = true;
                    }
                    break;
                case 6:
                    if (this.values[1][2] == 0) {
                        this.values[1][2] = this.turn;
                        changed = true;
                    }
                    break;
                case 7:
                    if (this.values[2][0] == 0) {
                        this.values[2][0] = this.turn;
                        changed = true;
                    }
                    break;
                case 8:
                    if (this.values[2][1] == 0) {
                        this.values[2][1] = this.turn;
                        changed = true;
                    }
                    break;
                case 9:
                    if (this.values[2][2] == 0) {
                        this.values[2][2] = this.turn;
                        changed = true;
                    }
                    break;
                default:
                    System.out.print("error");
                    System.exit(1);
            }

            if (changed) {
                this.turn = (this.turn == 1) ? 2 : 1;
                this.turnCount++;
            }
            // System.out.println(this.turn); //debug

            this.checkWinState();

            this.updateView();
        } //end of processMove method 
        
        //---------------------------------------------------------------------------------------------------WIN / LOSS DETERMINATION
        
        /**Determines if Tic Tac Toe has been won
         */
        private void checkWinState () {
            int player = 0;

            //top
            if (this.values[0][1] != 0) {
                player = values[0][1];
                if ((this.values[0][0] == player) && (this.values[0][2] == player)) {
                    if (player == 1) {p1win = true;}
                    else {p2win = true;}
                }
            }
            //left
            if (this.values[1][0] != 0) {
                player = values[1][0];
                if ((this.values[0][0] == player) && (this.values[2][0] == player)) {
                    if (player == 1) {p1win = true;}
                    else {p2win = true;}
                }
            }
            //center
            if (this.values[1][1] != 0) {
                player = values[1][1];
                if ((this.values[1][0] == player) && (this.values[1][2] == player) || /*horizotal*/
                    (this.values[0][1] == player) && (this.values[2][1] == player) || /*vertical*/
                    (this.values[2][0] == player) && (this.values[0][2] == player) || /*diagonal bottom left to top right*/
                    (this.values[0][0] == player) && (this.values[2][2] == player)    /*diagonal bottom right to top left*/ )  {
                    if (player == 1) {p1win = true;}
                    else {p2win = true;}
                }
            }
            //right
            if (this.values[1][2] != 0) {
                player = values[1][2];
                if ((this.values[0][2] == player) && (this.values[2][2] == player)) {
                    if (player == 1) {p1win = true;}
                    else {p2win = true;}
                }
            }
            //bottom
            if (this.values[2][1] != 0) {
                player = values[2][1];
                if ((this.values[2][0] == player) && (this.values[2][2] == player)) {
                    if (player == 1) {p1win = true;}
                    else {p2win = true;}
                }
            }
        } //end of checkWinState method

        //---------------------------------------------------------------------------------------------------VIEW UPDATING
        
        /**Updates the view
         */
        private void updateView ()
        {
            this.view.update();
        } //end of updateView method

    } //end of Model2048 class