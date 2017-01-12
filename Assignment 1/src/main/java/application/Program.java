package main.java.application;

import javax.xml.bind.JAXBException;

import main.java.model.application.AbstractProgramFactory;
import main.java.model.application.ConcreteProgramFactoryA;

import main.java.view.IView;

public class Program {

	public static void main(String[] args) {
		// manual testing
		GameOfChance game = new GameOfChance();
		AbstractProgramFactory factory = new ConcreteProgramFactoryA();
		
		// factory dependent
		try {
			IView view = factory.getAView();
			game.run(factory.getAController(view));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
