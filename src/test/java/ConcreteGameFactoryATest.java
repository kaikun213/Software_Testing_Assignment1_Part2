package test.java;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.any;


import main.java.model.Player;
import main.java.model.error.NotEnoughCreditsException;
import main.java.model.game.AbstractGameFactory;
import main.java.model.game.ConcreteGameFactoryA;
import main.java.model.game.IPickANumberGame;
import main.java.model.game.PickANumberGame;

public class ConcreteGameFactoryATest {

	@Test
	public void testPickANumberGameCreation() throws NotEnoughCreditsException {
		Player playerMock = Mockito.mock(Player.class);
		Random randomMock = Mockito.mock(Random.class);
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		Mockito.when(randomMock.nextInt(any(Integer.class))).thenReturn(PickANumberGame.MIN_NUMBER);
		IPickANumberGame expected = new PickANumberGame(playerMock, randomMock);
		AbstractGameFactory sut = new ConcreteGameFactoryA();
		IPickANumberGame actual = sut.getPickANumberGame(playerMock, randomMock);

		// test if behavior is the same
		expected.play(PickANumberGame.MIN_NUMBER);
		actual.play(PickANumberGame.MIN_NUMBER);
		
		assertEquals(expected.hasWon(), actual.hasWon());
	}

}
