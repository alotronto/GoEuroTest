package org.arl.goeuro.test;


import org.arl.goeuro.src.MyArguments;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * This class is used to perform the Unit Tests of the MyArguments class.
 * 
 * @author Andrea Rocco Lotronto
 *
 */

public class MyArgumentsTest {
	private static String [] args = {"Villa San Giovanni"};
	private static MyArguments myArguments;
	
	@BeforeClass
	public static void beforeClass(){
		
		myArguments = new MyArguments();
		myArguments.setArguments(args);
	}
		
	@Test 
	public void checkArgumentFormat(){
		
		assertEquals("The function should be return true",
				true, 
				myArguments.checkArgumentFormat());
	}
	
	@Test
	public void getUrlApiTest() throws UnsupportedEncodingException {
		
		String aspectedValue =URLEncoder.encode(args[0],"UTF-8");
		aspectedValue = aspectedValue.replace("+", "%20");
		
		assertEquals("The fucntion should be return: "+aspectedValue,
				aspectedValue,
				myArguments.getArgumentInURIFormat());
	}
}
