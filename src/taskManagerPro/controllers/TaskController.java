package taskManagerPro.controllers;

import java.util.List;

import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Task;

public class TaskController {
	
	private DBManager dbmgr = new DBManager();
	
	public List<Task> getTasks(String userName){
		return dbmgr.getTasks(userName);
	}
	
	public int convertStatusToInteger(String status) {
		if(status.equals("To do"))
			return 0;
		else if(status.contentEquals("In progress"))
			return 1;
		else if(status.contentEquals("Completed"))
			return 2;
		else
			return 0;
	}
	
	public void setTaskStatus(String username, Task task) {
		
	}

}
