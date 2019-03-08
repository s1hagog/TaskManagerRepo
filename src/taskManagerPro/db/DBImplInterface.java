package taskManagerPro.db;

public interface DBImplInterface {
	
	//connect to the database
	public void dbOpenConnection();	
	
	//close connection
	public void dbCloseConnection();
	
	//get password for login
	public String getUserPassword(String username);
	
	
	

}
