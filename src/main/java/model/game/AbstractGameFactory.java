package main.java.model.game;


import main.java.model.Player;

public abstract class AbstractGameFactory {
	
	protected AbstractGameFactory(){
		
	}
	
	public abstract IPickANumberGame getPickANumberGame(Player a_player);
	public abstract IDealerNoMatchGame getDealerNoMatchGame(Player a_player);

}
