import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.DB;


public class MongoDemo {

	public static void main(String[] args) {
		try {
			MongoClientURI uri = new MongoClientURI(
				    "mongodb+srv://alex_user:123qwe@cluster0.mongodb.net/admin");
			MongoClient mongoClient = new MongoClient(uri);
			DB database = mongoClient.getDB("Csis3275");
			System.out.println("Connected");
		}catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
