package taskManagerPro.db;

public class DBManager {
	
	DBImplInterface imp = new MongoDBImpl();
	
	public String getUserPassword(String username) {
		
		return imp.getUserPassword(username);
	}

}
