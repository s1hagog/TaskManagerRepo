import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.text.Document;

import com.mongodb.client.MongoCollection;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;

public class UserInformationScreen  {
	//region variables
	private JFrame frame;
	public JPanel panel;
	public JLabel lblUserInformation;
	public JButton btn_EditUserInformation ;
	//labels not to be modified
	public JLabel lbl_name;
	public JLabel lbl_Project ;
	public JLabel lbl_Task;
	public JLabel lbl_Department;
	//labesl for displaying user information
	public JLabel lbl_UserName;
	public JLabel lbl_UserProject;
	public JLabel lbl_UserTask;
	public JLabel lbl_UserDepartment;
	//Mongo Db 
	public MongoDemo mongodb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInformationScreen window = new UserInformationScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInformationScreen() {
		mongodb = new MongoDemo();
		mongodb.dbConnection();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("UserInformation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(800,600);
		frame.getContentPane().setLayout(null);

		initializeOtherComponents();
		initializeLabels();
		
		//retrieve information from user 
		getUserInformation();
	}
	
	public void getUserInformation() {
		MongoCollection<Document> collection =  mongodb.getMongoCollection("UserData");
		Document query = collection.find().first();
		//System.out.println(query.toJson());
	}
	
	public void initializeLabels(){
		
		//labels ui
		lbl_name = new JLabel("User Name");
		lbl_name.setBounds(35, 42, 68, 22);
		panel.add(lbl_name);
		
		lbl_Project = new JLabel("<html>Project <br>\r\n Working on</html>");
		lbl_Project.setBounds(35, 85, 68, 38);
		panel.add(lbl_Project);
		
		lbl_Task = new JLabel("Tasks");
		lbl_Task.setBounds(35, 139, 48, 14);
		panel.add(lbl_Task);
		
		lbl_Department = new JLabel("Department");
		lbl_Department.setBounds(35, 176, 48, 14);
		panel.add(lbl_Department);
		
		//for displaying user information
		lbl_UserName = new JLabel("New label");
		lbl_UserName.setBounds(164, 46, 48, 14);
		panel.add(lbl_UserName);
		
		lbl_UserProject = new JLabel("New label");
		lbl_UserProject.setBounds(164, 101, 48, 14);
		panel.add(lbl_UserProject);
		
		lbl_UserTask = new JLabel("New label");
		lbl_UserTask.setBounds(164, 139, 48, 14);
		panel.add(lbl_UserTask);
		
		lbl_UserDepartment = new JLabel("New label");
		lbl_UserDepartment.setBounds(164, 176, 48, 14);
		panel.add(lbl_UserDepartment);

	}
	
	public void initializeOtherComponents() {
		lblUserInformation = new JLabel("User Information");
		lblUserInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserInformation.setBounds(332, 56, 128, 31);
		frame.getContentPane().add(lblUserInformation);
		
		panel = new JPanel();
		panel.setBounds(245, 135, 305, 278);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btn_EditUserInformation = new JButton("Edit information");
		btn_EditUserInformation.setBounds(164, 219, 111, 23);
		panel.add(btn_EditUserInformation);
	}
	

}
