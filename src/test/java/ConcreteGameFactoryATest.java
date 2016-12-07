package test.java;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.any;

import main.java.model.Player;
import main.java.model.error.NotEnoughCreditsException;
import main.java.model.game.AbstractGameFactory;
import main.java.model.game.ConcreteGameFactoryA;
import main.java.model.game.DealerNoMatchGame;
import main.java.model.game.IPickANumberGame;
import main.java.model.game.PickANumberGame;


@RunWith(PowerMockRunner.class)
@PrepareForTest({Player.class, DealerNoMatchGame.class, ConcreteGameFactoryA.class})
public class ConcreteGameFactoryATest {

	@Test
	public void testPickANumberGameCreation() throws NotEnoughCreditsException {
		// Alternative: Behavior test instead of verify with PowerMockito -> (not fully covered test)
		Player playerMock = Mockito.mock(Player.class);
		Random randomMock = Mockito.mock(Random.class);
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		Mockito.when(randomMock.nextInt(any(Integer.class))).thenReturn(PickANumberGame.MIN_NUMBER);
		IPickANumberGame expected = new PickANumberGame(playerMock, randomMock);
		AbstractGameFactory sut = new ConcreteGameFactoryA();
		IPickANumberGame actual = sut.getPickANumberGame(playerMock);

		// test if behavior is the same
		expected.play(PickANumberGame.MIN_NUMBER);
		actual.play(PickANumberGame.MIN_NUMBER);
		
		assertEquals(expected.hasWon(), actual.hasWon());
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
