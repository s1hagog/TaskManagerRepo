package taskManagerPro.entities;

public class User {
	
	public String email;
	public String first_name;
	public String last_name;
	public String dept_name;
	public String dept_desc;
	public String password;
	public Login login;
	public boolean isManager;
	
	@Override
	public String toString() {
		return this.first_name + " " + this.last_name; 
	}
	
	

}
