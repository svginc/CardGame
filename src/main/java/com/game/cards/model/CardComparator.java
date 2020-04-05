package com.game.cards.model;

import java.util.Comparator;

/**
 * Compare cards by the given color argument
 * 
 * @author Prasad Konka
 *
 */
public class CardComparator implements Comparator<Card> {
	private static String compareBy;

	public CardComparator(String color) {
		this.compareBy = color;
	}

	/**
	 * Compare by given color argument. Result is cards sorted by given color argument to be on the top of the list
	 */
	public int compare(Card c1, Card c2) {
		if (compareBy.equals(c1.getSuit().getSuitColor()))
			return -1;
		else if (compareBy.equals(c2.getSuit().getSuitColor()))
			return 1;
		else
			return 0;

	}
}