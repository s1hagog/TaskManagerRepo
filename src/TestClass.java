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
		TaskController tc = new TaskController();
		tc.deleteTask("moshakalex@gmail.com", "123");
		
	}

}
