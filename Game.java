// ENSF 607 Assignment 2
// Sam Rainbow
// UCID: 30084292
import java.io.*;

/**
 * Game class creates an instance of the Board used for the tic tac toe board. It also instantiates the referee which
 * is responsible for running the game. This class contains the main function.
 **/
public class Game implements Constants {

	private Board theBoard;
	private Referee theRef;

	/**
	 * The constructor instantiates theBoard as type Board.
	 */
    public Game( ) {
        theBoard  = new Board();
	}

	/**
	 * This method sets the referee by being passed a Referee type.
	 * @param r
	 * @throws IOException
	 */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }

	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);

		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);

		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);

        theGame.appointReferee(theRef);
	}


}
