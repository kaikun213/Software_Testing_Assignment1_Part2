package main.java.model.application;

import main.java.controller.GameController;
import main.java.view.IView;

public abstract class AbstractProgramFactory {
	
	protected AbstractProgramFactory(){}
	
	public abstract IView getAView();
	public abstract GameController getAController(IView view);
}
