package main.java.model.game;

import java.util.Random;

import main.java.model.Player;

public abstract class AbstractGameFactory {
	
	protected AbstractGameFactory(){
		
	}
	
	public abstract IPickANumberGame getPickANumberGame(Player a_player, Random rand);

}
