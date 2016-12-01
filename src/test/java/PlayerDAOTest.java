package test.java;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import main.java.dao.PlayerDAO;
import main.java.model.Player;

// Third party test 
@RunWith(PowerMockRunner.class)
@PrepareForTest({File.class, PlayerDAO.class})
public class PlayerDAOTest {
	
	@SuppressWarnings("unused")
	@Test
	public void testClassCreation(){
		PlayerDAO testClass = new PlayerDAO();
	}

	@Test
	public void testMockFile() {
		// first, create a mock for File
        final File fileMock = Mockito.mock(File.class);
        Mockito.when(fileMock.getAbsolutePath()).thenReturn("testPath");
        
        // return the mock when file-object is constructed
        try {
			PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(fileMock);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        // verify
        final String mockedFilePath = new File("testPath").getAbsolutePath();
        Assert.assertEquals("testPath", mockedFilePath);
	}
	
	@Test
	public void jaxbXMLToObjectTest() throws Exception {
		// first, create a mock for File
		final String filepath = System.getProperty("user.dir") + "/src/test/resources/PlayerTest.xml";
        final File fileMock = Mockito.mock(File.class);
        Mockito.when(fileMock.getAbsolutePath()).thenReturn(filepath);
        
        // return the mock when file-object is constructed
		PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(fileMock);
		
        
        // write test data
        try {
			PrintWriter writer = new PrintWriter(filepath);
			writer.println( "<player>" +"\n" +
							"<credits>100</credits>" +"\n" +
							"<name>Tester</name>" +"\n" +
							"</player>" +"\n"); 
			writer.close();
		} catch (FileNotFoundException e) {
			fail("XMLToObject parsing failed.");
		}
                
        // run the SUT
        Player actual = PlayerDAO.jaxbXMLToObject();
        String expected = "Tester";
        
        // verify
        if (actual == null) fail("XMLToObject parsing failed.");
        assertEquals(expected, actual.getName());
        
        // teardown - flush test data
		PrintWriter writer = new PrintWriter(filepath);
		writer.print(""); 
		writer.close();
	
        
	}
	
	@Test
	public void jaxbObjectToXMLTest() throws Exception {
		// first, pass test-file at construction
		final String filepath = System.getProperty("user.dir") + "/src/test/resources/PlayerTest.xml";
        final File fileMock = new File(filepath);
        
        // return the test-file when file-object is constructed
		PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(fileMock);
		
        
        // Create Test-Data
        Player tester = new Player("Tester");
                
        // run the SUT
        PlayerDAO.jaxbObjectToXML(tester);
        
        // verify
        String expected   = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "\n" +
        					"<player>" +"\n" +
							"<credits>100</credits>" +"\n" +
							"<name>Tester</name>" +"\n" +
							"</player>" +"\n";
        List<String> actualList = new ArrayList<String>();
		try {
			actualList = Files.readAllLines(fileMock.toPath());
		} catch (IOException e1) {
			fail("ObjectToXML parsing failed.");
		}
        String actual = "";
        for (String s : actualList){
        	actual += s + "\n";
        }
        // cut whitespaces for comparison (pretty-printer in jaxb)
        assertEquals(expected.replaceAll("\\s+", ""), actual.replaceAll("\\s+", ""));

        
        // teardown - flush test data
        try {
			PrintWriter writer = new PrintWriter(filepath);
			writer.print(""); 
			writer.close();
		} catch (FileNotFoundException e) {
			fail("XMLToObject parsing failed.");
		}
	}
	
	

}
