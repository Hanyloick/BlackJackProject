package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private Player player = new Player();
	private Dealer dealer = new Dealer();

	public static void main(String[] args) {
		BlackJackApp blackJackApp = new BlackJackApp();
		Scanner scanner = new Scanner(System.in);
		blackJackApp.run(scanner, blackJackApp);
	}

	public void run(Scanner sc, BlackJackApp blackJackApp) {

		boolean on = true;
		while(on) {
			blackJackApp.displayMenu();
			on = blackJackApp.userChoice(sc);
		}
		// dealer deals card to player
		// dealer deals card to dealer

		// dealer deals card to player
		// dealer deals card to dealer

		// ask the player hit or stand?

		// player adds up cards in hand to determine hit or stand
		// if user adds cards and are over 21 they bust otherwise

		// if player hits give another card
		// player adds up cards in hand to determine hit or stand
		// ask the player hit or stand?

		// if player stands no more cards.

		// Dealer must hit below 17 and stand above 17

		// if player is over 21 they bust and game over

	}

	public void displayMenu() {
		System.out.println("|-----------------------------------|");
		System.out.println("|-Would you like to play BlackJack?-|");
		System.out.println("|1.-----------YES-------------------|");
		System.out.println("|2.-----------=NO-------------------|");
		System.out.println("|-----------------------------------|");
	}

	public boolean userChoice(Scanner scanner) {
		int input = 0;
		do {
			input = getIntput(scanner);
			if (input < 1 || input > 2) {
				System.out.println("Out of Range, Try Again.");
			}
		} while (input < 1 || input > 2);
		switch (input) {
		case 1:
			startGame();
			break;
		case 2:
			return false;
		}
		return true;
	}
	
	public int getIntput(Scanner scanner) {
		int input = 0;
		try {
			input = scanner.nextInt();	
		} catch (Exception e) {
			System.err.println("invalid option");
		}
		return input;
	}

	public void startGame() {
		player.addCardToHand(dealer.dealCard());
		System.out.println("players " + player);

		dealer.addCardToHand(dealer.dealCard());
		dealer.dealDisplay();

		player.addCardToHand(dealer.dealCard());
		System.out.println("players " + player);

		dealer.addCardToHand(dealer.dealCard());
		dealer.dealDisplay();

	}
	
	

	// win conditions
	public Hand determineWinner() {
		if (player.getBjHand() instanceof BlackJackHand) {
			System.out.println(((BlackJackHand) (player.getBjHand())).getHandValue());
			return null;

		}
		return null;
	}
}