
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoDemo implements MongoConnectionI {
	MongoDatabase mongoDB;
	MongoClient mongoClient;
	public static void main(String[] args) {
		
	}

	public MongoCollection getMongoCollection(String collectionName) {
		return mongoDB.getCollection(collectionName);
	}

	public void dbConnection() {
		// TODO Auto-generated method stub
		try {			
			 mongoClient = MongoClients.create("mongodb://alex_user:123qwe@cluster0-shard-00-00-fc9jq.azure.mongodb.net:27017,cluster0-shard-00-01-fc9jq.azure.mongodb.net:27017,cluster0-shard-00-02-fc9jq.azure.mongodb.net:27017/Csis3275?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true");
			
			mongoDB = mongoClient.getDatabase("Csis3275");
			System.out.println("connected");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	public void dbCloseConnection() {
		// TODO Auto-generated method stub
		mongoClient.close();
	}
	
	public org.bson.Document getCollectionAndQueryID(int id){
		dbConnection();
		MongoCollection collection =  getMongoCollection("UserData");
		org.bson.Document query = (org.bson.Document) collection.find(eq("id",id)).first();
	
		return query;
	}
	
	public List getUserBasicData(int id) {
		org.bson.Document query = getCollectionAndQueryID(id);
		List<org.bson.Document> project = (List<org.bson.Document>) query.get("project");
		System.out.print(project.size());
		for (org.bson.Document doc : project) {
			System.out.print(doc.get("name"));
        }
		org.bson.Document department = (org.bson.Document) query.get("department");
		List userBasicInformation = new ArrayList();
		userBasicInformation.add(query.get("first_name").toString());
		userBasicInformation.add(query.get("last_name").toString());
		userBasicInformation.add(department.get("name").toString());

		
		return userBasicInformation;
	}
	
	
	public List<org.bson.Document> getUserTaskData(int id) {
		org.bson.Document query = getCollectionAndQueryID(id);
		List<org.bson.Document> project = (List<org.bson.Document>) query.get("task");
		System.out.print(project.size());
		for (org.bson.Document doc : project) {
			System.out.print(doc.get("name"));
        }
		return project;
	}


}


