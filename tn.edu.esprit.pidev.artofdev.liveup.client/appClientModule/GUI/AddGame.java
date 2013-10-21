package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.GameServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.StadiumServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.TeamServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Stadium;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddGame extends JFrame {

	private JPanel contentPane;
	private JTextField timeField;
	private JTextField refreeField;
	private JTextField team1Score;
	private JTextField team2Score;
	private List<Team> teams ;
	private List<Stadium> stadiums ;
	final JComboBox teamCombo1 = new JComboBox();
	final JComboBox teamCombo2 = new JComboBox();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGame frame = new AddGame();
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
	public AddGame() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate();
		final StadiumServicesDelegate stadiumService = new StadiumServicesDelegate();
		final GameServicesDelegate gameService = new GameServicesDelegate();
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final JComboBox typeCombo = new JComboBox();
		
		
		typeCombo.setBounds(107, 337, 87, 20);
		contentPane.add(typeCombo);
		typeCombo.addItem("Group A");
		typeCombo.addItem("Group B");
		typeCombo.addItem("Group C");
		typeCombo.addItem("Group D");
		typeCombo.addItem("Group E");
		typeCombo.addItem("Group F");
		typeCombo.addItem("Group G");
		typeCombo.addItem("Group H");
		typeCombo.addItem("Final Quarter");
		typeCombo.addItem("3rd Place");
		typeCombo.addItem("Semi Final");
		typeCombo.addItem("Final");
		
		teams = new ArrayList<Team>();
		teams=teamService.findAllTeam();
		
		
			
				teamCombo1.setBounds(107, 25, 109, 20);
				contentPane.add(teamCombo1);
				for(Team team : teams)
				{
					teamCombo1.addItem(team.getName());
				}
				
				
				
				teamCombo2.setBounds(107, 84, 109, 20);
				contentPane.add(teamCombo2);
				for(Team team : teams)
				{
					teamCombo2.addItem(team.getName());
				}
			
				
				
	
		
		
		stadiums=stadiumService.findAllStadium();
		
		
		
		JLabel lblNewLabel = new JLabel("Team 1 ");
		lblNewLabel.setBounds(32, 28, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Team 2");
		lblNewLabel_1.setBounds(32, 87, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(107, 144, 87, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setBounds(32, 144, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		timeField = new JTextField();
		timeField.setBounds(108, 197, 86, 20);
		contentPane.add(timeField);
		timeField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Time");
		lblNewLabel_3.setBounds(32, 200, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		refreeField = new JTextField();
		refreeField.setBounds(108, 295, 86, 20);
		contentPane.add(refreeField);
		refreeField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Refree");
		lblNewLabel_4.setBounds(32, 298, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		

		
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(32, 340, 46, 14);
		contentPane.add(lblType);
		
		team1Score = new JTextField();
		team1Score.setBounds(329, 25, 32, 20);
		contentPane.add(team1Score);
		team1Score.setColumns(10);
		
		team2Score = new JTextField();
		team2Score.setBounds(329, 87, 32, 20);
		contentPane.add(team2Score);
		team2Score.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Team1 goals");
		lblNewLabel_5.setBounds(245, 28, 69, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Team2 goals");
		lblNewLabel_6.setBounds(245, 90, 69, 14);
		contentPane.add(lblNewLabel_6);
		
		final JComboBox stadiumCombo = new JComboBox();
		stadiumCombo.setBounds(107, 250, 87, 20);
		contentPane.add(stadiumCombo);
		for(Stadium stadium : stadiums)
		{
			stadiumCombo.addItem(stadium.getName());
		}
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team team1 = new Team();
				Team team2 = new Team();
				team1=teamService.findTeamByName((String)teamCombo1.getSelectedItem());
				team2=teamService.findTeamByName((String)teamCombo2.getSelectedItem());
				List<Team> teamsGame = new ArrayList<Team>();
				teamsGame.add(team1);
				teamsGame.add(team2);
				int team1Goal=Integer.parseInt(team1Score.getText());
				int team2Goal=Integer.parseInt(team2Score.getText());
				Date date = dateChooser.getDate();
				String refree = refreeField.getText();
				String group = (String)typeCombo.getSelectedItem();
				String type = (String)typeCombo.getSelectedItem();
				String time = timeField.getText();
				Stadium stadium = new Stadium();
				stadium =stadiumService.findStadiumByName((String)stadiumCombo.getSelectedItem());
				
				List<Game> games = new ArrayList<Game>();
				List<Team> teams1 = new ArrayList<Team>();
				List<Team> teams2 = new ArrayList<Team>();

				Game game = new Game();
				game.setDate(date);
				game.setGroupe(group);
				game.setRefree(refree);
				game.setType(type);
				game.setTime(time);
				game.setStadium(stadium);
				game.setTeam1Goals(team1Goal);
				game.setTeam1Goals(team2Goal);
				game.setTeams(teamsGame);
				gameService.create(game);
				List<Game> games1 = new ArrayList<Game>();
				List<Game> games2 = new ArrayList<Game>();
				games1=teamService.findGameOnTeam(team1);
				games2=teamService.findGameOnTeam(team2);
				games2=team2.getGame();
				games1.add(game);
				team1.setGame(games1);
				team2.setGame(games2);
				teamService.update(team1);
				teamService.update(team2);
				games.add(game);
				stadium.affectStadiumToGames(games);

				
				


			
			}
		});
		btnNewButton.setBounds(296, 340, 89, 44);
		contentPane.add(btnNewButton);
		
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Stadium");
		lblNewLabel_7.setBounds(32, 253, 46, 14);
		contentPane.add(lblNewLabel_7);
	}
}
