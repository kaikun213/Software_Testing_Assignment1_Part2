package main.java.controller;

import java.io.IOException;

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
			try {
			userChoice = m_view.getUserEvent();
			} catch (IOException e) {
				userChoice = Event.Quit;
			}
			
			if (userChoice == Event.Reset){
				m_player.resetCredits();
			}
			
			if (userChoice == Event.ChangeName){
				String name;
				try {
					name = m_view.getName();
				} catch (IOException e) {
					name = "InvalidInputExceptionName";	// If userinput fails give dully-name (requirements-definition)
				}
				m_player.setName(name);
			}
			
			if (userChoice == Event.ViewHighscore){
				m_view.showHighScore(m_player.getHighscore());
			}
			
			if (userChoice == Event.PlayPickNumer){
				m_view.showPickANumberGameRules();
			}

		}while(userChoice != Event.Quit);
		
		return m_player;
	}
	
	

}
