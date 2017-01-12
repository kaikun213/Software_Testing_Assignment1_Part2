package se.lnu.http;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import se.lnu.http.HTTPServer;
import se.lnu.http.HTTPServerConsole;
import se.lnu.http.Port;
import se.lnu.http.ServerFactory;
import se.lnu.http.exceptions.MalformedRequestException;
import se.lnu.http.view.ConsoleView;

public class AdditionalTests {
	

	@Test
	public void testHTTPServerConsoleViewStopFailsOnce() throws Exception {
		ConsoleView mockedView = mock(ConsoleView.class);
		ServerFactory mockedServerFactory = mock(ServerFactory.class);
		HTTPServer mockedServer = mock(HTTPServer.class);
		
		HTTPServerConsole sut = new HTTPServerConsole(mockedView, mockedServerFactory);
		
		Port port = new Port(80);
		File directory = new File("/");
		
		when(mockedServerFactory.create(port, directory, mockedView)).thenReturn(mockedServer);
		
		when(mockedView.getPort()).thenReturn(port);
		when(mockedView.getDirectory()).thenReturn(directory);
		when(mockedView.doStop()).thenReturn(false).thenReturn(true);
		sut.runConsole();
		verify(mockedView, never()).showhelp();
		verify(mockedServer).start();
		verify(mockedServer).stop();
	}
	
	@Test
	public void testCreateHTTPRequestParser(){
		@SuppressWarnings("unused")
		HTTPRequestParser sut = new HTTPRequestParser();
	}
	
	@Test
	public void testHTTPRequestDoCloseBranch() throws MalformedRequestException{
		Map<Header.HTTPHeader, Header> headers = new HashMap<Header.HTTPHeader, Header>();
		headers.put(Header.HTTPHeader.Connection, Header.fromString("Connection: open"));
		headers.put(Header.HTTPHeader.Host, Header.fromString("Host: test"));
		HTTPRequest sut = new HTTPRequest(HTTPRequest.Method.GET, "", headers);
		
		assertFalse(sut.doCloseAfterResponse());
	}
	
	@Test
	public void testContentTypePackage(){
		se.lnu.http.response.ContentType sut = se.lnu.http.response.ContentType.applicationunknown;
		assertEquals("package se.lnu.http.response", sut.getClass().getPackage().toString());
	}

}
