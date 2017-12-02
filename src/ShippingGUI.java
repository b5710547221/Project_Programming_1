

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class ShippingGUI extends ShoppingGUI{

	public JFrame frame;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShippingGUI window = new ShippingGUI();
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
	public ShippingGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("CheckBox.light"));
		textPane.setBounds(362, 58, 342, 307);
		frame.getContentPane().add(textPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
		    Main main = new Main();
		    main.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 456, 80, 23);
		frame.getContentPane().add(btnBack);
		
		JRadioButton rdbtnIncorrectOrders = new JRadioButton("Incorrect orders");
		rdbtnIncorrectOrders.setSelected(true);
		rdbtnIncorrectOrders.setBackground(Color.WHITE);
		rdbtnIncorrectOrders.setBounds(159, 405, 149, 23);
		frame.getContentPane().add(rdbtnIncorrectOrders);
		
		
		JRadioButton rdbtnConfirmed = new JRadioButton("confirmed");
		rdbtnConfirmed.setSelected(false);
		rdbtnConfirmed.setBackground(UIManager.getColor("Button.highlight"));
		rdbtnConfirmed.setBounds(10, 405, 173, 23);
		frame.getContentPane().add(rdbtnConfirmed);
		
		price = new JTextField();
		PaymentGUI  pay = new PaymentGUI();
		price.setText(pay.toString());
		price.setEditable(false);
		price.setBounds(54, 366, 159, 23);
		price.setColumns(10);
		
		
		textPane.setEditable(false);
		frame.getContentPane().add(price);
		
		JRadioButton rdbtnExpress = new JRadioButton("express");
		rdbtnExpress.setBackground(Color.WHITE);
		rdbtnExpress.setBounds(159, 323, 149, 23);
		frame.getContentPane().add(rdbtnExpress);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Myriad Pro Light", Font.PLAIN, 14));
		lblPrice.setBounds(10, 370, 70, 15);
		frame.getContentPane().add(lblPrice);
		
		JRadioButton rdbtnRegisterd = new JRadioButton("Registerd");
		rdbtnRegisterd.setBackground(Color.WHITE);
		rdbtnRegisterd.setBounds(10, 323, 118, 23);
		frame.getContentPane().add(rdbtnRegisterd);
		JButton btnProceeding = new JButton("Proceeding..");
		btnProceeding.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			if(rdbtnConfirmed.isSelected()){
				frame.setVisible(false);
				Main main = new Main();
				main.frame.setVisible(true);
				
				
				
			}else if(rdbtnIncorrectOrders.isSelected()){
				
				JLabel msg = new JLabel("GO BACK!!");
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100,30);
				JDialog error  = new JDialog();
			    error.setVisible(true);
			    error.setContentPane(msg);
			    error.setBounds(231, 50, 149, 23);
				JButton close = new JButton("Close");
				close.setSize(150,300);
			    close.setBounds(50, 100, 90,50);
				error.getContentPane().add(close);
				
				close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					error.setVisible(false);
					}
				});
				
			    error.setSize(200, 200);
			    
			    frame.getContentPane().add(error);
			    
			}
			}
		});
		btnProceeding.setBounds(566, 386, 118, 23);
		frame.getContentPane().add(btnProceeding);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(ShippingGUI.class.getResource("/image/ShippingBG.jpg")));
		bg.setBounds(0, 0, 747, 501);
		
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBackground(Color.WHITE);
		frame.getContentPane().add(btnCheckout);
		btnCheckout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				
				String text = ("Total price exclude shipping is " + pay.toString() + " bahts. \n");
				if(rdbtnRegisterd.isSelected() && rdbtnConfirmed.isSelected()){
					String total = String.format("\nTotal cost is %s", (pay.sum()+100));
					textPane.setText(text + "shipping price is 100 bahts" + total);
				}else if(rdbtnExpress.isSelected()  && rdbtnConfirmed.isSelected()){
					String total2 = String.format("\nTotal cost is %s", (pay.sum()+350));
					textPane.setText(text + "shipping price is 350 bahts"+ total2);
				}
			}
		});
		btnCheckout.setBounds(127, 453, 117, 29);
		frame.getContentPane().add(bg);
		
		
	}
}
