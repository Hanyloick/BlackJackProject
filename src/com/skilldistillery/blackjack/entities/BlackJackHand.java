package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {
	
	public BlackJackHand() {
		super();
	}

	public boolean isBlackJack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;

	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;

	}
	


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackJackHand [");
		if (cardsInHand != null) {
			builder.append("Current Hand=");
			builder.append(cardsInHand);
			builder.append(", ");
		}
		builder.append("Hand total=");
		builder.append(getHandValue());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int getHandValue() {
		int value = 0;
		for (Card card : cardsInHand) {
			value += card.getValue();
		}
		return value;

	}

}

//	private boolean isHard() {
//		
//	}
//	private boolean isSoft() {
//		
//	}