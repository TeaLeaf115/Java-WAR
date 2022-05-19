// *********************************************************************
// CardImg.java		Author: Owen Barnes			Version: 2.2 (5/17/22)
//
// This class takes in a Card object and creates an ASCII image
// based on those parameters, then returns the image for printing use.
// 
// *********************************************************************

// --------------------
// Imports
// --------------------
import java.util.HashMap;

public class CardImg
{
	// --------------------
	// Constants
	// --------------------
	private final HashMap<String, String> SUITS;

	
	// --------------------
	// PIV Declaration
	// --------------------

	// PIV's for functionality use.
	private String cardIMG, suitIMG, warCardIMG;
	
	// PIV's for image stitching purposes.
	private String nTop, nMid, nBot, wTop, wMid, wBot;


	// --------------------
	// Constructor
	// --------------------

	// Constructor setting the PIV's.
	public CardImg (Card card)
	{
		SUITS = new HashMap<>();
		
		// Adds the suits to the 'SUITS' HashMap
		SUITS.put(null, " ");
		SUITS.put("Spades", "♠");
		SUITS.put("Hearts", "♥");
		SUITS.put("Clubs", "♣");
		SUITS.put("Diamonds", "♦");

		
		suitIMG = SUITS.get(card.getSuit());
		cardIMG = makeRegCard(card.getName());
		warCardIMG = makeWarCard(card.getName());
		
	}


	// --------------------
	// Image Creation Methods
	// --------------------


	// Creates the art for a normal card draw.
	private String makeRegCard(String cardName)
	{
		String ln = "\n";
		// Special case for face cards. Fits the name to scale. ~ v1.1
		if (cardName.length() > 2)
		{
			cardName = cardName.substring(0,1);
		}

		// Special case for the number 10. Fits the card to scale.
		if (cardName.length() == 2)
		{
			nTop = toRedorBlack("		┌─────────┐") +ln+ toRedorBlack("		│" + cardName + "       │") +ln;
			nMid = toRedorBlack("		│         │") +ln+ toRedorBlack("		│    " + suitIMG + "    │") +ln+ toRedorBlack("		│         │") +ln;
			nBot = toRedorBlack("		│       " + cardName + "│") +ln+ toRedorBlack("		└─────────┘");
		}

		// Creates the normal card format.
		else
		{
			nTop = toRedorBlack("		┌─────────┐") +ln+ toRedorBlack("		│" + cardName + "        │") +ln;
			nMid = toRedorBlack("		│         │")  +ln+ toRedorBlack("		│    " + suitIMG + "    │") +ln+ toRedorBlack("		│         │") +ln;
			nBot = toRedorBlack("		│        " + cardName + "│") +ln+ toRedorBlack("		└─────────┘");
		}
		
		return nTop + nMid + nBot;
	}


	// Creates the art for a war.
	private String makeWarCard(String cardName)
	{
		String ln = "\n";
		
		// Special case for face cards. Fits the name to scale. ~ v1.1
		if (cardName.length() > 2)
		{
			cardName = cardName.substring(0,1);
		}
		

		// Special case for the number 10. Fits the card to scale.
		if (cardName.length() == 2) // ~ v2.2
		{
			wTop = toRedorBlack("		┌─┌─┌──┌─────────┐") +ln+ toRedorBlack("		│▒│▒│▒▒│" + cardName + "       │") +ln;
			wMid = toRedorBlack("		│▒│▒│▒▒│         │") +ln+ toRedorBlack("		│▒│▒│▒▒│    " + suitIMG + "    │") +ln+ toRedorBlack("		│▒│▒│▒▒│         │") +ln;
			wBot = toRedorBlack("		│▒│▒│▒▒│       " + cardName + "│") +ln+ toRedorBlack("		└─└─└──└─────────┘");
		}

		// Creates the war card format.
		else
		{
			wTop = toRedorBlack("		┌─┌─┌──┌─────────┐") +ln+ toRedorBlack("		│▒│▒│▒▒│" + cardName + "        │") +ln;
			wMid = toRedorBlack("		│▒│▒│▒▒│         │") +ln+ toRedorBlack("		│▒│▒│▒▒│    " + suitIMG + "    │") +ln+ toRedorBlack("		│▒│▒│▒▒│         │") +ln;
			wBot = toRedorBlack("		│▒│▒│▒▒│        " + cardName + "│") +ln+ toRedorBlack("		└─└─└──└─────────┘");
		}

		return wTop + wMid + wBot;
	}


	// --------------------
	// Color Methods
	// --------------------

	// Colors any string with a white background, and either making it black or red based on its suit, then makes the text bold. ~ v2.1
	public String toRedorBlack(String str)
	{
		// Escape Sequence keys
		
		// 1 makes the text bold
		// 47 makes the background of the text white
		// 30 makes the color of the text black
		// 31 makes the color of the text red
		
		if (suitIMG.equals("♠") || suitIMG.equals("♣"))
			return "\033[1;47;30m" + str + "\033[0m";
		return "\033[1;47;31m" + str + "\033[0m";
	}

	
	// --------------------
	// Getter Methods
	// --------------------
	public String getIMGVal(int layerVal)
	{
		if (layerVal == 0)
		{
			return nTop;
		}

		else if (layerVal == 1)
		{
			return nMid;
		}

		else if (layerVal == 2)
		{
			return nBot;
		}

		// Returns an error message when the wrong parameter is inputed. ~ v1.2
		else
		{

			System.out.println("Check your parameters to be either 0 - 2");
			return null;
		}
	}

	// --------------------
	// toString Methods
	// --------------------

	// Returns the Image of the card in war art.
	public String getWarCards()
	{
		return warCardIMG;
	}

	// Returns the Image of the card in a normal drawing.
	public String toString()
	{
		return cardIMG;
	}

	/*End of Class*/
}


// --------------------
// ASCII Art References
// --------------------

/*
# Two indents until it prints

# Fig. 1
		┌─────────┐\n
		│%%       │\n  # nTop endpoint
		│         │\n
		│    @    │\n
		│         │\n  # nMid endpoint
		│       $$│\n
		└─────────┘    # nBot endpoint

# Fig. 2
		┌─┌─┌──┌─────────┐\n
		│▒│▒│▒▒│%%       │\n  # wTop endpoint
		│▒│▒│▒▒│         │\n
		│▒│▒│▒▒│    @    │\n
		│▒│▒│▒▒│         │\n  # wMid endpoint
		│▒│▒│▒▒│       $$│\n
		└─└─└──└─────────┘    # wBot endpoint

# Unicode Symbols
	♠(U+2660) ♦(U+2666) ♥(U+2665) ♣(U+2663) ▒(U+2592) │(U+2502)
	─(U+2500) ┌(U+250C) ┐(U+2510) └(U+2514) ┘(U+2518)

# Other Symbol Codes
	% is replaced by the card number on the top section.
	$ is replaced by the card number on the bottom section.
	# is replaced by the suit unicode symbol.


	ASCII Image Art Credit for Fig. 1:
	(Partially reused in Fig. 2 but tweaked for my own needs)

	https://codereview.stackexchange.com/questions/82103/ascii-fication-of-playing-cards

*/

/*

CHANGELOG:
-----------
v1.0 ~ Initial Creation of Class
v1.1 ~ Fixed a bug that made face cards to appear incorrectly when printed in the console.
v1.2 ~ Added the ability to get different layers of the card prior the card being stitched together. 
	* Takes in the values 0-2 and returns the appropriate layer.
	* Added an Error message to occur when a wrong parameter is given.
v2.0 ~ Remade the entire class.
v2.1 ~ Added color features to the card images.
v2.2 ~ Fixed a color bug with the WAR version of a card with the value of 10.
*/