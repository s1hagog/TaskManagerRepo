package taskManagerPro.entities;

public class Login {
	
	public String userLogin;
	public String userPassword;
	
	public Login(String l, String p) {
		userLogin = l;
		userPassword = p;
	}
	
	//I dont think we need getter and setters because once we create object instance
	//we wont change this info.
	
	
	//ADDITIONAL METHODS
	
	private void passwordHash() {
		//here will be code for hashing password;
	}
	
	

}
