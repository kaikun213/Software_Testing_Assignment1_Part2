package main.java.model.game;

import java.util.Random;

import main.java.model.Player;

public class ConcreteGameFactoryA extends AbstractGameFactory{
	
	public IPickANumberGame getPickANumberGame(Player a_player){
		return new PickANumberGame(a_player, new Random());
	}

	@Override
	public IDealerNoMatchGame getDealerNoMatchGame(Player a_player) {
		return new DealerNoMatchGame(a_player, new Random());
	}

}
