package main.java.controller;

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
	
	public Player play(Player a_player){
		if (a_player == null) m_player = m_view.registerPlayer();
		else m_player = a_player;

		// start gameplay
		do{
			m_view.showMenu();
			userChoice = m_view.getUserEvent();
			
//			if (userChoice == Event.Reset){
//				m_player.resetCredits();
//			}

		}while(userChoice != Event.Quit);
		
		return m_player;
	}
	
	

}
