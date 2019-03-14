package taskManagerPro.controllers;

import java.util.List;

import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Task;

public class TaskController {
	
	private DBManager dbmgr = new DBManager();
	
	public List<Task> getTasks(String userName){
		return dbmgr.getTasks(userName);
	}
	
	public void setTaskStatus(String username, int id, String status) {
		dbmgr.setTaskStatus(username, id, status);
	}

}
