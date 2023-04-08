package com.skilldistillery.blackjack.test;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealerTest {

	public static void main(String[] args) {
		DealerTest dealer = new DealerTest();
		dealer.run();
	}

	public void run() {
		Deck deck = new Deck();
		deck.shuffle();
		int numCardsInDeck = deck.checkDeckSize();
		System.out.println("Current num cards in deck " + numCardsInDeck);

		Scanner scanner = new Scanner(System.in);
		System.out.print("How many cards ");
		int numCardsIWant = scanner.nextInt();
		scanner.nextLine();
		if (numCardsIWant <= numCardsInDeck) {

			int sumOfCards = 0;
			for (int cardNumDealt = 0; cardNumDealt < numCardsIWant; cardNumDealt++) {
				Card dealtCard = deck.dealCard();

				sumOfCards += dealtCard.getValue();
				System.out.println("you now have: " + dealtCard + " sum of cards " + sumOfCards + " "
						+ deck.checkDeckSize() + " cards left");
			}

		} else {
			System.out.println("Go play somewhere else!");
		}

		scanner.close();
	}

}