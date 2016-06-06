package ProjectFlow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import com.sun.glass.events.KeyEvent;

@SuppressWarnings("serial")
public class GameBoard extends JFrame implements ProjectInterface
{
	//First Let us Determine the difficulty levels:
	//Notice we set the mediumLevel = true, because this is going to be our default game Mode
	//If the user wants to play the game on regular mode, this is the level that comes up.
//	boolean easyLevel = false;
//	boolean mediumLevel = true;
//	boolean hardLevel = false;
	boolean easy = false;
    boolean normal = true;
    boolean hard = false;
    
	//Next, let us determine if the user wants to be either X or O icon
	//Notice, we set iconAvatarX = true, because by default the user will be assign X icon Avatar;
//	boolean iconAvatarX = true;
//	boolean iconAvatorO = false;
    boolean userIsX = true;
    boolean twoPlayerMode = false;
    
	//Now, let us determine all the variables that we can use to keep record of the scores
	//int winner =0, draws =0, loss=0, oWinner=0, xWinner=0, counterMove =0, usersDraw =0;
    int wins = 0;
    int oWins = 0;
    int xWins = 0;
    int draws = 0;
    int losses = 0;
    int moveCounter = 0;
    int twoPlayerDraws = 0;
    
	//Okay, So now, let us create the game main Panel for the game screen
	JPanel gameScreen;
	
	//Now, Let us create some Labels for screen messages for losses, draws and wins, to display
	// and keep records.
	//JLabel winLabel, lossLabel, drawLabel;
	JLabel winsRecord;
    JLabel lossRecord;
    JLabel drawRecord;
    
    
	//Okay, now since we are writing a 6x6x5 game, we need total of 36 blocks with each holding data
	// So we will need an array to store all the 36 grids in it. We need to declare the initial value
	// of each data to be 0
	//I prefer using buttons so I do this
//	JButton [] gameButtons = new JButton[36];
    JButton [] buttons = new JButton[36];
	int [] gameBoard = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	//Now, let us have so fun by applying our design skills
	//Let us create out game menu
	//Check Boxes to select game mode
//	private JRadioButtonMenuItem easyMode;
//	private JRadioButtonMenuItem mediumMode;
//	private JRadioButtonMenuItem hardMode;
//	
//	//Top Menu Bars
//	private JMenu mainFile;
//	private JMenu helpBar;
//	private JMenuItem aboutMe;
//	private JMenuBar menuBar;
//	private JMenu modeMenu;
//	private JMenuItem developerInfo;
//	private JMenuItem newMenu;
//	private JMenuItem exitGame;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuBar menuBar;
    private JMenuItem newMenu;
    private JMenuItem exitMenu;
    private JMenuItem aboutMenu;
    private JMenu difficultyMenu;
    private JRadioButtonMenuItem difficultyEasy;
    private JRadioButtonMenuItem difficultyHard;
    private JRadioButtonMenuItem difficultyNormal;
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
	public void theMenuHandler() 
	{
		// Create the menu bar.
        menuBar = new JMenuBar();

        // Create the file and help menus.
        theFileMenuHandler();
        gameDifficultyMenu();
        theHelpMenuHandler();

        // Add the file and help menus to the menu bar.
        menuBar.add(fileMenu);
        menuBar.add(difficultyMenu);
        menuBar.add(helpMenu);

        // Set the window's menu bar.
        setJMenuBar(menuBar);
	}

	@Override
	public void theFileMenuHandler() 
	{
		// Create an Exit menu item.
        exitMenu = new JMenuItem("Exit");
        exitMenu.setMnemonic(KeyEvent.VK_X);
        exitMenu.addActionListener(new ExitButtonListener());

        // Create a New menu item.
        newMenu = new JMenuItem("New");
        newMenu.setMnemonic(KeyEvent.VK_N);
        newMenu.addActionListener(new NewButtonListener());

        // Create a JMenu object for the File menu.
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // Add the items to the menu.
        fileMenu.add(newMenu);
        fileMenu.add(exitMenu);
	}

	@Override
	public void theHelpMenuHandler() 
	{
		// Create an Exit menu item.
        aboutMenu = new JMenuItem("About");
        aboutMenu.addActionListener(new AboutButtonListener());

        // Create a JMenu object for the Help menu.
        helpMenu = new JMenu("Help");

        // Add the items to the menu.
        helpMenu.add(aboutMenu);
	}

	@Override
	public void gameDifficultyMenu() 
	{
		// Create an Exit menu item.
        difficultyEasy = new JRadioButtonMenuItem("Easy");
        difficultyEasy.addActionListener(new DifficultyListener());
        difficultyNormal = new JRadioButtonMenuItem("Normal", true);
        difficultyNormal.addActionListener(new DifficultyListener());
        difficultyHard = new JRadioButtonMenuItem("Hard");
        difficultyHard.addActionListener(new DifficultyListener());

        // Create a JMenu object for the Help menu.
        difficultyMenu = new JMenu("Difficulty");

        // Add the difficulty buttons to a group to make them mutually exclusive.
        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(difficultyEasy);
        difficultyGroup.add(difficultyNormal);
        difficultyGroup.add(difficultyHard);

        // Add the items to the menu.
        difficultyMenu.add(difficultyEasy);
        difficultyMenu.add(difficultyNormal);
        difficultyMenu.add(difficultyHard);
	}

	@Override
	public void gamePanel() 
	{
		gameScreen = new JPanel();
        //JButton buttons[];
        
        //mainPanel.setBackground(Color.white);
        gameScreen.setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        
        gamePanel.setBackground(Color.white);
        gamePanel.setBorder(BorderFactory.createTitledBorder("Game Board"));
        gamePanel.setLayout(new GridLayout(5,5));

        for (int count = 0; count < 25; count++) 
        {
            buttons[count] = new JButton();
            buttons[count].setBorder(BorderFactory.createLineBorder(Color.black));
            buttons[count].addActionListener(new ButtonListener());
            buttons[count].setBackground(Color.white);
            buttons[count].setActionCommand("" + count);
            gamePanel.add(buttons[count]);
            buttons[count].setFont(buttons[count].getFont().deriveFont(75.0f));
        }
        JPanel controls = new JPanel();
        controls.setLayout(new BorderLayout());
        controls.setBorder(BorderFactory.createTitledBorder("Control"));

        JButton newGame = new JButton("New Game");
        controls.add(newGame, BorderLayout.NORTH);
        newGame.addActionListener(new NewButtonListener());

        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new GridLayout(4,1,5,5));

        JPanel record = new JPanel();
        record.setLayout(new GridLayout(3,1));
        record.setBorder(BorderFactory.createTitledBorder("History Of Your Previous Games"));
        winsRecord = new JLabel("Wins: 0");
        lossRecord = new JLabel("Losses: 0");
        drawRecord = new JLabel ("Draws: 0");

        record.add(winsRecord);
        record.add(lossRecord);
        record.add(drawRecord);
        JLabel spacer = new JLabel(" ");

        informationPanel.add(spacer);
        informationPanel.add(record);
        controls.add(informationPanel, BorderLayout.CENTER);

        JRadioButton userPlaysX = new JRadioButton("User Plays X", true);
        JRadioButton userPlaysO = new JRadioButton("User Plays O");
        JRadioButton twoPlayer = new JRadioButton("Two Player Mode");

        userPlaysX.addActionListener(new RadioListener());
        userPlaysO.addActionListener(new RadioListener());
        twoPlayer.addActionListener(new RadioListener());

        clearGameBoard();

        ButtonGroup group = new ButtonGroup();
        group.add(userPlaysX);
        group.add(userPlaysO);
        group.add(twoPlayer);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3,1));
        radioPanel.add(userPlaysX);
        radioPanel.add(userPlaysO);
        radioPanel.add(twoPlayer);
        informationPanel.add(radioPanel);

        JButton exitGame = new JButton("Exit");
        controls.add(exitGame, BorderLayout.SOUTH);
        exitGame.addActionListener(new ExitButtonListener());

        gameScreen.add(gamePanel, BorderLayout.CENTER);
        gameScreen.add(controls, BorderLayout.EAST);
	}

	@Override
	public void gameArtificialIntelligence() {
		 // Check for a draw game.
        if (!decidingDraw()) {
            
            // Tell the user if there is a winner.
        	decidingDraw();

            // If there is not a winner after the last turn, proceed with AI.
            if (gettingWinner() == 0) {
                
                // If the AI is able to win, it does so. If not, it attempts to block the user from winning.
                if (!possiblePoint()) {
                    if (!blockingOpponent()) {
                        
                        // Choose a random move if all else fails.
                    	makeRandomMove();
                    }
                }
                
                // If there is a winner after the AI moves, inform the user.
                updatingWinner();
                
                // Check for a draw game.
                decidingDraw();
            }
        }
		
	}

	@Override
	public int gettingWinner() 
	{
		
		// Check for a win horizontally.
        for (int k = 1; k < 6; k++) 
        {
            for (int i = 0; i < 34; i+=6) 
            {
                if(gameBoard[i] == k && gameBoard[i + 1] == k && gameBoard[i + 2] == k && gameBoard[i + 3] == k && gameBoard[i + 4] == k)
                    return k;
                
                if(gameBoard[i + 1] == k && gameBoard[i + 2] == k && gameBoard[i + 3] == k && gameBoard[i + 4] == k && gameBoard[i + 5] == k)
                    return k;
            }
        }

        // Check for a win vertically.
        for (int k = 1; k < 6; k++) 
        {
            for (int i = 0; i < 6; i++) 
            {
                if(gameBoard[i] == k && gameBoard[i + 6] == k && gameBoard[i + 12] == k && gameBoard[i + 18] == k && gameBoard[i + 24] == k)
                    return k;
                
                if(gameBoard[i + 6] == k && gameBoard[i + 12] == k && gameBoard[i + 18] == k && gameBoard[i + 24] == k && gameBoard[i + 30] == k)
                    return k;
            }
        }
        
        // Check for a win diagonally, top left to bottom right.
        for (int i = 1; i < 6; i++) 
        {
            if(gameBoard[0] == i && gameBoard[7] == i && gameBoard[14] == i && gameBoard[21] == i && gameBoard[28] == i )
                return i;
            
            if(gameBoard[7] == i && gameBoard[14] == i && gameBoard[21] == i && gameBoard[28] == i && gameBoard[35] == i)
                return i;
            
            if(gameBoard[1] == i && gameBoard[8] == i && gameBoard[15] == i && gameBoard[22] == i && gameBoard[29] == i)
                return i;
            
            if(gameBoard[6] == i && gameBoard[13] == i && gameBoard[20] == i && gameBoard[27] == i && gameBoard[34] == i)
                return i;
        }

        // Check for win diagonally, top right to bottom left.
        for (int i = 1; i < 6; i++) 
        {
            if(gameBoard[5] == i && gameBoard[10] == i && gameBoard[15] == i && gameBoard[20] == i && gameBoard[25] == i)
                return i;
            
            if(gameBoard[10] == i && gameBoard[15] == i && gameBoard[20] == i && gameBoard[25] == i && gameBoard[30] == i)
                return i;
            
            if(gameBoard[4] == i && gameBoard[9] == i && gameBoard[14] == i && gameBoard[19] == i && gameBoard[24] == i)
                return i;
            
            if(gameBoard[11] == i && gameBoard[16] == i && gameBoard[21] == i && gameBoard[26] == i && gameBoard[31] == i)
                return i;
        }
        return 0;
	}

	@Override
	public boolean decidingDraw() 
	{
		
		if (gameBoardAvailability() && gettingWinner() == 0) 
		{
            JOptionPane.showMessageDialog(null,"THE GAME IS A DRAW");
            if (twoPlayerMode)
                twoPlayerDraws++;
            else
                draws++;
            gettingrecord();
            return true;
        }
        else
            return false;
	}

	@Override
	public void gettingrecord() 
	{
		if (!twoPlayerMode) 
		{
            winsRecord.setText("Wins: " + wins);
            lossRecord.setText("Losses: " + losses);
            drawRecord.setText("Draws: " + draws);
        }
        else 
        {
            winsRecord.setText("X Wins: " + xWins);
            lossRecord.setText("O Wins: " + oWins);
            drawRecord.setText("Draws: " + twoPlayerDraws);
        }
	}

	@Override
	public void updatingWinner() 
	{
		if (gettingWinner() == 1) 
		{
            JOptionPane.showMessageDialog(null,"X WINS");
            
            if (userIsX)
                wins++;
            
            if (!userIsX && !twoPlayerMode)
                losses++;
            
            if (twoPlayerMode)
                xWins++;
            gettingrecord();
        }

        if (gettingWinner() == 2) 
        {
            JOptionPane.showMessageDialog(null,"O WINS");
            if (userIsX || twoPlayerMode)
                losses++;
            if (!userIsX && !twoPlayerMode)
                wins++;
            if (twoPlayerMode)
                oWins++;
            gettingrecord();
        }
	}

	@Override
	public boolean possiblePoint() 
	{
		int CPUValue;
        int bestMove = -1;

        // Find out if the CPU is X or O. 2 for O, 1 for X.
        if (userIsX)
            CPUValue = 2;
        else
            CPUValue = 1;

        // Try to win horizontally.
        bestMove = possibleHorizontalScore(CPUValue);

        // Try to win vertically.
        if (bestMove == -1)
            bestMove = possibleVerticalScore(CPUValue);

        // Try to win diagonally.
        if (bestMove == -1)
            bestMove = possibleDiagonalScore(CPUValue);

        if (bestMove > -1 && bestMove < 36) 
        {
        	userMakesMove(bestMove);
            return true;
        }
        else
            return false;
	}

	@Override
	public boolean blockingOpponent() 
	{
		int userValue;
        int bestMove = -1;

        if (userIsX)
            userValue = 1;
        else
            userValue = 2;

        bestMove = possibleHorizontalScore(userValue);

        // Block commonly used tic tac toe moves if the difficulty is hard.
        if (hard && commonStrategy(userValue) > 0) 
        {
            if (bestMove == -1)
                bestMove = commonStrategy(userValue);
        }

        // Block the user's vertical move.
        if (bestMove == -1)
            bestMove = possibleVerticalScore(userValue);

        // Block the user's diagonal move.
        if (bestMove == -1)
            bestMove = possibleDiagonalScore(userValue);

        // If difficulty is normal or hard, prioritize the remaining spaces.
        if (normal || hard) 
        {
            if (bestMove == -1 && gameBoard[14]==0 && userIsX)
                bestMove = 14;

            if (bestMove == -1)
                bestMove = findRandomCorner();
        }

        // If bestMove falls between the valid numbers 0 and 8 instruct the CPU to physically make the move and return true.
        if (bestMove > -1 && bestMove < 36) {
        	userMakesMove(bestMove);
            return true;
        }
        else
            return false;
	}

	@Override
	public void makeRandomMove() 
	{
		Random rndGenerator = new Random();
        int rndNum = rndGenerator.nextInt(39);

        if (!gameBoardAvailability()) 
        {
        	userMakesMove (rndNum);
        }
	}

	@Override
	public boolean gameBoardAvailability() 
	{
		for (int i = 0; i < 36; i++) {
            if (gameBoard[i] == 0) {
                return false;
            }
        }
        return true;
	}

	@Override
	public int possibleHorizontalScore(int val) 
	{
		// Incrementing by 4 each time ensures the values are on the same row on the game board.
        for (int k = 0; k < 34; k+=6) 
        {
            // Check each member of the current row and return a value if a critical move is detected.
            if(gameBoard[k + 1] == val && gameBoard[k + 2] == val && gameBoard[k + 3] == val && gameBoard[k + 4] == val && gameBoard[k + 5] ==0)
                return (k + 4);
            
            if(gameBoard[k] == val && gameBoard[k + 1] == val && gameBoard[k + 2] == val && gameBoard[k + 3] == val && gameBoard[k + 4] ==0)
                return (k + 3);
            
            if(gameBoard[k + 2] == val && gameBoard[k + 1] == val && gameBoard[k + 4] == val && gameBoard[k + 3] == val && gameBoard[k + 5] ==0)
                return (k + 3);
            
            if(gameBoard[k + 1] == val && gameBoard[k] == val && gameBoard[k + 3] == val && gameBoard[k + 2] == val && gameBoard[k + 4] ==0)
                return (k + 2);
            
            if(gameBoard[k + 3] == val && gameBoard[k + 4] == val && gameBoard[k + 1] == val && gameBoard[k + 2] == val && gameBoard[k + 5] ==0)
                return (k + 2);
            
            if(gameBoard[k + 2] == val && gameBoard[k + 3] == val && gameBoard[k] == val && gameBoard[k + 1] == val && gameBoard[k + 4] ==0)
                return (k + 1);
            
            if(gameBoard[k + 5] == val && gameBoard[k + 4] == val && gameBoard[k + 3] == val && gameBoard[k + 2] == val && gameBoard[k + 1] == 0)
                return (k + 1);
            
            if(gameBoard[k + 4] == val && gameBoard[k + 3] == val && gameBoard[k + 2] == val && gameBoard[k + 1] == val && gameBoard[k] == 0)
                return (k);
        }
        // Return -1 if no critical move is found.
        return -1;
	}

	@Override
	public int possibleVerticalScore(int val) 
	{
		for (int i = 0; i < 6; i++) 
		{
            // Check each member of the current column to detect if there is a critical move.
            if(gameBoard[i + 6] == val && gameBoard[i + 12] == val && gameBoard[i + 18] == val && gameBoard[i + 24] == val && gameBoard[i + 30] ==0)
                return i + 30;

            if(gameBoard[i + 12] == val && gameBoard[i + 30] == val && gameBoard[i + 6] == val && gameBoard[i + 24] ==val && gameBoard[i + 18] ==0)
                return i + 18;
            
            if(gameBoard[i] == val && gameBoard[i + 6] == val && gameBoard[i + 12] == val && gameBoard[i + 18] == val && gameBoard[i + 24] ==0)
                return i + 24;
            
            if(gameBoard[i + 24] == val &&gameBoard[i + 12] == val && gameBoard[i + 6] == val && gameBoard[i + 30] == val && gameBoard[i + 18] == 0)
                return i + 18;
            
            if(gameBoard[i + 6] == val && gameBoard[i] == val && gameBoard[i + 18] ==val && gameBoard[i + 24] == val && gameBoard[i + 12] == 0)
                return i + 12;
            
            if(gameBoard[i + 20] == val && gameBoard[i + 15] == val && gameBoard[i + 10] == val && gameBoard[i + 5] == 0)
                return i + 5;
            
            if(gameBoard[i + 10] == val && gameBoard[i + 15] == val && gameBoard[i] == val && gameBoard[i + 5] == 0)
                return i + 5;
            
            if(gameBoard[i + 15] == val && gameBoard[i + 10] == val && gameBoard[i + 5] == val && gameBoard[i] == 0)
                return i;
        }
        // Return -1 if no critical move is found.
        return -1;
	}

	@Override
	public int possibleDiagonalScore(int val) 
	{
		// Determine if there are any critical moves diagonally.
        if(gameBoard[6] == val && gameBoard[12] == val && gameBoard[18] == val && gameBoard[24] == val && gameBoard[28] == 0)
            return 28;

        if(gameBoard[0] == val && gameBoard[6] == val && gameBoard[12] == val && gameBoard[18] == val && gameBoard[24] == 0)
            return 24;
        
        if(gameBoard[12] == val && gameBoard[6] == val && gameBoard[24] == val && gameBoard[18] == 0)
            return 18;
        
        if(gameBoard[6] == val && gameBoard[18] == val && gameBoard[0] == val && gameBoard[12] == 0)
            return 12;
        
        if(gameBoard[18] == val && gameBoard[24] == val && gameBoard[6] == val && gameBoard[12] == 0)
            return 12;
        
        if(gameBoard[12] == val && gameBoard[0] == val && gameBoard[18] == val && gameBoard[6] == 0)
            return 6;
        
        if(gameBoard[24] == val && gameBoard[18] == val && gameBoard[12] == val && gameBoard[6] == 0)
            return 6;
        
        if(gameBoard[18] == val && gameBoard[12] == val && gameBoard[6] == val && gameBoard[0] == 0)
            return 0;
        
        // The other way
        if(gameBoard[8] == val && gameBoard[12] == val && gameBoard[16] == val && gameBoard[20] == 0)
            return 20;

        if(gameBoard[12] == val && gameBoard[8] == val && gameBoard[20] == val && gameBoard[16] == 0)
            return 16;

        if(gameBoard[4] == val && gameBoard[8] == val && gameBoard[12] == val && gameBoard[16] == 0)
            return 16;
        
        if(gameBoard[16] == val && gameBoard[20] == val && gameBoard[8] == val && gameBoard[12] == 0)
            return 12;
        
        if(gameBoard[8] == val && gameBoard[4] == val && gameBoard[16] == val && gameBoard[12] == 0)
            return 12;
        
        if(gameBoard[12] == val && gameBoard[16] == val && gameBoard[4] == val && gameBoard[8] == 0)
            return 8;
        
        if(gameBoard[20] == val && gameBoard[16] == val && gameBoard[12] == val && gameBoard[8] == 0)
            return 8;
        
        if(gameBoard[16] == val && gameBoard[12] == val && gameBoard[8] == val && gameBoard[4] == 0)
            return 4;
        
        // Return -1 if no critical move is found.
        return -1;
	}

	@Override
	public int commonStrategy(int val) 
	{
		if(gameBoard[0] == val && gameBoard[24] == val && gameBoard[10] == 0)
            return 10;
        
        if(gameBoard[4] == val && gameBoard[20] == val && gameBoard[14] == 0)
            return 14;
        
        return -1;
	}

	@Override
	public int findRandomCorner() 
	{
		Random rndGenerator = new Random();
        int rndNum = rndGenerator.nextInt(5);

        switch (rndNum) {
            case 0:
                if (gameBoard[0]==0)
                    return 0;
                if (gameBoard[4]==0)
                    return 4;
                if (gameBoard[20]==0)
                    return 20;
                if (gameBoard[24]==0)
                    return 24;
                break;
            
            case 1:
                if (gameBoard[12]==0 && !userIsX)
                    return 12;
                if (gameBoard[4]==0)
                    return 4;
                if (gameBoard[20]==0)
                    return 20;
                if (gameBoard[24]==0)
                    return 24;
                if (gameBoard[0]==0)
                    return 0;
                break;


            case 2:
                if (gameBoard[20]==0)
                    return 20;
                if (gameBoard[24]==0)
                    return 24;
                if (gameBoard[0]==0)
                    return 0;
                if (gameBoard[4]==0)
                    return 4;
                break;
                
            case 3:
                if (gameBoard[24]==0)
                    return 24;
                if (gameBoard[0]==0)
                    return 0;
                if (gameBoard[4]==0)
                    return 4;
                if (gameBoard[20]==0)
                    return 20;
                break;
        }
        return -1;
	}

	@Override
	public void userMakesMove(int goFirst) 
	{
		 if (userIsX) {
	            buttons[goFirst].setText("O");
	            gameBoard[goFirst] = 2;
	        }
	        else {
	            buttons[goFirst].setText("X");
	            gameBoard[goFirst] = 1;
	        }
		
	}
	
	// Clears the game board.
    protected void clearGameBoard() {
        moveCounter = 0;
        
        for (int count = 0; count < 25; count++) {
            buttons[count].setText("");
            gameBoard[count] = 0;
        }
    }

}
