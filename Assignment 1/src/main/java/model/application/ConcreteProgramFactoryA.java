package main.java.model.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import main.java.controller.GameController;
import main.java.model.game.ConcreteGameFactoryA;
import main.java.view.ConsoleView;
import main.java.view.IView;

public class ConcreteProgramFactoryA extends AbstractProgramFactory{
	
	public IView getAView(){
		return new ConsoleView(System.out, new BufferedReader(new InputStreamReader(System.in)));
	}
	
	public GameController getAController(IView view){
		return new GameController(view, new ConcreteGameFactoryA());
	}


}
