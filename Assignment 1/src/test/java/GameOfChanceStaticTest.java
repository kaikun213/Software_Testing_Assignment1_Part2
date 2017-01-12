package test.java;

import static org.mockito.Mockito.times;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import javax.xml.bind.JAXBException;

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
@PrepareForTest(value = {PlayerDAO.class, GameOfChance.class})
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
	public void shouldInvokeStaticLoadMethod() throws JAXBException{
		
		// stub static method
		PowerMockito.mockStatic(PlayerDAO.class);
		try {
			PowerMockito.doNothing().when(PlayerDAO.class, "jaxbObjectToXML", Mockito.any(Player.class));
		} catch (Exception e) {
			fail("The save Player to File method failed");
		}
		Mockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(new Player("OriginalTester"));
		
		Player tester = sut.load();
		
		//Verify static call
		assertEquals(tester.getName(), "OriginalTester");
		PowerMockito.verifyStatic(times(1));
		PlayerDAO.jaxbXMLToObject();
	}
	
	@Test
	public void shouldInvokeStaticSaveMethod() throws JAXBException{
		
		// stub static method
		PowerMockito.mockStatic(PlayerDAO.class);
		Mockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(new Player("OriginalTester"));
		try {
			PowerMockito.doNothing().when(PlayerDAO.class, "jaxbObjectToXML", Mockito.any(Player.class));
		} catch (Exception e) {
			fail("The save Player to File method failed");
		}
		
		sut.save(new Player("Tester"));
		
		//Verify static call
		PowerMockito.verifyStatic(times(1));
		PlayerDAO.jaxbObjectToXML(Mockito.any(Player.class));
	}


}
