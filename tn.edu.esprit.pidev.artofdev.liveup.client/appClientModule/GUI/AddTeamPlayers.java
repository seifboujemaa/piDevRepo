package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.PlayerServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.TeamServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTeamPlayers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private List<Player> players = new ArrayList<Player>();
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeamPlayers frame = new AddTeamPlayers();
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
	public AddTeamPlayers() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate() ;
		final PlayerServicesDelegate playerService = new PlayerServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox teams = new JComboBox();
		teams.setBounds(212, 24, 114, 20);
		contentPane.add(teams);
		List<Team> teamsSelect = new ArrayList<Team>();
		teamsSelect= teamService.findAllTeam();
		for(Team team : teamsSelect)
		{
			teams.addItem(team.getName());
		}
		
		
	
		 
		JLabel lblNewLabel = new JLabel("Choose a team");
		lblNewLabel.setBounds(24, 27, 104, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(60, 95, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 95, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Team  team = teamService.findTeamByName((String)teams.getSelectedItem());
				Player player = new Player();
				player.setFirstName(textField.getText());
				player.setLastName(textField_1.getText());
				player.setTeam(team);
				playerService.create(player);
			}
		});
		btnNewButton_1.setBounds(316, 94, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
