
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.ListModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class ShoppingGUI extends JList<Object> {

	public JFrame frmSushiBarkasetsart;
	public JTextField sal_button;
	public JTextField tuna_botton;
	public JTextField salmon_uzu_button;
	public JTextField tuna_uzu_botton;
	public JTextField green_tea_button;
	public JTextField extra_button;

	public JButton order_sal;
	public JButton order_tuna;
	public JButton order_sal_uzu;
	public JButton order_tuna_uzu;
	public JButton order_greentea;
	public JButton payOrder;
	public JButton check_status;
	public JButton orderExtraProduct;

	public String sal = "";
	public String sal2 = "";
	public String tuna = "";
	public String tuna2 = "";
	public String tea = "";
	public String text = "";

	/**
	 * Launch the application.
	 */
	public static void run() {
		try {
			ShoppingGUI window = new ShoppingGUI();
			window.frmSushiBarkasetsart.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		run();
	}

	/**
	 * Create the application.
	 */
	public ShoppingGUI() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmSushiBarkasetsart = new JFrame();
		frmSushiBarkasetsart.getContentPane().setBackground(Color.WHITE);
		frmSushiBarkasetsart.setTitle("Sushi bar @kasetsart");
		frmSushiBarkasetsart.setBounds(100, 100, 804, 559);
		frmSushiBarkasetsart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSushiBarkasetsart.getContentPane().setLayout(null);
		sal_button = new JTextField();

		// sal = "salmon sushi = " + sal_button.getText();
		sal_button.setText("0");
		sal_button.setBounds(148, 221, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(sal_button);
		sal_button.setColumns(10);

		tuna_botton = new JTextField();
		tuna_botton.setText("0");
		tuna = "Tuna sushi = " + tuna_botton.getText();
		

		tuna_botton.setColumns(10);
		tuna_botton.setBounds(386, 223, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(tuna_botton);

		salmon_uzu_button = new JTextField();
		salmon_uzu_button.setText("0");
		sal2 = "Salmon usuzukuri = " + salmon_uzu_button.getText();
		

		salmon_uzu_button.setColumns(10);
		salmon_uzu_button.setBounds(614, 223, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(salmon_uzu_button);

		tuna_uzu_botton = new JTextField();
		tuna_uzu_botton.setText("0");
		tuna2 = "tuna usuzukuri = " + tuna_uzu_botton.getText();
		;

		tuna_uzu_botton.setColumns(10);
		tuna_uzu_botton.setBounds(148, 398, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(tuna_uzu_botton);

		green_tea_button = new JTextField();
		green_tea_button.setText("0");
		tea = "Green tea = " + green_tea_button.getText();

		green_tea_button.setColumns(10);
		green_tea_button.setBounds(386, 403, 56, 19);
		frmSushiBarkasetsart.getContentPane().add(green_tea_button);

		DefaultListModel<String> model = new DefaultListModel<String>();
		// add all words from wordList to model
		model.addElement(tea);
		model.addElement(sal);
		model.addElement(sal2);
		model.addElement(tuna);
		model.addElement(tuna2);
		// create JList with model - model
		JList<String> list = new JList<String>(model);
		JScrollPane textPane = new JScrollPane(list);
		textPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JTextPane show_text = new JTextPane();
		textPane.setViewportView(show_text);

		textPane.setBounds(465, 270, 284, 203);

		frmSushiBarkasetsart.getContentPane().add(textPane);

		JLabel lblSushiSalmon = new JLabel("Sushi Salmon");
		lblSushiSalmon.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblSushiSalmon.setBounds(35, 114, 116, 26);
		frmSushiBarkasetsart.getContentPane().add(lblSushiSalmon);

		JLabel lblSushiTuna = new JLabel("Sushi Tuna");
		lblSushiTuna.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblSushiTuna.setBounds(259, 114, 116, 26);
		frmSushiBarkasetsart.getContentPane().add(lblSushiTuna);

		JLabel lblSalmonUsuzukuri = new JLabel("Salmon usuzukuri");
		lblSalmonUsuzukuri.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblSalmonUsuzukuri.setBounds(500, 114, 169, 26);
		frmSushiBarkasetsart.getContentPane().add(lblSalmonUsuzukuri);

		JLabel lblTunaUsuzukuri = new JLabel("Tuna Usuzukuri");
		lblTunaUsuzukuri.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblTunaUsuzukuri.setBounds(35, 287, 138, 15);
		frmSushiBarkasetsart.getContentPane().add(lblTunaUsuzukuri);

		JLabel lblGreentea = new JLabel("Greentea");
		lblGreentea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblGreentea.setBounds(259, 287, 70, 15);
		frmSushiBarkasetsart.getContentPane().add(lblGreentea);

		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				frmSushiBarkasetsart.setVisible(false);
				main.frame.setVisible(true);
			}
		});
		Back.setBounds(661, 484, 117, 25);
		frmSushiBarkasetsart.getContentPane().add(Back);

		JButton order_tuna = new JButton("");
		order_tuna.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		order_tuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tuna = "Tuna sushi = " + tuna_botton.getText();
				text += tuna + "\n";
				// tuna_botton.setText(tuna_botton.getText());
			}
		});
		order_tuna.setBounds(259, 221, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(order_tuna);

		JButton order_sal_uzu = new JButton("");
		order_sal_uzu.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		order_sal_uzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sal2 = "Salmon usuzukuri = " + salmon_uzu_button.getText();
				text += sal2 + "\n";
				// salmon_uzu_button.setText(salmon_uzu_button.getText());
			}
		});
		order_sal_uzu.setBounds(498, 221, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(order_sal_uzu);

		JButton order_greentea = new JButton("");
		order_greentea.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		order_greentea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tea = "Green tea = " + green_tea_button.getText();
				text += tea + "\n";
				// green_tea_button.setText(green_tea_button.getText());
			}
		});
		order_greentea.setBounds(259, 396, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(order_greentea);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/bioweb.jpg")));
		lblNewLabel.setBounds(34, 137, 106, 78);
		frmSushiBarkasetsart.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/IMG_0122.jpg")));
		label.setBounds(259, 132, 105, 78);

		frmSushiBarkasetsart.getContentPane().add(label);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/sushi1.jpg")));
		label_2.setBounds(500, 137, 100, 78);
		frmSushiBarkasetsart.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/sushi2.jpg")));
		label_3.setBounds(34, 307, 97, 78);
		frmSushiBarkasetsart.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/tea1.jpg")));
		label_4.setBounds(259, 307, 97, 78);
		frmSushiBarkasetsart.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/ku1.jpg")));
		label_5.setBounds(0, -3, 116, 106);
		frmSushiBarkasetsart.getContentPane().add(label_5);

		order_sal = new JButton("");
		order_sal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sal = "salmon sushi = " + sal_button.getText();
				text += sal + "\n";
				// sal_button.setText(sal_button.getText());

			}
		});
		order_sal.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		order_sal.setBounds(32, 220, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(order_sal);

		order_tuna_uzu = new JButton("");
		order_tuna_uzu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tuna2 = "Tuna uzusukuri  = " + tuna_uzu_botton.getText();
				text += tuna2 + "\n";
				// tuna_uzu_botton.setText(tuna_uzu_botton.getText());
			}
		});
		order_tuna_uzu.setIcon(new ImageIcon(ShoppingGUI.class.getResource("/image/animated-order-now-button.jpg")));
		order_tuna_uzu.setBounds(35, 395, 106, 26);
		frmSushiBarkasetsart.getContentPane().add(order_tuna_uzu);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(
				ShoppingGUI.class.getResource("/image/sushi-cartoon-facebook-cover-timeline-banner-for-fb.jpg")));
		label_6.setBounds(105, -17, 715, 126);
		frmSushiBarkasetsart.getContentPane().add(label_6);

		JComboBox category = new JComboBox();
		extra_button = new JTextField();
		extra_button.setBounds(35, 470, 88, 26);
		frmSushiBarkasetsart.getContentPane().add(extra_button);
		extra_button.setColumns(10);

		category.addItem("New food");
		category.setBounds(259, 433, 130, 24);
		frmSushiBarkasetsart.getContentPane().add(category);

		orderExtraProduct = new JButton("Order extra Product");
		orderExtraProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text += "Extra " + category.getSelectedItem() + " = " + extra_button.getText();
				extra_button.setText(extra_button.getText());
			}
		});
		orderExtraProduct.setBounds(35, 433, 181, 25);
		frmSushiBarkasetsart.getContentPane().add(orderExtraProduct);

		payOrder = new JButton("Pay order");
		payOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSushiBarkasetsart.setVisible(false);
				PaymentGUI pay = new PaymentGUI();
				pay.frame.setVisible(true);
				pay.setDebt_menu(0, Integer.parseInt(sal_button.getText()) * 25);
				// pay.setDebt_menu(0,Integer.parseInt(sal_button.getText())*30);
				// pay.setDebt_menu(0,Integer.parseInt(sal_button.getText())*169);
				// pay.setDebt_menu(0,Integer.parseInt(sal_button.getText())*20);
				// pay.setDebt_menu(0,Integer.parseInt(sal_button.getText())*20);

			}
		});
		payOrder.setBounds(475, 485, 139, 25);
		frmSushiBarkasetsart.getContentPane().add(payOrder);

		check_status = new JButton("Check status");
		check_status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_text.setText(text);
			}
		});
		check_status.setBounds(279, 484, 169, 25);
		frmSushiBarkasetsart.getContentPane().add(check_status);

	}

}
