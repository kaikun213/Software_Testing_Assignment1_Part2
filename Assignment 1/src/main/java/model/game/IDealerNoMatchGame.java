package main.java.model.game;

import main.java.model.IDealerNoMatchRandomNumbersObserver;
import main.java.model.error.NotEnoughCreditsException;

public interface IDealerNoMatchGame {
	
	public boolean play(int wager) throws NotEnoughCreditsException;
	public void addSubscriber(IDealerNoMatchRandomNumbersObserver observer);

}
