package main.java.model.game;

import java.util.Random;

import main.java.model.Player;

public class ConcreteGameFactoryA extends AbstractGameFactory{
	
	public IPickANumberGame getPickANumberGame(Player a_player, Random rand){
		return new PickANumberGame(a_player, rand);
	}

}
