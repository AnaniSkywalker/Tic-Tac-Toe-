package ProjectFlow;

import static java.lang.System.out;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import com.sun.glass.events.KeyEvent;

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
	private JMenuItem aboutMe;
	private JMenuBar menuBar;
	private JMenu modeMenu;
	private JMenu developerInfo;
	private JMenuItem newMenu;
	private JMenuItem exitGame;
	
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

	//Here, we are creating the menu list where we will store all the functionalities of the game
	@Override
	public void theMenuHandler() {
		// TODO Auto-generated method stub
		
		//Here we will store the help option
		//Also we are storing the game Mode
		theFileMenuHandler();
		theHelpMenuHandler();
		gameDifficultyMenu();
		
		//First Let us create The Menu bar for the window
		setJMenuBar(menuBar);
		
		//Let us create and instance to hold the data for the menu bar
	    menuBar = new JMenuBar();
	    
	    //Now, Let us use the menuBar to add some import stuff to the menu bar 
	    menuBar.add(mainFile);
	    menuBar.add(modeMenu);
	    menuBar.add(helpBar);
	    menuBar.add(developerInfo);
		
	}

	@Override
	public void theFileMenuHandler() {
		// TODO Auto-generated method stub
		//First Let us add some items to the menu that the user may utilize
		mainFile.add(newMenu);
		mainFile.add(exitGame);
		
		//Next, Let us create a new menu item
		newMenu = new JMenuItem("New Game");
		newMenu.setMnemonic(KeyEvent.VK_0);
		newMenu.addActionListener(new NewButtonListener());
		
		//Now, let us create a new item to exit 
		exitGame = new JMenuItem("Exit");
		exitGame.setMnemonic(KeyEvent.VK_1);
		exitGame.addActionListener(new ExitButtonListener());
		
		//So let us create a new File Menu for the JMenu
		mainFile = new JMenu("Add File");
		mainFile.setMnemonic(KeyEvent.VK_2);
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
