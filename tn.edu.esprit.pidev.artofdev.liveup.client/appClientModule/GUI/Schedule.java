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
		setBounds(100, 100, 668, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		
		table = new JTable();
		table.setBounds(29, 100, 567, 325);
		contentPane.add(table);
		
				final DefaultTableModel tab = new DefaultTableModel();
				tab.setRowCount(0);
				
					
					tab.addColumn("ID");
				    tab.addColumn("Date");
					tab.addColumn("Time");
					tab.addColumn("Match Schedule");
					tab.addColumn("Team1");
					tab.addColumn("Team2");
					
					games = gameService.findAllGame();

					for(Game game : games)
					{
						
						 List<Team> teams = new ArrayList<Team>();
						 String team1 ;
						 String team2 ;

						 int id = game.getIdGame();
						 Date date = game.getDate();
						 String time = game.getTime();
						 String group = game.getGroupe();
						 teams = gameService.findTeamsOnGame(game);
						 team1=teams.get(0).getName();
						 team2=teams.get(1).getName();
						 String ref = game.getRefree();
						 String stad = game.getStadium().toString();
						 
						 
						 

						 
						 
						
						Object[] obj = {id,date,time,group,team1,team2} ;
						tab.addRow(obj);
					}
					table.setModel(tab);
					
					JButton btnNewButton = new JButton("Delete");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) { 
							int a = table.getSelectedRow();
							Game game=new Game();
							int id=(Integer) table.getValueAt(a,0);
							game=gameService.findGameById(id);
							gameService.delete(game);
							
						
							
								}
					});
					btnNewButton.setBounds(495, 55, 108, 30);
					contentPane.add(btnNewButton);
					
					up = new JButton("Update");
					up.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int a = table.getSelectedRow();
							Game game = new Game();
							int id=(Integer) table.getValueAt(a,0);
							game=gameService.findGameById(id);
							Date date = (Date) table.getValueAt(a,1);
							String time = (String) table.getValueAt(a,2);
							String group = (String) table.getValueAt(a,3);
							game.setDate(date);
							game.setTime(time);
							game.setGroupe(group);
							gameService.update(game);
							
						}
					});
					up.setBounds(353, 55, 108, 30);
					contentPane.add(up);
					
					
					
				
				
				
				
				
				
			
		
		


		
		
		
		
		
	}
}
