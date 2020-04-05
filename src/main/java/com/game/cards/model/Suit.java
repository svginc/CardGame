package com.game.cards.model;

/**
 * Represents a Suit. Each suit has a designated color associated
 * 
 * @author Prasad Konka
 *
 */
public enum Suit {
	HEARTS("RED"), SPADES("BLACK"), CLUBS("GREEN"), DIAMONDS("YELLOW");

	private String suitColor;

	private Suit(String suitColor) {
		this.suitColor = suitColor;
	}

	public String getSuitColor() {
		return suitColor;
	}

}