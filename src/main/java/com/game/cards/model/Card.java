package com.game.cards.model;

/**
 * Represents a card. A card has a value and it is part of a suit
 * 
 * @author Prasad Konka
 *
 */
public class Card {
	private Suit suit;
	private CardValue cardValue;

	public Card(CardValue cardValue, Suit suit) {
		this.cardValue = cardValue;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public CardValue getCardValue() {
		return cardValue;
	}

	public void setCardValue(CardValue cardValue) {
		this.cardValue = cardValue;
	}

	/**
	 * Compare cards by its color and then value
	 * @param c1 Card
	 * @param c2 Card
	 * @return int
	 */
	public static int compareByColorThenValue(Card c1, Card c2) {
		if (c1.suit.getSuitColor().equals(c2.suit.getSuitColor())) {
			return c1.cardValue.getCardValue() - c2.cardValue.getCardValue();
		} else {
			return c1.suit.getSuitColor().compareTo(c2.suit.getSuitColor());
		}
	}

	/**
	 * Compare cards by its value
	 * @param c1 Card
	 * @param c2 Card
	 * @return int
	 */
	public static int compareByValue(Card c1, Card c2) {
		if (c1.suit.getSuitColor().equals(c2.suit.getSuitColor()))
			return c1.cardValue.getCardValue() - c2.cardValue.getCardValue();
		else
			return 0;
	}

}