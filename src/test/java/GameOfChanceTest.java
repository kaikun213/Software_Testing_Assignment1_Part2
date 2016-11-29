package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.application.GameOfChance;

public class GameOfChanceTest {
	
	GameOfChance sut;

	@Before
	public void setUp() throws Exception {
		sut = new GameOfChance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldShowMenu() {
		sut.run();
	}

}
