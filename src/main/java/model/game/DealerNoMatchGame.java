package main.java.model.game;

import java.util.ArrayList;
import java.util.BitSet;
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
		boolean result = true;
		BitSet bits = new BitSet(100);
		int nextNumber;
		
		for (int i=0; i<16; i++){
			nextNumber = rand.nextInt(100);
			if (bits.get(nextNumber)) result = false;
			else bits.set(nextNumber);
			
			for (IDealerNoMatchRandomNumbersObserver s : subscribers){
				s.randomNumberGenerated(nextNumber);
			}
		}
		
		return result;
	}

	public void addSubscriber(IDealerNoMatchRandomNumbersObserver observer) {
		subscribers.add(observer);		
	}

}
