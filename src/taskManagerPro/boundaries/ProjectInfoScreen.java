package taskManagerPro.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import taskManagerPro.controllers.ProjectController;
import taskManagerPro.controllers.UserController;
import taskManagerPro.entities.Project;
import taskManagerPro.entities.User;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class ProjectInfoScreen extends JFrame {

	private JPanel contentPane;
	public JList ProjectUserlist;
	public ArrayList<User> users;
	public ArrayList<Project> projects;
	public User u;
	public JComboBox comboBox_projects;
	public JLabel projTilte;
	public JLabel txt_userName;
	public JLabel txt_UserDeparmetn;
	public JLabel txt_UserLastName;
	/**
	 * Create the frame.
	 */
	public ProjectInfoScreen(User user) {
		initComponents();
		u = user;
		createEvents();
		getProjects();
		
	}
	
	public void getProjects() {
		ProjectController pController = new ProjectController();
		// get the first project or wait for user to chose project
		projects = (ArrayList<Project>) pController.getProjects(u.email);
		for(Project proj : projects) {
			comboBox_projects.addItem(proj.name);
		}
		populateList(projects.get(0).name);
	}
	
	public void populateList(String projName) {
		
		ProjectController pController = new ProjectController();
		// get the first project or wait for user to chose project
		users = (ArrayList<User>) pController.getUsersFromProject(projName);
		ArrayList<String> userNames = new ArrayList<String>();
		for(User u:users) {
			userNames.add(u.first_name+ " " + u.last_name);
		}
		ProjectUserlist.setListData(userNames.toArray());
	}
	public void createEvents() {
		ProjectUserlist.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int index = ProjectUserlist.getSelectedIndex();
				User u = users.get(index);
				loadUserInfo(u);
			}
			
		});
		comboBox_projects.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int index = comboBox_projects.getSelectedIndex();
				System.out.print(index);
				populateList(projects.get(index).name);
			}
			
		});
	}
	
	public void loadUserInfo(User u) {
		txt_userName.setText(u.first_name);
		txt_UserLastName.setText(u.last_name);
		txt_UserDeparmetn.setText(u.dept_name);
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 projTilte = new JLabel("Project Title");
		 projTilte.setBounds(51, 32, 64, 21);
		contentPane.add(projTilte);
		
		ProjectUserlist = new JList();
		ProjectUserlist.setBounds(51, 88, 155, 230);
		contentPane.add(ProjectUserlist);
		
		JLabel lblProjectMembers = new JLabel("Project Members");
		lblProjectMembers.setBounds(51, 64, 89, 14);
		contentPane.add(lblProjectMembers);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(241, 89, 71, 14);
		contentPane.add(lblName);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(241, 162, 89, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(241, 126, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_userName = new JLabel("");
		txt_userName.setBounds(366, 89, 114, 14);
		contentPane.add(txt_userName);
		
		txt_UserLastName = new JLabel("");
		txt_UserLastName.setBounds(366, 126, 132, 14);
		contentPane.add(txt_UserLastName);
		
		txt_UserDeparmetn = new JLabel("");
		txt_UserDeparmetn.setBounds(366, 162, 132, 14);
		contentPane.add(txt_UserDeparmetn);
		
		comboBox_projects = new JComboBox();
		comboBox_projects.setBounds(178, 11, 114, 22);
		contentPane.add(comboBox_projects);
	}
}
