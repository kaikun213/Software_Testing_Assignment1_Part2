package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.java.model.Player;
import main.java.model.error.NotEnoughCreditsException;
import main.java.model.game.PickANumberGame;

public class PickANumberGameTest {
	
	Player playerMock;
	Random randMock;
	PickANumberGame sut;

	@Before
	public void setUp() throws Exception {
		playerMock = mock(Player.class);
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		randMock = mock(Random.class);
		sut = new PickANumberGame(playerMock, randMock);
	}

	@Test
	public void testPickANumberGameCreation() {
		sut = new PickANumberGame(playerMock, randMock);
	}

	@Test
	public void testPlay() throws NotEnoughCreditsException {
		when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		sut.play(PickANumberGame.MIN_NUMBER);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldFailGuessUnderMinimum() throws IndexOutOfBoundsException, NotEnoughCreditsException {
		sut.play(PickANumberGame.MIN_NUMBER-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldFailGuessOverMaximum() throws IndexOutOfBoundsException, NotEnoughCreditsException {
		sut.play(PickANumberGame.MAX_NUMBER+1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldFailGetWinningNumberWithoutPlay() throws IndexOutOfBoundsException {
		sut.getWinningNumber();
	}
	
	@Test(expected = NotEnoughCreditsException.class)
	public void shouldFailNotEnoughCreditsException() throws NotEnoughCreditsException{
		playerMock = Mockito.mock(Player.class);
		Mockito.doThrow(new NotEnoughCreditsException()).when(playerMock).decreaseCredits(any(Integer.class));
		sut = new PickANumberGame(playerMock, randMock);
		
		sut.play(PickANumberGame.MIN_NUMBER);
	}

	@Test
	public void testHasWon() throws NotEnoughCreditsException {
		when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		
		//run & verify
		sut.play(1+PickANumberGame.MIN_NUMBER);
		assertEquals(true, sut.hasWon());
		
		//run & verify
		sut.play(2+PickANumberGame.MIN_NUMBER);
		assertEquals(false, sut.hasWon());
	}

	@Test
	public void testGetWinningNumber() throws NotEnoughCreditsException {
		when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		
		//run & verify
		sut.play(1+ PickANumberGame.MIN_NUMBER);
		assertEquals(1 + PickANumberGame.MIN_NUMBER, sut.getWinningNumber());
	}

}
