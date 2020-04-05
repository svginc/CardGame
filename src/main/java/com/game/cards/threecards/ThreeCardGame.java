package com.game.cards.threecards;

import java.util.Collections;
import java.util.List;

import com.game.cards.CardGame;
import com.game.cards.model.Card;
import com.game.cards.model.Deck;
import com.game.cards.model.Player;
import com.game.cards.model.Suit;

/**
 * Each player gets three cards from the shuffled deck. Identify the winner
 * Whoever has the high score wins the game. (color point calculation, red = 3,
 * yellow =2, green = 1) the point is calculated by color point * number in the
 * card.
 * 
 * @author Prasad Konka
 *
 */
public class ThreeCardGame implements CardGame {

	private Deck deck;

	public ThreeCardGame(Deck deck) {
		this.deck = deck;
	}

	/**
	 * Deal cards to each player in sequence from a shuffled deck.
	 * 
	 * @param players
	 * @param numCards
	 *            number of cards for each player
	 * @return winner
	 * @throws GameException
	 */
	@Override
	public void dealCards(List<Player> players, int numCards) throws GameException {
		if (players == null || players.isEmpty())
			throw new GameException("No players");

		if (numCards <= 0)
			throw new GameException("Invalid number of cards");

		for (int i = 0; i < numCards; i++) {
			for (Player player : players)
				deck.dealCardToPlayer(player);
		}
	}

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
	@Override
	public Player getWinner(List<Player> players) throws GameException {
		// First iterate throw the players and make sure they have equal cards
		int cardsCount = players.get(0).getCards().size();
		int lastCardsCount = 0;
		for (Player player : players) {
			List<Card> cards = player.getCards();
			lastCardsCount = cards.size();
			if (cardsCount != lastCardsCount)
				throw new GameException("Invalid dealing of cards");
			player.setScore(getPlayerScore(player));
		}

		// Sort descending order. See Player.compareTo()
		Collections.sort(players);
		return players.get(0);
	}

	private int getPlayerScore(Player player) {
		int score = 0;
		for (Card card : player.getCards()) {
			if (card.getSuit().getSuitColor().equals(Suit.HEARTS.getSuitColor()))
				score = score + (3 * card.getCardValue().getCardValue());
			else if (card.getSuit().getSuitColor().equals(Suit.DIAMONDS.getSuitColor()))
				score = score + (2 * card.getCardValue().getCardValue());
			else if (card.getSuit().getSuitColor().equals(Suit.CLUBS.getSuitColor()))
				score = score + (1 * card.getCardValue().getCardValue());
		}
		//System.out.println("Payer " + player.getName() + " score is: " + score);
		return score;
	}

	/**
	 * public static void main(String[] args) { Deck deck = new Deck();
	 * deck.shuffle(); Game game = new ThreeCardGame(deck); Player player1 = new
	 * Player("John"); Player player2 = new Player("Justin"); Player player3 = new
	 * Player("Amber"); Player player4 = new Player("Bella"); List<Player> players =
	 * new ArrayList<Player>(); players.add(player1); players.add(player2);
	 * players.add(player3); players.add(player4);
	 * 
	 * Player winner; try { game.dealCards(players); winner =
	 * game.getWinner(players); System.out.println("Winner is: " +
	 * winner.getName()); System.out.println("Winner score is: " +
	 * winner.getScore()); } catch (DeckException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } }
	 */
}
