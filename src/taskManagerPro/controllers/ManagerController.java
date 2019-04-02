package taskManagerPro.controllers;

import java.util.List;

import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Manager;
import taskManagerPro.entities.Project;
import taskManagerPro.entities.Task;
import taskManagerPro.entities.User;

public class ManagerController {
	
	private DBManager dbmgr = new DBManager();
	
	public List<User> getUsers(Manager m){
		return dbmgr.getAllUsers(m);
	}
	
	public List<Project> getProjects(Manager m){
		return dbmgr.getAllProjects(m);
	}
	
	public void assignUserToProject(User u, Project p) {
		dbmgr.assignUserToProject(u, p);
	}
	
	public void assignTaskToUser(User u, Task t) {
		dbmgr.assignTaskToUser(u, t);
	}
	
	public void addTaskToProject(Task t, Project p) {
		dbmgr.addTaskToProject(t, p);
	}

	public void unassignTask(String email, String name) {
		// TODO Auto-generated method stub
		dbmgr.deleteTask(email, name);
	}

	public void unassignProject(String email, String name) {
		// TODO Auto-generated method stub
		dbmgr.unassignProject(email,name);
		
	}
	
	public boolean isUserPartOfProject(String email,String projectName){
		
		return dbmgr.isUserPartOfProject(email,projectName);
	}
	

}
