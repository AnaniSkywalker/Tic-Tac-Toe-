package ProjectFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ButtonListener extends GameBoard implements ActionListener
{
	
	public void actionPerformed(ActionEvent event) 
	{
        String numberPressed = event.getActionCommand();
        JButton theButton = (JButton) event.getSource();

        if (theButton.getText() == "") {
            if (userIsX && !twoPlayerMode) {
                theButton.setText ("X");
                gameBoard[Integer.parseInt(numberPressed)] = 1;
                gameArtificialIntelligence();
            }

            if (!userIsX && !twoPlayerMode) {
                theButton.setText ("O");
                gameBoard[Integer.parseInt(numberPressed)] = 2;
                gameArtificialIntelligence();
            }

            if (twoPlayerMode) {
                if (moveCounter == 0 || moveCounter == 2 || moveCounter == 4|| moveCounter == 6 || moveCounter == 8 || moveCounter == 10|| moveCounter == 12 || moveCounter == 14 || moveCounter == 16|| moveCounter == 18 || moveCounter == 20 || moveCounter == 22|| moveCounter == 24) {
                    gameBoard[Integer.parseInt(numberPressed)] = 1;
                    theButton.setText ("X");
                }
                else {
                    gameBoard[Integer.parseInt(numberPressed)] = 2;
                    theButton.setText ("O");
                }
                gettingWinner();
                gettingWinner();
                moveCounter++;
            }
        }
    }
}
