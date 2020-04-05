package com.game.cards.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player
 * 
 * @author Prasad Konka
 *
 */
public class Player implements Comparable<Player> {
	private String name;
	private int score;
	private List<Card> cards;

	/**
	 * Constructor
	 */
	public Player() {
	}

	/**
	 * Constructor
	 * 
	 * @param name player name
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * Get player name
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set player name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get cards
	 * 
	 * @return List of cards
	 */
	public List<Card> getCards() {
		if (cards == null)
			cards = new ArrayList<Card>();
		return cards;
	}

	/**
	 * Add multiple cards
	 * 
	 * @param cards
	 */
	public void addCards(List<Card> cards) {
		this.cards.addAll(cards);
	}

	/**
	 * Add card
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}

	/**
	 * Get score
	 * 
	 * @return int score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Set score
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Compare players for descending order
	 */
	public int compareTo(Player comparePlayer) {
		int compareScore = comparePlayer.getScore();
		// descending order
		return compareScore - this.score;
	}

}
