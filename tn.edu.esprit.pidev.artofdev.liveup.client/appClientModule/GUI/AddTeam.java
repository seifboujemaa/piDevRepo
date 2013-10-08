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

public class AddTeam extends JFrame {
	

	private JPanel contentPane;
	private AddPlayer addPlayer = new AddPlayer() ;
	private AddTeamStat addStat = new AddTeamStat () ;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AddTeam frame = new AddTeam();
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
	public AddTeam() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeamName = new JLabel("Team Name ");
		lblTeamName.setBounds(108, 35, 148, 14);
		contentPane.add(lblTeamName);
		
		JButton btnNewButton = new JButton("Add players");
		btnNewButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
			
				addPlayer.show();
				
			}
		});
		btnNewButton.setBounds(53, 162, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update stats");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) textField.getText();
				addStat.getLblNewLabel_3().setText(name);
				addStat.show();
				
				
			}
		});
		btnNewButton_1.setBounds(191, 162, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create Team");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      String name = (String) textField.getText();
			      Team team = new Team() ;
			      team.setName(name);
			      teamService.create(team);
			      
			      
			}
		});
		btnNewButton_2.setBounds(343, 162, 109, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(214, 32, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
