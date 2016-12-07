package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;

import java.io.BufferedReader;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import main.java.controller.GameController;
import main.java.model.application.AbstractProgramFactory;
import main.java.model.application.ConcreteProgramFactoryA;
import main.java.model.game.ConcreteGameFactoryA;
import main.java.view.ConsoleView;
import main.java.view.IView;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ConsoleView.class, IView.class, GameController.class, ConcreteProgramFactoryA.class})
public class ConcreteProgramFactoryATest {
	
	AbstractProgramFactory sut;
	
	@Test
	public void testViewCreation() throws Exception {
		sut = new ConcreteProgramFactoryA();
		ConsoleView viewMock = Mockito.mock(ConsoleView.class);
		PowerMockito.whenNew(ConsoleView.class).withAnyArguments().thenReturn(viewMock);
		
		//run
		IView actual = sut.getAView();
		
		//verify
		if (!(actual instanceof ConsoleView)){
			fail("Did not create a ConsoleView in ProgamFactoryA");
		}
		PowerMockito.verifyNew(ConsoleView.class).withArguments(any(PrintStream.class), any(BufferedReader.class));
	}
	
	@Test
	public void testControllerCreation() throws Exception {
		sut = new ConcreteProgramFactoryA();
		IView viewMock = Mockito.mock(ConsoleView.class);
		GameController controllerMock = Mockito.mock(GameController.class);
		PowerMockito.whenNew(GameController.class).withAnyArguments().thenReturn(controllerMock);

		//run
		sut.getAController(viewMock);
		
		// verify
		//assertEquals(controllerMock, actual);
		PowerMockito.verifyNew(GameController.class).withArguments(any(viewMock.getClass()), any(ConcreteGameFactoryA.class));
	}

}
