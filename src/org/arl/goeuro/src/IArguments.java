package org.arl.goeuro.src;

/**
 * This interface is used to abstract the concept of arguments, in details here 
 * we specify all the functions used to save and check the arguments inserted by 
 * the user.
 * 
 * @author Andrea Rocco Lotronto
 *
 */
public interface IArguments{
	/**
	 * Save all the arguments inserted
	 * 
	 * @param args  String[] with all the parameters
	 */
	public void setArguments(String [] args);
	
	/**
	 * Check if the inserted arguments are in the correct form
	 * 
	 * @return True if the arguments was corrected false otherwise
	 */
	public boolean checkArgumentFormat();
	
	/**
	 * Returns the argument inserted in the correct URI format
	 * 
	 * @return String Java type containing the argument in URI format
	 */
	public String getArgumentInURIFormat();

}
