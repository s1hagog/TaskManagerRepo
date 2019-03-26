package taskManagerPro.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import taskManagerPro.entities.User;

class TestDB {
	
	private DBManager dbmgr = new DBManager();

	@Test
	void testDuplicateUsers() {
		User u1 = new User();
		User u2 = new User();
		u1.email = "test@mail.com";
		u2.email = "test@mail.com";
		u1.password = "12345";
		u2.password = "12345";
		
	}

}
