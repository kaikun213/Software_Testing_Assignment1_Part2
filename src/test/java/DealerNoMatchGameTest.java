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
import main.java.model.game.DealerNoMatchGame;

@RunWith(MockitoJUnitRunner.class)
public class DealerNoMatchGameTest {
	
	@Mock
	Player playerMock;
	@Mock
	Random randMock;
	@InjectMocks
	DealerNoMatchGame sut;


	@Test
	public void shouldLosePlayGame() {
		Mockito.when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		
		Boolean actual = sut.play();
		
		assertFalse(actual);
	}
	
	@Test
	public void shouldNotifyObservers(){
		IDealerNoMatchRandomNumbersObserver observerMock = Mockito.mock(IDealerNoMatchRandomNumbersObserver.class);
		Mockito.doNothing().when(observerMock).randomNumberGenerated(any(Integer.class));
		sut.addSubscriber(observerMock);
		
		sut.play();
		
		Mockito.verify(observerMock, times(16)).randomNumberGenerated(any(Integer.class));
	}
	
	@Test
	public void shouldWinPlayGame(){
		Mockito.when(randMock.nextInt(any(Integer.class))).thenAnswer(new Answer<Integer>() {
		    private int count = 0;

		    public Integer answer(InvocationOnMock invocation) {
		        return count++;
		    }
		});	
		
		Boolean actual = sut.play();

		assertTrue(actual);
	}

}
