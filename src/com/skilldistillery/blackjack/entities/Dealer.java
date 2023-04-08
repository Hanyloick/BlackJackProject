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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer [");
		if (cardDeck != null) {
			builder.append("cardDeck=");
			builder.append(cardDeck);
		}
		builder.append("]");
		return builder.toString();
	}
}