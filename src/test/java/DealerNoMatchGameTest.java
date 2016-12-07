package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;

import java.util.Random;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import main.java.model.IDealerNoMatchRandomNumbersObserver;
import main.java.model.Player;
import main.java.model.error.NotEnoughCreditsException;
import main.java.model.game.DealerNoMatchGame;
import main.java.model.game.IDealerNoMatchGame;

@RunWith(MockitoJUnitRunner.class)
public class DealerNoMatchGameTest {
	
	@Mock
	Player playerMock;
	@Mock
	Random randMock;
	@InjectMocks
	DealerNoMatchGame sut;


	@Test
	public void shouldLosePlayGame() throws NotEnoughCreditsException {
		Mockito.when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		
		Boolean actual = sut.play(50);
		
		assertFalse(actual);
		Mockito.verify(playerMock, times(1)).decreaseCredits(50);
	}
	
	@Test
	public void shouldNotifyObservers() throws NotEnoughCreditsException{
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		IDealerNoMatchRandomNumbersObserver observerMock = Mockito.mock(IDealerNoMatchRandomNumbersObserver.class);
		Mockito.doNothing().when(observerMock).randomNumberGenerated(any(Integer.class));
		sut.addSubscriber(observerMock);
		
		sut.play(50);
		
		Mockito.verify(observerMock, times(16)).randomNumberGenerated(any(Integer.class));
	}
	
	@Test
	public void shouldWinPlayGame() throws NotEnoughCreditsException{
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));

		Mockito.when(randMock.nextInt(any(Integer.class))).thenAnswer(new Answer<Integer>() {
		    private int count = 0;

		    public Integer answer(InvocationOnMock invocation) {
		        return count++;
		    }
		});	
		
		Boolean actual = sut.play(50);

		assertTrue(actual);
		Mockito.verify(playerMock, times(1)).increaseCredits(100);
	}
	
	@Test(expected = NotEnoughCreditsException.class)
	public void shouldThrowNotEnoughCreditsException() throws NotEnoughCreditsException {
		Mockito.doThrow(NotEnoughCreditsException.class).when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		Mockito.when(randMock.nextInt(any(Integer.class))).thenReturn(1);

		sut.play(200);
	}
	
	@Test
	public void shouldImplementInterface() throws NotEnoughCreditsException{
		IDealerNoMatchGame sutInterface = new DealerNoMatchGame(playerMock, randMock);
		
		Mockito.when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		sutInterface.play(50);
	}

}
