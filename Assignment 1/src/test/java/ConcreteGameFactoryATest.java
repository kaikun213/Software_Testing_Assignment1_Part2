package test.java;


import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.any;

import main.java.model.Player;
import main.java.model.game.AbstractGameFactory;
import main.java.model.game.ConcreteGameFactoryA;
import main.java.model.game.DealerNoMatchGame;
import main.java.model.game.PickANumberGame;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Player.class, DealerNoMatchGame.class, ConcreteGameFactoryA.class})
public class ConcreteGameFactoryATest {

	@Test
	public void testPickANumberGameCreation() throws Exception {
		AbstractGameFactory sut = new ConcreteGameFactoryA();
		Player playerMock = Mockito.mock(Player.class);
		PickANumberGame gameMock = Mockito.mock(PickANumberGame.class);
		PowerMockito.whenNew(PickANumberGame.class).withAnyArguments().thenReturn(gameMock);
		
		sut.getPickANumberGame(playerMock);
		
		PowerMockito.verifyNew(PickANumberGame.class).withArguments(any(playerMock.getClass()), any(Random.class));
	}
	
	@Test
	public void testNoMatchDealerGameCreation() throws Exception{
		// Powermockito test creation
		AbstractGameFactory sut = new ConcreteGameFactoryA();
		Player playerMock = Mockito.mock(Player.class);
		DealerNoMatchGame gameMock = Mockito.mock(DealerNoMatchGame.class);
		PowerMockito.whenNew(DealerNoMatchGame.class).withAnyArguments().thenReturn(gameMock);
		
		sut.getDealerNoMatchGame(playerMock);
		
		PowerMockito.verifyNew(DealerNoMatchGame.class).withArguments(any(playerMock.getClass()), any(Random.class));

	}

}
