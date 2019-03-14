package taskManagerPro.entities;

import java.util.Date;

public class Task {
	
	public int _id;
	public String name;
	public String description;
	public String status;
	public Date start_date;
	public Date end_date;
	
	public int convertStatusToInteger() {
		if(status.equals("To do"))
			return 0;
		else if(status.contentEquals("In progress"))
			return 1;
		else if(status.contentEquals("Completed"))
			return 2;
		else
			return 0;
	}
	
	
	@Override
	public String toString() {
		return this.name;
	}

}
