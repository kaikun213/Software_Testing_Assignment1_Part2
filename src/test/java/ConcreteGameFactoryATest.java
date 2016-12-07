package test.java;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.mockito.Mockito;

import main.java.model.Player;
import main.java.model.game.AbstractGameFactory;
import main.java.model.game.ConcreteGameFactoryA;
import main.java.model.game.IPickANumberGame;
import main.java.model.game.PickANumberGame;

public class ConcreteGameFactoryATest {

	@Test
	public void testPickANumberGameCreation() {
		Player playerMock = Mockito.mock(Player.class);
		Random randomMock = Mockito.mock(Random.class);
		
		IPickANumberGame expected = new PickANumberGame(playerMock, randomMock);
		
		AbstractGameFactory sut = new ConcreteGameFactoryA();
		
		IPickANumberGame actual = sut.getPickANumberGame(playerMock, randomMock);
		
		assertEquals(expected., actual);
	}

}
