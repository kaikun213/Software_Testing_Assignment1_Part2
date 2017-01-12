package test.java;

import static org.mockito.Matchers.any;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import main.java.dao.PlayerDAO;
import main.java.model.Player;

@RunWith(PowerMockRunner.class)
@PrepareForTest({File.class, PlayerDAO.class})
public class PlayerDAOExceptionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = NullPointerException.class)
	public void shouldFailToLoadFile() throws Exception{
		
	     // return the mock when file-object is constructed
        final File fileMock = Mockito.mock(File.class);
		PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(fileMock);
			
		
        // run the SUT
        PlayerDAO.jaxbXMLToObject();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailToLoadFileForSaving() throws Exception{
	     // return the mock when file-object is constructed
		PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(null);
	
        
        // run the SUT and expect failure
        PlayerDAO.jaxbObjectToXML(any(Player.class));
	}
	
	@Test (expected = JAXBException.class)
	public void shouldFailToMarshall() throws Exception{
		
		// first, pass test-file at construction
		final String filepath = System.getProperty("user.dir") + "/src/test/resources/PlayerTest.xml";
        final File fileMock = new File(filepath);
        
        // return the test-file when file-object is constructed
		PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(fileMock);
			
		
        // run the SUT
        PlayerDAO.jaxbXMLToObject();
	}

}
