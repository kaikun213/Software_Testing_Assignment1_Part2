package main.java.model.game;

import main.java.model.IDealerNoMatchRandomNumbersObserver;

public interface IDealerNoMatchGame {
	
	public boolean play();
	public void addSubscriber(IDealerNoMatchRandomNumbersObserver observer);

}
