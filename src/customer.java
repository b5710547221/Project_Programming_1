
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;

public class Customer {

	public JFrame frame;
	private static JTextField name;
	private static JTextField lastName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
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
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblFindByName = new JLabel("Name");
		lblFindByName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblFindByName.setBounds(366, 210, 53, 15);
		frame.getContentPane().add(lblFindByName);

		JLabel lblFindByLastname = new JLabel("Lastname");
		lblFindByLastname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblFindByLastname.setBounds(332, 253, 87, 15);
		frame.getContentPane().add(lblFindByLastname);

		name = new JTextField("name");
		name.setBounds(422, 208, 257, 19);
		name.setText("name");
		frame.getContentPane().add(name);
		name.setColumns(10);

		lastName = new JTextField("lastname");
		lastName.setBounds(422, 251, 257, 19);
		lastName.setText("lastname");
		frame.getContentPane().add(lastName);
		lastName.setColumns(10);

		JTextArea log = new JTextArea();
		log.setBackground(SystemColor.control);
		log.setEditable(false);
		log.setBounds(10, 253, 192, 205);
		frame.getContentPane().add(log);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(SystemColor.text);
		btnRegister.setIcon(new ImageIcon(Customer.class.getResource("/image/RegisBtn.jpg")));
		btnRegister.setBorderPainted(false);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

				Add_remove add = new Add_remove();
				add.frame.setVisible(true);
			}
		});
		btnRegister.setBounds(281, 294, 137, 50);
		frame.getContentPane().add(btnRegister);

		JLabel lblCustomerDatebase = new JLabel("Customer Database");
		lblCustomerDatebase.setFont(new Font("CordiaUPC", Font.BOLD, 27));
		lblCustomerDatebase.setBounds(10, 210, 344, 29);
		frame.getContentPane().add(lblCustomerDatebase);

		JButton btnUnregistered = new JButton("");
		btnUnregistered.setBackground(SystemColor.text);
		btnUnregistered.setIcon(new ImageIcon(Customer.class.getResource("/image/UnregisBtn.jpg")));
		btnUnregistered.setBorderPainted(false);
		btnUnregistered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

				Add_remove add = new Add_remove();
				add.frame.setVisible(true);
			}
		});
		btnUnregistered.setBounds(456, 294, 137, 50);
		frame.getContentPane().add(btnUnregistered);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Main main = new Main();
				main.frame.setVisible(true);
			}
		});
		btnBack.setBounds(612, 428, 67, 25);
		frame.getContentPane().add(btnBack);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Customer.class.getResource("/image/CustomerBanner.jpg")));
		bg.setBounds(0, 0, 774, 475);
		frame.getContentPane().add(bg);
	}

	public  static String getName() {
       return name.getText();
	}

	public  static String getLastName() {
       return lastName.getText();
	}
}
