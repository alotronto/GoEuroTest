package org.arl.goeuro.test;

import org.arl.goeuro.src.MyArguments;
import org.arl.goeuro.src.MyClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;


/**
 * This class is used to perform the Unit Tests of the MyClient class.
 * 
 * @author Andrea Rocco Lotronto
 *
 */

public class MyClientTest {
	private static MyClient myClient;;
	private static MyArguments myArguments;
	private static String[] args = {"Villa San Giovanni"};
	private static String  baseURI = "http://api.goeuro.com/api/v2/position/suggest/en/"; 
	private static File testFile;
	
	@BeforeClass
	public static void beforeClass(){
		myClient = new MyClient();
		myClient.setBaseURI(baseURI);
		myArguments = new MyArguments();
		myArguments.setArguments(args);
		testFile = new File(args[0]+".csv");
	}
	
	@AfterClass
	public static void afterClass(){
		testFile.delete();
		
	}
	
	@Test
	public void getCitiesJSONArrayTest(){			 
			 assertNotNull("The function should be return a JSONArray Object" , 
					 myClient.getCitiesJSONArray(myArguments.getArgumentInURIFormat()));
	}
	
	@Test
	public void makeCSVFileTest(){
		myClient.makeCSVFile(
				myClient.getCitiesJSONArray(myArguments.getArgumentInURIFormat()),
				args[0]);
		
		assertTrue("The tested method should create a new file with \""+args[0]+".csv\"name",
				testFile.exists());
	}
	
}
