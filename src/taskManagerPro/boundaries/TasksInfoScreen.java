package taskManagerPro.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taskManagerPro.controllers.TaskController;
import taskManagerPro.entities.Task;
import taskManagerPro.entities.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TasksInfoScreen extends JFrame {

	private JPanel contentPane;
	private JList taskToDoList;
	private JList taskInProgressList;
	private JList taskCompleteList;
	private JTextArea taskDescTextArea;
	private JTextArea startDateTextArea;
	private JTextArea endDateTextArea;
	private JButton btnToDo_InProgress;
	private JButton btnInProgress_ToDo;
	private JButton btnInProgress_Completed;
	private JButton btnCompleted_InProgress;
	
	
	private User u;
	private ArrayList<Task> tasks;
	private List<Task> tasksToDo = new ArrayList<Task>();
	private List<Task> tasksInProgress = new ArrayList<Task>();
	private List<Task> tasksCompleted = new ArrayList<Task>();

	/**
	 * Create the frame.
	 */
	public TasksInfoScreen(User u) {
		this.u = u;
		setResizable(false);
		setTitle("Tasks - TaskManagerPRO");
		initComponents();
		createEvents();
		
	}
	
	
	
	//////////////////////////////////////////////////////
	//This methods is responsible for creating and
	//initializing components
	//////////////////////////////////////////////////////
	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		taskToDoList = new JList();
		
		taskToDoList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		taskToDoList.setSelectedIndex(0);
		
		taskInProgressList = new JList();
		
		
		taskCompleteList = new JList();
		
		taskCompleteList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblToDo = new JLabel("TO DO:");
		lblToDo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblToDo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblInProgress = new JLabel("IN PROGRESS:");
		lblInProgress.setHorizontalAlignment(SwingConstants.CENTER);
		lblInProgress.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblCompleted = new JLabel("COMPLETED:");
		lblCompleted.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompleted.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblTaskDescription = new JLabel("Task Description:");
		
		taskDescTextArea = new JTextArea();
		taskDescTextArea.setWrapStyleWord(true);
		taskDescTextArea.setLineWrap(true);
		
		JLabel lblDateAssigned = new JLabel("Date Assigned:");
		
		JLabel lblTaskDeadline = new JLabel("Task Deadline:");
		
		startDateTextArea = new JTextArea();
		
		endDateTextArea = new JTextArea();
		
		btnToDo_InProgress = new JButton("-->");
		
		
		btnInProgress_ToDo = new JButton("<--");
		
		btnInProgress_Completed = new JButton("-->");
		
		btnCompleted_InProgress = new JButton("<--");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addComponent(lblToDo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(215)
					.addComponent(lblInProgress, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
					.addComponent(lblCompleted, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(91))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(taskToDoList, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(btnToDo_InProgress, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnInProgress_ToDo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(taskInProgressList, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInProgress_Completed, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnCompleted_InProgress, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(taskCompleteList, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTaskDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(taskDescTextArea, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTaskDeadline, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblDateAssigned, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(startDateTextArea, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(endDateTextArea, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addGap(255))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblToDo)
								.addComponent(lblInProgress)
								.addComponent(lblCompleted))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(taskToDoList, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(taskInProgressList, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(taskCompleteList, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(btnToDo_InProgress)
							.addGap(41)
							.addComponent(btnInProgress_ToDo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(btnInProgress_Completed)
							.addGap(43)
							.addComponent(btnCompleted_InProgress)))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskDescription)
						.addComponent(taskDescTextArea, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDateAssigned)
								.addComponent(startDateTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTaskDeadline)
								.addComponent(endDateTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(231, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
		loadTasksLists();
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		taskToDoList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = taskToDoList.getSelectedIndex();
				Task task = tasksToDo.get(index);
				loadTaskInfo(task);
			}
		});
		
		taskInProgressList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = taskInProgressList.getSelectedIndex();
				Task task = tasksInProgress.get(index);
				loadTaskInfo(task);
			}
		});
		
		taskCompleteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = taskCompleteList.getSelectedIndex();
				Task task = tasksCompleted.get(index);
				loadTaskInfo(task);
			}
		});
		
//		btnToDo_InProgress.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//Get selected task
//				int index = taskToDoList.getSelectedIndex();
//				Task task = tasksToDo.get(index);
//				//Change its status
//				task.status = "In progress";
//				//Send the change task controller
//				
//				//Update the frame to show the changes
//				
//				
//			}
//		});
	}
	
	private void loadTasksLists() {

		//Loading tasks into the frame
		TaskController tc = new TaskController();
		tasks = (ArrayList<Task>)tc.getTasks(u.email);
		//Now we need to sort them according to the status.
		//Lets create 3 array which will represent different status of tasks
		
		for(Task task : tasks) {
			switch(task.convertStatusToInteger()) {
				case 0:
					tasksToDo.add(task);
					break;
				case 1:
					tasksInProgress.add(task);
					break;
				case 2:
					tasksCompleted.add(task);
					break;
			}
		}

		//now lets put the created lists into the JLists	
		taskToDoList.setListData(tasksToDo.toArray());
		taskInProgressList.setListData(tasksInProgress.toArray());
		taskCompleteList.setListData(tasksCompleted.toArray());
	}
	
	private void loadTaskInfo(Task task) {
		taskDescTextArea.setText(task.description);
		startDateTextArea.setText(task.start_date.toString());
		endDateTextArea.setText(task.end_date.toString());
	}
}
