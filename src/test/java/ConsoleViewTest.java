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
		Mockito.when(input.read()).thenReturn((int)('1'));
		sut = new ConsoleView(printStream, input);
		
		//run & verify 1
		Mockito.when(input.read()).thenReturn((int)('1'));
		Event actual = sut.getUserEvent();
		Event expected = Event.PlayPickNumer;
		assertEquals(expected, actual);
		
		//run & verify 2
		Mockito.when(input.read()).thenReturn((int)('2'));
		actual = sut.getUserEvent();
		expected = Event.PlayNoMatchDealer;
		assertEquals(expected, actual);
		
		//run & verify 3
		Mockito.when(input.read()).thenReturn((int)('3'));
		actual = sut.getUserEvent();
		expected = Event.PlayFindAce;
		assertEquals(expected, actual);
				
		//run & verify 4
		Mockito.when(input.read()).thenReturn((int)('4'));
		actual = sut.getUserEvent();
		expected = Event.ViewHighscore;
		assertEquals(expected, actual);
		
		//run & verify 5
		Mockito.when(input.read()).thenReturn((int)('5'));
		actual = sut.getUserEvent();
		expected = Event.ChangeName;
		assertEquals(expected, actual);
				
		//run & verify 6
		Mockito.when(input.read()).thenReturn((int)('6'));
		actual = sut.getUserEvent();
		expected = Event.Reset;
		assertEquals(expected, actual);
		
		//run & verify 7
		Mockito.when(input.read()).thenReturn((int)('7'));
		actual = sut.getUserEvent();
		expected = Event.Quit;
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldOutPutInvalidChoice() throws IOException{
		// initialize & mock
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		Mockito.when(input.read()).thenReturn((int)('8')).thenReturn((int)('7'));
		sut = new ConsoleView(printStream, input);

		// run
		sut.getUserEvent();
		
		//verify
		verify(printStream).println((int)('8') + ConsoleView.INVALID_CHOICE);
		// run + verify quit to terminate
		Event actual = sut.getUserEvent();

		Event expected = Event.Quit;
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
	
	@Test
	public void shouldFailToReadName() throws IOException{
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		Mockito.when(input.readLine()).thenThrow(new IOException());
		sut = new ConsoleView(printStream, input);
		
		Player tester = sut.registerPlayer();
		
		assertEquals(tester.getName(), "InvalidInputExceptionName");
	}
	
	@Test
	public void shouldGetName() throws IOException{
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		Mockito.when(input.readLine()).thenReturn("Tester");
		sut = new ConsoleView(printStream, input);
		
		String name = sut.getName();
		
		assertEquals("Tester", name);
		verify(printStream, times(1)).println(ConsoleView.GetName);
	}
	
	@Test
	public void shouldShowHighScore(){
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		sut = new ConsoleView(printStream, input);
		
		sut.showHighScore(Player.defaultCredits);
		
		verify(printStream).println("\n===================| HIGHSCORE |====================\n" +
									"You currently have the high score of " + Player.defaultCredits +" credits!\n");
	}
	
	@Test
	public void shouldShowPickANumberGameRules(){
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		sut = new ConsoleView(printStream, input);
		
		sut.showPickANumberGameRules();
		
		verify(printStream).println(ConsoleView.PickANumberGameRules);
	}
	
	@Test(expected = IOException.class)
	public void shouldThrowExceptionForGetANumberBetween() throws IOException{
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		sut = new ConsoleView(printStream, input);
		Mockito.when(input.readLine()).thenThrow(new IOException());
		sut.getNumberBetween(0, 10);
	}
	
	@Test
	public void shouldGetANumberBetween() throws IOException{
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		sut = new ConsoleView(printStream, input);
		Mockito.when(input.readLine()).thenReturn("1");
		
		// null given first
		Mockito.when(input.readLine()).thenReturn(null).thenReturn("1");
		int expected = 1;
		int actual = sut.getNumberBetween(0, 10);
		assertEquals(expected, actual);
		verify(printStream, times(0)).println("This is not an valid Integer-Number");
		
		//default case
		actual = sut.getNumberBetween(0, 10);
		expected = 1;
		assertEquals(expected, actual);
		// two times because second test
		verify(printStream, times(2)).println("Please enter an Integer-Number between: 0 - 10");
		
		// first a higher number, then a lower number and then user needs to put in again
		Mockito.when(input.readLine()).thenReturn("11").thenReturn("-1").thenReturn("1");
		actual = sut.getNumberBetween(0, 10);
		assertEquals(expected, actual);
		verify(printStream, times(2)).println("The Number must be in the given constraints!");

		
		// boundaries
		actual = sut.getNumberBetween(1, 10);
		assertEquals(expected, actual);
		actual = sut.getNumberBetween(0, 1);
		assertEquals(expected, actual);

		// negative
		Mockito.when(input.readLine()).thenReturn("-1");
		actual = sut.getNumberBetween(-5, 0);
		expected = -1;
		assertEquals(expected, actual);
		
		// no Integer given
		Mockito.when(input.readLine()).thenReturn("testing").thenReturn("1");
		expected = 1;
		actual = sut.getNumberBetween(0, 10);
		assertEquals(expected, actual);
		verify(printStream).println("This is not an valid Integer-Number");
	}
	
	@Test
	public void shouldShowNotEnoughCredits(){
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		sut = new ConsoleView(printStream, input);
		
		sut.showNotEnoughCredits();
		
		verify(printStream, times(1)).println(ConsoleView.NotEnoughCreditsNotification + any(String.class));
	}
	
	@Test
	public void shouldShowCurrentState(){
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		sut = new ConsoleView(printStream, input);
		
		sut.showCurrentState("Tester", 5);
		
		verify(printStream, times(1)).println("\nPlayer Name: " + "Tester" + "\nCredits: " + "5");
	}
	
	@Test
	public void shouldShowResultPickANumberGame(){
		PrintStream printStream = mock(PrintStream.class);
		BufferedReader input = mock(BufferedReader.class);
		sut = new ConsoleView(printStream, input);
		
		// lose
		sut.showResultPickANumberGame(false, 5);
		verify(printStream, times(1)).println(ConsoleView.PickANumberLoosingStatement + "5");
		
		// win
		sut.showResultPickANumberGame(true, 5);
		verify(printStream, times(1)).println(ConsoleView.PickANumberWinningStatement + "5");
	}

}
