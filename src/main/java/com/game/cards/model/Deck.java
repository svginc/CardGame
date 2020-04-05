package com.game.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.game.cards.threecards.GameException;

/**
 * A deck is a collection of 52 cards with 4 suits and each suit with 13 cards
 * 
 * @author Prasad Konka
 *
 */
public class Deck {

	private List<Card> cards;

	/**
	 * Initialize Deck with 4 suits and 13 cards for each suit
	 */
	public Deck() {
		int numSuits = Suit.values().length;
		int numCards = CardValue.values().length;

		this.cards = new ArrayList<Card>();
		for (int i = 0; i < numCards; i++) {
			CardValue value = CardValue.values()[i];

			for (int j = 0; j < numSuits; j++) {
				Card card = new Card(value, Suit.values()[j]);
				this.cards.add(card);
			}
		}
	}

	/**
	 * Get cards of the deck
	 * 
	 * @return List of cards
	 */
	public List<Card> getCards() {
		// showDeck();
		return cards;
	}

	/**
	 * Shuffle the cards
	 */
	public void shuffle() {
		Collections.shuffle(cards);
		// showDeck();
	}

	/**
	 * Get top card on the deck
	 * 
	 * @return Card
	 * @throws GameException
	 *             if the deck is empty
	 */
	public Card getTopCard() throws GameException {
		if (cards.size() == 0)
			throw new GameException("No more cards left. Empty Deck!");

		return cards.remove(0);
	}

	/**
	 * Deal top card from the deck to the player given
	 * 
	 * @param player
	 * @throws GameException
	 *             if the deck is empty
	 */
	public void dealCardToPlayer(Player player) throws GameException {
		if (player == null)
			player = new Player();
		player.getCards().add(getTopCard());
	}

	/**
	 * Sort the cards by the same order of list of colors given
	 * @param colors
	 */
	public void sortByColor(List<String> colors) {
		String[] colorsArray = colors.toArray(new String[0]);
		int length = colorsArray.length;
		//Sort in reverse so that the last sorted color is at the top
		for (int i = length - 1; i >= 0; i--)
			Collections.sort(cards, new CardComparator(colorsArray[i]));

		//Sort color sorted cards by their value
		cards.sort(Card::compareByValue);
	}

	/**
	 * Display deck
	 */
	public void showDeck() {
		Iterator<Card> cardIterator = cards.iterator();
		while (cardIterator.hasNext()) {
			Card aCard = cardIterator.next();
			System.out.println(
					aCard.getCardValue() + " of " + aCard.getSuit() + " of Color " + aCard.getSuit().getSuitColor());
		}
	}
}