

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Add_remove_product {

	public JFrame frame;
	public JTextField productField;
	private JTextField promotion;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_remove_product window = new Add_remove_product();
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
	public Add_remove_product() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 631, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		productField = new JTextField();
		productField.setBounds(177, 71, 230, 38);
		frame.getContentPane().add(productField);
		productField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(22, 94, 168, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdd = new JButton("add");
		btnAdd.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/addBtn.jpg")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("Add product "+ productField.getText());
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
				addProduct(productField.getText(),Integer.parseInt(price.getText()),promotion.getText());
				
			}
		});
		
		btnAdd.setBounds(126, 288, 160, 52);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("remove");
		btnRemove.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/RemoveBtn.jpg")));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog prompt = new JDialog();
				JLabel msg = new JLabel("Remove product "+ productField.getText());
				msg.setBounds(50, 50, 80, 50);
				msg.setSize(100, 30);
				prompt.setVisible(true);
				prompt.setContentPane(msg);
				prompt.setBounds(231, 50, 149, 23);
				prompt.setSize(300, 300);
				removeProduct(productField.getText(),Integer.parseInt(price.getText()),promotion.getText());
			}
		});
		btnRemove.setBounds(351, 288, 160, 52);
		frame.getContentPane().add(btnRemove);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Administrator back = new Administrator();
			back.frame.setVisible(true);
			}
		});
		btnBack.setBounds(10, 375, 117, 25);
		frame.getContentPane().add(btnBack);
		
		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(Add_remove_product.class.getResource("/image/AddProductBG.jpg")));
		bg.setBounds(0, 0, 615, 411);
		
		
		JLabel lblfoodPrice = new JLabel("Food price");
		lblfoodPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblfoodPrice.setBounds(24, 144, 150, 25);
		frame.getContentPane().add(lblfoodPrice);
		
		JLabel lblFoodPromotion = new JLabel("Food promotion");
		lblFoodPromotion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodPromotion.setBounds(22, 209, 141, 25);
		frame.getContentPane().add(lblFoodPromotion);
		
		
		promotion = new JTextField();
		promotion.setColumns(10);
		promotion.setBounds(177, 196, 230, 38);
		frame.getContentPane().add(promotion);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(177, 139, 230, 38);
		frame.getContentPane().add(price);
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
	public static void addProduct(String food_name,int food_price, String food_promotion){
		String SQL = "INSERT INTO menu (food_name,food_price,food_promotion) VALUES (?,?,?);";
		 try (Connection conn = connect();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
	 
	            pstmt.setString(1, food_name);
	            //pstmt.setString(2, age);
	            pstmt.setInt(2, food_price);
	            pstmt.setString(3, food_promotion);
	            pstmt.executeUpdate();
	            System.out.println("Add menu successful!!");
	            conn.close();
	        } catch (SQLException ex) {
	        	System.out.println("Connection Failed! Check output console");
				ex.printStackTrace();
	            System.out.println(ex.getMessage());
	            return;
	        }
	}
	public static void removeProduct(String food_name,int food_price, String food_promotion){
		String SQL = "DELETE FROM menu WHERE food_name = ? AND food_price = ? AND food_promotion = ?;";
		 try (Connection conn = connect();
	                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
	 
	            pstmt.setString(1, food_name);
	            //pstmt.setString(2, age);
	            pstmt.setInt(2, food_price);
	            pstmt.setString(3, food_promotion);
	            pstmt.executeUpdate();
	            System.out.println("delete menu successful!!");
	            conn.close();
	        } catch (SQLException ex) {
	        	System.out.println("Connection Failed! Check output console");
				ex.printStackTrace();
	            System.out.println(ex.getMessage());
	            return;
	        }
	}
}
