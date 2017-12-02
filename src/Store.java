

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Store {

	public JFrame frame;
	private JTextField enterItem;
    public  ArrayList<String> product = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store window = new Store();
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
	public Store() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStockOfBar = new JLabel("STOCK OF BAR");
		lblStockOfBar.setBounds(10, 105, 193, 15);
		frame.getContentPane().add(lblStockOfBar);
		
		JTextArea menuSystem = new JTextArea();
		menuSystem.setBackground(UIManager.getColor("Button.background"));
		product.add("Salmon_sushi_25_bahts");
		product.add("Tuna_sushi_30_bahts");
		product.add("Salmon_usuzukuri_169_bahts");
		product.add("Tuna_usuzukuri_179_bahts");
		product.add("Green_tea_20_bahts");
		
		menuSystem.setText(product.get(0) +"\n"+product.get(1) +"\n"+product.get(2) +"\n"+product.get(3) +"\n"+product.get(4) +"\n");
		menuSystem.setBounds(10, 131, 207, 217);
		frame.getContentPane().add(menuSystem);
		
		JLabel lblSearchBy = new JLabel("Search by");
		lblSearchBy.setBounds(265, 143, 70, 15);
		frame.getContentPane().add(lblSearchBy);
		
		JComboBox search = new JComboBox();
		search.addItem("Price");
		search.addItem("Promotion");
		search.setBounds(332, 138, 171, 24);
		frame.getContentPane().add(search);
		
		JTextPane showDialog = new JTextPane();
		showDialog.setText("Database in construction!");
		showDialog.setEditable(false);
		showDialog.setBackground(UIManager.getColor("Button.background"));
		showDialog.setBounds(332, 233, 276, 42);
		frame.getContentPane().add(showDialog);
		
		JLabel lblEnter = new JLabel("Enter");
		lblEnter.setBounds(283, 188, 70, 15);
		frame.getContentPane().add(lblEnter);
		
		enterItem = new JTextField();
		enterItem.setBounds(332, 183, 171, 24);
		frame.getContentPane().add(enterItem);
		enterItem.setColumns(10);
		
		JLabel lblShowBelow = new JLabel("Show below");
		lblShowBelow.setBounds(251, 248, 92, 15);
		frame.getContentPane().add(lblShowBelow);
		
		JLabel lblRemoveStock = new JLabel("Remove Stock");
		lblRemoveStock.setBounds(251, 307, 110, 15);
		frame.getContentPane().add(lblRemoveStock);
		
		JButton btnThisOne = new JButton("This One");
		btnThisOne.setBounds(332, 302, 117, 25);
		frame.getContentPane().add(btnThisOne);
		
		JButton btnRevenue = new JButton("Revenue");
		btnRevenue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("Revenue is underconstruction");
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
			};
		});
		btnRevenue.setBounds(85, 359, 117, 25);
		frame.getContentPane().add(btnRevenue);
		
		JButton btnExpense = new JButton("expense");
		btnExpense.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("expense is underconstruction");
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
			}
		});
		btnExpense.setBounds(265, 359, 117, 25);
		frame.getContentPane().add(btnExpense);
		
		JButton btnProfit = new JButton("profit");
		btnProfit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("profit is underconstruction");
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
			}
		});
		btnProfit.setBounds(446, 359, 117, 25);
		frame.getContentPane().add(btnProfit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Main main = new Main();
			main.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 456, 117, 30);
		frame.getContentPane().add(btnBack);
		
		JButton btnAdmins = new JButton("Admins");
		btnAdmins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Administrator ads = new Administrator();
				ads.frame.setVisible(true);
			}
		});
		btnAdmins.setBounds(521, 456, 117, 30);
		frame.getContentPane().add(btnAdmins);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Store.class.getResource("/image/stroeBG.jpg")));
		bg.setBounds(0, 0, 669, 525);
		frame.getContentPane().add(bg);
	}
}
