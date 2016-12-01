package test.java;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.Random;

import static org.mockito.Mockito.times;
import static org.junit.Assert.*;
import static org.mockito.Mockito.any;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.java.controller.GameController;
import main.java.controller.GameController.Event;
import main.java.model.Player;
import main.java.model.error.NotEnoughCreditsException;
import main.java.model.game.AbstractGameFactory;
import main.java.model.game.ConcreteGameFactoryA;
import main.java.model.game.PickANumberGame;
import main.java.view.ConsoleView;
import main.java.view.IView;

public class GameControllerTest {
	
	GameController sut;
	IView view;
	Player player;
	
	@Before
	public void setUp() throws Exception {
		// initialize SUT
		view = mock(ConsoleView.class);
		sut = new GameController(view, new ConcreteGameFactoryA());
		player = Mockito.mock(Player.class);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldShowMenu() throws IOException {
		// mocking so it terminates
		Mockito.when(view.getUserEvent()).thenReturn(Event.Quit);

		// run
		sut.play(player);
		
		// verify
		verify(view).showMenu();
		
	}
	
	@Test
	public void shouldQuitProgram() throws IOException{
		// initialize and mock
		Mockito.when(view.getUserEvent()).thenReturn(Event.Quit);

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
	public void shouldFailToGetUserChoice() throws IOException{
		// initialize system
		Mockito.when(view.getUserEvent()).thenReturn(Event.Reset).thenThrow(new IOException());
		
		// stub player return
		Mockito.when(view.registerPlayer()).thenReturn(new Player("Tester"));
		
		// run
		sut.play(null);
		
		// verify exactly 2 rounds cause variable is set quit when exception occours.
		verify(view, times(2)).showMenu();
		
	}
	
	@Test
	public void shouldResetCredits() throws IOException{
		Mockito.when(view.getUserEvent()).thenReturn(Event.Reset).thenReturn(Event.Quit);
		
		sut.play(player);
		
		// verify exactly called 2 time only
		verify(view, times(2)).showMenu();
		verify(view, times(2)).getUserEvent();
		verify(player).resetCredits();
	}
	
	@Test
	public void shouldChangeName() throws IOException{
		Mockito.when(view.getUserEvent()).thenReturn(Event.ChangeName).thenReturn(Event.Quit);
		Mockito.when(view.getName()).thenReturn("Tester");

		Mockito.when(player.getName()).thenReturn("Tester");
		
		player = sut.play(player);
		
		// verify exactly called 2 time only
		verify(view, times(2)).showMenu();
		verify(view, times(2)).getUserEvent();
		verify(view, times(1)).getName();
		verify(player).setName(any(String.class));
		assertEquals("Tester", player.getName());
	}
	
	@Test
	public void shouldFailReadNameAndGiveDullyName() throws IOException{
		Mockito.when(view.getUserEvent()).thenReturn(Event.ChangeName).thenReturn(Event.Quit);
		Mockito.when(view.getName()).thenThrow(new IOException());
		Mockito.when(player.getName()).thenReturn("InvalidInputExceptionName");
		
		player = sut.play(player);
		
		// verify exactly called 2 time only
		verify(view, times(2)).showMenu();
		verify(view, times(2)).getUserEvent();
		verify(view, times(1)).getName();
		verify(player).setName(any(String.class));
		assertEquals("InvalidInputExceptionName", player.getName());
	}
	
	@Test
	public void shouldShowHighscore() throws IOException{
		Mockito.when(view.getUserEvent()).thenReturn(Event.ViewHighscore).thenReturn(Event.Quit);
		Mockito.when(player.getHighscore()).thenReturn(Player.defaultCredits);
		
		player = sut.play(player);
		
		verify(view, times(1)).showHighScore(any(Integer.class));
		verify(player, times(1)).getHighscore();
		assertEquals(Player.defaultCredits, player.getHighscore());
	}
	
	@Test
	public void shouldPlayPickANumberGame() throws IOException, NotEnoughCreditsException{
		// mock View, Player, GameFactory and Game behaviour (dependent)
		Mockito.when(view.getUserEvent()).thenReturn(Event.PlayPickNumer).thenReturn(Event.Quit);
		Mockito.doNothing().when(view).showPickANumberGameRules();
		Mockito.doNothing().when(view).showResultPickANumberGame(any(Boolean.class), any(Integer.class));
		Mockito.when(view.getNumberBetween(any(Integer.class), any(Integer.class))).thenReturn(5);
		
		PickANumberGame game = Mockito.mock(PickANumberGame.class);
		Mockito.doNothing().when(game).play(any(Integer.class));
		Mockito.when(game.hasWon()).thenReturn(true);
		Mockito.when(game.getWinningNumber()).thenReturn(5);
		
		AbstractGameFactory gameFactory = Mockito.mock(ConcreteGameFactoryA.class);
		Mockito.when(gameFactory.getPickANumberGame(any(Player.class), any(Random.class))).thenReturn(game);
		
		Mockito.doNothing().when(player).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(player).increaseCredits(any(Integer.class));
		
		sut = new GameController(view, gameFactory);
		
		// run
		player = sut.play(player);
		
		// verify every call one time
		verify(view, times(1)).showPickANumberGameRules();
		verify(view, times(1)).showResultPickANumberGame(true, 5);
		verify(view, times(1)).getNumberBetween(any(Integer.class), any(Integer.class));
		verify(game, times(1)).play(5);
		verify(game, times(1)).getWinningNumber();
		verify(game, times(1)).hasWon();
	}

	
}
