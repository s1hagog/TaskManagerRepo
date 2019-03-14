package taskManagerPro.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taskManagerPro.controllers.UserController;
import taskManagerPro.entities.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class EditUserScreen extends JFrame {
	private EditUserScreen frame = this;
	private User user;
	
	private JButton btnUpdateUser;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textEmail;
	private JTextField textPassword;
	private JTextField textDepartment;
	private JTextArea textDepartmentDescription;
	

	/**
	 * Create the frame.
	 */
	public EditUserScreen(User u) {
		this.user = u;
		setTitle("Edit " + u.first_name + " - TaskManagerPRO");
		initComponents();
		createEvents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 395, 465);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnUpdateUser = new JButton("Update User");
		
		JLabel lblNewLabel = new JLabel("Update " +  user.first_name + "'s Info");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		
		JLabel lblLastName = new JLabel("Last Name:");
		
		JLabel lblEmail = new JLabel("Email:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JLabel lblDepartment = new JLabel("Department:");
		
		textFirstName = new JTextField(user.first_name);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField(user.last_name);
		textLastName.setColumns(10);
		
		textEmail = new JTextField(user.email);
		textEmail.setColumns(10);
		
		textPassword = new JTextField(user.password);
		textPassword.setColumns(10);
		
		textDepartment = new JTextField(user.dept_name);
		textDepartment.setColumns(10);
		
		JLabel lblDepartmentDescription = new JLabel("Department Description:");
		
		textDepartmentDescription = new JTextArea(user.dept_desc);
		textDepartmentDescription.setWrapStyleWord(true);
		textDepartmentDescription.setLineWrap(true);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textDepartmentDescription, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDepartmentDescription, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(213, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblDepartment, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblLastName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textPassword)
								.addComponent(textEmail)
								.addComponent(textLastName)
								.addComponent(textFirstName)
								.addComponent(textDepartment, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addComponent(btnUpdateUser)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(textLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepartment)
						.addComponent(textDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblDepartmentDescription)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textDepartmentDescription, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnUpdateUser)
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() {
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//set the values to the current user
				user.first_name = textFirstName.getText();
				user.last_name = textLastName.getText();
				user.email = textEmail.getText();
				user.password = textPassword.getText();
				user.dept_name = textDepartment.getText();
				user.dept_desc = textDepartmentDescription.getText();
				
				//use controller to update it in db
				UserController uc = new UserController();
				uc.updateUser(user);
				
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	UserInfoScreen userInfoScreen = new UserInfoScreen(user);
			        	userInfoScreen.setVisible(true);
			        	frame.dispose();
			        }
				});
			}
		});
	}
}
