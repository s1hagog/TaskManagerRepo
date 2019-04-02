package taskManagerPro.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taskManagerPro.controllers.ManagerController;
import taskManagerPro.controllers.ProjectController;
import taskManagerPro.controllers.TaskController;
import taskManagerPro.entities.Manager;
import taskManagerPro.entities.Project;
import taskManagerPro.entities.Task;
import taskManagerPro.entities.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManagerInfoScreen extends JFrame {

	private JPanel contentPane;
	private JList listAllUsers;
	private JButton btnCheckTasks;
	private JButton btnCheckProjects;
	private JList listProjects;
	private JList listTasks;
	private JButton btnAssignProject;
	private JButton btnUnassignProject;
	private JButton btnAssignTask;
	private JButton btnUnassignTask;
	private JList listAllProjects;
	private JList listUsers;
	private JLabel lblUsers;
	private JList listTasksForProject;
	private JLabel lblTasks_1;
	private JButton btnCheckUsersFor;
	private JButton btnCheckTasksFor;
	private JButton btnAddUser;
	private JButton btnRemoveUser;
	private JButton btnAddTask;
	private JButton btnRemoveTask;
	
	private Manager manager = new Manager();
	private List<User> users;
	private List<Task> tasks;
	private List<Project> projects;
	private ManagerInfoScreen frame = this;
	private JButton btnReset;
	private JButton btnCreateProject;
	

	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	public ManagerInfoScreen(Manager u) {
		setTitle(manager.first_name + " " + manager.last_name + " - TaskManagerPRO");
		manager = u;
		initComponents();
		createEvents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		listAllUsers = new JList();
		
		//load users into array
		ManagerController mc = new ManagerController();
		users = mc.getUsers(manager);
		listAllUsers.setListData(users.toArray());
		
		JLabel lblTitle = new JLabel("Hello " + manager.first_name);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblAllUsers = new JLabel("All Users");
		
		btnCheckTasks = new JButton("Check User Tasks");
		
		
		btnCheckProjects = new JButton("Check User Projects");
		
		
		listProjects = new JList();
		
		JLabel lblProjects = new JLabel("Projects");
		
		listTasks = new JList();
		
		JLabel lblTasks = new JLabel("Tasks");
		
		btnAssignProject = new JButton("Assign Project");
		
		
		btnUnassignProject = new JButton("Unassign Project");
		
		
		btnAssignTask = new JButton("Assign Task");
		
		btnUnassignTask = new JButton("Unassign Task\r\n");
		
		listAllProjects = new JList();
		
		//load project into screen
		
		projects = mc.getProjects(manager);
		listAllProjects.setListData(projects.toArray());
		
		JLabel lblNewLabel = new JLabel("Projects");
		
		listUsers = new JList();
		
		lblUsers = new JLabel("Users");
		
		listTasksForProject = new JList();
		
		lblTasks_1 = new JLabel("Tasks");
		
		btnCheckUsersFor = new JButton("Check Users for Project");
		
		
		btnCheckTasksFor = new JButton("Check Tasks for Project");
		
		
		btnAddUser = new JButton("Add User");
		
		
		btnRemoveUser = new JButton("Remove user");
		
		btnAddTask = new JButton("Add Task");
		
		
		btnRemoveTask = new JButton("Remove Task");
		
		btnReset = new JButton("RESET");
		
		btnCreateProject = new JButton("Create Project");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(listAllProjects, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(listAllUsers, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCheckTasks, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
								.addComponent(btnCheckProjects, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
								.addComponent(btnCheckUsersFor, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
								.addComponent(btnCheckTasksFor, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
								.addComponent(btnReset)
								.addComponent(btnCreateProject))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(listUsers, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
								.addComponent(listProjects, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAssignProject, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
										.addComponent(btnUnassignProject)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnAddUser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnRemoveUser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(listTasksForProject, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(listTasks, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRemoveTask)
								.addComponent(btnAddTask)
								.addComponent(btnAssignTask)
								.addComponent(btnUnassignTask))))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addComponent(lblAllUsers, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
					.addComponent(lblProjects)
					.addGap(280)
					.addComponent(lblTasks, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(164))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(312)
					.addComponent(lblUsers, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
					.addComponent(lblTasks_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(162))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAllUsers)
								.addComponent(lblProjects)
								.addComponent(lblTasks))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(listAllUsers, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(listProjects, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(listTasks, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(btnAssignProject)
							.addGap(42)
							.addComponent(btnUnassignProject))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addComponent(btnAssignTask)
							.addGap(46)
							.addComponent(btnUnassignTask))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(99)
							.addComponent(btnCheckTasks)
							.addGap(39)
							.addComponent(btnCheckProjects)
							.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(btnAddUser)
							.addGap(18)
							.addComponent(btnRemoveUser))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(btnAddTask)
							.addGap(28)
							.addComponent(btnRemoveTask))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(71)
								.addComponent(btnCheckUsersFor)
								.addGap(81)
								.addComponent(btnCheckTasksFor)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCreateProject))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(29)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel)
									.addComponent(lblUsers)
									.addComponent(lblTasks_1))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(listUsers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(listTasksForProject, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
									.addComponent(listAllProjects, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))))
					.addGap(105))
		);
		contentPane.setLayout(gl_contentPane);
//		listProjects.setEnabled(false);
//		listTasks.setEnabled(false);
//		listTasksForProject.setEnabled(false);
//		listUsers.setEnabled(false);
//		
//		btnAddTask.setEnabled(false);
//		btnAddUser.setEnabled(false);
//		btnAssignProject.setEnabled(false);
//		btnAssignTask.setEnabled(false);
//		btnRemoveTask.setEnabled(false);
//		btnRemoveUser.setEnabled(false);
//		btnUnassignProject.setEnabled(false);
//		btnUnassignTask.setEnabled(false);
	}
	
	private void createEvents() {
		
		btnCheckTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listAllUsers.setEnabled(false);
				listTasks.setEnabled(true);
				btnAssignTask.setEnabled(true);
				btnUnassignTask.setEnabled(true);
				TaskController tc = new TaskController();
				User user = (User) listAllUsers.getSelectedValue();
				tasks = tc.getTasks(user.email);

				listTasks.setListData(tasks.toArray());
				
			}
		});
		
		btnCheckProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listAllUsers.setEnabled(false);
				listProjects.setEnabled(true);
				btnUnassignProject.setEnabled(true);
				btnAssignProject.setEnabled(true);
				ProjectController pc = new ProjectController();
				User user = (User) listAllUsers.getSelectedValue();
				projects = pc.getProjects(user.email);
				listProjects.setListData(projects.toArray());
			}
		});
		
		btnCheckUsersFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectController pc = new ProjectController();
				Project project = (Project)listAllProjects.getSelectedValue();
				users = pc.getUsersFromProject(project.name);
				listUsers.setListData(users.toArray());
			}
		});
		
		btnCheckTasksFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project project = (Project)listAllProjects.getSelectedValue();
				TaskController tc = new TaskController();
			
				tasks = tc.getTasks(manager.email, project);
				
				listTasksForProject.setListData(tasks.toArray());
			}
		});
		
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Project project = (Project)listAllProjects.getSelectedValue();
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	CreateNewTask createNewTask = new CreateNewTask(project, manager);
			        	createNewTask.setVisible(true);
			        	frame.dispose();
			        }
				});
			}
		});
		
		
		btnAssignProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = (User)listAllUsers.getSelectedValue();
				Project p = (Project)listAllProjects.getSelectedValue();
				ManagerController mc = new ManagerController();
				mc.assignUserToProject(u, p);
			}
		});
		
		btnAssignTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = (User)listAllUsers.getSelectedValue();
				Task t = (Task)listTasksForProject.getSelectedValue();
				ManagerController mc = new ManagerController();
				mc.assignTaskToUser(u, t);
			}
		});
		
		btnUnassignProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = (User)listAllUsers.getSelectedValue();
				Project p = (Project)listAllProjects.getSelectedValue();
				ManagerController mc = new ManagerController();
				mc.unassignProject(u.email, p.name);
			}
		});
		
		btnUnassignTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerController mc = new ManagerController();
				User u = (User)listAllUsers.getSelectedValue();
				Task t = (Task)listTasks.getSelectedValue();
				
				mc.unassignTask(u.email, t.name);
				
			}
		});
		
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = (User)listAllUsers.getSelectedValue();
				Project p = (Project)listAllProjects.getSelectedValue();
				ManagerController mc = new ManagerController();
				mc.assignUserToProject(u, p);
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List l = new ArrayList();
				listAllUsers.setEnabled(true);
				listProjects.setListData(l.toArray());
				listTasks.setListData(l.toArray());
				
			}
		});
		
		btnCreateProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	CreateProjectScreen createProjectScreen = new CreateProjectScreen(manager);
			        	createProjectScreen.setVisible(true);
			        	frame.dispose();
			        }
				});
			}
		});
	}
}
