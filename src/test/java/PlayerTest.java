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

}
