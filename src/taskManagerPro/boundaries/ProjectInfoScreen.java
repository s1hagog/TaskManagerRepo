package taskManagerPro.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import taskManagerPro.controllers.UserController;
import taskManagerPro.entities.User;

import javax.swing.JLabel;
import javax.swing.JList;

public class ProjectInfoScreen extends JFrame {

	private JPanel contentPane;
	public JList ProjectUserlist;
	public ArrayList<User> users;
	public User u;


	/**
	 * Create the frame.
	 */
	public ProjectInfoScreen(User user) {
		initComponents();
		u = user;
		createEvents();
		pupulateList();
	}
	
	public void pupulateList() {
		UserController uController = new UserController();
		// get the first project or wait for user to chose project
		//users = uController.getUsersFromProject(u.project);
	}
	public void createEvents() {
		ProjectUserlist.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Project Title");
		lblNewLabel.setBounds(51, 32, 64, 21);
		contentPane.add(lblNewLabel);
		
		ProjectUserlist = new JList();
		ProjectUserlist.setBounds(51, 88, 155, 230);
		contentPane.add(ProjectUserlist);
		
		JLabel lblProjectMembers = new JLabel("Project Members");
		lblProjectMembers.setBounds(51, 64, 89, 14);
		contentPane.add(lblProjectMembers);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(266, 89, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(266, 162, 64, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(266, 126, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(366, 89, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(366, 126, 99, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(366, 162, 82, 14);
		contentPane.add(lblNewLabel_4);
	}
}
