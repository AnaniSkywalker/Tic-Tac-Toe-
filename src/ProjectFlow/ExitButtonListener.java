package ProjectFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Handles the event that the user presses the Exit button.
@SuppressWarnings("serial")
public class ExitButtonListener extends GameBoard implements ActionListener {
	
    public void actionPerformed(ActionEvent event) {
        System.exit(0);
    }
}