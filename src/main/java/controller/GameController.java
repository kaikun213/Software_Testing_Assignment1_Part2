package main.java.controller;

import main.java.dao.PlayerDAO;
import main.java.model.Player;
import main.java.view.IView;

public class GameController {
	
	public static enum Event {
			PlayPickNumer,
			PlayNoMatchDealer,
			PlayFindAce,
			ViewHighscore,
			ChangeName,
			Reset,
			Quit
	}
	
	Player m_player;
	IView m_view;
	Event userChoice;
	
	public GameController(IView a_view){
		this.m_view = a_view;
	}
	
	
	public void play(){
		// load or register new player
		m_player = PlayerDAO.jaxbXMLToObject();
		if (m_player == null) m_player = m_view.registerPlayer();
		
		// start gameplay
		do{
			m_view.showMenu();
			userChoice = m_view.getUserEvent();
//			if (userChoice == Event.Reset){
//				m_player.setCredits(Player.defaultCredits);
//			}

		}while(userChoice != Event.Quit);
		
		// save user data to file
		PlayerDAO.jaxbObjectToXML(m_player);
	}
	

}
