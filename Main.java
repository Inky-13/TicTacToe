package javaProgramming5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean gameRunning = true;
		
	// Keeps the game looping unless the user selects "No" at the end."
	do {	
			// Starts game.
			Tic t = new Tic();
			System.out.println();
			System.out.println("Welcome to Tic-Tac-Toe! \nWho is playing?");
			String userName = sc.nextLine();
			String input = "";
			
			// Checks if the user is the first to play. There is a 50% chance this happens.
			if (t.playerTurn(userName, "CPU")) { 
				System.out.println("You start " + userName + ". (X)");
				System.out.println();
				t.printBoard(t.board);
				System.out.println();
				while (gameRunning) {
					
					//User Turn
					t.userInput(input);
					
					// if the user puts a mark on an already marked number this loops, telling to pick another number to mark.
					while (t.repeatedX) {
						System.out.println("There is a mark already there!");
						t.userInput(input);
						System.out.println();
					}
					// Prints board as an update.
					t.printBoard(t.board);
					System.out.println();
					t.playerTurn = false; // passes turn.
					
					//-----------------------
					
					// If the user wins (X) it displays a congratulation message and asks if they want to play again.
					if (t.winCheck(" X ", t.board)) {
						System.out.println(userName + " wins! Congratulations.");
						System.out.println();
						System.out.println("Want to play again? Y/N");
						String finalInput = sc.nextLine();
						if (finalInput.equalsIgnoreCase("y")) {
							break;
						}
						else {
							System.out.println("Alright see you next time!"); //if user does not want to play again.
							gameRunning = false;
							break;
						}
					}
					// If it is a tie or in other words the board is full and neither the user nor the computer won.
					else if (t.tieCheck()) {
						System.out.println("It is a tie."); // Displays
						System.out.println();
						System.out.println("Want to play again? Y/N"); // Asks if they want to play again.
						String finalInput = sc.nextLine();
						if (finalInput.equalsIgnoreCase("y")) {
							break;
						}
						else {
							System.out.println("Alright see you next time!"); //if user does not want to play again.
							gameRunning = false;
							break;
						}
					}
					
					
					//CPU Turn
					System.out.println("The computer played.");
					
					// Generates a number from 1-9 and inputs it in the board.
					t.cpuInput();
					System.out.println();
					
					// Loops generating a new number if the previous one was already marked.
					while (t.repeatedO) {
						t.cpuInput();
						System.out.println();
					}
					// Prints board as an update.
					t.printBoard(t.board);
					System.out.println();
					t.playerTurn = true; //passes turn.
					
					//----------------------
					
					// If the computer wins (O) it displays a congratulation message and asks if the user want to play again.
					if (t.winCheck(" O ", t.board)) {
						System.out.println("Computer wins! Congratulations.");
						System.out.println();
						System.out.println("Want to play again? Y/N"); // Asks if they want to play again.
						String finalInput = sc.nextLine();
						if (finalInput.equalsIgnoreCase("y")) {
							break;
						}
						else {
							System.out.println("Alright see you next time!"); //if user does not want to play again.
							gameRunning = false;
							break;
						}
					}
					
					// If it is a tie or in other words the board is full and neither the user nor the computer won.
					else if (t.tieCheck()) {
						System.out.println("It is a tie.");
						System.out.println();
						System.out.println("Want to play again? Y/N"); //Asks if they want to play again.
						String finalInput = sc.nextLine();
						if (finalInput.equalsIgnoreCase("y")) {
							break;
						}
						else {
							System.out.println("Alright see you next time!"); //if user does not want to play again.
							gameRunning = false;
							break;
						}
					}
				}
			}
			
			// If the user does is not the first one to play. There is a 50% chance this happens.
			else {
				
				System.out.println("The computer goes first.");
				
				while (gameRunning) {
				
					//CPU
					System.out.println("The computer played. (O)");
					
					// The computer generates a number and inputs it on the board.
					t.cpuInput();
					System.out.println();
					
					while (t.repeatedO) { // Loops while the generated number is marked already.
						t.cpuInput();
					}
					
					// Prints the board as an update.
					System.out.println();
					t.printBoard(t.board);
					System.out.println();
					t.playerTurn = true; //pass turn.
					
					//----------------------
					
					// Checks if computer wins.
					if (t.winCheck(" O ", t.board)) {
						System.out.println("Computer wins! Congratulations."); //displays 
						System.out.println();
						System.out.println("Want to play again? Y/N"); //asks if the user wants to play again.
						String finalInput = sc.nextLine();
						if (finalInput.equalsIgnoreCase("y")) {
							break;
						}
						else {
							System.out.println("Alright see you next time!"); //if the user selects "No".
							gameRunning = false;
							break;
						}
					}
					// Check if its a tie.
					else if (t.tieCheck()) {
						System.out.println("It is a tie.");
						System.out.println();
						System.out.println("Want to play again? Y/N");
						String finalInput = sc.nextLine();
						if (finalInput.equalsIgnoreCase("y")) {
							break;
						}
						else {
							System.out.println("Alright see you next time!");
							gameRunning = false;
							break;
						}
					}
					
					
					//User
					System.out.println("It is your turn now. (X)");
					t.userInput(input);
					
					while (t.repeatedX) {
						System.out.println("There is a mark already there!");
						t.userInput(input);
						System.out.println();
					}
					t.printBoard(t.board);
					System.out.println();
					t.playerTurn = false; // pass turn.
					
					//-----------------------
					
					//Same as before (check game status and acts accordingly).
					if (t.winCheck(" X ", t.board)) {
						System.out.println(userName + " wins! Congratulations.");
						System.out.println();
						System.out.println("Want to play again? Y/N");
						String finalInput = sc.nextLine();
						if (finalInput.equalsIgnoreCase("y")) {
							break;
						}
						else {
							System.out.println("Alright see you next time!");
							gameRunning = false;
							break;
						}
					}
					else if (t.tieCheck()) {
						System.out.println("It is a tie.");
						System.out.println();
						System.out.println("Want to play again? Y/N");
						String finalInput = sc.nextLine();
						if (finalInput.equalsIgnoreCase("y")) {
							break;
						}
						else {
							System.out.println("Alright see you next time!");
							gameRunning = false;
							break;
						}
					}
				}
			}
		} 
	
		while (gameRunning); // If gameRunning is ever false the game ends. Else it will keep looping.
		sc.close();
	}

}
