package taskManagerPro.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import taskManagerPro.controllers.TaskController;
import taskManagerPro.db.DBManager;

class TestBuild {
	
	private DBManager dbmgr = new DBManager();

	@Test
	void testTasksDeadline() {
		TaskController tc = new TaskController();
		List<Task> tasks = tc.getTasks("moshakalex@gmail.com");
		Task checked_task = tasks.get(1);
		if(checked_task.end_date.compareTo(new Date()) < 0) {
			assertEquals(2,checked_task.convertStatusToInteger());
		}
	}
	
	@Test
	void isUserInProject() {
		String username = "moshakalex@gmail.com";
		String p_name = "test3";
		List<User> users = dbmgr.getUsersFromProject(p_name);
		boolean isInProject = false;
		for(User user: users) {
			if(user.email.equals(username)) {
				isInProject = true;
			}
		}
		
		assertEquals(true, isInProject);
	}

}
