package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.java.controller.GameController.Event;
import main.java.model.Player;
import main.java.view.ConsoleView;

public class ConsoleViewTest {
	
	ConsoleView sut;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldShowMenu() {
		PrintStream printStream = mock(PrintStream.class);
		sut = new ConsoleView(printStream, new BufferedReader(new InputStreamReader(System.in)));
		
		sut.showMenu();
		
		verify(printStream).println(ConsoleView.MENU);
	}
	
	@Test
	public void shouldRegisterPlayer(){
		// initialize & mock
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		try {
			Mockito.when(input.readLine()).thenReturn("Test name");
		} catch (IOException e1) {
			fail("Failed Test by trying to mock readLine-method");
		}
		sut = new ConsoleView(printStream, input);
		
		//run system
		Player tester = sut.registerPlayer();
		
		/* verification */
		
		// output message
		verify(printStream).println(ConsoleView.REGISTER);
		// verify call
		try {
			verify(input).readLine();
		} catch (IOException e) {
			fail("Failed Test by trying to scan the name");
		}
		
		assertEquals("Test name", tester.getName());
		
		verify(printStream).println("Welcome to the Game of Chance" + tester.getName() +"\n" +
				"You have been given"+ Player.defaultCredits +" credits.\n");
	}
	
	@Test 
	public void shouldGetUserEvent(){
		// initialize & mock
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		try {
			Mockito.when(input.read()).thenReturn(1);
		} catch (IOException e1) {
			fail("Failed Test by trying to mock read-method");
		}
		sut = new ConsoleView(printStream, input);
		
		//run system
		Event actual = sut.getUserEvent();
		
		//verify
		Event expected = Event.PlayPickNumer;
		
		assertEquals(expected, actual);
	}

}
