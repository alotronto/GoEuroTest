package org.arl.goeuro.src;


import javax.json.JsonArray;

/**
 * This interface is used to abstract the concept of JSON converter.
 * @author Andrea Rocco Lotronto
 *
 */
public interface IJSONConvert {
	
	/**
	 * Creates a csv file starting from a JsonArray, the name of the file is given as a parameter.
	 * 
	 * @param jsonArray JasonArray type that contains the information used to fill the csv file
	 * @param fileName String type that specify the name of the file that will be created
	 */
	public void makeCSVFile(JsonArray jsonArray, String fileName);

}
