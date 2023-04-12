import java.util.Scanner;

/**
	This program implements the poison cake game
*/

public class PoisonCake {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int numRow, numCol;

		System.out.print("Enter the number of rows: ");
		numRow = keyboard.nextInt();
		System.out.print("Enter the number of columns: ");
		numCol = keyboard.nextInt();
		
		boolean player1Turn = true;
		boolean gameEnd = false;
		int[][] board = new int[numRow][numCol];
		
		do {
			// print current board
			for (int i = 0; i < numRow; i++) {
				for (int j = 0; j < numCol; j++) {
					String printStr = "O";
					if (board[i][j] != 0) {
						printStr = "" + board[i][j];
					} else if (i == numRow - 1 && j == numCol - 1) {
						printStr = "X";
					}
					System.out.print("|" + printStr);
				}
				System.out.println("|");
			}
			
			int playerNum = 2;
			if (player1Turn) playerNum = 1;

			// check game end
			if (board[numRow-1][numCol-1] != 0) {
				System.out.println("Game ended! Player " + (playerNum % 2 + 1) + " ate the posion cake! Player " + playerNum + " wins!");
				gameEnd = true;
			}

			if (!gameEnd) {
				System.out.println("Player " + playerNum + "'s turn:");
				int pRow = 0, pCol = 0;
				
				System.out.print("Enter the row number: ");
				pRow = keyboard.nextInt();

				System.out.print("Enter the column number: ");
				pCol = keyboard.nextInt();

				for (int i = 0; i < pRow; i++) {
					for (int j = 0; j < pCol; j++) {
						if (board[i][j] == 0) board[i][j] = playerNum;
					}
				}

				// Switch player's turn
				player1Turn = !player1Turn;
			}
		} while (!gameEnd);
	}
}