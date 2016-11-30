package test.java;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import main.java.controller.GameController;
import main.java.dao.PlayerDAO;
import main.java.model.Player;
import main.java.view.ConsoleView;
import main.java.view.IView;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PlayerDAO.class})
public class GameControllerStaticTest {
	
	GameController sut;
	IView view;
	
	@Test 
	public void shouldTryLoadPlayer(){
		// initialize system
		IView view = mock(ConsoleView.class);
		sut = new GameController(view);
		
		// stub static method
		PowerMockito.mockStatic(PlayerDAO.class);
		Mockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(new Player("OriginalTester"));
		
		//Run
		sut.play();
		
		//Verify static call
		PowerMockito.verifyStatic(times(1));
		PlayerDAO.jaxbXMLToObject();
	}
	
	@Test
	public void shouldTryToRegisterPlayer(){
		// initialize system
		IView view = mock(ConsoleView.class);
		sut = new GameController(view);
		
		// stub static method
		PowerMockito.mockStatic(PlayerDAO.class);
		Mockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(null);
		
		//Run
		sut.play();
		
		//Verify static call
		PowerMockito.verifyStatic(times(1));
		PlayerDAO.jaxbXMLToObject();
		
		verify(view).registerPlayer();
	}
	
	@Test
	public void shouldTryToSavePlayer(){
		// initialize system
		IView view = mock(ConsoleView.class);
		sut = new GameController(view);
		
		// stub static method
		PowerMockito.mockStatic(PlayerDAO.class);
		try {
			PowerMockito.doNothing().when(PlayerDAO.class, "jaxbObjectToXML", Mockito.any(Player.class));
		} catch (Exception e) {
			fail("The save Player to File method failed");
		}
		
		//Run
		sut.play();
		
		//Verify static call
		PowerMockito.verifyStatic(times(1));
		PlayerDAO.jaxbObjectToXML(Mockito.any(Player.class));
	}
	
	

}
