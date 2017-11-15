

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Add_remove_product {

	public JFrame frame;
	public JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_remove_product window = new Add_remove_product();
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
	public Add_remove_product() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 631, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(271, 204, 230, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(142, 213, 168, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/addBtn.jpg")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnAdd.setBounds(126, 288, 160, 52);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("");
		btnRemove.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/RemoveBtn.jpg")));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemove.setBounds(351, 288, 160, 52);
		frame.getContentPane().add(btnRemove);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Administrator back = new Administrator();
			back.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 375, 117, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/AddProductBG.jpg")));
		label.setBounds(0, 0, 615, 411);
		frame.getContentPane().add(label);
	}
}
