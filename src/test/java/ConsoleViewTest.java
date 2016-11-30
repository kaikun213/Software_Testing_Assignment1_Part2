package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
		sut = new ConsoleView(printStream);
		
		sut.showMenu();
		
		verify(printStream).println("-=[ Game of Chance MENU ]=-\n" +
									"1 - Play the pick a number game\n" +
									"2 - Play the No Match Dealer game\n" +
									"3 - Play the Find the Ace game\n" +
									"4 - View current high score\n" +
									"5 - Change your user Name\n" +
									"6 - Reset your account at 100 credits\n" +
									"7 - Quit\n");
	}
	
	@Test
	public void shouldSetDefaultPrintStream(){
		sut = new ConsoleView();
		try{
			sut.showMenu();	
		}
		catch (NullPointerException e){
			fail("Nullpointer exception thrown : No default set");
		}
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
		verify(printStream).println("-=-=-{ NEW PLAYER REGISTRATION }-=-=-\n" +
									"Enter your Name:");
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

}
