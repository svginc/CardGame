package test.com.game.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.game.cards.CardGame;
import com.game.cards.model.Card;
import com.game.cards.model.Deck;
import com.game.cards.model.Player;
import com.game.cards.model.Suit;
import com.game.cards.threecards.GameException;
import com.game.cards.threecards.ThreeCardGame;

/**
 * Test cases to check Game functionalilty
 * 
 * @author Prasad Konka
 *
 */
public class GameTest {

	/**
	 * Deal three cards to each player in sequence from a shuffled deck. Identify
	 * the winner Whoever has the high score wins the game. (color point
	 * calculation, red = 3, yellow =2, green = 1) the point is calculated by color
	 * point * number in the card.
	 */
	@DisplayName("Test Winner of three card game")
	@Test
	public void testWinnerOfThreeCardGame() throws GameException
	{
		//Create Deck
		Deck deck = new Deck();
		deck.shuffle();
		
		//Create game with the deck
		CardGame game = new ThreeCardGame(deck);
		
		//Add players
		List<Player> players = new ArrayList<Player>();
		Player player1 = new Player("John");
		Player player2 = new Player("Justin");
		players.add(player1);
		players.add(player2);
		
		//Deal cards to the players
		game.dealCards(players, 3);
		
		//Get the winner
		Player winner = game.getWinner(players);

		//Assert the winner
		int score1 = getPlayerScore(player1);
		int score2 = getPlayerScore(player2);
		
		if(score1 > score2)
			assertEquals(player1, winner);
		else
			assertEquals(player2, winner);
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
		return score;
	}
}
