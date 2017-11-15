

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Main {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void run() {
		try {

			Main window = new Main();
			window.frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		run();
	}

	/**b
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Main() {
		initialize();
	}

	/**d
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Kasetsart SUSHI");
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 758, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShoppingGUI shop = new ShoppingGUI() ; 
				shop.run();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Main.class.getResource("/image/OrderBtn.jpg")));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(10, 486, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer cus = new customer();
				cus.frame.setVisible(true);
				frame.setVisible(false);
			}
		    
		    
		});
		btnNewButton_1.setIcon(new ImageIcon(Main.class.getResource("/image/MemberBtn.jpg")));
		btnNewButton_1.setBounds(155, 486, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Store stock = new Store();
				stock.frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Main.class.getResource("/image/StockBtn.jpg")));
		btnNewButton_2.setBounds(300, 486, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Main.class.getResource("/image/ExitBtn.jpg")));
		btnNewButton_3.setBounds(448, 486, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel label = new JLabel("");
		label.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			frame.dispose();
			}
		});
		label.setForeground(Color.BLACK);
		label.setIcon(new ImageIcon(Main.class.getResource("/image/bgMain.jpg")));
		label.setBounds(0, 0, 742, 535);
		frame.getContentPane().add(label);

	}
}
