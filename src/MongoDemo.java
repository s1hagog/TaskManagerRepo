import java.util.List;

import com.mongodb.Mongo;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.*;

public class MongoDemo extends Mongo {
	public static void main(String[] args) {
		try {			
			MongoClient mongoClient = MongoClients.create("mongodb://alex_user:123qwe@cluster0-shard-00-00-fc9jq.azure.mongodb.net:27017,cluster0-shard-00-01-fc9jq.azure.mongodb.net:27017,cluster0-shard-00-02-fc9jq.azure.mongodb.net:27017/Csis3275?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true");
			
			MongoDatabase mongoDB = mongoClient.getDatabase("Csis3275");
			System.out.println("connected");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}


