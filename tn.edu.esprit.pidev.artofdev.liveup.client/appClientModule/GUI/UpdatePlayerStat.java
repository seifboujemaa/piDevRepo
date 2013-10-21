package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.PlayerServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.TeamServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdatePlayerStat extends JFrame {

	private JPanel contentPane;
	List<Player> players = new ArrayList<Player>();
	private JTable table;
	public static int id ;
	public String first ;
	public String last ;
	public int goals ;
	public int time ;
	public int red ;
	public int yellow ;
	private JButton btnNewButton;
	UpdatePlayerStatForm updateForm ;
	private JButton delete;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePlayerStat frame = new UpdatePlayerStat();
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
	public UpdatePlayerStat() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate();
		final PlayerServicesDelegate playerService = new PlayerServicesDelegate();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 146, 525, 224);
		contentPane.add(scrollPane);
	
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
			
		
		final JComboBox comboTeam = new JComboBox();
		comboTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Team team = teamService.findTeamByName((String)comboTeam.getSelectedItem());
				players=playerService.findPlayerByTeam(team.getIdTeam());
				
				final DefaultTableModel tab = new DefaultTableModel();
				tab.setRowCount(0);
				
				tab.addColumn("ID");
				tab.addColumn("First Name");
				tab.addColumn("Goals");
				tab.addColumn("Last name");
				tab.addColumn("Play time");
				tab.addColumn("Red Cards");
				tab.addColumn("Yellow Cards");
				
				for(Player player : players)
				{
					id=player.getIntPlayer();
					 first = player.getFirstName();
					 goals = player.getGoals();
					 last = player.getLastName();
					 time = player.getPlayTime();
					 red = player.getRedCards();
					 yellow = player.getYellowCards();
					Object[] obj = {id,first,goals,last,time,red,yellow} ;
					tab.addRow(obj);
				}
				
				table.setModel(tab);
			}
		});
		comboTeam.setBounds(131, 66, 99, 20);
		contentPane.add(comboTeam);
		 List<Team> teams = new ArrayList<Team>();
		 teams=teamService.findAllTeam();
		 for(Team team : teams)
		 {
			 comboTeam.addItem(team.getName());
		 }
		
		JLabel lblNewLabel = new JLabel("Select Team");
		lblNewLabel.setBounds(27, 69, 94, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 updateForm = new UpdatePlayerStatForm();
			 int a = table.getSelectedRow();
			 if(a!=-1)
			 {
			updateForm.first.setText(table.getValueAt(a,0).toString());
			updateForm.goal.setText(table.getValueAt(a,1).toString());
			updateForm.last.setText(table.getValueAt(a,2).toString());
			updateForm.play.setText(table.getValueAt(a,3).toString());
			updateForm.red.setText(table.getValueAt(a,4).toString());
			updateForm.yellow.setText(table.getValueAt(a,5).toString());
			
			
			 }
			 updateForm.show();
			}
		});
		btnNewButton.setBounds(454, 55, 89, 33);
		contentPane.add(btnNewButton);
		
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = table.getSelectedRow();
				Player player = new Player();
				int id = (Integer) table.getValueAt(a, 0);
				player =playerService.findPlayerById(id);
				playerService.delete(player);
				
				
			}
		});
		delete.setBounds(336, 55, 89, 33);
		contentPane.add(delete);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
