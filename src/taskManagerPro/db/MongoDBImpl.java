package taskManagerPro.db;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters; 
import com.mongodb.client.model.Updates;

import taskManagerPro.entities.Task;

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
		return userpass;
	}

	public Map<String, String> getUserData(String username) {
		this.dbOpenConnection();
		Map<String, String> userMap = new HashMap<String, String>();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			org.bson.Document query = (org.bson.Document) collection.find(eq("email",username)).first();
			org.bson.Document department = (org.bson.Document)query.get("department");
			userMap.put("first_name", query.getString("first_name"));
			userMap.put("last_name", query.getString("last_name"));
			userMap.put("email", query.getString("email"));
			userMap.put("dept_name", department.getString("name"));
			userMap.put("dept_desc", department.getString("description"));
			
		} catch(MongoException mx) {
			System.out.println("Error getting user data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		this.dbCloseConnection();
		return userMap;
	}

	public List<Task> getTasks(String username) {
		this.dbOpenConnection();
		List<Task> tasks = new ArrayList<Task>();
		//Task instance to write into array
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			org.bson.Document query = (org.bson.Document) collection.find(eq("email",username)).first();
			List<Document> tasksData = (List<Document>)query.get("tasks");
			for(Document taskData : tasksData) {
				Task tempTask = new Task();
				tempTask._id = taskData.getInteger("_id");
				tempTask.name = taskData.getString("name");
				tempTask.description = taskData.getString("description");
				tempTask.end_date = taskData.getDate("end_date");
				tempTask.start_date = taskData.getDate("start_date");
				tempTask.status = taskData.getString("status");
				tasks.add(tempTask);
			}
			
		} catch(MongoException mx) {
			System.out.println("Error getting tasks data");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		this.dbCloseConnection();
		return tasks;
	}

	public void setTaskStatus(String username, Task t) {
		// TODO Auto-generated method stub
		this.dbCloseConnection();
		
		try {
			MongoCollection<Document> collection = this.mongoDB.getCollection("UserData");
			collection.updateOne(eq("email",username), Updates.set("task.status", t.status));
			
		} catch(MongoException mx) {
			System.out.println("Error changing task status");
			System.out.println(mx.getMessage());
			System.out.println(mx.getCode());
			System.out.println(mx.getStackTrace());
		}
		
		this.dbCloseConnection();
		
	}
	
	
	

}
