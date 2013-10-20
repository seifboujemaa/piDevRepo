package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.EventServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.GameServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.TeamServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Event;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AddEvent extends JFrame {

	private JPanel contentPane;
	private JTextField desc;
	private JTextField min;
	private JTable table;
	List<Team> teams = new ArrayList<Team>();
	List<Game> games  = new ArrayList<Game>();
	public Date date ;
	public String group ;
	public String typee ;
	public String team1 ;
	public String team2 ;
	public int id ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				 AddEvent frame = new AddEvent();
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
	public AddEvent() {
		final EventServicesDelegate eventSErvice = new EventServicesDelegate();
		final TeamServicesDelegate teamService = new TeamServicesDelegate();
		final GameServicesDelegate gameService = new GameServicesDelegate();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desc = new JTextField();
		desc.setBounds(115, 214, 390, 89);
		contentPane.add(desc);
		desc.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description");
		lblNewLabel.setBounds(10, 214, 95, 14);
		contentPane.add(lblNewLabel);
		
		min = new JTextField();
		min.setBounds(115, 327, 56, 20);
		contentPane.add(min);
		min.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Minute");
		lblNewLabel_1.setBounds(10, 330, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		final JComboBox type = new JComboBox();
		type.setBounds(115, 371, 167, 20);
		contentPane.add(type);
		
		type.addItem("Goal");
		type.addItem("Injury");
		type.addItem("Foul");
		type.addItem("Red Card");
		type.addItem("Yellow Card");
		type.addItem("Offside");
		type.addItem("Substitute");
		type.addItem("Half time");
		type.addItem("End");
		type.addItem("Other");


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 11, 524, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		final DefaultTableModel tab = new DefaultTableModel();
		tab.setRowCount(0);
		
		tab.addColumn("Id");
		tab.addColumn("Date");
		tab.addColumn("Group");
		tab.addColumn("Type");
		tab.addColumn("Team 1");
		tab.addColumn("Team 2");
		
		
	  games = gameService.findAllGame();
	  for(Game game : games)
	  {
		  List<Team> teams = new ArrayList<Team>();

		  id=game.getIdGame();
		  date=game.getDate();
		  group=game.getGroupe();
		  typee = game.getType();
		  teams = gameService.findTeamsOnGame(game);
		  team1=teams.get(0).getName();
		  team2=teams.get(1).getName();
		  Object[] obj = {id,date,group,typee,team1,team2} ;
		  tab.addRow(obj);

		  }
	  
	  table.setModel(tab);

		

		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Type ");
		lblNewLabel_2.setBounds(10, 374, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(554, 386, 89, 46);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Event event = new Event () ;
				event.setDesciption(desc.getText());
				event.setMinute(Integer.parseInt(min.getText()));
				event.setType((String)type.getSelectedItem());
				int a = table.getSelectedRow();
				Game gameSelected = new Game () ;
				gameSelected=gameService.findGameById((Integer) table.getValueAt(a,0));
				event.setGame(gameSelected);
				eventSErvice.create(event);
				
			}
		});
		contentPane.add(btnNewButton);
		
		
		
		
	
	  
		
		
	}
}
