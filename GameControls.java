// *********************************************************************
// GameControls.java	Author: Owen Barnes		Version: 1.0 (1/21/22)
// 
// This class creates methods for running the card game "WAR", it
// allows any file using these methods to simulate a turn in the game, 
// check who wins that round, and check if the game is over. 
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

public class GameControls
{

	// --------------------
	// PIV Declaration
	// --------------------
	
	private Deck humanDeck, computerDeck, warHolderDeck;

	// Creates a scanner object.
	static Scanner input = new Scanner(System.in);


	// --------------------
	// Constructor
	// --------------------
	
	public GameControls(Deck humanDeck, Deck computerDeck)
	{
		this.humanDeck = humanDeck;
		this.computerDeck = computerDeck;
		warHolderDeck = new Deck("emptyDeck");
	}


	// --------------------
	// Main Modifying Methods
	// --------------------

	// Simulates a turn in the game.
	public void playTurn()
	{
		
		while (humanDeck.getCard().getVal() == computerDeck.getCard().getVal())
		{
			System.out.println("Computer's Card:\n");
			computerDeck.printCard();

			System.out.println("\n\nYour Card:\n");
			humanDeck.printCard();
			
			boolean end = WAR();

			if (end)
			{
				return;
			}
			// System.out.println("Computer's Card:\n");
			// computerDeck.printCard();

			// System.out.println("\n\nYour Card:\n");
			// humanDeck.printCard();
			// if (humanDeck.getDeckSize() < 4 && lessThan)
		}
	
		// This runs if both cards don't have the same value and prints the according image.
		// else
		// {
			// Prints the computer's card.
			System.out.println("Computer's Card:\n");
			computerDeck.printCard();

			// Prints the player's card.
			System.out.println("\n\nYour Card:\n");
			humanDeck.printCard();

			// Leads to the 'WinCheck' method to see who has won the round.
			WinCheck();
		// }
	}


	// This checks which deck pulled the highest value card.
	// This method uses the Boolean Wrapper class to set a value to null that is unreached.
	public Boolean WinCheck()
	{
		// Checks if the player's hand has won the round.
		if (humanDeck.getCard().getVal() > computerDeck.getCard().getVal())
		{
			playerWin();
			return true;
		}

		// Checks if the computer's hand has won the round.
		else if (humanDeck.getCard().getVal() < computerDeck.getCard().getVal())
		{
			comWin();
			return false;
		}
		return null;
	}


	// Marks that the computer has won that round.
	public void comWin()
	{
		// Takes the card from the player and inserts it into the computer's deck.
		computerDeck.takeCard(humanDeck.loseCard());
		// Sets the player's current card to null.


		System.out.println("Computer Wins!");
		// input.nextLine();
	}


	// Marks that the player has won that round.
	public void playerWin()
	{
		// Takes the card from the computer and inserts it into the player's deck.
		humanDeck.takeCard(computerDeck.loseCard());
		// Sets the computer's current card to null.
		

		System.out.println("Player Wins WAR!");
		// input.nextLine();
	}

	// This is the placeholder war method.
	public boolean WAR()
	{	
		if (humanDeck.getDeckSize() <= 4 || computerDeck.getDeckSize() <= 4)
		{
			endWar();
			return true;
		}
		// This prints a print line that prints an introduction to a war.
		System.out.println("\n\nTHIS IS WAR!!!!!");
		input.nextLine();
		System.out.println("I");
		input.nextLine();
		System.out.println("DE-");
		input.nextLine();
		System.out.println("-CLAR");
		input.nextLine();
		System.out.println("WAR!!!!!");
		input.nextLine();

		for (int i = 0; i < 4; i++)
		{
			try
			{
			warHolderDeck.takeCard(humanDeck.getCard());
			warHolderDeck.takeCard(computerDeck.getCard());

			humanDeck.loseCard();
			computerDeck.loseCard();
			}

			catch(IndexOutOfBoundsException e)
			{
				break;
			}
		}
		
		// This prints the war version of the cards to signify that a war is occuring.
		System.out.println("\nComputer's Card:\n");
		computerDeck.printWarCard();
		
		System.out.println("\n\nYour Card:\n");
		humanDeck.printWarCard();

		boolean isPlayerWin = WinCheck();

		System.out.println();
		
		if (isPlayerWin)
		{
			System.out.println("You got: " + warHolderDeck.toString() + "\n");
			System.out.println(humanDeck.toString() + "\n");
			System.out.println(computerDeck.toString());
		}
		else
		{
			System.out.println("The Computer got: " + warHolderDeck.toString() + "\n");
			System.out.println(humanDeck.toString() + "\n");
			System.out.println(computerDeck.toString());
		}

		// Takes the cards from the 
		do
		{
			if (isPlayerWin)
			{
				
				humanDeck.takeCard(warHolderDeck.getCard());
				warHolderDeck.loseCard();
			}
			else
			{
				computerDeck.takeCard(warHolderDeck.getCard());
				warHolderDeck.loseCard();
			}
		} while (warHolderDeck.getDeckSize() != 0);
		return false;
	}


	// Check to see if the game is over.
	public boolean isGameOver()
	{
		// Prints that the player has won.
		if (humanDeck.getDeckSize() == 52)
		{
			System.out.println("0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n CONGRATULATIONS!!! YOU WON!!!\n0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0");
			return true;
		}

		// Prints that the computer has won.
		else if (computerDeck.getDeckSize() == 52)
		{
			System.out.println("0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n Better Luck Next Time, You LOST\n0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0");
			return true;
		}

		return false;
	}

	public void endWar()
	{
		// Prints that the player has won.
		if (humanDeck.getDeckSize() > computerDeck.getDeckSize())
		{
			System.out.println("0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n CONGRATULATIONS!!! YOU WON!!!\n0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0");
		}

		// Prints that the computer has won.
		else if (computerDeck.getDeckSize() > humanDeck.getDeckSize())
		{
			System.out.println("0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0\n Better Luck Next Time, You LOST\n0~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~0");
		}
		return;
		
	}
	
	/*End of Class*/
}

/*

CHANGELOG:
-----------
v1.0 ~ Initial creation of class

*/



// --------------------
// Unused Methods
// --------------------
// These methods are going to be used at a later time.