package test.com.game.cards;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.game.cards.model.Card;
import com.game.cards.model.Deck;
import com.game.cards.model.Suit;
import com.game.cards.threecards.GameException;

/**
 * Test cases to test Deck functionality
 * @author Prasad Konka
 *
 */
public class DeckTest {

	/**
	 * Get deck of cards, shuffle them and compare initial deck with shuffled deck
	 */
	@DisplayName("Test deck shuffling")
	@Test
	public void testDeckShuffle()
	{
		//Create Deck
		Deck deck = new Deck();
		
		//Keep copy of cards
		List<Card> cards = new ArrayList<Card>();
		cards.addAll(deck.getCards());
		
		//Shuffle cards
		deck.shuffle();
		
		//Assert pre shuffle cards size equals to shuffled cards
		List<Card> shuffledCards = deck.getCards();
		assertEquals(cards.size(), shuffledCards.size());
		
		//Assert pre shuffle cards are not equals to shuffled cards
		assertNotEquals(cards, shuffledCards);
	}
	
	/**
	 * Get shuffled cards from the deck, 
	 * draw card from top of the deck and assert it is from top the deck 
	 * Test throw an Exception if there are no more cards in the deck
	 */
	@DisplayName("Test Get Top card from the deck")
	@Test
	public void testGetCardFromTopOfDeck() throws GameException
	{
		//Create a deck
		final Deck deck = new Deck();
		deck.shuffle();
		//Get shuffled cards
		List<Card> shuffledCards = new ArrayList<Card>();
		shuffledCards.addAll(deck.getCards());
		
		//Get top card from the deck
		//Assert it is equal to the card from the shuffled card list
		for(Card shuffledCard : shuffledCards)
		{
			Card topCard = deck.getTopCard();
			assertEquals(topCard, shuffledCard);
		}

		//Assert exception for end of the deck
		assertThrows(GameException.class, () -> {
			    deck.getTopCard();
			  });

	}

	@DisplayName("Test Color sorting of the deck")
	@Test
	public void testColorSort() throws GameException
	{
		//Create a deck and get shuffled cards
		Deck deck = new Deck();
		deck.shuffle(); 
		List<Card> shuffledCards = new ArrayList<Card>();
		shuffledCards.addAll(deck.getCards());
		
		//Create suit colors to sort
		List<String> colors = new ArrayList<String>();
		colors.add(Suit.CLUBS.getSuitColor());
		colors.add(Suit.DIAMONDS.getSuitColor());
		colors.add(Suit.HEARTS.getSuitColor());
		
		//Sort the deck by the colors given
		deck.sortByColor(colors);
		
		//Get sorted cards
		List<Card> sortedCards = deck.getCards();
		
		//Assert shuffled cards are not equal to sorted cards
		assertNotEquals(shuffledCards, sortedCards);
		assertEquals(sortedCards.size(), shuffledCards.size());
		
		//Assert each given color represents in the sorted deck with the same sequences it is given
		//Assert each color card groups are in sorted ascending 
		for(String suitColor : colors) 
		{
			boolean found = false;
			int count = 0;
			int value = 1;
			//Assert each color has 13 cards
			for(Card card : sortedCards)
			{
				if(card.getSuit().getSuitColor().equals(suitColor))
				{
					found = true;
					count++;
					assertTrue(value < card.getCardValue().getCardValue(), "Cards should be ascending sort order");
					value = card.getCardValue().getCardValue();
				}
			}
			if(!found)
				assertTrue(found, "Color "+suitColor + " not found");
			else
				assertEquals(count, 13);
		}
	}
	
	
}
