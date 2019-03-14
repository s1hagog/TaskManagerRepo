package taskManagerPro.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taskManagerPro.controllers.LoginController;
import taskManagerPro.controllers.UserController;
import taskManagerPro.entities.Login;
import taskManagerPro.entities.User;

import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainLoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField loginTxtField;
	private JTextField passwordTxtField;
	private JLabel lblAttempt;
	private JButton btnSubmit;
	private MainLoginScreen frame = this;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLoginScreen frame = new MainLoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainLoginScreen() {
		setResizable(false);
		setTitle("Login - TaskManagerPRO");
		initComponents();
		createEvents();
		
	}

	//////////////////////////////////////////////////////
	//This methods is responsible for creating and
	//initializing components
	//////////////////////////////////////////////////////
	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLogin = new JLabel("Login");
		
		loginTxtField = new JTextField();
		lblLogin.setLabelFor(loginTxtField);
		loginTxtField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		passwordTxtField = new JTextField();
		passwordTxtField.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		
		
		lblAttempt = new JLabel("");
		
		btnNewButton = new JButton("Create User");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordTxtField)
								.addComponent(loginTxtField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(158)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAttempt, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(loginTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(18)
					.addComponent(btnSubmit)
					.addGap(18)
					.addComponent(lblAttempt)
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	
	//////////////////////////////////////////////////////
	//This methods is responsible for creating events
	//////////////////////////////////////////////////////
	private void createEvents() {
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = loginTxtField.getText();
				String password = passwordTxtField.getText();
				Login l = new Login(username, password);
				LoginController lc = new LoginController();
				if(lc.isValid(l)) {
					lblAttempt.setText("Login Successful");
					final User user = new User();
					UserController uc = new UserController();
					uc.setUser(user, l);
					EventQueue.invokeLater(new Runnable() {
				        public void run() 
				        {
				        	UserInfoScreen userInfoScreen  = new UserInfoScreen(user);
				        	userInfoScreen.setVisible(true);
				        }
					});
					frame.dispose();
				}
				else
					lblAttempt.setText("Login Unsuccessful");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	CreateUserScreen createUserScreen = new CreateUserScreen();
			        	createUserScreen.setVisible(true);
			        }
				});
			}
		});
		
	}
}
