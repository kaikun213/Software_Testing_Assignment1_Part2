package main.java.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBException;

import main.java.controller.GameController;
import main.java.dao.PlayerDAO;
import main.java.model.Player;
import main.java.view.ConsoleView;
import main.java.view.IView;

public class GameOfChance {

	public static void main(String[] args) {
		GameOfChance game = new GameOfChance();
		IView view = new ConsoleView(System.out, new BufferedReader(new InputStreamReader(System.in)));

		try {
			game.run(new GameController(view));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public Player load(){
		try {
			return PlayerDAO.jaxbXMLToObject();
		} catch (JAXBException e) {
			return null;
		}
	}
	
	public void save(Player a_player) throws JAXBException{
			PlayerDAO.jaxbObjectToXML(a_player);

	}
	
	public void run(GameController controller) throws JAXBException{
		// load player
		Player a_player = load();
		// play games
		a_player = controller.play(a_player);
		// save player
		save(a_player);
	}

}
