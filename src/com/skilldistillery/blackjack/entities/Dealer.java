package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Dealer extends Player {

	private Deck cardDeck = new Deck();

	public Dealer() {
		super();
		shuffle();

	}

	public Card dealCard() {
		Card dealtCard = cardDeck.dealCard();
		return dealtCard;
	}

	public void shuffle() {
		cardDeck.shuffle();
	}
	
	public void dealDisplay() {
		List<Card> dealerCards = blackJackHand.getCardsInHand();

		System.out.print("Dealer's hand: [First card face down");
		for (int i = 1; i < dealerCards.size(); i++) {
			System.out.print(", " + dealerCards.get(i));
		}
		System.out.println("]");
	}
	
	public Deck newDeck() {
		cardDeck = new Deck();
		shuffle();
		return cardDeck;
	}
	
	public int countDeck() {
		return this.cardDeck.checkDeckSize();
	}
	
	public boolean needsHit() {
		if (blackJackHand.getHandValue() < 17) {
			return true;
		}
		return false;

	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (blackJackHand != null) {
			builder.append(blackJackHand);
		}
		builder.append("]");
		return builder.toString();
	}
}