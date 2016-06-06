package ProjectFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//Handles the event that the user presses the About menu button.
@SuppressWarnings("serial")
class AboutButtonListener extends GameBoard implements ActionListener 
{
    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "6x6x5 Tic Tac Toe\nDeveloped by Anani Assoutovi -- University of Houston Downtown\n\n Rules: Placing 4 identical markers in a row wins the game!","About", getDefaultCloseOperation());
    }
}