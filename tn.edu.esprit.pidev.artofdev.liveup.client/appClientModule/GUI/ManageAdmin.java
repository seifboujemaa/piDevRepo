package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAdmin frame = new ManageAdmin();
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
	public ManageAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddAgent = new JButton("ADD AGENT");
		btnAddAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAgent().setVisible(true);
				setVisible(false);
			}
		});
		btnAddAgent.setBounds(51, 54, 107, 23);
		contentPane.add(btnAddAgent);
		
		JButton btnAddFreelance = new JButton("ADD FreeLance");
		btnAddFreelance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddFreeLance().setVisible(true);
				setVisible(false);
			}
		});
		btnAddFreelance.setBounds(51, 103, 107, 23);
		contentPane.add(btnAddFreelance);
		
		JButton btnAddReporter = new JButton("ADD Reporter");
		btnAddReporter.setBounds(51, 161, 107, 23);
		contentPane.add(btnAddReporter);
		
		JButton btnAddJornalist = new JButton("ADD Jornalist");
		btnAddJornalist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddJournalist().setVisible(true);
				setVisible(false);
			}
		});
		btnAddJornalist.setBounds(51, 210, 107, 23);
		contentPane.add(btnAddJornalist);
		
		JButton btnAddChefeditor = new JButton("ADD ChefEditor");
		btnAddChefeditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddChefEditor().setVisible(true);
				setVisible(false);
			}
		});
		btnAddChefeditor.setBounds(51, 265, 107, 23);
		contentPane.add(btnAddChefeditor);
	}
}
