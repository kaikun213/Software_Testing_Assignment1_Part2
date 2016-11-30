package main.java.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import main.java.controller.GameController;
import main.java.dao.PlayerDAO;
import main.java.model.Player;
import main.java.view.ConsoleView;
import main.java.view.IView;

public class GameOfChance {

	public static void main(String[] args) {
		GameOfChance game = new GameOfChance();
		IView view = new ConsoleView(System.out, new BufferedReader(new InputStreamReader(System.in)));

		game.run(new GameController(view));
	}
	
	public Player load(){
		return PlayerDAO.jaxbXMLToObject();
	}
	
	public void save(Player a_player){
		PlayerDAO.jaxbObjectToXML(a_player);

	}
	
	public void run(GameController controller){
		// load player
		Player a_player = load();
		// play games
		a_player = controller.play(a_player);
		// save player
		save(a_player);
	}

}
