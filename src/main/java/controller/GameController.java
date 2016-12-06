package main.java.controller;

import java.io.IOException;
import java.util.Random;

import main.java.model.Player;
import main.java.model.error.NotEnoughCreditsException;
import main.java.model.game.AbstractGameFactory;
import main.java.model.game.IPickANumberGame;
import main.java.model.game.PickANumberGame;
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
	AbstractGameFactory games;
	
	public GameController(IView a_view, AbstractGameFactory games){
		this.m_view = a_view;
		this.games = games;
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
				userChoice = Event.Quit;	// IO-Exception = Quit Application (Requirement)
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
				IPickANumberGame game = games.getPickANumberGame(m_player, new Random());
				m_view.showPickANumberGameRules();
				int guess;
				try {
					guess = m_view.getNumberBetween(PickANumberGame.MIN_NUMBER, PickANumberGame.MAX_NUMBER);
					try {
						game.play(guess);
						m_view.showResultPickANumberGame(game.hasWon(), game.getWinningNumber());
					} catch (NotEnoughCreditsException e) {
						m_view.showNotEnoughCredits();
					}
				} catch (IOException e1) {
					userChoice = Event.Quit;	// IO-Exception = Quit Application (Requirement)
				}
			}

		}while(userChoice != Event.Quit);
		
		return m_player;
	}
	
	

}
