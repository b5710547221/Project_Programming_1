
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Add_remove {

	public JFrame frame;
	private JTextField name;
	private JTextField lastName;
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_remove window = new Add_remove();
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
	public Add_remove() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		name = new JTextField("name");

		name.setBounds(309, 47, 224, 19);
		frame.getContentPane().add(name);
		name.setColumns(10);
		if (!Customer.getName().equals(null)) {
			name.setText(Customer.getName());
		} else {
            name.setText("");
		}
		name.setEditable(false);

		lastName = new JTextField("lastname");
		lastName.setColumns(10);
		if (!Customer.getLastName().equals(null)) {
			lastName.setText(Customer.getLastName());
		} else {
            name.setText("");
		}
		
		lastName.setEditable(false);
		lastName.setBounds(309, 77, 224, 19);
		frame.getContentPane().add(lastName);

		age = new JTextField();
		age.setColumns(10);
		age.setBounds(309, 107, 85, 19);
		frame.getContentPane().add(age);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(247, 50, 70, 15);
		frame.getContentPane().add(lblName);

		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(229, 80, 133, 15);
		frame.getContentPane().add(lblLastName);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(260, 110, 42, 15);
		frame.getContentPane().add(lblAge);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(247, 131, 70, 30);
		frame.getContentPane().add(lblGender);

		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBackground(Color.WHITE);
		rdbtnM.setBounds(309, 133, 53, 23);
		frame.getContentPane().add(rdbtnM);

		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBackground(Color.WHITE);
		rdbtnF.setBounds(374, 134, 42, 23);
		frame.getContentPane().add(rdbtnF);
         
		JButton btnAddToDatabase = new JButton("add");
		btnAddToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String gender ="";
				if(rdbtnM.isSelected()){
                	gender =  "M";
                }else if(rdbtnF.isSelected()){
                	gender = "F";
                }

                addMember(name.getText(),(age.getText()),gender);
				
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("Add!");
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
			}
		});
		btnAddToDatabase.setIcon(new ImageIcon(Add_remove.class.getResource("/image/addBtn.jpg")));
		btnAddToDatabase.setBackground(Color.GREEN);
		btnAddToDatabase.setBounds(40, 232, 160, 52);
		frame.getContentPane().add(btnAddToDatabase);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer mem = new Customer();
				frame.setVisible(false);
				mem.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 370, 117, 25);
		frame.getContentPane().add(btnBack);

		JButton btnRemoveThisMember = new JButton("");
		btnRemoveThisMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String gender ="";
					if(rdbtnM.isSelected()){
	                	gender =  "M";
	                }else if(rdbtnF.isSelected()){
	                	gender = "F";
	                }

	                removeMember(name.getText(),(age.getText()),gender);
				JDialog prompt2 = new JDialog();
				JLabel msg2 = new JLabel("Remove!");
				msg2.setBounds(50, 50, 80, 50);
				msg2.setSize(100, 30);
				prompt2.setVisible(true);
				prompt2.setContentPane(msg2);
				prompt2.setBounds(231, 50, 149, 23);
				prompt2.setSize(300, 300);
			}
		});
		btnRemoveThisMember.setIcon(new ImageIcon(Add_remove.class.getResource("/image/RemoveBtn.jpg")));
		btnRemoveThisMember.setBackground(Color.RED);
		btnRemoveThisMember.setBounds(296, 232, 160, 52);
		frame.getContentPane().add(btnRemoveThisMember);

		JButton btnSearchDatabase = new JButton("Search member");
		btnSearchDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				Human_resources human = new Human_resources();
				human.frame.setVisible(true);
			}
		});
		btnSearchDatabase.setBounds(400, 370, 133, 25);
		frame.getContentPane().add(btnSearchDatabase);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Add_remove.class.getResource("/image/AddBg.jpg")));
		bg.setBounds(0, 0, 543, 406);
		frame.getContentPane().add(bg);
		
	}
	public static void addMember(String member_name,String age, String gender){
		String SQL = "INSERT INTO member (member_name,age,gender) "
				+ "VALUES(?,?,?);";
		 try (Connection conn = connect();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
	 
	            pstmt.setString(1, member_name);
	            //pstmt.setString(2, age);
	            pstmt.setInt(2, Integer.parseInt(age));
	            pstmt.setString(3, gender);
	            int rs = pstmt.executeUpdate();
	            System.out.println("insert successful!!");
	            conn.close();
	        } catch (SQLException ex) {
	        	System.out.println("Connection Failed! Check output console");
				ex.printStackTrace();
	            System.out.println(ex.getMessage());
	            return;
	        }
	}
	public static void removeMember(String member_name,String age, String gender){
		String SQL = "DELETE FROM member WHERE member_name = ? AND age = ? AND gender = ?;";
		 try (Connection conn = connect();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
	 
	            pstmt.setString(1, member_name);
	            //pstmt.setString(2, age);
	            pstmt.setInt(2, Integer.parseInt(age));
	            pstmt.setString(3, gender);
	            int rs = pstmt.executeUpdate();
	            System.out.println("delete successful!!");
	            conn.close();
	        } catch (SQLException ex) {
	        	System.out.println("Connection Failed! Check output console");
				ex.printStackTrace();
	            System.out.println(ex.getMessage());
	            return;
	        }
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
}
