

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Human_resources {

    public JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Human_resources window = new Human_resources();
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
	public Human_resources() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 535, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearchMemberBy = new JLabel("Search member by");
		lblSearchMemberBy.setBounds(106, 150, 176, 15);
		frame.getContentPane().add(lblSearchMemberBy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Name");
		comboBox.addItem("Lastname");
		comboBox.addItem("Gender");
		comboBox.addItem("Age");
		comboBox.setBounds(270, 145, 176, 24);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(270, 187, 176, 24);
		switch(comboBox.getSelectedIndex()){
		case 0:{
			
			break;
		}
		case 1:{
			break;
		}
		case 2:{
			break;
		}
		case 3:
			break;
		}
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterInformation = new JLabel("Enter information");
		lblEnterInformation.setBounds(106, 192, 176, 15);
		frame.getContentPane().add(lblEnterInformation);
		
		JButton btnGoToDatabase = new JButton("Go to Database");
		btnGoToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Add_remove add = new Add_remove();
			add.frame.setVisible(true);
			}
		});
		btnGoToDatabase.setBounds(10, 239, 186, 50);
		frame.getContentPane().add(btnGoToDatabase);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Human_resources.class.getResource("/image/memberBG.jpg")));
		label.setBounds(0, 0, 519, 319);
		frame.getContentPane().add(label);
	}

}
