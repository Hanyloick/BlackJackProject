package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
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
		while (on) {
			blackJackApp.displayMenu();
			on = blackJackApp.userChoice(sc);
		}

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
			scanner.nextLine();
			if (input < 1 || input > 2) {
				System.out.println("Out of Range, Try Again.");
			}
		} while (input < 1 || input > 2);
		switch (input) {
		case 1:
			startGame(scanner);
			scanner.nextLine();
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

	public void startGame(Scanner scanner) {
		player.addCardToHand(dealer.dealCard());
		System.out.println("players " + player);

		dealer.addCardToHand(dealer.dealCard());
		dealer.dealDisplay();

		player.addCardToHand(dealer.dealCard());
		System.out.println("players " + player);

		dealer.addCardToHand(dealer.dealCard());
		dealer.dealDisplay();

		checkForBlackJackOrBust(player, scanner);
		hitOrStand(scanner);
		checkForBlackJack(scanner);
	}

	// win conditions
	public void checkForBlackJackOrBust(Player player, Scanner scanner) {
		if ((player.getBjHand() instanceof BlackJackHand)) {
			if (((BlackJackHand) (player.getBjHand())).isBlackJack()) {
				System.out.println(player);
				System.out.println("Player wins with BlackJack!");
				playAgain(scanner);
			} else if (((BlackJackHand) (player.getBjHand())).isBust()) {
				System.out.println(player);
				System.out.println("Bust!");
				playAgain(scanner);
			}
		}
	}

	public void hitMenu() {
		System.out.println("|-----------------------------------|");
		System.out.println("|----Do you want to Hit or Stand?---|");
		System.out.println("|1.-----------Hit-------------------|");
		System.out.println("|2.----------Stand------------------|");
		System.out.println("|-----------------------------------|");
	}

	public void hitOrStand(Scanner scanner) {
		hitMenu();

		int input = 0;
		if ((player.getBjHand() instanceof BlackJackHand)) {
			if (((BlackJackHand) (player.getBjHand())).getHandValue() < 21) {
				do {
					input = getIntput(scanner);
					scanner.nextLine();
					if (input < 1 || input > 2) {
						System.out.println("Out of Range, Try Again.");
					}
				} while (input < 1 || input > 2);
				switch (input) {
				case 1:
					player.addCardToHand(dealer.dealCard());
					checkForBlackJackOrBust(player, scanner);
					break;
				case 2:
					dealerTurn();
					break;

				}
			}
		}
	}

	public void dealerTurn() {
		while (dealer.needsHit()) {
			dealer.addCardToHand(dealer.dealCard());
			System.out.println("dealer " + dealer);
		}
	}

	public void playAgain(Scanner scanner) {
		System.out.println("Play again 1-2");
		int input = 0;
		do {
			input = getIntput(scanner);
			if (input < 1 || input > 2) {
				System.out.println("Out of Range, Try Again.");
			}
		} while (input < 1 || input > 2);
		switch (input) {
		case 1:
			if (dealer.countDeck() > 8) {
				dealer.newHand();
				player.newHand();
				startGame(scanner);
			} else {
				dealer.newDeck();
				dealer.newHand();
				player.newHand();
			}
			scanner.nextLine();
			break;
		case 2:
			System.out.println("Thanks for playing! ");

		}
	}

	private void checkForBlackJack(Scanner scanner) {
		if ((dealer.getBjHand() instanceof BlackJackHand) && ((player.getBjHand() instanceof BlackJackHand))) {
			if (((BlackJackHand) (dealer.getBjHand())).isBlackJack()
					&& (((BlackJackHand) (player.getBjHand())).isBlackJack())) {

				System.out.println("It's a draw!");
				playAgain(scanner);
			}
		} else if ((((BlackJackHand) (player.getBjHand())).isBlackJack())) {

			System.out.println("You win BlackJack!");
			playAgain(scanner);
		} else if (((BlackJackHand) (dealer.getBjHand())).isBlackJack()) {

			System.out.println("The dealer wins BlackJack.");
			playAgain(scanner);

		}
	}
}
