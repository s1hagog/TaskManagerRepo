package taskManagerPro.controllers;

import java.util.List;

import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Manager;
import taskManagerPro.entities.Project;
import taskManagerPro.entities.Task;

public class TaskController {
	
	private DBManager dbmgr = new DBManager();
	
	public List<Task> getTasks(String userName){
		return dbmgr.getTasks(userName);
	}
	
	public void setTaskStatus(String username, String name, String status) {
		dbmgr.setTaskStatus(username, name, status);
	}

	public void deleteTask(String username, String name) {
		// TODO Auto-generated method stub
		dbmgr.deleteTask(username, name);
		
	}

	public void createTask(String username, Task task) {
		// TODO Auto-generated method stub
		dbmgr.createTask(username, task);
		
	}

	public List<Task> getTasks(String m_username, Project p) {
		// TODO Auto-generated method stub
		return dbmgr.getTasks(m_username, p);
	}


	public void createTask(Manager m, Project p, Task task) {
		// TODO Auto-generated method stub
		dbmgr.createTask(m,p, task); 
	}
	
	

}
