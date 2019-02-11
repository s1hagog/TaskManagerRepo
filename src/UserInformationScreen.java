import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;

public class UserInformationScreen  {

	private JFrame frame;
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
		
		JLabel lblUserInformation = new JLabel("User Information");
		lblUserInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserInformation.setBounds(332, 56, 128, 31);
		frame.getContentPane().add(lblUserInformation);
		
		JList list = new JList();
		list.setBounds(223, 122, 328, 265);
		frame.getContentPane().add(list);

	}
}
