package taskManagerPro.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestProject {
	private Project p = new Project();
	

	@Test
	void testProjectStatusToInteger() {
		p.name = "Test project";
		p.phase = "Completed";
		int test = p.convertStatusToInteger();
		assertEquals(2, test);
	}

}
