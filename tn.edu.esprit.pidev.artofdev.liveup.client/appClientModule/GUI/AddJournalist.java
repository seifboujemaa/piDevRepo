package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddAdministratorServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddAgentServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddJournalist extends JFrame {

	private JPanel contentPane;
	private JTextField last;
	private JTextField first;
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
					AddJournalist frame = new AddJournalist();
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
	public AddJournalist() {
		final AddAdministratorServicesDelegate administratorService = new AddAdministratorServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setBounds(10, 42, 73, 14);
		contentPane.add(lblLastname);
		
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setBounds(10, 75, 57, 14);
		contentPane.add(lblFirstname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 112, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 149, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPwd = new JLabel("Pwd");
		lblPwd.setBounds(10, 189, 46, 14);
		contentPane.add(lblPwd);
		
		last = new JTextField();
		last.setBounds(108, 39, 86, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		first = new JTextField();
		first.setBounds(108, 72, 86, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		email = new JTextField();
		email.setBounds(108, 109, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		login = new JTextField();
		login.setBounds(108, 146, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(108, 186, 86, 20);
		contentPane.add(pwd);
		pwd.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Journalist journalist = new Journalist() ;
				journalist.setFirstName(first.getText());
				journalist.setLastName(last.getText());
				journalist.setEmail(email.getText());
				journalist.setLogin(login.getText());
				journalist.setPwd(pwd.getText());
				administratorService.create(journalist);
			}
		});
		btnAdd.setBounds(298, 227, 89, 23);
		contentPane.add(btnAdd);
	}

}
