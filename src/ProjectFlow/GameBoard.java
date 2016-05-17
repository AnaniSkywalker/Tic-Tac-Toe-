package ProjectFlow;

import static java.lang.System.out;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class GameBoard extends JFrame implements ProjectInterface
{
	//First Let us Determine the difficulty levels:
	//Notice we set the mediumLevel = true, because this is going to be our default game Mode
	//If the user wants to play the game on regular mode, this is the level that comes up.
	boolean easyLevel = false;
	boolean mediumLeve = true;
	boolean hardLevel = false;
	
	//Next, let us determine if the user wants to be either X or O icon
	//Notice, we set iconAvatarX = true, because by default the user will be assign X icon Avatar;
	boolean iconAvatarX = true;
	boolean iconAvatorO = false;
	
	//Now, let us determine all the variables that we can use to keep record of the scores
	int winner =0, draws =0, loss=0, oWinner=0, xWinner=0, counterMove =0, usersDraw =0;
	
	//Okay, So now, let us create the game main Panel for the game screen
	JPanel gameScreen;
	
	//Now, Let us create some Labels for screen messages for losses, draws and wins, to display
	// and keep records.
	JLabel winLabel, lossLabel, drawLabel;
	
	//Okay, now since we are writing a 6x6x5 game, we need total of 36 blocks with each holding data
	// So we will need an array to store all the 36 grids in it. We need to declare the initial value
	// of each data to be 0
	//I prefer using buttons so I do this
	JButton [] gameButtons = new JButton[36];
	int [] gameBoard = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	//Now, let us have so fun by applying our design skills
	//Let us create out game menu
	//Check Boxes to select game mode
	private JRadioButtonMenuItem easyMode;
	private JRadioButtonMenuItem mediumMode;
	private JRadioButtonMenuItem hardMode;
	
	//Top Menu Bars
	private JMenu mainFile;
	private JMenu helpBar;
	private JMenu aboutMe;
	private JMenu menuBar;
	private JMenu modeMenu;
	private JMenu newMenu;
	private JMenu exitGame;
	
	//Now, Let us worry about the constructor and the game's menu
	public GameBoard()
	{
		setSize(950, 750);
		setTitle("Tic Tac Toe (6x6x5)\t by Anani Assoutovi");
		theMenuHandler();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel();
		add(gameScreen);
		setVisible(true);
	}

	@Override
	public void theMenuHandler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void theFileMenuHandler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void theHelpMenuHandler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameDifficultyMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gamePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameArtificialIntelligence() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int gettingWinner() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean decidingDraw() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void gettingrecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatingWinner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean possiblePoint() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean blockingOpponent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeRandomMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean gameBoardAvailability() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int possibleHorizontalScore(int val) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int possibleVerticalScore(int val) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int possibleDiagonalScore(int val) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commonStrategy(int val) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findRandomCorner() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void userMakesMove(int goFirst) {
		// TODO Auto-generated method stub
		
	}

}
