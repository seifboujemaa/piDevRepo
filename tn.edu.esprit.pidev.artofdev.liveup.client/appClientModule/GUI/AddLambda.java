package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.LambdaServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Lambda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLambda extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField pswd;
	private JTextField first;
	private JTextField last;
	private JTextField mail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLambda frame = new AddLambda();
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
	public AddLambda() {
		final LambdaServicesDelegate  lambdaService = new LambdaServicesDelegate () ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("login");
		lblNewLabel.setBounds(22, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(22, 63, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First name");
		lblNewLabel_2.setBounds(22, 104, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last name");
		lblNewLabel_3.setBounds(22, 143, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(22, 185, 98, 14);
		contentPane.add(lblNewLabel_4);
		
		login = new JTextField();
		login.setBounds(136, 21, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		pswd = new JTextField();
		pswd.setBounds(146, 60, 86, 20);
		contentPane.add(pswd);
		pswd.setColumns(10);
		
		first = new JTextField();
		first.setBounds(156, 101, 86, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		last = new JTextField();
		last.setBounds(136, 140, 86, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(136, 182, 86, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lambda lambda = new Lambda() ;
				lambda.setEmail(mail.getText());
				lambda.setFirstName(first.getText());
				lambda.setLastName(last.getText());
				lambda.setLogin(login.getText());
				lambda.setPwd(pswd.getText());
				lambdaService.create(lambda);
				
			}
		});
		btnNewButton.setBounds(250, 208, 89, 23);
		contentPane.add(btnNewButton);
	}
}
