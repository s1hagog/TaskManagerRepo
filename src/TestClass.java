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
		Login l = new Login("easy@mail.com", "12345");
		User u = uc.getUser(l);
		System.out.println(u.toString());

	}

}
