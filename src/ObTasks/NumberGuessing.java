package ObTasks;

import java.util.Scanner;
import java.util.Random;

class Game {
	int generatedInput;
	int myInput;
	int noOfGuesses=0;
	
	//generating random number in default constructor
	Game() {
		Random random = new Random();
		this.generatedInput = random.nextInt(100) + 1;
	}
	
	//method to take user guesses
	public boolean takeUserInput() {
		if (noOfGuesses < 5) {
			System.out.println("Guess the number: ");
			this.myInput = NumberGuessing.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("You are unable to guess the number...please try again\n");
			return true;
		}
	}
	
	public boolean isCorrectGuess() {
		
		if(generatedInput == myInput) {
			System.out.println("you guessed the number" + generatedInput + "in " + noOfGuesses+" guesses");
			switch(noOfGuesses) {
			case 1 :
				System.out.println("You scored 100");
			    break;
			case 2 :
				System.out.println("You scored 90");
			    break;
			case 3 :
				System.out.println("You scored 70");
			    break;
			case 4 :
				System.out.println("You scored 50");
			    break;
			case 5 :
				System.out.println("You scored 30");
			    break;
			}
			System.out.println();
			return true;
		}
		else if(noOfGuesses < 5 && myInput > generatedInput) {
			if(myInput - generatedInput > 10) {
				System.out.println("Number is  too High");
			}
			else {
				System.out.println("a little high.Very nearer to answer");
			}
		}
		else if(noOfGuesses < 5 && myInput < generatedInput) {
			if(generatedInput - myInput > 10) {
				System.out.println("Number is  too lower");
			}
			else {
				System.out.println("a little lower.Very nearer to answer");
			}
		}
		return false;
	}
}
//main class 
public class NumberGuessing {
	
	public static int takeIntegerInput(int capacity) {
		int input = 0 ;
		boolean flag = false;
		
		while(!flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if(flag && input > capacity || input < 1) {
					System.out.println("Choose number between 1 to " + capacity);
					flag = false;
				}
			}
			catch(Exception e) {
				System.out.println("Only integer values are allowed");
				flag = false;
			}
		};
		return input;
	}

	public static void main(String[] args) {
		
		System.out.println("1.Start the game\n 2.Exit");
		System.out.println("Enter your choice :");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
						
			// to check next round is there or not
			while ( nextRound == 1 ) {
				// creating object of Game class
				Game game = new Game();
				boolean isMatchingNumber = false;
				boolean isCapacityCross = false;
				System.out.println("\n Your Round " + ++noOfRound + " starts...");
				
				// to check correct guess and limit cross
				while ( !isMatchingNumber && !isCapacityCross) {
					isCapacityCross = game.takeUserInput();
					isMatchingNumber = game.isCorrectGuess();
				}
				
				System.out.println("1. Next Round \n2. Exit");
				System.out.println("Enter your choice : ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}

	}

}
