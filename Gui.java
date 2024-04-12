package finalProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.princeton.cs.algs4.Graph;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JLabel lblSource;
	private JLabel lblDestination;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		String testpath = "src/finalProject/res/test.csv";
		String filepath = "src/finalProject/res/monsters.csv";
		FindShortestPath path = new FindShortestPath(testpath); 
		path.printAdjacencyList();
		
		//make the gui
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblSource = new JLabel("Monster Source: ");
		lblSource.setForeground(Color.WHITE);
		contentPane.add(lblSource);
		
		comboBox = new JComboBox();
		contentPane.add(comboBox);
		
		lblDestination = new JLabel("Monster Destination: ");
		lblDestination.setForeground(Color.WHITE);
		contentPane.add(lblDestination);
		
		comboBox_1 = new JComboBox();
		contentPane.add(comboBox_1);
	}

}
