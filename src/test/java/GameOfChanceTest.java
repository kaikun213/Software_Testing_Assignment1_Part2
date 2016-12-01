package test.java;

import static org.mockito.Mockito.when;

import javax.xml.bind.JAXBException;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import main.java.application.GameOfChance;
import main.java.controller.GameController;
import main.java.model.Player;

@RunWith(MockitoJUnitRunner.class)
public class GameOfChanceTest {
	
	@Spy
	GameOfChance sut = new GameOfChance();;
	
	@Test
	public void shouldPlayGameController() throws JAXBException{
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
	
	@Test
	public void shouldInvokeLoadPlayerInRun() throws JAXBException{
		// mock load, play and save method calls
		GameController controller = mock(GameController.class);
		when(controller.play(any(Player.class))).thenReturn(new Player("Tester"));
		doNothing().when(sut).save(any(Player.class));
		when(sut.load()).thenReturn(any(Player.class));

		
		
		//run
		sut.run(controller);
		
		// verify
		verify(sut, times(1)).load();
	}
	
	@Test
	public void shouldInvokeSavePlayerInRun() throws JAXBException{
		// mock load, play and save method calls
		GameController controller = mock(GameController.class);
		when(controller.play(any(Player.class))).thenReturn(new Player("Tester"));
		doNothing().when(sut).save(any(Player.class));
		when(sut.load()).thenReturn(any(Player.class));
	
		//run
		sut.run(controller);
		
		// verify
		verify(sut, times(1)).save(any(Player.class));
	}
	


}
