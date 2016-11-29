package test.java;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import main.java.controller.GameController;

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
		sut.play();
		verify(view).showMenu();
	}
	
}
