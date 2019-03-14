package taskManagerPro.entities;

import java.util.Date;

public class Project {
	public int _id;
	public String name;
	public String description;
	public String phase;
	public String projectOwner;
	public Date start_date;
	public Date end_date;

	
	public int convertStatusToInteger() {
		if(phase.equals("Iteration 1"))
			return 0;
		else if(phase.contentEquals("Iteration 2"))
			return 1;
		else if(phase.contentEquals("Completed"))
			return 2;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
