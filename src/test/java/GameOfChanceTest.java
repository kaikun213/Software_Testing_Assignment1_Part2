package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import main.java.application.GameOfChance;

@RunWith(MockitoJUnitRunner.class)
public class GameOfChanceTest {
	
	@Spy
	GameOfChance sut = new GameOfChance();;

	@Before
	public void setUp() throws Exception {
		 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test(){
		
	}


}
