package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.TeamServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TeamMenu extends JFrame {
	

	private JPanel contentPane;
	private UpdateTeamStat addStat = new UpdateTeamStat () ;
	private CreateTeam createTeam = new CreateTeam() ;
	private AddTeamPlayers createNewTeam = new AddTeamPlayers();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TeamMenu frame = new TeamMenu();
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
	public TeamMenu() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add players");
		btnNewButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
				createNewTeam.show();
				
				
			
			
				
			}
		});
		btnNewButton.setBounds(52, 43, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update stats");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addStat.show();
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(183, 43, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create Team");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createTeam.show();
			     
			     
			      
			      
			}
		});
		btnNewButton_2.setBounds(334, 43, 109, 23);
		contentPane.add(btnNewButton_2);
	}
}
