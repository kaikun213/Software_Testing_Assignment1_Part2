package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.controller.GameController;
import main.java.view.ConsoleView;
import main.java.view.IView;

public class GameControllerTest {
	
	GameController sut;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldShowMenu() {
		IView view = mock(ConsoleView.class);
		sut = new GameController(view);
		
		sut.play();
		
		verify(view).showMenu();
	}

}
