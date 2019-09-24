package javaProgramming5;

import java.util.Random;
import java.util.Scanner;



public class Tic {

	// The board
	String board[][] = {{" 1 ","|"," 2 ","|"," 3 "},
						{"---","+","---","+","---"},
						{" 4 ","|"," 5 ","|"," 6 "},
						{"---","+","---","+","---"},
						{" 7 ","|"," 8 ","|"," 9 "}};
	Scanner sc = new Scanner(System.in);
	
	boolean playerTurn; // If its the players turn its true, else its false.
	boolean repeatedX; // If there is a number already marked with " X " returns true, else its false.
	boolean repeatedO; // If there is a number already marked with " O " returns true, else its false.
	
	
	

	

	// Prints board.
	public void printBoard(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				if ((j == board[0].length - 1)) {
					System.out.println(board[i][j]);
				}
				else {
					System.out.print(board[i][j]);
				}
			}	
		}
	}
	
	// Given a number it swaps that number with an X. If there is an X already in that place set repeatedX to true.
	public void pInsertX(String num, String[][] board) {
		for (int i = 0; i < board.length; i += 2) {
			for (int j = 0; j < board[0].length; j++) {
			if ((board[i][j].equals(" O ")) || (board[i][j].equals(" X "))) {
				repeatedX = true;
				continue;
			}
			else if (num.equals(board[i][j])) {
					board[i][j]= " X ";
					repeatedX = false;
					return;
				}	
			}
		}
	}
	
	// Given a number it swaps that number with an O. If there is an O already in that place set repeatedO to true.
	public void pIinsertO(String num, String[][] board) {
		for (int i = 0; i < board.length; i += 2) {
			for (int j = 0; j < board[0].length; j++) {
			if ((board[i][j].equals(" O ")) || (board[i][j].equals(" X "))) {
				repeatedO = true;
				cpuChoiceGenerator();
				continue;
			}
			else if (num.equals(board[i][j])) {
					board[i][j]= " O ";
					repeatedO = false;
					return;
				}
				
			}
		}
	}
	
	// Generates a number between 1-2 and returns either true or false if the user is playing or not (respectively).
	public boolean playerTurn(String userName1, String cpu) {
		Random r = new Random();
		int i = r.nextInt(2) + 1;
		
		
		if (i == 1) {
			
			playerTurn = true;
			return true;
		}
		else {
			
			playerTurn = false;
			return false;
		}
		
		
	}
	

	
	// Generates a number between 1-9 and changes it to a string the the form of " number ".
	public String cpuChoiceGenerator() {
		Random r = new Random();
		int i = r.nextInt(9) + 1;
		String s = "";
		boolean run = true;
		
		while (run) {
			switch (i) {
			case 1: 
				s = " 1 ";
				run = false;
				break;
			case 2:
				s = " 2 ";
				run = false;
				break;
			case 3:
				s = " 3 ";
				run = false;
				break;
			case 4: 
				s = " 4 "; 
				run = false;
				break;
			case 5:
				s = " 5 ";
				run = false;
				break;
			case 6: 
				s = " 6 ";
				run = false;
				break;
			case 7:
				s = " 7 ";
				run = false;
				break;
			case 8:
				s = " 8 ";
				run = false;
				break;
			case 9:
				s = " 9 ";
				run = false;
				break;
			}
		}	
		return s;
	}
	
	// Asks the user for input, formats it and passes it to pInsert, which prints " X " in the numbered location.
	public void userInput(String input) {
		String fInput;
		
		System.out.println("Pick a number between 1-9 to put your mark.");
		input = sc.nextLine();
		fInput = " " + input + " ";
		
		pInsertX(fInput, board);
		
	}
	
	// Generates a value 1-9 using the cpuChoice generator and passes it to pInsertO, which prints " O " in the numbered location.
	public void cpuInput() {
		String cpuIn;
		cpuIn = cpuChoiceGenerator();
		pIinsertO(cpuIn, board);
	}
	
	// Will check for gaming wins. Either full row, full column, full diagonal, or full inverse diagonal. 
	// Returns true if either one of those cases is true.
	public boolean winCheck(String symbol, String[][] board) {
		int countRow = 0;
		int countCol = 0;
		int countDia = 0;
		int countIDia = 0;
		for (int i = 0; i < board.length; i += 2) {
			for (int j = 0; j < board[0].length; j += 2) {
			
				if ((board[i][j].equals(symbol)) && (i == j)) {
					countDia += 1;
					
				}
				if ((board[i][j].equals(symbol)) && (i + j == 4)) {
					countIDia += 1;
				}
				
				if (board[i][j].equals(symbol)) {
					countRow += 1;
				}
				
				if (board[j][i].equals(symbol)) {
					countCol += 1;
				}
			}
			if (countRow == 3) {
				return true;
			}
			else if (countCol == 3) {
				return true;
			}
			else if (countDia == 3) {
				return true;
			}
			else if (countIDia == 3) {
				return true;
			}
			else {
				countRow = 0;
				countCol = 0;
			}
			
		}
		return false;
	}
	
	// Checks for a tie. If the board is full and no one wins. Returns true if this happens.
	public boolean tieCheck() {
		int count = 0;
		for (int i = 0; i < board.length; i += 2) {
			for (int j = 0; j < board[0].length; j++) {
				if ((this.board[i][j].equals(" X ")) || (this.board[i][j].equals(" O "))) {
					count += 1;
				}
			}
		}
		if (count == 9) {
			return true;
		}
		return false;
	}
	
}
	

