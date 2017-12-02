
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;

public class PaymentGUI extends ShoppingGUI {

	public JFrame frame;

	private static ArrayList<Integer> debt_menu = new ArrayList<Integer>();
	private static PaymentGUI window;
	private static int extraPrice = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
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

		JTextPane debt = new JTextPane();
		debt.setBackground(UIManager.getColor("CheckBox.background"));
		debt.setBounds(41, 315, 769, 132);
		int i = 5;
		while (i < debt_menu.size()) {
			debt.setText("Total price  = " + this.toString() + "\nSalmon price is " + getDebt_menu(0)
					+ "\nTuna price is " + getDebt_menu(1) + "\nSalmon Uzu price is " + getDebt_menu(2)
					+ "\nTuna uzu price is " + getDebt_menu(3) + "\nGreen tea price is " + getDebt_menu(4)
					+ "\nOther food price is " + getDebt_menu_extra(i));
			i++;
		}
		debt.setEditable(false);
		frame.getContentPane().add(debt);

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

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(PaymentGUI.class.getResource("/image/PaymenBG.jpg")));
		bg.setBounds(0, 0, 810, 494);
		frame.getContentPane().add(bg);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static int getDebt_menu(int i) {
		return debt_menu.get(i);
	}

	public static void setDebt_menu(int value) {
		PaymentGUI.debt_menu.add(value);

	}
	

	public static int getDebt_menu_extra(int i) {
		
		if (i > 4) {
			extraPrice += debt_menu.get(i);
		}
		return extraPrice;
	}

	public int sum() {
		;
		int sum = 0;
		for (int i = 0; i < debt_menu.size(); i++) {
			sum += getDebt_menu(i);
		}
		return sum;
	}

	public String toString() {
		return String.format("%d", sum());
	}
}
