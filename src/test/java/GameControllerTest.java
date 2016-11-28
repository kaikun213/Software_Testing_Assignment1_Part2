package test.java;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import main.java.controller.GameController;
import main.java.dao.PlayerDAO;
import main.java.model.Player;
import main.java.view.ConsoleView;
import main.java.view.IView;


@PrepareForTest({PlayerDAO.class})
@RunWith(PowerMockRunner.class)
public class GameControllerTest {
	
	GameController sut;
	IView view;

	@Test
	public void shouldShowMenu() {
		IView view = mock(ConsoleView.class);
		sut = new GameController(view);
		sut.play();
		verify(view).showMenu();
	}
	
	
	@Test 
	public void shouldTryLoadPlayer(){
		IView view = mock(ConsoleView.class);
		sut = new GameController(view);
		
		PowerMockito.mockStatic(PlayerDAO.class);
		PowerMockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(new Player("OriginalTester"));
		
		sut.play();
		
		PowerMockito.verifyStatic(times(1));
		PlayerDAO.jaxbXMLToObject();
		//PowerMockito.when(PlayerDAO.jaxbXMLToObject()).thenReturn(new Player("OriginalTester"));

	}
	
}
