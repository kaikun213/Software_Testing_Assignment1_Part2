package test.java;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import static org.mockito.Mockito.times;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.java.controller.GameController;
import main.java.controller.GameController.Event;
import main.java.model.Player;
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
	public void shouldShowMenu() throws IOException {
		// mocking so it terminates
		Mockito.when(view.getUserEvent()).thenReturn(Event.Quit);
		Player player = Mockito.mock(Player.class);

		// run
		sut.play(player);
		
		// verify
		verify(view).showMenu();
		
	}
	
	@Test
	public void shouldQuitProgram() throws IOException{
		// initialize and mock
		Mockito.when(view.getUserEvent()).thenReturn(Event.Quit);
		Player player = Mockito.mock(Player.class);

		//run
		sut.play(player);
		
		// verify exactly called 1 time only
		verify(view, times(1)).showMenu();
		verify(view, times(1)).getUserEvent();
	}
	
	@Test
	public void shouldTryToRegisterPlayer() throws IOException{
		// initialize system
		Mockito.when(view.getUserEvent()).thenReturn(Event.Quit);
		
		// stub player return
		Mockito.when(view.registerPlayer()).thenReturn(new Player("Tester"));
		
		// run
		sut.play(null);
		
		// verify
		verify(view).registerPlayer();
	}
	
	@Test
	public void shouldResetCredits() throws IOException{
		Mockito.when(view.getUserEvent()).thenReturn(Event.Reset).thenReturn(Event.Quit);
		Player player = Mockito.mock(Player.class);
		
		sut.play(player);
		
		// verify exactly called 2 time only
		verify(view, times(2)).showMenu();
		verify(view, times(2)).getUserEvent();
	}
	
}
