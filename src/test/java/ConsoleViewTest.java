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
	public void shouldGetUserEvent() throws IOException{
		// initialize & mock
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		Mockito.when(input.read()).thenReturn(1);
		sut = new ConsoleView(printStream, input);
		
		//run & verify 1
		Mockito.when(input.read()).thenReturn(1);
		Event actual = sut.getUserEvent();
		Event expected = Event.PlayPickNumer;
		assertEquals(expected, actual);
		
		//run & verify 2
		Mockito.when(input.read()).thenReturn(2);
		actual = sut.getUserEvent();
		expected = Event.PlayNoMatchDealer;
		assertEquals(expected, actual);
		
		//run & verify 3
		Mockito.when(input.read()).thenReturn(3);
		actual = sut.getUserEvent();
		expected = Event.PlayFindAce;
		assertEquals(expected, actual);
				
		//run & verify 4
		Mockito.when(input.read()).thenReturn(4);
		actual = sut.getUserEvent();
		expected = Event.ViewHighscore;
		assertEquals(expected, actual);
		
		//run & verify 5
		Mockito.when(input.read()).thenReturn(5);
		actual = sut.getUserEvent();
		expected = Event.ChangeName;
		assertEquals(expected, actual);
				
		//run & verify 6
		Mockito.when(input.read()).thenReturn(6);
		actual = sut.getUserEvent();
		expected = Event.Reset;
		assertEquals(expected, actual);
		
		//run & verify 7
		Mockito.when(input.read()).thenReturn(7);
		actual = sut.getUserEvent();
		expected = Event.Quit;
		assertEquals(expected, actual);
	}
	
	@Test(expected = IOException.class)
	public void shouldFailReadUserLine() throws IOException{
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		Mockito.when(input.read()).thenThrow(new IOException());
		sut = new ConsoleView(printStream, input);
		
		sut.getUserEvent();
	}

}
