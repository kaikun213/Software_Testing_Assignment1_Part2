package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

}
