// *********************************************************************
// Main.java		Author: Owen Barnes			Version: 1.0 (1/21/22)
// 
// This class is the main class for the WAR Card Game assignment for an 
// AP Java class.
// 
// *********************************************************************


// --------------------
// Imports
// --------------------

// Imports the scanner class.
import java.util.Scanner;


// --------------------
// Main Class
// --------------------

public class Main
{
	// --------------------
	// Static Variables
	// --------------------

	static Deck pDeck = new Deck();
	static Deck comDeck = new Deck("emptyDeck");
	static GameControls gameControls = new GameControls(pDeck, comDeck);

	// --------------------
	// Main Method
	// --------------------

	public static void main(String[] args)
	{
		// Scanner Setup
		Scanner input = new Scanner(System.in);

		String uInput;

		// This shuffles the player's deck.
		pDeck.shuffleDeck();

		// This sets the last 26 cards of the player's shuffled deck, to the first 26 cards of the computer's deck.
		for (int i = 26; i < 52; i++)
		{
			comDeck.takeCard(pDeck.getCard(i));
			pDeck.loseCard(i);
		}

		// Resets the current card to 0 in the player and computer's deck.
		pDeck.setCurrentCardIndex(0);
		comDeck.setCurrentCardIndex(0);


		uInput = "1";

		// Plays the following lines of code until it is breaked out of the loop.
		while (!uInput.equals("0"))
		{
			// If the users input is 1, it simulates a round of the card gae WAR.
			if (uInput.equals("1"))
			{
				// A prevention to any 'NullPointerExceptions' that occur.
				try
				{
					// Simulates a round of the card game WAR.
					gameControls.playTurn();
					// Prints the Computer's deck.
					System.out.println("\n\nComputer's Cards:\n" + comDeck.toString());
					
					// Prints the player's deck.
					System.out.println("\nPlayer's Cards:\n" + pDeck.toString());

					// Sets a pause between simulating each round.
					System.out.println("\n\n~~~Press ENTER to continue~~~");
					uInput = input.nextLine();
				}

				// Catches any 'NullPointerExceptions' made during the play of the game.
				catch(NullPointerException e)
				{
					gameControls.endWar();
					break;
				}
				
				// Checks if the game is over and breaks out of the loop if so.
				if (gameControls.isGameOver() == true)
				{
					break;
				}
			}

			// If the player inputs 2, it prints a list of commands.
			else if (uInput.equals("2"))
			{
				commandList();
				uInput = input.nextLine();
			}

			// If the player inputs 0, it exits the program.
			else if (uInput.equals("0"))
			{
				break;
			}

			// If the player doesn't enter anything, the program continues in the loop.
			else
			{
				uInput = "1";
			}
		}

		// Prints that the program has ended.
		System.out.println("\n\n\n~~~~~~~~~~~~~~~~~~~~\n Program Has Ended.\n~~~~~~~~~~~~~~~~~~~~");
	}


	// --------------------
	// Other Methods
	// --------------------

	// A method to print a list of commands in the console.
	public static void commandList()
	{
		System.out.println("0 - Exit Program\n1 - Draw next card\n2 - Help List\n\nIf you want to access the dev class, enter 0 and type \"java GameDevTester\"");
	}
	/*End of Class*/
}


/*
0 - Exit Program
1 - Draw next card
2 - Help List

If you want to access the dev class, enter 0 and type \"java GameDevTester\"

0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n
  CONGRATULATIONS!!! YOU WON!!!\n
0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0

0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n
 Better Luck Next Time, You LOST\n
0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0

*/


/*

CHANGELOG:
-----------
v1.0 ~ Initial creation of class

*/