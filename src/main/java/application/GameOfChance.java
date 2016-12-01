package main.java.application;

import javax.xml.bind.JAXBException;

import main.java.controller.GameController;
import main.java.dao.PlayerDAO;
import main.java.model.Player;


public class GameOfChance {
	
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
