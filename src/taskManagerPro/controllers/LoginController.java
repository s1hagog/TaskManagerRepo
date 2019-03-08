package taskManagerPro.controllers;

import taskManagerPro.db.DBManager;
import taskManagerPro.entities.Login;

public class LoginController {
	
	private boolean isPasswordValid;
	private boolean isLoginValid;
	private String userDBPassword;
	private DBManager dbmgr = new DBManager();
	
	public boolean isValid(Login userLogin) {
		boolean validation;
		isLoginValid = validateLogin(userLogin.userLogin);
		isPasswordValid = validatePassword(userLogin.userPassword);
		if(isPasswordValid && isLoginValid)
			validation = true;
		else
			validation = false;
		return validation;
	}
	
	private boolean validatePassword(String password) {
		//compare the passwords from DB and in a userLogin
		if(userDBPassword.equals(password))
			return true;
		else
			return false;
	}
	
	private boolean validateLogin(String login) {
		//find user
		//get the password
		try {
			this.userDBPassword = dbmgr.getUserPassword(login);
			return true;
		} catch (Exception ex) {
			return false;
		}
		//save the password in a field
	}
	

}
