package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import main.java.model.PickANumberGame;
import main.java.model.Player;

public class PickANumberGameTest {
	
	@Mock
	Player playerMock;
	@Mock
	Random randMock;
	@InjectMocks
	PickANumberGame sut;

	@Before
	public void setUp() throws Exception {
		randMock = mock(Random.class);
		sut = new PickANumberGame(playerMock, randMock);
	}

	@Test
	public void testPickANumberGameCreation() {
		sut = new PickANumberGame(playerMock, randMock);
	}

	@Test
	public void testPlay() {
		when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		sut.play(1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldFailGuessUnderMinimum() throws IndexOutOfBoundsException {
		sut.play(PickANumberGame.MIN_NUMBER-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldFailGuessOverMaximum() throws IndexOutOfBoundsException {
		sut.play(PickANumberGame.MAX_NUMBER+1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldFailGetWinningNumberWithoutPlay() throws IndexOutOfBoundsException {
		sut.getWinningNumber();
	}

	@Test
	public void testHasWon() {
		when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		
		//run & verify
		sut.play(1+PickANumberGame.MIN_NUMBER);
		assertEquals(true, sut.hasWon());
		
		//run & verify
		sut.play(2+PickANumberGame.MIN_NUMBER);
		assertEquals(false, sut.hasWon());
	}

	@Test
	public void testGetWinningNumber() {
		when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		
		//run & verify
		sut.play(1+ PickANumberGame.MIN_NUMBER);
		assertEquals(1 + PickANumberGame.MIN_NUMBER, sut.getWinningNumber());
	}

}
