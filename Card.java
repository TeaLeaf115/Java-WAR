// *********************************************************************
// Card.java		Author: Owen Barnes			Version: 1.1 (12/22/21)
// 
// This class creates the structure of a standard playing card with a
// suit, and value. It also adds a numerical value to the card for
// better comparison between cards in the game war.
// 
// *********************************************************************

public class Card
{
	// --------------------
	// PIV Declaration
	// --------------------

	protected String cardSuit, cardName;
	private int numValue;
	private CardImg img;


	// --------------------
	// Constructors
	// --------------------

	// Constructor setting the PIV's.
	public Card (String suit, String name, int val)
	{
		this.cardSuit = suit;
		this.cardName = name;
		this.numValue = val;
		img = new CardImg(this);
	}


	// --------------------
	// Getters
	// --------------------

	// Card suit getter
	public String getSuit()
	{
		return cardSuit;
	}

	// Card name getter
	public String getName()
	{
		return cardName;
	}

	// Card value getter
	public int getVal()
	{
		return numValue;
	}

	public String getImgLayer(int layerNum)
	{
		return img.getIMGVal(layerNum);
	}

	// Returns the card's drawn image from the CardImg Class. ~ v1.1
	public void printCard()
	{
		System.out.println(img);
	}

	// Returns the card's war image from the CardImg Class. ~ v1.1
	public void printWarCards()
	{
		System.out.println(img.getWarCards());
	}

	// Checks if a 2 Card objects are the same card. ~ v1.1
	public boolean equals(Card cCard)
	{
		// Checks if the suit and numerical value are the came from the comparing Card object. Returns true if so.
		if ((this.getSuit()).equals(cCard.getSuit()) && this.getVal() == cCard.getVal())
		{
			return true;
		}
		// Returns false if they are not equal.
		return false;
	}


	// --------------------
	// toString Methods
	// --------------------

	// toString Method
	public String toString()
	{
		return cardName + " of " + cardSuit;
	}
	
	/*End of Class*/
}

/*

CHANGELOG:
-----------
v1.0 ~ Initial creation of class
v1.1 ~ Added a link with the CardImg Class. Creating a image for this card.
		 ~ Added methods to print the image in the console.
		 ~ Added a .equals() method to compare different cards.

*/