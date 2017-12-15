

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Store {

	public JFrame frame;
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
		lblStockOfBar.setBounds(268, 102, 193, 15);
		frame.getContentPane().add(lblStockOfBar);
		
		JTextArea menuSystem = new JTextArea();
		menuSystem.setBackground(UIManager.getColor("Button.background"));
		product.add("Salmon_sushi_25_bahts");
		product.add("Tuna_sushi_30_bahts");
		product.add("Salmon_usuzukuri_169_bahts");
		product.add("Tuna_usuzukuri_179_bahts");
		product.add("Green_tea_20_bahts");
		
		//menuSystem.setText(product.get(0) +"\n"+product.get(1) +"\n"+product.get(2) +"\n"+product.get(3) +"\n"+product.get(4) +"\n");
		menuSystem.setText(showMenu());
		menuSystem.setEditable(false);
		menuSystem.setBounds(66, 129, 476, 217);
		frame.getContentPane().add(menuSystem);
		
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
	public static Connection connect() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e1.printStackTrace();
			
		}
		
		//System.out.println("Success! connection");
        return DriverManager.getConnection("jdbc:postgresql:postgres", "tbap",
				"ionay999");
    }
	public static String showMenu() {
		String SQL = "SELECT * FROM menu ;";
		String result = "";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			//pstmt.setString(1, food_promotion);

			ResultSet rs = pstmt.executeQuery();
			result = display(rs);
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return "Not Found";
		}
		return " promotion is " +result ;
	}
	private static String display(ResultSet rs) throws SQLException {
		String promotion = "";
		String price = "";
		String name = "";
		
		if(!rs.next()){
			name = "NULL";
			promotion = "NOT FOUND";
			price = "NULL";
		}
		while (rs.next()) {
			System.out.println(rs.getString("food_promotion") + "\t");
            promotion = rs.getString("food_promotion") + "\t";
            price = rs.getString("food_price") + "\t";
            name = rs.getString("food_name") + "\t";
            
		}
		return name+"  : "+price+" with "+ promotion;
	}
}
