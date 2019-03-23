import java.util.ArrayList;
import java.util.List;

import taskManagerPro.controllers.TaskController;
import taskManagerPro.controllers.UserController;
import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Login;
import taskManagerPro.entities.Task;
import taskManagerPro.entities.User;

public class TestClass {
	
	public static void main(String[] args) {
		UserController uc = new UserController();
		User u = uc.getUser(new Login("moshakalex@gmail.com", "123qwe"));
		System.out.println(u);
		User u2 = uc.getUser(new Login("billgates@npe.com", "microsoft"));
		System.out.println(u2);
	}

}
