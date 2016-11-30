package main.java.view;

import java.io.PrintStream;

import main.java.controller.GameController.Event;
import main.java.model.Player;

public class ConsoleView implements IView{
	
	PrintStream out;
	
	public ConsoleView(){
		this.out = System.out;	// set default PrintStream
	}
	
	public ConsoleView(PrintStream out){
		this.out = out;
	}

	public void showMenu() {
		out.println("-=[ Game of Chance MENU ]=-\n" +
					"1 - Play the pick a number game\n" +
					"2 - Play the No Match Dealer game\n" +
					"3 - Play the Find the Ace game\n" +
					"4 - View current high score\n" +
					"5 - Change your user Name\n" +
					"6 - Reset your account at 100 credits\n" +
					"7 - Quit\n");
	}

	public Event getUserEvent() {
		return null;
	}

	public Player registerPlayer() {
		return null;
	}

}
