package test.java;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.java.controller.GameController;
import main.java.controller.GameController.Event;
import main.java.view.ConsoleView;
import main.java.view.IView;

public class GameControllerTest {
	
	GameController sut;
	IView view;
	
	@Before
	public void setUp() throws Exception {
		// initialize SUT
		view = mock(ConsoleView.class);
		sut = new GameController(view);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldShowMenu() {
		// mocking so it terminates
		Mockito.when(view.getUserEvent()).thenReturn(Event.Quit);

		sut.play();
		verify(view).showMenu();
		
	}
	
	@Test
	public void shouldQuitProgram(){
		Mockito.when(view.getUserEvent()).thenReturn(Event.Quit);
		
		sut.play();
		
		// verify exactly called 1 time only
		verify(view, times(1)).showMenu();
		verify(view, times(1)).getUserEvent();
	}
	
}
