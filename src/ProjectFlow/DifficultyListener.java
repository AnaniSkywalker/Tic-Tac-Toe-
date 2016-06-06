package ProjectFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButtonMenuItem;

@SuppressWarnings("serial")

//Handles the event that the user changes the difficulty.
class DifficultyListener extends GameBoard implements ActionListener 
{
    public void actionPerformed(ActionEvent event) {
        JRadioButtonMenuItem theButton = (JRadioButtonMenuItem)
        event.getSource();
        
        if (theButton.getText().equals("Easy")) {
            easy = true;
            normal = false;
            hard = false;
        }
        
        if (theButton.getText().equals("Normal")) {
            easy = false;
            normal = true;
            hard = false;;
        }
        
        if (theButton.getText().equals("Hard")) {
            easy = false;
            normal = false;
            hard = true;
        }
    }
}