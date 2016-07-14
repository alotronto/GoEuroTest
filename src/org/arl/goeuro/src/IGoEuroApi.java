package org.arl.goeuro.src;

import javax.json.JsonArray;

/**
 * This interface is used to abstract the GoEuro API concept, 
 * in details here  we specify all the functions used to manage the API.
 * 
 * @author Andrea Rocco Lotronto
 *
 */

public interface IGoEuroApi {
	
	/**
	 * Sets the base URI of the API
	 * 
	 * @param baseURI String Java type with the base URI of the API
	 */
	public void setBaseURI(String baseURI);
	
	/**
	 * Gets a JsonArray that contains the result of the request
	 * "http://api.goeuro.com/api/v2/position/suggest/en/cityName" 
	 * where cityName is given as parameter of the method.
	 * 
	 * @param cityName String Java type with the name of the city in correct URI format
	 * @return JsonArray type if the request is successful null otherwise
	 */
	public JsonArray getCitiesJSONArray(String cityName);

}
