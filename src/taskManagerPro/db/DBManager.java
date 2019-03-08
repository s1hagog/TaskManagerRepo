package taskManagerPro.db;

import java.util.Map;

public class DBManager {
	
	DBImplInterface imp = new MongoDBImpl();
	
	public String getUserPassword(String username) {
		
		return imp.getUserPassword(username);
	}
	
	public Map<String, String> getUserData(String username){
		
		return imp.getUserData(username);
	}

}
