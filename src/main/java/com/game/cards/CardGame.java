package com.game.cards;

import java.util.List;

import com.game.cards.model.Player;
import com.game.cards.threecards.GameException;

/**
 * Interface representing card game
 * @author Prasad Konka
 *
 */
public interface CardGame {

	/**
	 * Deal cards to each player in sequence from a shuffled deck.
	 * 
	 * @param players
	 * @param numCards
	 *            number of cards for each player
	 * @return winner
	 * @throws GameException
	 */
	public void dealCards(List<Player> players, int numCards) throws GameException;

	/**
	 * Identify the winner Whoever has the high score wins the game. (color point
	 * calculation, red = 3, yellow =2, green = 1) the point is calculated by color
	 * point * number in the card.
	 * 
	 * @param players
	 * @param numCards
	 *            number of cards for each player
	 * @return winner
	 * @throws GameException
	 */	
	public Player getWinner(List<Player> players) throws GameException;
}
