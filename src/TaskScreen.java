import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.List;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;



public class TaskScreen extends JFrame{

	private JFrame frame;
	public MongoDemo mongodb;
	private int user_id;

	//for user information
	public int int_userID;
	public List list_toDo ;
	private JButton btnRemoveTask;
	private List list_inProgress;
	private List list_Completed;
	private JLabel lblCompleted;
	private JLabel lblInProgress;
	private JLabel lblToDo;
	private JTextField txt_TaskName;
	private JTextField txt_progLanguage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskScreen window = new TaskScreen();
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
	public TaskScreen() {
		initialize();

	}
	public TaskScreen(int id) {
		user_id = id;
		mongodb = new MongoDemo();
		initialize();		
		populateTaskList();
	}


	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Task Screen");
		frame.setBounds(100, 100, 684, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		list_toDo = new List();
		list_toDo.setFont(new Font("Arial", Font.PLAIN, 13));
		list_toDo.setBounds(22, 108, 168, 154);
		frame.getContentPane().add(list_toDo);
		
		initializeLbls_buttons();
		
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//make visible textboxs for user create new task
				
			}
		});
		btnAddTask.setBounds(391, 39, 89, 23);
		frame.getContentPane().add(btnAddTask);
		
		txt_TaskName = new JTextField();
		txt_TaskName.setBounds(51, 289, 96, 20);
		frame.getContentPane().add(txt_TaskName);
		txt_TaskName.setColumns(10);
		
		JTextPane txtP_description = new JTextPane();
		txtP_description.setBounds(49, 320, 221, 80);
		frame.getContentPane().add(txtP_description);
		
		JComboBox comboBox_status = new JComboBox();
		comboBox_status.setBounds(330, 323, 28, 22);
		frame.getContentPane().add(comboBox_status);
		
		txt_progLanguage = new JTextField();
		txt_progLanguage.setBounds(184, 289, 96, 20);
		frame.getContentPane().add(txt_progLanguage);
		txt_progLanguage.setColumns(10);
		
	}
	
	public void initializeLbls_buttons() {
		btnRemoveTask = new JButton("Remove Task");
		btnRemoveTask.setBounds(141, 39, 129, 23);
		frame.getContentPane().add(btnRemoveTask);
		
		list_inProgress = new List();
		list_inProgress.setBounds(255, 108, 168, 154);
		frame.getContentPane().add(list_inProgress);
		
		list_Completed = new List();
		list_Completed.setBounds(478, 108, 168, 154);
		frame.getContentPane().add(list_Completed);
		
		lblCompleted = new JLabel("Completed");
		lblCompleted.setBounds(499, 78, 79, 14);
		frame.getContentPane().add(lblCompleted);
		
		lblInProgress = new JLabel("In Progress");
		lblInProgress.setBounds(311, 78, 62, 14);
		frame.getContentPane().add(lblInProgress);
		
		lblToDo = new JLabel("To Do");
		lblToDo.setBounds(73, 78, 48, 14);
		frame.getContentPane().add(lblToDo);
	}
	public void populateTaskList() {
		java.util.List<org.bson.Document> u_task=  mongodb.getUserTaskData(user_id);
		for (org.bson.Document doc : u_task) {
			// chech the status of the task and place it in the correct list
			if(doc.get("status").toString().equals("To do") ) {
				list_toDo.add(doc.get("name").toString());
			}else if(doc.get("status").toString().equals("In Progress")) {
				list_inProgress.add(doc.get("name").toString());
			}else if(doc.get("status").toString().equals("Completed")) {
				list_Completed.add(doc.get("name").toString());
			}
			
			System.out.print(doc.get("status").toString());
        }
		
	}
}
