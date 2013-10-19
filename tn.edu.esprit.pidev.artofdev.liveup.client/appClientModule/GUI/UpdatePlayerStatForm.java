package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.PlayerServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePlayerStatForm extends JFrame {

	private JPanel contentPane;
	public JTextField first;
	public JTextField goal;
	public JTextField last;
	public JTextField play;
	public JTextField red;
	public JTextField yellow;
	public int idplayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePlayerStatForm frame = new UpdatePlayerStatForm();
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
	public UpdatePlayerStatForm() {
		final PlayerServicesDelegate playerService = new PlayerServicesDelegate();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		first = new JTextField();
		goal = new JTextField();
		last = new JTextField();
		play = new JTextField();
		red = new JTextField();
		yellow = new JTextField();
		first.setBounds(119, 43, 86, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		
		goal.setBounds(119, 103, 86, 20);
		contentPane.add(goal);
		goal.setColumns(10);
		
	
		last.setBounds(119, 162, 86, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		
		play.setBounds(119, 225, 86, 20);
		contentPane.add(play);
		play.setColumns(10);
		
		
		red.setBounds(119, 290, 86, 20);
		contentPane.add(red);
		red.setColumns(10);
		
		
		yellow.setBounds(119, 353, 86, 20);
		contentPane.add(yellow);
		yellow.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Yellow Cards");
		lblNewLabel.setBounds(20, 356, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Red Cards");
		lblNewLabel_1.setBounds(20, 293, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Play Time");
		lblNewLabel_2.setBounds(20, 228, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setBounds(20, 165, 64, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Goals");
		lblNewLabel_4.setBounds(20, 106, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("First Name");
		lblNewLabel_5.setBounds(20, 46, 70, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idplayer=UpdatePlayerStat.id ;
				Player player = new Player () ;
				player = playerService.findPlayerById(idplayer);
				player.setFirstName(first.getText());
				player.setLastName(last.getText());
				player.setGoals(Integer.parseInt(goal.getText()));
				player.setPlayTime(Integer.parseInt(play.getText()));
				player.setRedCards(Integer.parseInt(red.getText()));
				player.setYellowCards(Integer.parseInt(yellow.getText()));
				playerService.update(player);
				
			}
		});
		btnNewButton.setBounds(289, 371, 89, 33);
		contentPane.add(btnNewButton);
	}

	public JTextField getFirst() {
		return first;
	}

	public void setFirst(JTextField first) {
		this.first = first;
	}

	public JTextField getGoal() {
		return goal;
	}

	public void setGoal(JTextField goal) {
		this.goal = goal;
	}

	public JTextField getLast() {
		return last;
	}

	public void setLast(JTextField last) {
		this.last = last;
	}

	public JTextField getPlay() {
		return play;
	}

	public void setPlay(JTextField play) {
		this.play = play;
	}

	public JTextField getRed() {
		return red;
	}

	public void setRed(JTextField red) {
		this.red = red;
	}

	public JTextField getYellow() {
		return yellow;
	}

	public void setYellow(JTextField yellow) {
		this.yellow = yellow;
	}

}
