

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Font;

public class Administrator {

	JFrame frame;
	private JTextField input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator window = new Administrator();
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
	public Administrator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStoreOwner = new JLabel("Store Owner");
		lblStoreOwner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStoreOwner.setBounds(28, 125, 148, 15);
		lblStoreOwner.setText("Warat N.");
		lblStoreOwner.setEnabled(false);
		frame.getContentPane().add(lblStoreOwner);
		
		JTextArea detailAuth = new JTextArea();
		detailAuth.setText("I'm CEO of this Japanese Restaurant ");
		detailAuth.setEditable(false);
		detailAuth.setBackground(UIManager.getColor("Button.background"));
		detailAuth.setBounds(122, 86, 384, 95);
		frame.getContentPane().add(detailAuth);
		
		JButton btnAddMenu = new JButton("");
		btnAddMenu.setIcon(new ImageIcon(Administrator.class.getResource("/image/addBtn.jpg")));
		btnAddMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			
			Add_remove_product add = new Add_remove_product();
			add.frame.setVisible(true);
			}
		});
		btnAddMenu.setBounds(64, 306, 148, 39);
		frame.getContentPane().add(btnAddMenu);
		
		JButton btnRemoveMenu = new JButton("");
		btnRemoveMenu.setIcon(new ImageIcon(Administrator.class.getResource("/image/RemoveBtn.jpg")));
		btnRemoveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
				Add_remove_product add = new Add_remove_product();
				add.frame.setVisible(true);
			}
		});
		btnRemoveMenu.setBounds(291, 306, 148, 39);
		frame.getContentPane().add(btnRemoveMenu);
		
		JLabel lblSearchMenuBy = new JLabel("Search menu by");
		lblSearchMenuBy.setBounds(98, 209, 148, 15);
		frame.getContentPane().add(lblSearchMenuBy);
		
		JComboBox search = new JComboBox();
		search.addItem("Price");
		search.addItem("Promotion");
		search.setBounds(206, 204, 156, 24);
		frame.getContentPane().add(search);
		
		input = new JTextField();
		
		input.setBackground(UIManager.getColor("Button.background"));
		input.setBounds(206, 246, 156, 30);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		JLabel lblEnter = new JLabel("Enter ");
		lblEnter.setBounds(142, 254, 70, 15);
		frame.getContentPane().add(lblEnter);
		
		JTextPane log = new JTextPane();
		//log.setText("Not match ! Database in construction");
		log.setEditable(false);
		log.setBackground(UIManager.getColor("Button.background"));
		log.setBounds(146, 377, 384, 39);
		frame.getContentPane().add(log);
		
		JLabel lblViewSearchOrder = new JLabel("View search order");
		lblViewSearchOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblViewSearchOrder.setBounds(10, 390, 177, 15);
		frame.getContentPane().add(lblViewSearchOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Store back = new Store();
			back.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 442, 117, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Administrator.class.getResource("/image/adminBG.jpg")));
		bg.setBounds(0, 0, 556, 495);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(search.getSelectedItem() == "Price"){
					log.setText(searchDBByPrice(Integer.parseInt(input.getText())));
				}else if(search.getSelectedItem() == "Promotion"){
					log.setText(searchDBByPromotion(input.getText()));
				}
			}
		});
		btnSearch.setBounds(389, 248, 117, 29);
		frame.getContentPane().add(btnSearch);
		frame.getContentPane().add(bg);
		
	}
	public static Connection connect() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e1.printStackTrace();

		}
		// System.out.println("Success! connection");
		return DriverManager.getConnection("jdbc:postgresql:postgres", "tbap", "ionay999");
	}
	public static String searchDBByPrice(int price) {
		String SQL = "SELECT food_price  ,food_name  FROM menu WHERE food_price = ? ;";
		String result = "";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setInt(1, price);

			ResultSet rs = pstmt.executeQuery();
			result = displayPrice(rs);
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return "Not Found";
		}
		return "Price : " +result;
	}
	private static String displayPrice(ResultSet rs) throws SQLException {
		String price = "";
		String name = "";
		if(!rs.next()){
			name = "NULL";
			price = "NOT FOUND";
		}
		while (rs.next()) {
			System.out.println(rs.getString("food_price") + "\t");
            price = rs.getString("food_price") + "\t";
            name = rs.getString("food_name") + "\t";
		}
		return name +" : "+  price;
	}
	public static String searchDBByPromotion(String food_promotion) {
		String SQL = "SELECT food_promotion,food_price ,food_name FROM menu WHERE food_promotion = ?  ;";
		String result = "";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setString(1, food_promotion);

			ResultSet rs = pstmt.executeQuery();
			result = displayPromotion(rs);
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return "Not Found";
		}
		return " promotion is "+result ;
	}
	private static String displayPromotion(ResultSet rs) throws SQLException {
		String promotion = "";
		String price = "";
		String name = "";
		
		if(!rs.next()){
			name = "NULL";
			promotion = "NOT FOUND";
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
