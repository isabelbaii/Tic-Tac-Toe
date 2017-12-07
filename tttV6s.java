import java.util.*;
	public class tttV6s {
		public static final int GAMESIZE = 3;// make sure that the array created is 3x3
		public static final int RAW = 8;//there are total 8 possible ways of win
		public static void main (String [] args) {
			TextIO.putf("Welcome to Tic Tac Toe.%n");
			do {
				char[][] game = new char[3][3];// create the array
        		for (int i = 0; i < 3; i++) {
            		for (int j = 0; j < 3; j++) {
                		game[i][j] = ' ';
            		}
        		}
				int steps = 0;
				boolean test = whoGoesfirst();//ask user who goes first
				boolean finish = false;
				while (!finish &&  steps< 3 * 3) {
                	steps++;// each time steps goes up
                	if (test) {
                    	userTurn(game);// a static method to find user's input
                	} else {
                    	finish = computerTurn(game);// computer's term to play
                	}
               		test = !test;//make while loop end
                	printBoard(game);// print out the game
            	}
            	if (steps == 3 * 3) {// if move to 9, the game is tie
                	TextIO.putf("It's a tie%n");
            	}
            	TextIO.putf("%n");
        	}
					 while (playAgain());
    	}
		public static boolean whoGoesfirst() {
        	TextIO.putf("Do you want to go first?%n");
        	boolean answer=TextIO.getlnBoolean();
					return answer;
        }

    	public static void userTurn(char[][] game) {
        	boolean result = false;
        	int row = 0;
        	int col = 0;

        	while (!result) {
            	TextIO.putf("What is the number in row? ");
            	row = TextIO.getlnInt() - 1;
            	TextIO.putf("What is the number in column? ");
            	col = TextIO.getlnInt() - 1;
            	if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            	// make sure the input is in the correct range
                	TextIO.putf("The answer must be between 1 and 3");
            	} else if (game[row][col] != ' ') {
                	TextIO.putf("That square is already taken%n");// check if the
                	//space has already been taken
            	} else {
                	result = true;//if the input is available, the result will become true,
                	// and while loop will stop
            	}
        	}
        	game[row][col] = 'X';
    	}//

    	
//
     	public static int testMove(char[] row) {
        	int userCount = 0;
        	int computerCount = 0;
        	for (int i = 0; i < 3; i++) {
            	if (row[i] == 'X') {
                	userCount++;
            	} else if (row[i] == 'O') {
                	computerCount++;
            	}
        	}
        	if (userCount > 0 && computerCount > 0) {
            	return 0;  // mixed row
        	} if (userCount == GAMESIZE - 1) {
            	return 2;  // user 2-in-a-row
        	} else if (computerCount == GAMESIZE - 1) {
            	return 3;  // computer 2-in-a-row
        	} else if (userCount == GAMESIZE) {
            	return 4;  // user 3-in-a-row
        	} else {
            	return 1;  //
        	}
    	}//
	 	public static void printBoard(char[][] game) {
        	for (int i = 0; i <= 4 * 3; i++) {//prints out the game graph
            	TextIO.put("-");
        	}
        	TextIO.putf("%n");
        	for (int j = 0; j < 3; j++) {
            	for (int k = 0; k < 3; k++) {
                	TextIO.putf("| " + game[j][k] + " ");
            	}
            	TextIO.putf("|%n");
            	for (int l = 0; l <= 4 * 3; l++) {
            		TextIO.put("-");
        		}
        		TextIO.putf("%n");
        	}
        	TextIO.putf("%n");
    	}
    	public static boolean playAgain() {// ask the user if he wants to play again

        	TextIO.putf("Do you want to play again?");
        	boolean answer=TextIO.getlnBoolean();
					return answer;
        		}
    	}
