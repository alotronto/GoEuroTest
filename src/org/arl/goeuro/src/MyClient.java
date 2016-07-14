package org.arl.goeuro.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

 
/**
 * This class implements the IGoEuroApi and IJSONConvert interfaces.
 * Using this class we will perform API requests also using this class 
 * we will create the csv file starting from the results of the requests API.
 * 
 * @author Andrea Rocco Lotronto
 *
 */
public class MyClient implements IGoEuroApi, IJSONConvert{

	private String baseURI;
	private Client client = null;
	private WebTarget target = null;
	private Response response = null;
	private static String extFile = ".csv";
	
	
	@Override
	public void setBaseURI(String baseURI) {
		this.baseURI = baseURI;
	}

	@Override
	public JsonArray getCitiesJSONArray(String cityName) {
		
		client = ClientBuilder.newClient();
		target = client.target(baseURI+cityName);
		response = target.request(MediaType.APPLICATION_JSON).get();
		
		if(response.getStatus()==200){
			 StringReader stringReader = new StringReader(
					 target.request(MediaType.APPLICATION_JSON).get(String.class)); 
			
			 JsonReader jsonReader = Json.createReader(stringReader);
			 JsonArray jsonArray = jsonReader.readArray();
			 jsonReader.close();
			  
			 return jsonArray;
		}
		else{
			return null;
		}
	}

	@Override
	public void makeCSVFile(JsonArray jsonArray, String fileName)  {
		String rowToWrite = " _id, name, type, latitude, longitude";
		PrintWriter printOnCSVFile;
		try {
			printOnCSVFile = new PrintWriter(
					new FileWriter(fileName+extFile));

			printOnCSVFile.println(rowToWrite);
			
			for(int i=0 ;i<jsonArray.size(); i++ ){
				rowToWrite = 
					jsonArray.getJsonObject(i).getInt("_id")+","+
					jsonArray.getJsonObject(i).getString("name")+","+
					jsonArray.getJsonObject(i).getString("type")+","+
					jsonArray.getJsonObject(i).getJsonObject("geo_position").getJsonNumber("latitude")+","+
					jsonArray.getJsonObject(i).getJsonObject("geo_position").getJsonNumber("longitude");
				
				printOnCSVFile.println(rowToWrite);
			}
			printOnCSVFile.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Write file Error");
		}
	}
}

