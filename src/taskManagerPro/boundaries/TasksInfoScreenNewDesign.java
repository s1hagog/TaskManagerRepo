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

public class TasksInfoScreenNewDesign extends JFrame {

	private JPanel contentPane;
	private JList listTasks;
	private JTextArea taskDescTextArea;
	private JTextArea startDateTextArea;
	private JTextArea endDateTextArea;
	
	
	private User u;
	private ArrayList<Task> tasks;
	private JList listTaskStatus;
	private JButton btnUpdateStatus;
	private JButton btnDeleteTask;
	

	/**
	 * Create the frame.
	 */
	public TasksInfoScreenNewDesign(User u) {
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

		listTasks = new JList();
		
		listTasks.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listTasks.setSelectedIndex(0);
		
		JLabel lblToDo = new JLabel("TASKS LIST");
		lblToDo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblToDo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTaskDescription = new JLabel("TASK DESCRIPTION");
		lblTaskDescription.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		taskDescTextArea = new JTextArea();
		taskDescTextArea.setWrapStyleWord(true);
		taskDescTextArea.setLineWrap(true);
		
		JLabel lblDateAssigned = new JLabel("Date Assigned:");
		
		JLabel lblTaskDeadline = new JLabel("Task Deadline:");
		
		startDateTextArea = new JTextArea();
		
		endDateTextArea = new JTextArea();
		
		btnDeleteTask = new JButton("Delete Task");
		
		
		JButton btnEditTask = new JButton("Edit Task");
		
		listTaskStatus = new JList();
		listTaskStatus.setVisibleRowCount(3);
		listTaskStatus.setModel(new AbstractListModel() {
			String[] values = new String[] {"To do", "In progress", "Completed"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblNewLabel = new JLabel("TASK STATUS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnUpdateStatus = new JButton("Update Status");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(lblToDo, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(151)
					.addComponent(lblTaskDescription, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(361, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(listTaskStatus, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
						.addComponent(listTasks, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
					.addGap(88)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(taskDescTextArea, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDateAssigned, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTaskDeadline))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(endDateTextArea, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addComponent(startDateTextArea, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnEditTask)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnDeleteTask)))
							.addGap(84))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnUpdateStatus)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel)
					.addContainerGap(612, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToDo)
						.addComponent(lblTaskDescription))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(taskDescTextArea, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(startDateTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDateAssigned)
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTaskDeadline)
										.addComponent(endDateTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDeleteTask)
								.addComponent(btnEditTask)))
						.addComponent(listTasks, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(listTaskStatus))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addComponent(btnUpdateStatus)))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
		loadTasksLists();
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		listTasks.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = listTasks.getSelectedIndex();
				Task task = tasks.get(index);
				loadTaskInfo(task);
			}
		});
		
		btnUpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get new status from UI
				String s = (String)listTaskStatus.getSelectedValue();
				
				//assign it to current task
				int index = listTasks.getSelectedIndex();
				Task task = tasks.get(index);
				task.status = s;
				
				//update the task in the database
				TaskController tc = new TaskController();
				tc.setTaskStatus(u.email, task.name, task.status);
			}
		});
		btnDeleteTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listTasks.getSelectedIndex();
				Task task = tasks.get(index);
				
				TaskController tc = new TaskController();
				tc.deleteTask(u.email, task.name);
				
			}
		});
		
	}
	
	private void loadTasksLists() {

		//Loading tasks into the frame
		TaskController tc = new TaskController();
		tasks = (ArrayList<Task>)tc.getTasks(u.email);
		
		//now lets put the created lists into the JLists	
		listTasks.setListData(tasks.toArray());
	}
	
	private void loadTaskInfo(Task task) {
		taskDescTextArea.setText(task.description);
		startDateTextArea.setText(task.start_date.toString());
		endDateTextArea.setText(task.end_date.toString());
		listTaskStatus.setSelectedIndex(task.convertStatusToInteger());
	}
}
