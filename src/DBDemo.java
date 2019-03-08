
public class DBDemo {

	public static void main(String[] args) {
		MongoDemo demo = new MongoDemo();
		demo.dbConnection();
		System.out.print(demo.getMongoCollection("UserData").find().first().toString());
	}

}
