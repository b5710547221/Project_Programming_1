

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Add_remove_product {

	public JFrame frame;
	public JTextField productField;
	private JTextField promotion;
	private JTextField price;

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
		
		productField = new JTextField();
		productField.setBounds(177, 71, 230, 38);
		frame.getContentPane().add(productField);
		productField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(22, 94, 168, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdd = new JButton("add");
		btnAdd.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/addBtn.jpg")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("Add product "+ productField.getText());
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
			}
		});
		
		btnAdd.setBounds(126, 288, 160, 52);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("remove");
		btnRemove.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/RemoveBtn.jpg")));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("Remove product "+ productField.getText());
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
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
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/AddProductBG.jpg")));
		bg.setBounds(0, 0, 615, 411);
		
		
		JLabel lblfoodPrice = new JLabel("Food price");
		lblfoodPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblfoodPrice.setBounds(24, 144, 150, 25);
		frame.getContentPane().add(lblfoodPrice);
		
		JLabel lblFoodPromotion = new JLabel("Food promotion");
		lblFoodPromotion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodPromotion.setBounds(22, 209, 141, 25);
		frame.getContentPane().add(lblFoodPromotion);
		
		
		promotion = new JTextField();
		promotion.setColumns(10);
		promotion.setBounds(177, 196, 230, 38);
		frame.getContentPane().add(promotion);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(177, 139, 230, 38);
		frame.getContentPane().add(price);
		frame.getContentPane().add(bg);
	}
}
