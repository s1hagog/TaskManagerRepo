package taskManagerPro.db;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class MongoDB {
	
	public MongoCollection getMongoCollection(MongoDatabase db, String collectionName) {
		
		return null;
	}

}
