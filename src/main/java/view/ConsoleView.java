package main.java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import main.java.controller.GameController.Event;
import main.java.model.Player;

public class ConsoleView implements IView{
	
	public final static String MENU = "\n\n-=[ Game of Chance MENU ]=-\n" +
									"1 - Play the pick a number game\n" +
									"2 - Play the No Match Dealer game\n" +
									"3 - Play the Find the Ace game\n" +
									"4 - View current high score\n" +
									"5 - Change your user Name\n" +
									"6 - Reset your account at 100 credits\n" +
									"7 - Quit\n";
	public final static String REGISTER = "-=-=-{ NEW PLAYER REGISTRATION }-=-=-\n" +
										"Enter your Name:";
	
	public final static String INVALID_CHOICE = "This is an invalid selection of choice";
	
	public final static String PickANumberGameRules = 	"\n###### Pick a Number ######\n"+
														"This game costs 10 credits to play. Simply pick a number\n"+
														"beetween 1 and 20, and if you pick the winning number, you\n"+
														"will win the jackpot of 100 credits!\n\n";
	public final static String PickANumberWinningStatement = "Congrats! You won the jackpot! And the winning number was : ";
	public final static String PickANumberLoosingStatement = "Ahh damn it! You lost! The winning number was : ";
	
	public final static String NotEnoughCreditsNotification = "You do not have enough credits to play! Sorry.";

	PrintStream out;
	BufferedReader in;
	
	public ConsoleView(PrintStream out,BufferedReader in){
		this.out = out;
		this.in = in;
	}

	public void showMenu() {
		out.println(MENU);
	}

	public Event getUserEvent() throws IOException{
		Event event = null;
		int choice = 0;

		while(event == null){
			choice = in.read();
			if (choice == '1') event = Event.PlayPickNumer;
			else if (choice == '2') event = Event.PlayNoMatchDealer;
			else if (choice == '3') event = Event.PlayFindAce;
			else if (choice == '4') event = Event.ViewHighscore;
			else if (choice == '5') event = Event.ChangeName;
			else if (choice == '6') event = Event.Reset;
			else if (choice == '7') event = Event.Quit;
			else out.println(INVALID_CHOICE);
		}
	
		return event;
	}

	public Player registerPlayer() {
		out.println(REGISTER);
		String name = "";
		try {
			name = getName();
		} catch (IOException e) {
			name = "InvalidInputExceptionName";	// If userinput fails give dully-name (requirements-definition)
		}
		out.println("Welcome to the Game of Chance" + name +"\n" +
					"You have been given"+ Player.defaultCredits +" credits.\n");
		return new Player(name);
	}
	
	public String getName() throws IOException{
		String name = in.readLine();
		return name;
	}

	public void showHighScore(int highscore) {
		out.println("\n===================| HIGHSCORE |====================\n" +
					"You currently have the high score of " + highscore +" credits!\n");
	}

	public void showPickANumberGameRules() {
		out.println(PickANumberGameRules);
	}

	public int getNumberBetween(int from, int until) throws IOException {
		out.println("Please enter an Integer-Number between: "+ from + " - " + until);
		int result = from -1;
		String readResult;
		do{
			try{
				readResult = in.readLine();
				if (readResult != null) {
					result = Integer.parseInt(readResult);
					if (result<from || result>until){
						out.println("The Number must be in the given constraints!");
						result = from-1;
					}
				}
			}
			catch(NumberFormatException e){
				out.println("This is not an valid Integer-Number");
				result = from-1;
			}
		}while(result<from);
		return result;
	}

	public void showResultPickANumberGame(boolean won, int winningNumber) {
		if (won) out.println(PickANumberWinningStatement + winningNumber);
		else out.println(PickANumberLoosingStatement + winningNumber);
	}

	public void showNotEnoughCredits() {
		// PickANumberGame.CREDIT_COST = amount it costs
		// TODO Auto-generated method stub
		out.println(NotEnoughCreditsNotification);
	}

	public void showCurrentState(String playerName, int playerCredits) {
		// TODO Auto-generated method stub
		out.println("Player Name: " + playerName + "\nCredits: " + playerCredits);
	}
	
	

}
