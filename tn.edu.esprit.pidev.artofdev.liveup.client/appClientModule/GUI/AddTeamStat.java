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
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTeamStat extends JFrame {

	private JPanel contentPane;
	private JTextField Victories;
	private JTextField Draws;
	private JTextField Defeats;
	private JLabel lblNewLabel_3;
	
	

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeamStat frame = new AddTeamStat();
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
	public AddTeamStat() {
		final TeamServicesDelegate teamService = new TeamServicesDelegate() ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Victories = new JTextField();
		Victories.setBounds(130, 45, 46, 20);
		contentPane.add(Victories);
		Victories.setColumns(10);
		
		Draws = new JTextField();
		Draws.setBounds(130, 119, 46, 20);
		contentPane.add(Draws);
		Draws.setColumns(10);
		
		Defeats = new JTextField();
		Defeats.setBounds(130, 185, 46, 20);
		contentPane.add(Defeats);
		Defeats.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Victories");
		lblNewLabel.setBounds(32, 48, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Draws");
		lblNewLabel_1.setBounds(32, 122, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Defeats");
		lblNewLabel_2.setBounds(32, 188, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int victories = Integer.parseInt(Victories.getText());
				int draws = Integer.parseInt(Draws.getText());
				int defeats = Integer.parseInt(Defeats.getText());
				
				Team team = teamService.findTeamByName(lblNewLabel_3.getText());
				team.setDraws(draws);
				team.setDefeats(defeats);
				team.setVictories(victories);
				teamService.update(team);
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(249, 277, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(227, 25, 173, 14);
		contentPane.add(lblNewLabel_3);
	}
}
