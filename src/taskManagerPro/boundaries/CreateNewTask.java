package taskManagerPro.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import taskManagerPro.controllers.TaskController;
import taskManagerPro.controllers.UserController;
import taskManagerPro.entities.Task;
import taskManagerPro.entities.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class CreateNewTask extends JFrame {
	
	private User user;
	private CreateNewTask frame = this;
	
	private JButton btnCreateTask;
	private JTextField textTaskName;
	private JTextField textDueDate;
	private JDatePickerImpl datePicker;
	private JTextArea textTaskDescription;
	private User u;
	

	/**
	 * Create the frame.
	 */
	
	
	public CreateNewTask(User u) {
		this.user = u;
		setTitle("Add New Task - TaskManagerPRO");
		initComponents();
		createEvents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 395, 344);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCreateTask = new JButton("Create Task");
		
		JLabel lblNewLabel = new JLabel("PLEASE FILL THE FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTaskName = new JLabel("Task Name:");
		
		JLabel lblLastName = new JLabel("Due Date:");
		
		textTaskName = new JTextField();
		textTaskName.setColumns(10);
		
		textDueDate = new JTextField();
		textDueDate.setColumns(10);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		
		JLabel lblTaskDescription = new JLabel("Task Description");
		
		textTaskDescription = new JTextArea();
		textTaskDescription.setWrapStyleWord(true);
		textTaskDescription.setLineWrap(true);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblLastName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTaskName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(datePicker, 260, 260, 260)
								.addComponent(textTaskName, 260, 260, 260))
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTaskDescription, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textTaskDescription, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addComponent(btnCreateTask)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskName)
						.addComponent(textTaskName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblTaskDescription)
					.addGap(18)
					.addComponent(textTaskDescription, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCreateTask)
					.addContainerGap(138, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() {
		btnCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create new task object
				Task task = new Task();
				
				//set the values
				task.name = textTaskName.getText();
				task.end_date = retrieveDate();
				task.start_date = new Date();
				task.description = textTaskDescription.getText();
				//send the new object to db
				
				TaskController tc = new TaskController();
				tc.createTask(user.email, task);
				
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	TasksInfoScreenNewDesign tasksInfoScreen = new TasksInfoScreenNewDesign(user);
			        	tasksInfoScreen.setVisible(true);
			        	frame.dispose();
			        }
				});
			}
		});
	}
	
	private Date retrieveDate() {
		String s_date = datePicker.getJFormattedTextField().getText();
		DateFormat format = new SimpleDateFormat("MMM. d, yyyy", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(s_date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return date;
	}
}
