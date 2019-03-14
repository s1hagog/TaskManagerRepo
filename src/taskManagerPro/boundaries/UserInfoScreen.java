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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInfoScreen extends JFrame {

	private String userName;
	private User user;
	private JPanel contentPane;
	private JLabel lblUserLastName;
	private JLabel lblUserFirstName;
	private JLabel lblUserDepartment;
	private JLabel lblUserEmail;
	private JTextArea textAreaUserDeptDescription;
	private JButton btnShowTasks;
	private JButton btnEditInfo;
	private JButton btnDeleteUser;
	private UserInfoScreen frame = this;

	/**
	 * Create the frame.
	 */
	public UserInfoScreen(User u) {
		this.user = u;
		this.userName = u.first_name + " " + u.last_name;
		setTitle(userName + " - TaskManagerPRO");
		initComponents();
		createEvents();
	}
	
	
	//////////////////////////////////////////////////////
	//This methods is responsible for creating and
	//initializing components
	//////////////////////////////////////////////////////
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Hello " + user.first_name);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblUserFirstName = new JLabel(user.first_name);
		lblUserFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblUserLastName = new JLabel(user.last_name);
		lblUserLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblUserEmail = new JLabel(user.email);
		lblUserEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblUserDepartment = new JLabel(user.dept_name);
		lblUserDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textAreaUserDeptDescription = new JTextArea(user.dept_desc);
		textAreaUserDeptDescription.setWrapStyleWord(true);
		textAreaUserDeptDescription.setLineWrap(true);
		textAreaUserDeptDescription.setEditable(false);
		
		btnEditInfo = new JButton("Edit Info");
		
		
		btnShowTasks = new JButton("Show Tasks");
		
		btnDeleteUser = new JButton("Delete User");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblFirstName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblLastName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblDepartment, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUserLastName, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUserFirstName, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUserDepartment, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(textAreaUserDeptDescription, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
											.addComponent(lblUserEmail, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnEditInfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
								.addComponent(btnShowTasks, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
								.addComponent(btnDeleteUser))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(lblUserFirstName, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditInfo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserLastName, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserEmail, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepartment, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserDepartment, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShowTasks))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addComponent(textAreaUserDeptDescription, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(17, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteUser)
							.addGap(32))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//////////////////////////////////////////////////////
	//This methods is responsible for creating events
	//////////////////////////////////////////////////////
	private void createEvents() {
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserController uc = new UserController();
				uc.deleteUser(user.email);
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	MainLoginScreen mainLoginScreen  = new MainLoginScreen();
			        	mainLoginScreen.setVisible(true);
			        	frame.dispose();
			        }
				});
			}
		});
		
		btnShowTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	TasksInfoScreenNewDesign taskInfoScreen  = new TasksInfoScreenNewDesign(user);
			        	taskInfoScreen.setVisible(true);
			        	frame.dispose();
			        }
				});
				
			}
		});
		
		btnEditInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	EditUserScreen editUserScreen = new EditUserScreen(user);
			        	editUserScreen.setVisible(true);
			        	frame.dispose();
			        }
				});
			}
		});
	}
}
