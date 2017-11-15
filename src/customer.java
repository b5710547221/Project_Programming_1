

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

public class customer {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer window = new customer();
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
	public customer() {
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
		lblFindByName.setBounds(286, 210, 53, 15);
		frame.getContentPane().add(lblFindByName);
		
		JLabel lblFindByLastname = new JLabel("Lastname");
		lblFindByLastname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblFindByLastname.setBounds(257, 253, 131, 15);
		frame.getContentPane().add(lblFindByLastname);
		
		textField = new JTextField();
		textField.setBounds(349, 209, 257, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(349, 252, 257, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.control);
		textArea.setEditable(false);
		textArea.setBounds(10, 248, 192, 205);
		frame.getContentPane().add(textArea);
		
		JButton btnRegister = new JButton("");
		btnRegister.setBackground(SystemColor.text);
		btnRegister.setIcon(new ImageIcon(customer.class.getResource("/image/RegisBtn.jpg")));
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
		
		JLabel lblCustomerDatebase = new JLabel("Customer Datebase");
		lblCustomerDatebase.setFont(new Font("CordiaUPC", Font.BOLD, 27));
		lblCustomerDatebase.setBounds(10, 224, 192, 15);
		frame.getContentPane().add(lblCustomerDatebase);
		
		JButton btnUnregistered = new JButton("");
		btnUnregistered.setBackground(SystemColor.text);
		btnUnregistered.setIcon(new ImageIcon(customer.class.getResource("/image/UnregisBtn.jpg")));
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(customer.class.getResource("/image/CustomerBanner.jpg")));
		label.setBounds(0, 0, 774, 475);
		frame.getContentPane().add(label);
	}
}
