package taskManagerPro.db;

import java.util.Map;

public interface DBImplInterface {
	
	//connect to the database
	public void dbOpenConnection();	
	
	//close connection
	public void dbCloseConnection();
	
	//get password for login
	public String getUserPassword(String username);
	
	//set user information from login
	//At first was supposed to be ArrayList but key-value Map is better
	public Map<String, String> getUserData(String username);
	
	

}
