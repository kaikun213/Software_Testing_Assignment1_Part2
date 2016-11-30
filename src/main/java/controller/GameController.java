package main.java.controller;

import main.java.dao.PlayerDAO;
import main.java.model.Player;
import main.java.view.IView;

public class GameController {
	
	public static enum Event {
			Quit,
			Play
	}
	
	Player m_player;
	IView m_view;
	
	public GameController(IView a_view){
		this.m_view = a_view;
	}
	
	
	public void play(){
		m_player = PlayerDAO.jaxbXMLToObject();
		if (m_player == null) m_player = m_view.registerPlayer();
		
		m_view.showMenu();
		
		PlayerDAO.jaxbObjectToXML(m_player);
	}
	

}
