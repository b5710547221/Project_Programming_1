
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;

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
					Add_remove window = new Add_remove();
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
	public Add_remove() {
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
		Customer cus = new Customer();

		textField = new JTextField("name");

		textField.setBounds(309, 47, 224, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		if (!cus.getName().equals(null)) {
			textField.setText(cus.getName());
		} else {
            textField.setText("");
		}
		textField.setEditable(false);

		textField_1 = new JTextField("lastname");
		textField_1.setColumns(10);
		if (!cus.getLastName().equals(null)) {
			textField_1.setText(cus.getLastName());
		} else {
            textField.setText("");
		}
		
		textField_1.setEditable(false);
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
		rdbtnM.setBounds(309, 133, 53, 23);
		frame.getContentPane().add(rdbtnM);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("F");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(374, 134, 42, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JButton btnAddToDatabase = new JButton("add");
		btnAddToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("Add!");
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
			}
		});
		btnAddToDatabase.setIcon(new ImageIcon(Add_remove.class.getResource("/image/addBtn.jpg")));
		btnAddToDatabase.setBackground(Color.GREEN);
		btnAddToDatabase.setBounds(40, 232, 160, 52);
		frame.getContentPane().add(btnAddToDatabase);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer mem = new Customer();
				frame.setVisible(false);
				mem.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 370, 117, 25);
		frame.getContentPane().add(btnBack);

		JButton btnRemoveThisMember = new JButton("");
		btnRemoveThisMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog prompt2 = new JDialog();
				JLabel msg2 = new JLabel("Remove!");
				msg2.setBounds(50, 50, 80, 50);
				msg2.setSize(100, 30);
				prompt2.setVisible(true);
				prompt2.setContentPane(msg2);
				prompt2.setBounds(231, 50, 149, 23);
				prompt2.setSize(300, 300);
			}
		});
		btnRemoveThisMember.setIcon(new ImageIcon(Add_remove.class.getResource("/image/RemoveBtn.jpg")));
		btnRemoveThisMember.setBackground(Color.RED);
		btnRemoveThisMember.setBounds(296, 232, 160, 52);
		frame.getContentPane().add(btnRemoveThisMember);

		JButton btnSearchDatabase = new JButton("Search member");
		btnSearchDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				Human_resources human = new Human_resources();
				human.frame.setVisible(true);
			}
		});
		btnSearchDatabase.setBounds(400, 370, 133, 25);
		frame.getContentPane().add(btnSearchDatabase);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Add_remove.class.getResource("/image/AddBg.jpg")));
		label.setBounds(0, 0, 543, 406);
		frame.getContentPane().add(label);
	}
}
