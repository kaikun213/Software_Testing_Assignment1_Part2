package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import main.java.application.GameOfChance;
import main.java.controller.GameController;
import main.java.dao.PlayerDAO;
import main.java.model.Player;

@RunWith(MockitoJUnitRunner.class)
public class GameOfChanceTest {
	
	@Spy
	GameOfChance sut = new GameOfChance();;

	@Before
	public void setUp() throws Exception {
		 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void shouldPlayGameController(){
		// initialize
		when(sut.load()).thenReturn(new Player("Tester"));
		doNothing().when(sut).save(any(Player.class));
		GameController controller = mock(GameController.class);
		when(controller.play(any(Player.class))).thenReturn(any(Player.class));
		//run
		sut.run(controller);
		
		// verify
		verify(controller, times(1)).play(any(Player.class));
	}


}
