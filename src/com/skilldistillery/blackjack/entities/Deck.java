package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cardDeck;

	public Deck() {
		cardDeck = buildDeck();

	}
	private List<Card> buildDeck() {
		List<Card> deck = new ArrayList<>(52);
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
		for (int i = 0; i < suits.length; i++) {
			for(Rank rank : ranks) {
				Card card = new Card(suits[i], rank);
				deck.add(card);
			}
		}
		return deck;
	}
//public List<Card> getCardDeck() {
//		return cardDeck;
//	}
	//	private List<Card> buildDeck() {
//		List<Card> deck = new ArrayList<>(52);
//		Rank[] ranks = Rank.values();
//		Suit[] suits = Suit.values();
//
//		for (Suit suit : suits) {
//			for (Rank rank : ranks) {
//				Card card = new Card(suit, rank);
//				deck.add(card);
//			}
//
//		}
//		return deck;
//	}
//	private List<Card> buildDeck() {
//		List<Card> deck = new ArrayList<>(52);
//		for (Suit suit : Suit.values()) {
//			for (Rank rank : Rank.values()) {
//				Card card = new Card(suit, rank);
//				deck.add(card);
//			}
//
//		}
//		return deck;
//	}
	public int checkDeckSize() {
		return cardDeck.size();
	}

	public void shuffle() {
		Collections.shuffle(cardDeck);
	}

	public Card dealCard() {		
		Card dealtCard = cardDeck.remove(0);
		return dealtCard;
	}

}
