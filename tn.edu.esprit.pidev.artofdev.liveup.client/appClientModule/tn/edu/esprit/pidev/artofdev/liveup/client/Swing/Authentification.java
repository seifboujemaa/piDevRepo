package tn.edu.esprit.pidev.artofdev.liveup.client.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(100, 73, 374, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(93, 48, 187, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(93, 87, 187, 20);
		panel.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(22, 51, 46, 14);
		panel.add(lblLogin);
		
		JLabel lblPassowrd = new JLabel("Passowrd");
		lblPassowrd.setBounds(22, 90, 46, 14);
		panel.add(lblPassowrd);
		
		JLabel label = new JLabel("\"\"\"\"\"\"\"\"\"\"");
		label.setBounds(160, 118, 46, 14);
		panel.add(label);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(275, 135, 89, 23);
		panel.add(btnConnexion);
	}
}
