package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

import java.util.Random;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import main.java.model.IDealerNoMatchRandomNumbersObserver;
import main.java.model.Player;
import main.java.model.error.NotEnoughCreditsException;
import main.java.model.game.DealerNoMatchGame;
import main.java.model.game.IDealerNoMatchGame;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DealerNoMatchGame.class)
public class DealerNoMatchGameTest {
	
	@Mock
	Player playerMock;
	@Mock
	Random randMock;
	@InjectMocks
	DealerNoMatchGame sut = PowerMockito.spy(new DealerNoMatchGame(playerMock, randMock));


	@Test
	public void shouldLosePlayGame() throws Exception {
		Mockito.when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		PowerMockito.doNothing().when(sut, method(DealerNoMatchGame.class, "delay", Integer.class)).withArguments(any(Integer.class));
		Boolean actual = sut.play(50);
		
		assertFalse(actual);
		Mockito.verify(playerMock, times(1)).decreaseCredits(50);
		PowerMockito.verifyPrivate(DealerNoMatchGame.class);
	}
	
	@Test
	public void shouldNotifyObservers() throws Exception{
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		IDealerNoMatchRandomNumbersObserver observerMock = Mockito.mock(IDealerNoMatchRandomNumbersObserver.class);
		Mockito.doNothing().when(observerMock).randomNumberGenerated(any(Integer.class));
		PowerMockito.doNothing().when(sut, method(DealerNoMatchGame.class, "delay", Integer.class)).withArguments(any(Integer.class));
		sut.addSubscriber(observerMock);
		
		sut.play(50);
		
		Mockito.verify(observerMock, times(16)).randomNumberGenerated(any(Integer.class));
	}
	
	@Test
	public void shouldWinPlayGame() throws Exception{
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		PowerMockito.doNothing().when(sut, method(DealerNoMatchGame.class, "delay", Integer.class)).withArguments(any(Integer.class));

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
	public void shouldThrowNotEnoughCreditsException() throws Exception {
		Mockito.doThrow(NotEnoughCreditsException.class).when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		Mockito.when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		PowerMockito.doNothing().when(sut, method(DealerNoMatchGame.class, "delay", Integer.class)).withArguments(any(Integer.class));

		sut.play(200);
	}
	
	@Test
	public void shouldImplementInterfaceAndSuccesullDelay() throws Exception{
		IDealerNoMatchGame sutInterface = new DealerNoMatchGame(playerMock, randMock);
		
		Mockito.when(randMock.nextInt(any(Integer.class))).thenReturn(1);
		Mockito.doNothing().when(playerMock).decreaseCredits(any(Integer.class));
		Mockito.doNothing().when(playerMock).increaseCredits(any(Integer.class));
		PowerMockito.doNothing().when(sut, method(DealerNoMatchGame.class, "delay", Integer.class)).withArguments(any(Integer.class));

		sutInterface.play(50);
	}

}
