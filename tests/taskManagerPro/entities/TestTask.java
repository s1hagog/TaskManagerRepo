package taskManagerPro.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTask {
	
	private Task t = new Task();

	@Test
	void testTaskStatusAsInteger() {
		t.name ="Test task";
		t.status = "To Do";
		int test = t.convertStatusToInteger();
		assertEquals(0, test);
	}

}
