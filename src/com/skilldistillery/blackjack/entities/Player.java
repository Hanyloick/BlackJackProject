package com.skilldistillery.blackjack.entities;

public class Player {
	protected Hand blackJackHand;
	
	public Player() {
		blackJackHand = new BlackJackHand();
	}

	public Hand getBlackJackHand() {
		return blackJackHand;
	}

	public void addCardToHand(Card card) {
		blackJackHand.addCard(card);
	}
	
	public void newHand() {
		this.blackJackHand = new BlackJackHand();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player's");
		if (blackJackHand != null) {
			builder.append(blackJackHand);
		}
		return builder.toString();
	}
	
	
	
}
