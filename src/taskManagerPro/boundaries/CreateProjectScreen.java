package taskManagerPro.boundaries;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import taskManagerPro.controllers.ProjectController;
import taskManagerPro.controllers.TaskController;
import taskManagerPro.controllers.UserController;
import taskManagerPro.entities.Manager;
import taskManagerPro.entities.Project;
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


public class CreateProjectScreen extends JFrame {
	
	private User user;
	private Manager m;
	private CreateProjectScreen frame = this;
	private Project p;
	private JButton btnCreateProject;
	private JTextField textTaskName;
	private JTextField textDueDate;
	private JTextArea textProjectDescription;
	private JLabel lblNewLabel;
	

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	
	
	public CreateProjectScreen(Manager m) {
		this.m = m;
		setTitle("Add New Project - TaskManagerPRO");
		initComponents();
		createEvents();
	}
	
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 395, 344);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCreateProject = new JButton("Create Project");
		
		lblNewLabel = new JLabel("PLEASE FILL THE FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblProjectName = new JLabel("Project Name:");
		
		textTaskName = new JTextField();
		textTaskName.setColumns(10);
		
		textDueDate = new JTextField();
		textDueDate.setColumns(10);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		
		JLabel lblProjectDescription = new JLabel("Project Description");
		
		textProjectDescription = new JTextArea();
		textProjectDescription.setWrapStyleWord(true);
		textProjectDescription.setLineWrap(true);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblProjectName, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textTaskName, 260, 260, 260)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProjectDescription, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textProjectDescription, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addComponent(btnCreateProject)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProjectName)
						.addComponent(textTaskName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addComponent(lblProjectDescription)
					.addGap(18)
					.addComponent(textProjectDescription, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCreateProject)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() {
		btnCreateProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//create new task object
				Project p = new Project();
				
				//set the values
				p.name = textTaskName.getText();
				p.description = textProjectDescription.getText();
				//send the new object to db
				
				ProjectController pc = new ProjectController();
				pc.createProject(m.email, p);
				
				EventQueue.invokeLater(new Runnable() {
			        public void run() 
			        {
			        	ManagerInfoScreen managerInfoScreen = new ManagerInfoScreen(m);
			        	managerInfoScreen.setVisible(true);
			        	frame.dispose();
			        }
				});
			}
		});
	}
	
}
