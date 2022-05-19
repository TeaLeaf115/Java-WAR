// *********************************************************************
// Deck.java		Author: Owen Barnes			Version: 2.1 (5/15/22)
// 
// This class creates the structure of a standard playing card deck 
// with a scalable deck between 1 and 52 cards. The ability to take a 
// card from another deck, and the ability to shuffle the deck.
// 
// *********************************************************************


// --------------------
// Imorts
// --------------------
import java.util.ArrayList;


public class Deck
{

	// --------------------
	// PIV Declaration
	// --------------------

	private ArrayList<Card> deck;
	private String[] suitType = {"Hearts", "Clubs", "Diamonds", "Spades"}, cardValue = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	
	private int currentCardIndex;


	// --------------------
	// Constructors
	// --------------------

	public Deck()
	{
		currentCardIndex = 0;

		deck = new ArrayList<Card>();

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 13; j++)
			{
				deck.add(new Card(suitType[i], cardValue[j], j));
			}
		}

	}

	// Overloaded Constructor for making an empty deck
	public Deck(String EMPTY_DECK)
	{
		currentCardIndex = 0;
		
		deck = new ArrayList<Card>();
	}

  
	// --------------------
	// Main Modifying Methods
	// --------------------

	// public Card nextCard()
	// {
	// 	currentCardIndex++;

	// 	// Sets the current card to 0 if it is greater than or equal to the length of the size of the deck.
	// 	if (currentCardIndex >= deck.size())
	// 	{
	// 		currentCardIndex = 0;
	// 	}

	// 	// Returns the current card in the deck.
	// 	return deck.get(currentCardIndex);
	// }


	// Create a void eatCard method which will take the other player's card if they win the hand
	public void takeCard(Card oppCard)
	{
		// Adds the opponents card to the end of the deck.
		deck.add(oppCard);

		// Adds the first card in the deck to the end of the deck. ~ v2.1
		deck.add(deck.remove(0));
	}
	

	// A method that sets a card at the current index to null.
	public Card loseCard()
	{
		return deck.remove(0);
	}

	// An overloaded method that sets a card at a specific index to null.
	public void loseCard(int index)
	{
		if (index >= deck.size())
			index = deck.size()-1;
		deck.remove(index);
	}

	// Shuffles the deck in a random order.
	public void shuffleDeck()
	{
		for (int i = 0; i < deck.size(); i++)
		{
			// Chooses a random index between 0 and 52.
			int randIndex = (int)(Math.random() * 52);
			// Sets the current card to an empty card object.
			Card tempCard = deck.get(i);
			// Sets a random card from the deck to the empty spot in the deck.
			deck.set(i, deck.get(randIndex));
			// Sets the random index in the deck as the stored temporary card.
			deck.set(randIndex, tempCard);
		}
	}


	// --------------------
	// Getter's
	// --------------------

	// A getter method to return the current card in the deck.
	public Card getCard()
	{
		// Returns the current card of the deck.
		return deck.get(currentCardIndex);
	}

	// An overloaded getter method to return the current card in the deck at a specific index.
	public Card getCard(int index)
	{
		if (index >= deck.size())
			index = deck.size()-1;		
		// Returns the card at the specified index.
		return deck.get(index);
	}
	
	// A getter method to return the size of the deck.
	public int getDeckSize()
	{
		return deck.size();
	}

	public int getCurrentCardIndex()
	{
		return currentCardIndex;
	}
 

	// --------------------
	// Setters
	// --------------------

	// A setter method that sets the current card in the deck.
	public void setCurrentCardIndex(int currentCardIndex)
	{
		this.currentCardIndex = currentCardIndex;
	}


	// --------------------
	// toString Methods
	// --------------------

	// Prints the entire deck as separate card images.
	public void printDeckImg()
	{
		for (int i = 0; i < deck.size(); i++)
		{
			deck.get(i).printCard();
		}
	}


	// Prints the entire deck as separate words (aka 'Ace of Spades').
	public void printDeckVals()
	{
		for (int i = 0; i < deck.size(); i++)
		{
			System.out.print(deck.get(i) + ";  ");
		}
	}


	// Prints the current card in its standard form.
	public void printCard()
	{
		deck.get(currentCardIndex).printCard();
	}

	// Prints the current card in a war form.
	public void printWarCard()
	{
		deck.get(currentCardIndex).printWarCards();
	}

	// Returns all the non-null cards in the deck on a single line separated by a semicolon. ~ v1.1
	public String toString()
	{
		String returnString = "";

		// Loops through the entire deck.
		for (int i = 0; i < deck.size(); i++)
		{
			// Checks if the current card at 'i' is not null, and adds it to the variable 'returnString'.
			if (deck.get(i) != null)
			{
				returnString += deck.get(i) + ";  ";
			}
		}

		// Returns the variable 'returnString'.
		return returnString;
	}

	/*End of Class*/
}

/*

CHANGELOG:
-----------
v1.0 ~ Initial creation of class
v1.1 ~ Added a toString method that prints all the non-null cards in the deck.
v2.0 ~ Reworked the entire class to use ArrayLists instead of Arrays.
v2.1 ~ Minor Bug Fixes
*/