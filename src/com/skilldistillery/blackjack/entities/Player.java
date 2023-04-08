package com.skilldistillery.blackjack.entities;

public class Player {
	protected Hand blackJackHand;
	
	public Player() {
		blackJackHand = new BlackJackHand();
	}

	public Hand getBjHand() {
		return blackJackHand;
	}

	public void addCardToHand(Card card) {
		blackJackHand.addCard(card);
	}
	
	public void newHand() {
		blackJackHand = new BlackJackHand();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (blackJackHand != null) {
			builder.append(blackJackHand);
		}
		return builder.toString();
	}
	
	
	
}
