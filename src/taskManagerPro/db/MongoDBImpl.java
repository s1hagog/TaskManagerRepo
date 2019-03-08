package taskManagerPro.db;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBImpl extends MongoDB implements DBImplInterface{
	
	private MongoDatabase mongoDB = null;
	private MongoClient mongoClient = null;
	private String dbUser = "alex_user";
	private String dbPass = "123qwe";
	private String dbName = "Csis3275";
	//user and password are added directly in connection link
	private String connURI = "mongodb://"
								+ dbUser 
								+ ":" 
								+ dbPass 
								+ "@cluster0-shard-00-00-fc9jq.azure.mongodb.net:27017,cluster0-shard-00-01-fc9jq."
								+ "azure.mongodb.net:27017,cluster0-shard-00-02-fc9jq.azure.mongodb.net:27017/" 
								+ dbName 
								+ "?ssl=true&replicaSet=Cluster0-"
								+ "shard-0&authSource=admin&retryWrites=true";
	
	public void dbOpenConnection() {
		try {
			this.mongoClient = MongoClients.create(this.connURI);
			this.mongoDB = this.mongoClient.getDatabase(this.dbName);	
		} catch (MongoException mx) {
			System.out.println("Error Connecting to database");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
	}

	public void dbCloseConnection() {
		this.mongoClient.close();	
	}

	public String getUserPassword(String username) {
		this.dbOpenConnection();
		String userpass = "";
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			org.bson.Document query = (org.bson.Document) collection.find(eq("email",username)).first();
			userpass = query.getString("password");
			
		} catch(MongoException mx) {
			System.out.println("Error getting user password");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		// TODO Auto-generated method stub
		return userpass;
	}
	
	
	

}
