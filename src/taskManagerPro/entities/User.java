package taskManagerPro.entities;

public class User {
	
	public String email;
	public String first_name;
	public String last_name;
	public String dept_name;
	public String dept_desc;
	public String password;
	public Login login;
	
	@Override
	public String toString() {
		return "User [email=" + email + ", first_name=" + first_name + ", last_name=" + last_name + ", dept_name="
				+ dept_name + ", dept_desc=" + dept_desc + "]";
	}
	
	

}
