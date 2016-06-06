package ProjectFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Handles the event that the user presses the New Game button.
@SuppressWarnings("serial")
class NewButtonListener extends GameBoard implements ActionListener {
	
    public void actionPerformed(ActionEvent event) {
        moveCounter = 0;
        
        for (int count = 0; count < 25; count++) {
            buttons[count].setText("");
            gameBoard[count] = 0;
        }
        
        if (userIsX == false && twoPlayerMode != true) {
        	gameArtificialIntelligence();
        }
    }
}