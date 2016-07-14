package org.arl.goeuro.src;

import java.net.URISyntaxException;

/**
 * This class contains the main method, this method, 
 * using an instance of MyArguments and one of MyClient, 
 * creates the console application for GoEuro Test.
 * 
 * @author Andrea Rocco Lotronto
 *
 */
public class GoEuroTest {

	public static void main(String[] args) throws URISyntaxException {
			
		MyArguments myArguments = new MyArguments();
		myArguments.setArguments(args);
		
		MyClient client = new MyClient();
		
		if(myArguments.checkArgumentFormat()){
			
			System.out.println("The input parameter is ok");
			client.setBaseURI("http://api.goeuro.com/api/v2/position/suggest/en/");
			System.out.println("Wait for csv file creation");
			client.makeCSVFile(
					client.getCitiesJSONArray(myArguments.getArgumentInURIFormat()), 
					args[0]
			);
			System.out.println("CSV file creation was successful");
		}
		else{
			System.out.println("The format of the argument is not valid !!");
			System.out.println("The correct format is: java -jar GeoTest.jar \"CITY\"");
			System.out.println("Try again");
		}
	}

}
