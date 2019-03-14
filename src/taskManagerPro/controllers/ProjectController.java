package taskManagerPro.controllers;

import java.util.List;

import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Project;
import taskManagerPro.entities.User;

public class ProjectController {

	private DBManager dbmanager = new DBManager();
	
	public List<User> getUsersFromProject(String projectName){
		return dbmanager.getUsersFromProject(projectName);
 	}
	
	public List<Project> getProjects(String userName){
		return dbmanager.getProjects(userName);
	}
}
