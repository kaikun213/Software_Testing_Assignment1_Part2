package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.model.Player;

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
		sut.setCredits(100);
		assertEquals(100, sut.getCredits());
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

}
