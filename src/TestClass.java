import java.util.ArrayList;
import java.util.List;

import taskManagerPro.controllers.TaskController;
import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Task;

public class TestClass {
	
	public static void main(String[] args) {
		TaskController tc = new TaskController();
		List<Task> tasks = tc.getTasks("moshakalex@gmail.com");
		Task task = tasks.get(2);
		task.status = "Test it!!!";
		System.out.println(task.toString());
		DBManager dbmgr = new DBManager();
		dbmgr.setTaskStatus("moshakalex@gmail.com", task);

	}

}
