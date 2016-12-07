package main.java.model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.java.model.IDealerNoMatchRandomNumbersObserver;
import main.java.model.Player;

public class DealerNoMatchGame implements IDealerNoMatchGame {
	
	List<IDealerNoMatchRandomNumbersObserver> subscribers = new ArrayList<IDealerNoMatchRandomNumbersObserver>();
	Player m_player;
	Random rand;
	
	public DealerNoMatchGame(Player player, Random rand){
		this.m_player = player;
		this.rand = rand;
	}
	

	public boolean play() {
		return false;
	}

	public void addSubscriber(IDealerNoMatchRandomNumbersObserver observer) {
		subscribers.add(observer);		
	}

}
