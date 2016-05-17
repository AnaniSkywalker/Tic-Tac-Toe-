package ProjectFlow;

public interface ProjectInterface {

	void theMenuHandler();
	void theFileMenuHandler();
	void theHelpMenuHandler();
	void gameDifficultyMenu();
	void gamePanel();
	void gameArtificialIntelligence();
	int gettingWinner();
	boolean decidingDraw();
	void gettingrecord();
	void updatingWinner();
	boolean possiblePoint();
	boolean blockingOpponent();
	void makeRandomMove();
	boolean gameBoardAvailability();
	int possibleHorizontalScore(int val);
	int possibleVerticalScore(int val);
	int possibleDiagonalScore(int val);
	int commonStrategy(int val);
	int findRandomCorner();
	void userMakesMove(int goFirst);
	
}
