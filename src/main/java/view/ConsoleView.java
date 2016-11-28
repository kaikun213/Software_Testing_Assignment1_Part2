package main.java.view;

import java.io.PrintStream;

import main.java.controller.GameController.Event;

public class ConsoleView implements IView{
	
	PrintStream out;
	
	public ConsoleView(){
		this.out = System.out;
	}
	
	public ConsoleView(PrintStream out){
		this.out = out;
	}

	public void showMenu() {
		out.println();
	}

	public Event getUserEvent() {
		return null;
	}

}
