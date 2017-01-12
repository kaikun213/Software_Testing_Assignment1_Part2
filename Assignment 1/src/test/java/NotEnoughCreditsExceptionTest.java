package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.model.error.NotEnoughCreditsException;

public class NotEnoughCreditsExceptionTest {

	@Test
	public void testCreation() {
		String expected = "description";
		NotEnoughCreditsException sut = new NotEnoughCreditsException(expected);
		
		String actual = sut.getMessage();
		
		assertEquals(expected, actual);
	}

}
