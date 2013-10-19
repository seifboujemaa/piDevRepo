package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddAgentServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAgent extends JFrame {

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
					AddAgent frame = new AddAgent();
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
	public AddAgent() {
		final AddAgentServiceDelegate agentService = new AddAgentServiceDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(59, 85, 46, 14);
		contentPane.add(label);
		
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setBounds(39, 59, 55, 25);
		contentPane.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setBounds(39, 118, 66, 14);
		contentPane.add(lblLastname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(39, 163, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(39, 219, 21, 3);
		contentPane.add(label_1);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(39, 208, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPwd = new JLabel("Pwd");
		lblPwd.setBounds(39, 253, 46, 14);
		contentPane.add(lblPwd);
		
		first = new JTextField();
		first.setBounds(155, 61, 86, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		last = new JTextField();
		last.setBounds(155, 115, 86, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		email = new JTextField();
		email.setBounds(155, 160, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		login = new JTextField();
		login.setBounds(155, 205, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(155, 250, 86, 20);
		contentPane.add(pwd);
		pwd.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agent agent = new Agent() ;
				agent.setFirstName(first.getText());
				agent.setLastName(last.getText());
				agent.setEmail(email.getText());
				agent.setLogin(login.getText());
				agent.setPwd(pwd.getText());
				agentService.create(agent);
				
			}
		});
		btnAjouter.setBounds(288, 322, 89, 23);
		contentPane.add(btnAjouter);
	}
}
