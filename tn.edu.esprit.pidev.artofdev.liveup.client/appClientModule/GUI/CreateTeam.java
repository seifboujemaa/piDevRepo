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
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class CreateTeam extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_6;
	
	List<Player> players = new ArrayList<Player>();


	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTeam frame = new CreateTeam();
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
	public CreateTeam() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(156, 11, 101, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Team Name ");
		lblNewLabel.setBounds(58, 14, 88, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team team = new Team();
				team.setName(textField.getText());
				team.affectTeamToPlayers(players);
				teamService.create(team);
		}
		});
		btnNewButton.setBounds(119, 127, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(119, 42, 46, 14);
		contentPane.add(lblPlayers);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 67, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(156, 67, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Player");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player player = new Player();
				player.setFirstName(textField_1.getText());
				player.setLastName(textField_6.getText());
				players.add(player);
				
				textField_1.setText("");
				textField_6.setText("");

			}
		});
		btnNewButton_1.setBounds(299, 66, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
