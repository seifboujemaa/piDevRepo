package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.GameServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.TeamServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;

import org.omg.DynamicAny.DynValueOperations;

public class Schedule extends JFrame {

	private JPanel contentPane;
	private List<Game> games = new ArrayList<Game>();
	private JTable table;
	private JButton up;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule frame = new Schedule();
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
	public Schedule() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate();
		final GameServicesDelegate gameService = new GameServicesDelegate();


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
				final DefaultTableModel tab = new DefaultTableModel();
				tab.setRowCount(0);
				
					
					tab.addColumn("ID");
				    tab.addColumn("Date");
					tab.addColumn("Time");
					tab.addColumn("Ref");
					tab.addColumn("Match Schedule");
					tab.addColumn("Team1");
					tab.addColumn("Team2");
					tab.addColumn("Team1 Score");
					tab.addColumn("Team2 Score");
					
					games = gameService.findAllGame();

					for(Game game : games)
					{
						
						 List<Team> teams = new ArrayList<Team>();
						 String team1 ;
						 String team2 ;

						 int id = game.getIdGame();
						 Date date = game.getDate();
						 String time = game.getTime();
						 String ref = game.getRefree();
						 String group = game.getGroupe();
						 teams = GameServicesDelegate.findTeamsOnGame(game);
						 team1=teams.get(0).getName();
						 team2=teams.get(1).getName();
						 int goal1 = game.getTeam1Goals();
						 int goal2 = game.getTeam2Goals();
						 String stad = game.getStadium().toString();
						 
						 
						 

						 
						 
						
						Object[] obj = {id,date,time,ref,group,team1,team2,goal1,goal2} ;
						tab.addRow(obj);
					}
					
					JButton btnNewButton = new JButton("Delete");
					btnNewButton.setBounds(495, 55, 108, 30);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) { 
							int a = table.getSelectedRow();
							Game game=new Game();
							int id=(Integer) table.getValueAt(a,0);
							game=gameService.findGameById(id);
							gameService.delete(game);
							
						
							
								}
					});
					contentPane.setLayout(null);
					contentPane.add(btnNewButton);
					
					up = new JButton("Update");
					up.setBounds(353, 55, 108, 30);
					up.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
						}
					});
					contentPane.add(up);
					
					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(10, 115, 799, 453);
					contentPane.add(scrollPane_1);
					
					
					
					
					
					
					
					table = new JTable();
					scrollPane_1.setViewportView(table);
					table.setModel(tab);
					
					
					
				
				
				
				
				
				
			
		
		


		
		
		
		
		
	}
}
