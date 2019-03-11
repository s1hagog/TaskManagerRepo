package taskManagerPro.entities;

import java.util.Date;

public class Task {
	
	public int _id;
	public String name;
	public String description;
	public String status;
	public Date start_date;
	public Date end_date;
	
	
	@Override
	public String toString() {
		return this.name;
	}

}
