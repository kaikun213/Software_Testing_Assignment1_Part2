package main.java.view;

import java.io.PrintStream;

import main.java.controller.GameController.Event;

public class ConsoleView implements IView{
	
	PrintStream printStream;
	
	public ConsoleView(){
		this.printStream = System.out;
	}
	
	public ConsoleView(PrintStream printStream){
		this.printStream = printStream;
	}

	public void showMenu() {
	}

	public Event getUserEvent() {
		return null;
	}

}
