import java.util.ArrayList;
import java.util.List;

import taskManagerPro.controllers.TaskController;
import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Task;

public class TestClass {
	
	public static void main(String[] args) {
		TaskController tc = new TaskController();
		List<Task> tasks = tc.getTasks("moshakalex@gmail.com");
		List<String> taskNamesToDo = new ArrayList<String>();
		List<String> taskNamesInProgress = new ArrayList<String>();
		List<String> taskNamesCompleted = new ArrayList<String>();
		for(Task task : tasks) {
			
			switch(tc.convertStatusToInteger(task.status)) {
				case 0:
					taskNamesToDo.add(task.name);
					break;
				case 1:
				
				taskNamesInProgress.add(task.name);
					break;
				case 2:
				
				taskNamesCompleted.add(task.name);
					break;
			}
		}
		System.out.println(taskNamesToDo.toString());
		
	}

}
