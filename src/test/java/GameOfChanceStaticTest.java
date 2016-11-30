package test.java;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
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
	public void shouldTryLoadPlayer() throws JAXBException{
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
	public void shouldTryToSavePlayer() throws JAXBException{
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
	
	@Test
	public void shouldFailAndReturnNullByLoadPlayer() throws JAXBException{
		// stub exception throwing of DAO class
		PowerMockito.mockStatic(PlayerDAO.class);
		Mockito.when(PlayerDAO.jaxbXMLToObject()).thenThrow(new JAXBException(""));
		
		// test that load method returns null
		assertNull(sut.load());
	}
	
	@Test(expected = JAXBException.class)
	public void shouldThrowExceptionWhenSaveFails() throws JAXBException{
		// stub exception throwing of DAO class
		PowerMockito.mockStatic(PlayerDAO.class);
		PowerMockito.doThrow(new JAXBException("")).when(PlayerDAO.class);
		PlayerDAO.jaxbObjectToXML(any(Player.class));
		
		// test that load method returns null
		sut.save(any(Player.class));
	}
	
	@Test
	public void shouldInvokeLoadPlayer() throws JAXBException{
		when(controller.play(any(Player.class))).thenReturn(new Player("OriginalTester"));
		doNothing().when(sut).save(any(Player.class));
		
		PowerMockito.mockStatic(PlayerDAO.class);
		Mockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(new Player("OriginalTester"));
		
		//run
		sut.run(controller);
		
		// verify
		verify(sut, times(1)).load();
	}
	
	@Test
	public void shouldInvokeSavePlayer() throws JAXBException{
		when(sut.load()).thenReturn(any(Player.class));
		when(controller.play(any(Player.class))).thenReturn(any(Player.class));
		
		PowerMockito.mockStatic(PlayerDAO.class);
		try {
			PowerMockito.doNothing().when(PlayerDAO.class, "jaxbObjectToXML", Mockito.any(Player.class));
		} catch (Exception e) {
			fail("The save Player to File method failed");
		}

		
		//run
		sut.run(controller);
		
		// verify
		verify(sut, times(1)).save(any(Player.class));
	}


}
