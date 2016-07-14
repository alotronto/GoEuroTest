package org.arl.goeuro.src;

import java.io.UnsupportedEncodingException;
//import java.net.URI;
//import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * This class implements the IArgument Interface to manage the arguments
 * inserted by the user
 * 
 * @author Andrea Rocco Lotronto
 *
 */
public class MyArguments implements IArguments {
	
	private String [] args = null;


	@Override
	public void setArguments(String[] args) {
		this.args = args;
		
	}

	@Override
	public boolean checkArgumentFormat() {
		if(args.length == 1){
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public String getArgumentInURIFormat() {
		try {
			String uriForm = URLEncoder.encode(args[0],"UTF-8");
			uriForm = uriForm.replace("+", "%20");
			return uriForm;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
