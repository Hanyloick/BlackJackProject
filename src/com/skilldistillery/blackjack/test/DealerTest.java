package com.skilldistillery.blackjack.test;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealerTest {
	public static void main(String[] args) {
		DealerTest dealerTest = new DealerTest();
		dealerTest.run();

	}

	public void run() {
		Deck deck = new Deck();
		System.out.println("There are " + deck.checkDeckSize() + " in this deck");
		System.out.println("how many cards do you want? ");
		Scanner scanner = new Scanner(System.in);
		deck.shuffle();
		int numOfCardsRequested = scanner.nextInt();
		scanner.nextLine();
		if (numOfCardsRequested < deck.checkDeckSize()) {
			int sumOfRank = 0;
			for (int i = 0; i < numOfCardsRequested; i++) {
				Card dealtCard = deck.dealCard();
				sumOfRank += dealtCard.getValue();
				System.out.println(
						"you now have " + dealtCard + " " + " rank value " + sumOfRank + " " + deck.checkDeckSize());
			}
		} else {
			System.out.println("not enough cards my guy");
		}

//		deck.getCardDeck();
		scanner.close();
	}
}
