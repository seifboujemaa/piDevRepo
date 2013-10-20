package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.ReporterServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddReporter extends JFrame {

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
					AddReporter frame = new AddReporter();
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
	public AddReporter() {
		final ReporterServicesDelegate reporterService = new ReporterServicesDelegate();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFristname = new JLabel("FristName:");
		lblFristname.setBounds(40, 55, 63, 14);
		contentPane.add(lblFristname);
		
		JLabel lblLastname = new JLabel("LastName:");
		lblLastname.setBounds(40, 95, 63, 14);
		contentPane.add(lblLastname);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(40, 142, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(40, 186, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPwd = new JLabel("Pwd:");
		lblPwd.setBounds(40, 224, 46, 14);
		contentPane.add(lblPwd);
		
		first = new JTextField();
		first.setBounds(122, 52, 86, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		last = new JTextField();
		last.setBounds(122, 92, 86, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		email = new JTextField();
		email.setBounds(122, 139, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		login = new JTextField();
		login.setBounds(122, 183, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(122, 221, 86, 20);
		contentPane.add(pwd);
		pwd.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reporter reporter = new Reporter() ;
				reporter.setFirstName(first.getText());
				reporter.setLastName(last.getText());
				reporter.setEmail(email.getText());
				reporter.setLogin(login.getText());
				reporter.setPwd(pwd.getText());
				
				reporterService.create(reporter);				
			}
				
			
		});
		btnAdd.setBounds(296, 238, 89, 23);
		contentPane.add(btnAdd);
	}
}
