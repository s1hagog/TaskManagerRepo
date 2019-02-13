import java.awt.*;

import javax.swing.*;

public class LoginScreen extends JFrame {
	
	private JButton loginBtn, signUpBtn;
	private JTextField usernameText, passwordText;
	
	public LoginScreen() {
		createView();
		setTitle("Login Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(800,600);
		setResizable(false);
		
	}

	private void createView() {
		JPanel jpanel = new JPanel();
		//jpanel.setLayout(new BorderLayout());;
		getContentPane().add(jpanel);
		loginBtn = new JButton("Sign In");
		signUpBtn = new JButton("Sign Up");
		jpanel.add(loginBtn, BorderLayout.CENTER);
		jpanel.add(signUpBtn, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new LoginScreen().setVisible(true);
			}
			
		});

	}

}
