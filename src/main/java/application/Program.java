package main.java.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBException;

import main.java.controller.GameController;
import main.java.view.ConsoleView;
import main.java.view.IView;

public class Program {

	public static void main(String[] args) {
		GameOfChance game = new GameOfChance();
		IView view = new ConsoleView(System.out, new BufferedReader(new InputStreamReader(System.in)));

		try {
			game.run(new GameController(view));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
