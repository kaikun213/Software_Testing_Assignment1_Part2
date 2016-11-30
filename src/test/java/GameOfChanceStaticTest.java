package test.java;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import main.java.application.GameOfChance;
import main.java.controller.GameController;
import main.java.dao.PlayerDAO;
import main.java.model.Player;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PlayerDAO.class})
public class GameOfChanceStaticTest {
	
	@Mock
	GameController controller;
	@InjectMocks
	GameOfChance sut;
	
	@Test 
	public void shouldTryLoadPlayer(){
		when(controller.play(any(Player.class))).thenReturn(new Player("Tester"));
		sut = new GameOfChance();

		
		// stub static method
		PowerMockito.mockStatic(PlayerDAO.class);
		Mockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(new Player("OriginalTester"));
		try {
			PowerMockito.doNothing().when(PlayerDAO.class, "jaxbObjectToXML", Mockito.any(Player.class));
		} catch (Exception e) {
			fail("The save Player to File method failed");
		}
		
		//Run
		sut.run(controller);
		
		//Verify static call
		PowerMockito.verifyStatic(times(1));
		PlayerDAO.jaxbXMLToObject();
	}
	
	@Test
	public void shouldTryToSavePlayer(){
		// initialize system
		when(controller.play(any(Player.class))).thenReturn(new Player("Tester"));
		sut = new GameOfChance();

		
		// stub static method
		PowerMockito.mockStatic(PlayerDAO.class);
		try {
			PowerMockito.doNothing().when(PlayerDAO.class, "jaxbObjectToXML", Mockito.any(Player.class));
		} catch (Exception e) {
			fail("The save Player to File method failed");
		}
		Mockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(new Player("OriginalTester"));

		
		//Run
		sut.run(controller);
		
		//Verify static call
		PowerMockito.verifyStatic(times(1));
		PlayerDAO.jaxbObjectToXML(Mockito.any(Player.class));
	}
	
	

}
