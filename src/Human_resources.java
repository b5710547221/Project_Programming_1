
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class Human_resources {

	public JFrame frame;
	private JTextField memInfo;
	private JPasswordField passwordField;

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

		JComboBox searchMem = new JComboBox();
		searchMem.addItem("Name");
		// searchMem.addItem("Lastname");
		searchMem.addItem("Gender");
		searchMem.addItem("Age");
		searchMem.setBounds(270, 145, 176, 24);
		frame.getContentPane().add(searchMem);

		memInfo = new JTextField();
		memInfo.setBounds(228, 187, 157, 24);
		switch (searchMem.getSelectedIndex()) {
		case 0: {

			break;
		}
		case 1: {
			break;
		}
		case 2: {
			break;
		}
		case 3:
			break;
		}
		frame.getContentPane().add(memInfo);
		memInfo.setColumns(10);

		JLabel lblEnterInformation = new JLabel("Enter information");
		lblEnterInformation.setBounds(106, 192, 176, 15);
		frame.getContentPane().add(lblEnterInformation);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Add_remove add = new Add_remove();
				add.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 239, 186, 50);
		frame.getContentPane().add(btnBack);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Human_resources.class.getResource("/image/memberBG.jpg")));
		bg.setBounds(0, 0, 535, 336);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(418, 186, 117, 29);
		frame.getContentPane().add(btnSearch);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(235, 230, 254, 86);
		frame.getContentPane().add(textPane);

		passwordField = new JPasswordField();
		passwordField.setBounds(259, 310, 10, 26);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(bg);
	}

	public static String searchDBByName(String member_name) {
		String SQL = "SELECT member_name ,age ,gender   FROM member WHERE member_name = ?,age = ? ,gender = ?;";
		String result ="";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setString(1, member_name);

			ResultSet rs = pstmt.executeQuery();
			result = displayName(rs);
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return "Not found";
		}
		return result;
	}

	public static String searchDBBy(String gender) {
		String SQL = "SELECT member_name ,age ,gender   FROM member WHERE member_name = ?,age = ? ,gender = ?;";
		String result ="";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {
			

			pstmt.setString(3, gender);
			ResultSet rs = pstmt.executeQuery();
			result = displayGender(rs);
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return "Not found";
		}
		return result;
	}

	public static int searchDBByAge(int age) {
		String SQL = "SELECT member_name ,age ,gender   FROM member WHERE member_name = ?,age = ? ,gender = ?;";
		int result = 0;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setInt(2, age);

			ResultSet rs = pstmt.executeQuery();
			result = displayAge(rs);
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return 99;
		}
		return result;
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
		return DriverManager.getConnection("jdbc:postgresql:oop_1_database", "tbap", "ionay999");
	}
	 private static String displayName(ResultSet rs) throws SQLException {
	        while (rs.next()) {
	            System.out.println(rs.getString("member_name") + "\t");
	                    
	 
	        }
	        return rs.getString("member_name") + "\t";
	    }
	 private static int displayAge(ResultSet rs) throws SQLException {
	        while (rs.next()) {
	            System.out.println(rs.getString("age") + "\t");
	                    
	 
	        }
	        return Integer.parseInt(rs.getString("age") + "\t");
	    }
	 private static String displayGender(ResultSet rs) throws SQLException {
	        while (rs.next()) {
	            System.out.println(rs.getString("gender") + "\t");
	                   
	        }
	        return rs.getString("gender") + "\t";
	    }
}
