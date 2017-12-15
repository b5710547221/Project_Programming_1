
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
	private String name = " ";
	private String gender = " ";
	private int age = 0;

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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(235, 230, 254, 86);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				switch (searchMem.getSelectedIndex()) {
				case 0: {
					name = memInfo.getText();
                    textPane.setText(searchDBByName(name));
					break;
				}
				case 1: {
					gender = memInfo.getText();
					textPane.setText(searchDBByGender(gender));
					break;
				}
				case 2: {
					age = Integer.parseInt(memInfo.getText());
					textPane.setText(searchDBByAge(age)+"");
					break;
				}
				}

			}
		});
		btnSearch.setBounds(418, 186, 117, 29);
		frame.getContentPane().add(btnSearch);

		
		frame.getContentPane().add(textPane);

		passwordField = new JPasswordField();
		passwordField.setBounds(259, 310, 10, 26);
		frame.getContentPane().add(passwordField);
		
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBounds(10, 301, 117, 29);
		btnReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resetDB();
			}
		});
		frame.getContentPane().add(btnReset);
		frame.getContentPane().add(bg);
	}

	public static String searchDBByName(String member_name) {
		String SQL = "SELECT member_name    FROM member WHERE member_name = ?;";
		String result = "";
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
		return "This Name is " +result+ " exist";
	}

	public static String searchDBByGender(String gender) {
		String SQL = "SELECT gender   FROM member WHERE gender = ?;";
		String result = "";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setString(1, gender);
			ResultSet rs = pstmt.executeQuery();
			result = displayGender(rs);
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return "Not found";
		}
		return "This Gender is " +result+ " exist";
	}

	public static String searchDBByAge(int age) {
		String SQL = "SELECT age    FROM member WHERE age = ? ;";
		int result = 0;
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

			pstmt.setInt(1, age);

			ResultSet rs = pstmt.executeQuery();
			result = displayAge(rs);
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return "Not Found";
		}
		return "This Age is " +result+ " exist";
	}
    public static void resetDB(){
    	String SQL = "DELETE  FROM member ;";
    	try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(SQL)) {

    		int rs = pstmt.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			
		}
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

	private static String displayName(ResultSet rs) throws SQLException {
		String name = "";
		if(!rs.next()){
			name = "NULL";
		}
		while (rs.next()) {
			System.out.println(rs.getString("member_name") + "\t");
            name = rs.getString("member_name") + "\t";
		}
		return name;
	}

	private static int displayAge(ResultSet rs) throws SQLException {
		int age = 0 ;
		if(!rs.next()){
			age = 00;
		}

		while (rs.next()) {
			System.out.println(rs.getString("age") + "\t");
			age = Integer.parseInt(rs.getString("age")) ;
  
		}
		return age;
	}

	private static String displayGender(ResultSet rs) throws SQLException {
		String gender = "";
		if(!rs.next()){
			gender = "NULL";
		}

		while (rs.next()) {
			System.out.println(rs.getString("gender") + "\t");
			gender = rs.getString("gender") + "\t";

		}
		return gender;
	}
}
