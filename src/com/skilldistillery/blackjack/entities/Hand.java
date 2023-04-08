package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cardsInHand=new ArrayList<>();
	
	public Hand() {
		List<Card> cardsInHand;
	}

	public List<Card> getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(List<Card> cardsInHand) {
		this.cardsInHand = cardsInHand;
	}

	public void checkHand() {
		for (Card card : cardsInHand) {
			System.out.println(card);
		}
	}

	public void addCard(Card card) {
		cardsInHand.add(card);
	}

	abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("hand: ").append(cardsInHand).append("");
		return builder.toString();
	
	}

}
