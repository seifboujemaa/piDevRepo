package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgentMenu extends JFrame {
	CreateTeam createTeam = new CreateTeam();
	AddStadium createStadium = new AddStadium();
	AddGame addGame = new AddGame();
	AddTeamPlayers addPlayer = new AddTeamPlayers();
	UpdatePlayerStat updatePlayer = new UpdatePlayerStat();
	UpdateTeamStat updateTeam = new UpdateTeamStat();
	Schedule modifGame = new Schedule();
	AddEvent event = new AddEvent();
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgentMenu frame = new AgentMenu();
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
	public AgentMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                  Agent Menu");
		lblNewLabel.setBounds(287, 24, 293, 14);
		contentPane.add(lblNewLabel);
		
		JButton addTam = new JButton("Add Teams");
		addTam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 createTeam.setVisible(true);
			 setVisible(false);
				
			}
		});
		addTam.setBounds(54, 95, 133, 60);
		contentPane.add(addTam);
		
		JButton addStadium = new JButton("Add Stadiums");
		addStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createStadium.setVisible(true);
				 setVisible(false);

			}
		});
		addStadium.setBounds(322, 95, 145, 60);
		contentPane.add(addStadium);
		
		JButton addMatch = new JButton("Add Match");
		addMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGame.setVisible(true);
				 setVisible(false);

			}
		});
		addMatch.setBounds(590, 95, 145, 60);
		contentPane.add(addMatch);
		
		JButton modifTeam = new JButton("Modify Teams");
		modifTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTeam.setVisible(true);
				
				 setVisible(false);

			}
		});
		modifTeam.setBounds(54, 218, 133, 66);
		contentPane.add(modifTeam);
		
		JButton modifPlayer = new JButton("Modify Players");
		modifPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePlayer.setVisible(true);
				 setVisible(false);

			}
		});
		modifPlayer.setBounds(54, 332, 133, 66);
		contentPane.add(modifPlayer);
		
		JButton addEvent = new JButton("Add Events");
		addEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				event.setVisible(true);
				 setVisible(false);

			}
		});
		addEvent.setBounds(590, 218, 145, 66);
		contentPane.add(addEvent);
		
		JButton addPlayer = new JButton("Add Players");
		addPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgentMenu.this.addPlayer.setVisible(true);
				 setVisible(false);

			}
		});
		addPlayer.setBounds(322, 218, 145, 66);
		contentPane.add(addPlayer);
		
		JButton modifyGame = new JButton("Modify Game");
		modifyGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifGame.setVisible(true);
				 setVisible(false);

			}
		});
		modifyGame.setBounds(322, 332, 145, 66);
		contentPane.add(modifyGame);
	}
}
