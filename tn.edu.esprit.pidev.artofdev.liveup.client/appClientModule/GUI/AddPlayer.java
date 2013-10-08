package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.PlayerServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.TeamServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import org.hibernate.metamodel.source.annotations.entity.IdType;
import javax.swing.JComboBox;

public class AddPlayer extends JFrame {

	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Goals;
	private JTextField PlayTime;
	private JTextField RedCards;
	private JTextField YellowCards;
	private JComboBox Teams ;
	
	
	public JComboBox getTeams() {
		return Teams;
	}

	public void setTeams(JComboBox teams) {
		Teams = teams;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlayer frame = new AddPlayer();
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
	public AddPlayer() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate();

	 final PlayerServicesDelegate playerService = new PlayerServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FirstName = new JTextField();
		FirstName.setBounds(140, 11, 86, 20);
		contentPane.add(FirstName);
		FirstName.setColumns(10);
		
	
		
		LastName = new JTextField();
		LastName.setBounds(140, 55, 86, 20);
		contentPane.add(LastName);
		LastName.setColumns(10);
		
		final JComboBox Teams = new JComboBox();
		List<Team> teamList = new ArrayList<Team>();
		teamList = teamService.findAllTeam();
		for(Team team : teamList )
		{
			Teams.addItem(team.getName());
		}
		
		Teams.setBounds(140, 107, 126, 20);
		contentPane.add(Teams);
		
		
		
		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = LastName.getText();
				String firstName = FirstName.getText() ;
				int goals = Integer.parseInt(Goals.getText());
				int redCards = Integer.parseInt(RedCards.getText());
				int yellowCards = Integer.parseInt(YellowCards.getText());
				int playTime = Integer.parseInt(PlayTime.getText());
				
				
				
				Team teamPlayer = new Team() ;
				teamPlayer = TeamServicesDelegate.findTeamByName((String)Teams.getSelectedItem());
				
			 
			
				Player player = new Player() ;
				
				player.setFirstName(firstName);
				player.setLastName(lastName);
				player.setGoals(goals);
				player.setPlayTime(playTime);
				player.setRedCards(redCards);
				player.setYellowCards(yellowCards);
				player.setTeam(teamPlayer);
				
				playerService.create(player) ;
				
				
				
			}
		});
		Add.setBounds(400, 351, 89, 23);
		contentPane.add(Add);
		
		Goals = new JTextField();
		Goals.setBounds(140, 156, 28, 20);
		contentPane.add(Goals);
		Goals.setColumns(10);
		
		PlayTime = new JTextField();
		PlayTime.setBounds(140, 207, 28, 20);
		contentPane.add(PlayTime);
		PlayTime.setColumns(10);
		
		RedCards = new JTextField();
		RedCards.setBounds(140, 257, 28, 20);
		contentPane.add(RedCards);
		RedCards.setColumns(10);
		
		YellowCards = new JTextField();
		YellowCards.setBounds(140, 310, 28, 20);
		contentPane.add(YellowCards);
		YellowCards.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name ");
		lblNewLabel.setBounds(27, 14, 65, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(27, 58, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Goals");
		lblNewLabel_2.setBounds(27, 159, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Play Time ");
		lblNewLabel_3.setBounds(27, 210, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Red cards");
		lblNewLabel_4.setBounds(27, 260, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Yellow Cards");
		lblNewLabel_5.setBounds(27, 313, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Team");
		lblNewLabel_6.setBounds(27, 110, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		
		
	}
}
