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

public class Schedule extends JFrame {

	private JPanel contentPane;
	private List<Game> games = new ArrayList<Game>();
	private JTable table;

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
				
					
					tab.addColumn("Date");
					tab.addColumn("Time");
					tab.addColumn("Match Schedule");
					
					games = gameService.findAllGame();

					for(Game game : games)
					{
						
						 Date date = game.getDate();
						 String time = game.getTime();
						 String group = game.getGroupe();
						 
						
						Object[] obj = {date,time,group} ;
						tab.addRow(obj);
					}
					table.setModel(tab);
					
					
				
				
				
				
				
				
			
		
		


		
		
		
		
		
	}
}
