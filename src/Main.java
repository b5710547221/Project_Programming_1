

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
		//frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 758, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton orderButton = new JButton("");
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShoppingGUI shop = new ShoppingGUI() ; 
				shop.run();
			}
		});
		orderButton.setIcon(new ImageIcon(Main.class.getResource("/image/OrderBtn.jpg")));
		orderButton.setBackground(Color.BLACK);
		orderButton.setForeground(Color.WHITE);
		orderButton.setBounds(10, 486, 89, 23);
		frame.getContentPane().add(orderButton);
		
		JButton memberButton = new JButton("");
		memberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cus = new Customer();
				cus.frame.setVisible(true);
				frame.setVisible(false);
			}
		    
		    
		});
		memberButton.setIcon(new ImageIcon(Main.class.getResource("/image/MemberBtn.jpg")));
		memberButton.setBounds(155, 486, 89, 23);
		frame.getContentPane().add(memberButton);
		
		JButton stockButton = new JButton("");
		stockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Store stock = new Store();
				stock.frame.setVisible(true);
				
			}
		});
		stockButton.setIcon(new ImageIcon(Main.class.getResource("/image/StockBtn.jpg")));
		stockButton.setBounds(300, 486, 89, 23);
		frame.getContentPane().add(stockButton);
		
		JButton exitButton = new JButton("");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		exitButton.setIcon(new ImageIcon(Main.class.getResource("/image/ExitBtn.jpg")));
		exitButton.setBounds(448, 486, 89, 23);
		frame.getContentPane().add(exitButton);
		
		JLabel bg = new JLabel("");
		bg.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			frame.dispose();
			}
		});
		bg.setForeground(Color.BLACK);
		bg.setIcon(new ImageIcon(Main.class.getResource("/image/bgMain.jpg")));
		bg.setBounds(0, 0, 758, 539);
		
		frame.getContentPane().add(bg);

	}
}
