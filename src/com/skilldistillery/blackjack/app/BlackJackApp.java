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

	public void run(Scanner scanner, BlackJackApp blackJackApp) {
		boolean running = true;
		while (running) {
			blackJackApp.displayMenu();
			running = blackJackApp.userChoice(scanner);
		}
	}

	private boolean userChoice(Scanner scanner) {

		if (getValidInput(scanner) == 1) {
			playGame(scanner);
		}
		return false;
	}

	public void displayMenu() {
		System.out.println("|-----------------------------------|");
		System.out.println("|-Would you like to play BlackJack?-|");
		System.out.println("|1.----------YES(1)-----------------|");
		System.out.println("|2.-----------NO(2)-----------------|");
		System.out.println("|-----------------------------------|");
	}

	public void playGame(Scanner scanner) {
		boolean playing = true;
		while (playing) {
			playing = startGame(scanner);
		}

	}

	public boolean startGame(Scanner scanner) {

		setupGame();

		BlackJackHand dealerBlackJackHand = (((BlackJackHand) (dealer.getBlackJackHand())));
		BlackJackHand playerBlackJackHand = (((BlackJackHand) (player.getBlackJackHand())));

		boolean playerTurn = true;
		while (playerTurn ) {
			playerTurn = runPlayerTurn(playerBlackJackHand, scanner);
		}

		if (!playerBlackJackHand.isBust()) {
			if (dealerBlackJackHand.isBlackJack()) {
				System.out.println("Dealer BlackJack!");
				System.out.println("Dealer's " + dealer);
				return determinePlayAgain(scanner);
			}
			while (!playerTurn && !dealerBlackJackHand.isBlackJack()) {
				playerTurn = runDealerTurn(dealerBlackJackHand);
			}
		}

		determineWinner(playerBlackJackHand, dealerBlackJackHand);
		displayMenu();
		return determinePlayAgain(scanner);
	}

	private void determineWinner(BlackJackHand playerBlackJackHand, BlackJackHand dealerBlackJackHand) {

		if (playerBlackJackHand.getHandValue() == dealerBlackJackHand.getHandValue()) {
			System.out.println("Draw!");
			System.out.println("Dealer's " + dealer);
			System.out.println("Player's " + player);
		} else if (((playerBlackJackHand.getHandValue() > dealerBlackJackHand.getHandValue())
				&& !playerBlackJackHand.isBust()) || dealerBlackJackHand.isBust()) {
			System.out.println("You Win!");

		} else {
			System.out.println("Dealer Wins!");

		}
	}

	public boolean determinePlayAgain(Scanner scanner) {
		return getValidInput(scanner) == 1;
	}

	private boolean runDealerTurn(BlackJackHand dealerBlackJackHand) {
		System.out.println("Dealer's " + dealer);
		if (dealerBlackJackHand.isBlackJack()) {
			System.out.println("BlackJack");
			return true;
		} else if (dealerBlackJackHand.isBust()) {
			System.out.println("Dealer Bust!");
			return true;
		} else if (dealer.needsHit()) {
			dealer.addCardToHand(dealer.dealCard());
			return false;
		}
		return true;
	}

	private boolean runPlayerTurn(BlackJackHand playerBlackJackHand, Scanner scanner) {
		System.out.println("Player's " + player);
		if (playerBlackJackHand.isBlackJack()) {
			System.out.println("Player BlackJack");
			return false;
		} else if (playerBlackJackHand.isBust()) {
			System.out.println("Bust!");
			return false;
		}

		hitMenu();

		if (getValidInput(scanner) == 1) {
			player.addCardToHand(dealer.dealCard());
			return true;
		} else {
			return false;
		}

	}

	public void hitMenu() {
		System.out.println("|-----------------------------------|");
		System.out.println("|----Do you want to Hit or Stand?---|");
		System.out.println("|1.----------Hit(1)-----------------|");
		System.out.println("|2.---------Stand(2)----------------|");
		System.out.println("|-----------------------------------|");
	}


	private void setupGame() {

		if (dealer.countDeck() <= 8) {
			dealer.newDeck();
		}
		player.newHand();
		dealer.newHand();

		player.addCardToHand(dealer.dealCard());
		System.out.println("players " + player);
		System.out.println(" ");
		dealer.addCardToHand(dealer.dealCard());
		dealer.dealDisplay();
		System.out.println(" ");
		player.addCardToHand(dealer.dealCard());
		System.out.println("players " + player);
		System.out.println(" ");
		dealer.addCardToHand(dealer.dealCard());
		dealer.dealDisplay();
	}

	private int getValidInput(Scanner scanner) {
		int input = 0;
		do {
			input = getIntput(scanner);
			if (input < 1 || input > 2) {
				System.out.println("Out of Range, Try Again.");
			}
		} while (input < 1 || input > 2);
		return input;
	}

	private int getIntput(Scanner scanner) {
		int input = 0;
		try {
			input = scanner.nextInt();
		} catch (Exception e) {
			System.err.println("invalid option");
		}
		return input;
	}

}
