import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.text.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UserInformationScreen  {
	//region variables
	private JFrame frame;
	public JPanel panel;
	public JLabel lblUserInformation;
	public JButton btn_EditUserInformation ;
	public JButton btnSubmit;
	//labels not to be modified
	public JLabel lbl_name;
	public JLabel lbl_LastName ;
	public JLabel lbl_Department;
	//labesl for displaying user information
	public JLabel lbl_UserName;
	public JLabel lbl_UserLastName;
	public JLabel lbl_UserDepartment;
	//Mongo Db 
	public MongoCollection collection;
	public MongoDemo mongodb;
	private JTextField textField_FName;
	private JTextField textField_LName;
	private JTextField textField_Department;
	private JButton btnViewTask;
	private JButton button;
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
		frame.setSize(600,400);
		frame.getContentPane().setLayout(null);

		initializeOtherComponents();
		initializeLabels();
		setTextBoxesComponentsVisible(false);
		//retrieve information from user 
		getUserInformation();
	}
	
	public void getUserInformation() {
		collection =  mongodb.getMongoCollection("UserData");

		List userInformation = mongodb.getUserBasicData(1);
		//fill the text boxes with the desired information
		System.out.print(userInformation.toString());
		lbl_UserName.setText(userInformation.get(0).toString());
		lbl_UserLastName.setText(userInformation.get(1).toString());
		lbl_UserDepartment.setText(userInformation.get(2).toString() + " department");
	}
	
	public void initializeLabels(){
		
		//labels ui
		lbl_name = new JLabel("First Name");
		lbl_name.setBounds(35, 42, 68, 22);
		panel.add(lbl_name);
		
		lbl_LastName = new JLabel("Last Name");
		lbl_LastName.setBounds(35, 104, 68, 38);
		panel.add(lbl_LastName);
		
		lbl_Department = new JLabel("Department");
		lbl_Department.setBounds(35, 176, 68, 23);
		panel.add(lbl_Department);
		
		//for displaying user information
		lbl_UserName = new JLabel("New label");
		lbl_UserName.setBounds(164, 46, 111, 18);
		panel.add(lbl_UserName);
		
		lbl_UserLastName = new JLabel("New label");
		lbl_UserLastName.setBounds(164, 114, 111, 18);
		panel.add(lbl_UserLastName);
		
		lbl_UserDepartment = new JLabel("New label");
		lbl_UserDepartment.setBounds(166, 176, 97, 23);
		panel.add(lbl_UserDepartment);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check if texbox is not empty
				if(textBoxesVerification()) {
					System.out.print("true");
					//get values from textboxes into labels
					setLabelUpdatedText(textField_FName.getText(),textField_LName.getText(),textField_Department.getText());
					setLabelComponentsVisible(true);
					setTextBoxesComponentsVisible(false);
					btnSubmit.setVisible(false);
					btn_EditUserInformation.setVisible(true);
					// uptdate datbase with values
					updateDatabse();
					
				}else {
					JOptionPane.showMessageDialog(null, "all fields must be completeed");
					System.out.print("false");
				}				
			}
		});
		btnSubmit.setBounds(174, 244, 89, 23);
		panel.add(btnSubmit);
		btnSubmit.setVisible(false);
		


	}
	
	public void updateDatabse() {
		collection.updateOne(eq("id", 1), new org.bson.Document("$set", new org.bson.Document("first_name", textField_FName.getText())));
		collection.updateOne(eq("id", 1), new org.bson.Document("$set", new org.bson.Document("last_name", textField_LName.getText())));
		collection.updateOne(eq("id", 1), new org.bson.Document("$set", new org.bson.Document("department.name", textField_Department.getText())));
	}
	
	public boolean textBoxesVerification() {
		if( !textField_FName.getText().isEmpty() ) {
			if(!textField_LName.getText().isEmpty() ) {
				if(!textField_Department.getText().isEmpty() ) {
					return true;
				}
			}
		}
		return false;
	}
	public void setLabelUpdatedText(String name, String lastName, String department) {
		lbl_UserName.setText(name);
		lbl_UserLastName.setText(lastName);
		lbl_UserDepartment.setText(department);
	}
	
	public void initializeOtherComponents() {
		lblUserInformation = new JLabel("User Information");
		lblUserInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserInformation.setBounds(232, 11, 128, 31);
		frame.getContentPane().add(lblUserInformation);
		
		panel = new JPanel();
		panel.setBounds(134, 53, 305, 278);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_FName = new JTextField();
		textField_FName.setBounds(164, 43, 96, 20);
		panel.add(textField_FName);
		textField_FName.setColumns(10);

		
		textField_LName = new JTextField();
		textField_LName.setBounds(164, 113, 96, 20);
		panel.add(textField_LName);
		textField_LName.setColumns(10);
		
		textField_Department = new JTextField();
		textField_Department.setBounds(164, 177, 96, 20);
		panel.add(textField_Department);
		textField_Department.setColumns(10);
		
		
		btn_EditUserInformation = new JButton("Edit information");
		btn_EditUserInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// handle new window creation here
				setLabelComponentsVisible(false);
				setTextBoxesComponentsVisible(true);
				btnSubmit.setVisible(true);
				btn_EditUserInformation.setVisible(false);
			}
		});
		
		
		btn_EditUserInformation.setBounds(164, 219, 111, 23);
		panel.add(btn_EditUserInformation);
		
		btnViewTask = new JButton("View Task");
		btnViewTask.setBounds(10, 82, 89, 23);
		frame.getContentPane().add(btnViewTask);
		
		button = new JButton("New button");
		button.setBounds(10, 152, 89, 23);
		frame.getContentPane().add(button);
	
	
		//task button should open an new page and close previouse one, interface needed for handling all screens
		btnViewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// handle new window creation here
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			           //inititate third screen and set make second screen invisible
			        	TaskScreen tasks = new TaskScreen(1);

			        	frame.setVisible(false);
			        	frame.dispose();
			        }
				});
			}
		});
	}

	public void setLabelComponentsVisible(boolean bool) {
		lbl_UserName.setVisible(bool);
		lbl_UserLastName.setVisible(bool);
		lbl_UserDepartment.setVisible(bool);
	}
	
	public void setTextBoxesComponentsVisible(boolean bool) {
		textField_FName.setVisible(bool);
		textField_LName.setVisible(bool);
		textField_Department.setVisible(bool);
	}
}
