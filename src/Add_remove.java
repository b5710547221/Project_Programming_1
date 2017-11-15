

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Add_remove {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_remove  window = new Add_remove ();
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
	public Add_remove () {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(309, 47, 224, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(309, 77, 224, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(309, 107, 85, 19);
		frame.getContentPane().add(textField_2);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(247, 50, 70, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(229, 80, 133, 15);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(260, 110, 42, 15);
		frame.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(247, 131, 70, 30);
		frame.getContentPane().add(lblGender);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBackground(Color.WHITE);
		rdbtnM.setBounds(309, 133, 42, 23);
		frame.getContentPane().add(rdbtnM);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("F");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(352, 133, 42, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JButton btnAddToDatabase = new JButton("");
		btnAddToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddToDatabase.setIcon(new ImageIcon(Add_remove .class.getResource("/image/addBtn.jpg")));
		btnAddToDatabase.setBackground(Color.GREEN);
		btnAddToDatabase.setBounds(40, 232, 160, 52);
		frame.getContentPane().add(btnAddToDatabase);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			customer mem  = new customer();
			frame.setVisible(false);
			mem.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 370, 117, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnRemoveThisMember = new JButton("");
		btnRemoveThisMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveThisMember.setIcon(new ImageIcon(Add_remove .class.getResource("/image/RemoveBtn.jpg")));
		btnRemoveThisMember.setBackground(Color.RED);
		btnRemoveThisMember.setBounds(296, 232, 160, 52);
		frame.getContentPane().add(btnRemoveThisMember);
		
		JButton btnSearchDatabase = new JButton("Search member");
		btnSearchDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			frame.setVisible(false);	
			Human_resources human  = new Human_resources();
			human.frame.setVisible(true);
			}
		});
		btnSearchDatabase.setBounds(400, 370, 133, 25);
		frame.getContentPane().add(btnSearchDatabase);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Add_remove .class.getResource("/image/AddBg.jpg")));
		label.setBounds(0, 0, 543, 406);
		frame.getContentPane().add(label);
	}
}
