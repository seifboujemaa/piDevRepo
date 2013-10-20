package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddAgentServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddFreeLanceServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.Freelance;

public class AddFreeLance extends JFrame {

	private JPanel contentPane;
	private JTextField first;
	private JTextField last;
	private JTextField email;
	private JTextField login;
	private JTextField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFreeLance frame = new AddFreeLance();
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
	public AddFreeLance() {
		final AddFreeLanceServicesDelegate freelanceServices = new AddFreeLanceServicesDelegate();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLastname = new JLabel("LastName:");
		lblLastname.setBounds(30, 53, 64, 14);
		contentPane.add(lblLastname);
		
		JLabel lblFirstname = new JLabel("FirstName:");
		lblFirstname.setBounds(30, 11, 64, 14);
		contentPane.add(lblFirstname);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(30, 97, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(30, 137, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPwd = new JLabel("Pwd:");
		lblPwd.setBounds(30, 174, 46, 14);
		contentPane.add(lblPwd);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FreeLance freelance = new FreeLance();
				
				freelance.setFirstName(first.getText());
				freelance.setLastName(last.getText());
				freelance.setEmail(email.getText());
				freelance.setLogin(login.getText());
				freelance.setPwd(pwd.getText());
				freelanceServices.create(freelance);
				
				
				
							
			
			}
		});
		btnNewButton.setBounds(316, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		first = new JTextField();
		first.setBounds(164, 8, 86, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		last = new JTextField();
		last.setBounds(164, 50, 86, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		email = new JTextField();
		email.setBounds(164, 94, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		login = new JTextField();
		login.setBounds(164, 134, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(164, 171, 86, 20);
		contentPane.add(pwd);
		pwd.setColumns(10);
	}
}
