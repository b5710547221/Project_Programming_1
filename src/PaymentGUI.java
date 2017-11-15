
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;

public class PaymentGUI {

	public JFrame frame;

	private static  int[] debt_menu;
	private static PaymentGUI window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println(sum() + "");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new PaymentGUI();
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
	public PaymentGUI() {
		debt_menu = new int[5];
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 826, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTotalDept = new JLabel("Total Dept");
		lblTotalDept.setFont(new Font("DokChampa", Font.BOLD, 22));
		lblTotalDept.setBounds(31, 275, 134, 33);
		frame.getContentPane().add(lblTotalDept);

		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("CheckBox.background"));
		textPane.setBounds(41, 315, 769, 132);

		textPane.setText("Total price  = " + this.toString() + "\nSalmon price is " + getDebt_menu(0) + "\nTuna price is "
				+ getDebt_menu(1) + "\nSalmon Uzu price is " + getDebt_menu(2) + "\nTuna uzu price is " + getDebt_menu(3)
				+ "\nGreen tea price is " + getDebt_menu(4));
		textPane.setEditable(false);
		frame.getContentPane().add(textPane);

		JButton btnBack = new JButton("Proceed");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ShippingGUI ship = new ShippingGUI();
				ship.frame.setVisible(true);
			}
		});
		btnBack.setBounds(31, 448, 117, 25);
		frame.getContentPane().add(btnBack);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PaymentGUI.class.getResource("/image/PaymenBG.jpg")));
		label.setBounds(0, 0, 810, 494);
		frame.getContentPane().add(label);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	

	public  static int getDebt_menu(int i) {
		return debt_menu[i];
	}

	public static void setDebt_menu(int debt,int value) {
		PaymentGUI.debt_menu[debt] = value;
	}

	

	public static int sum() {;
		int sum = 0;
		for(int i = 0 ;i<debt_menu.length;i++){
			sum += getDebt_menu(i);
		}
		return sum;
	}

	public String toString() {
		return String.format("%d", sum());
	}
}
