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
		
		verify(printStream).println();
	}

}
