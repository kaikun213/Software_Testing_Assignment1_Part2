package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.model.Player;
import main.java.model.error.NotEnoughCreditsException;

public class PlayerTest {
	
	Player sut;

	@Before
	public void setUp() throws Exception {
		sut = new Player();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnName() {
		sut.setName("Tester");
		assertEquals("Tester",sut.getName());
	}
	
	@Test
	public void shouldReturnCredits(){
		assertEquals(100, sut.getCredits());
	}
	
	@Test
	public void shouldIncreaseCreditsAndSetHighscore(){
		sut.resetCredits();
		sut.increaseCredits(100);
		
		int highscore = sut.getHighscore();
		assertEquals(Player.defaultCredits + 100, sut.getCredits());
		assertEquals(highscore, sut.getCredits());
	}
	
	@Test
	public void shouldDecreaseCredits() throws NotEnoughCreditsException{
		sut.resetCredits();
		sut.decreaseCredits(50);
		
		assertEquals(Player.defaultCredits - 50, sut.getCredits());
	}
	
	@Test(expected = NotEnoughCreditsException.class)
	public void shouldDecreaseCreditsAndThrowException() throws NotEnoughCreditsException{
		sut.resetCredits();
		sut.decreaseCredits(Player.defaultCredits+1);
	}
	
	@Test
	public void shouldReturnDefaultCredits(){
		int expected = Player.defaultCredits;
		assertEquals(expected, sut.getCredits());
	}
	
	@Test
	public void shouldConstructWithName(){
		sut = new Player("Tester");
		assertEquals("Tester",sut.getName());
	}
	
	@Test 
	public void shouldConstructWithNameAndDefaultCredits(){
		sut = new Player("Tester");
		assertEquals("Tester",sut.getName());
		int expected = Player.defaultCredits;
		assertEquals(expected, sut.getCredits());
	}
	
	@Test
	public void shouldReturnDefaultName(){
		String expected = "DefaultPlayerName";
		assertEquals(expected ,sut.getName());
	}
	
	@Test
	public void resetCredits(){
		int expected = Player.defaultCredits;
		sut = new Player("Tester");
		sut.resetCredits();
		int actual = sut.getCredits();
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnHighscore() {
		sut.resetCredits();
		sut.increaseCredits(100);
		assertEquals(Player.defaultCredits + 100,sut.getHighscore());
	}
	
	@Test
	public void shouldSetDefaultHighscore(){
		assertEquals(Player.defaultCredits,sut.getHighscore());

	}

}
