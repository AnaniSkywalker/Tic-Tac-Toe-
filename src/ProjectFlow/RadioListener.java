package ProjectFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

//Handles the event that the user plays X or user plays O as indicated by radio buttons.
@SuppressWarnings("serial")
class RadioListener extends GameBoard implements ActionListener 
{
    public void actionPerformed(ActionEvent event) {
        JRadioButton theButton = (JRadioButton) event.getSource();
        
        if (theButton.getText().equals("User Plays X")) {
            userIsX = true;
            twoPlayerMode = false;
        }
        
        if (theButton.getText().equals("User Plays O")) {
            userIsX = false;
            twoPlayerMode = false;
        }
        
        if (theButton.getText().equals("Two Player Mode")) {
            userIsX = false;
            twoPlayerMode = true;
        }
        gettingrecord();
        clearGameBoard();
    }
}