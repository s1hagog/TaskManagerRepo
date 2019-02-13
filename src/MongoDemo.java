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

}


