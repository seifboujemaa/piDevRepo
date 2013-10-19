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
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddChefEditorServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddChefEditor extends JFrame {

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
					AddChefEditor frame = new AddChefEditor();
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
	public AddChefEditor() {
		final AddChefEditorServicesDelegate chefeditorService = new AddChefEditorServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLastname = new JLabel("LastName :");
		lblLastname.setBounds(10, 41, 67, 14);
		contentPane.add(lblLastname);
		
		JLabel label = new JLabel("FirstName :");
		label.setBounds(10, 80, 67, 14);
		contentPane.add(label);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 124, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(10, 167, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPwd = new JLabel("Pwd :");
		lblPwd.setBounds(10, 209, 46, 14);
		contentPane.add(lblPwd);
		
		last = new JTextField();
		last.setBounds(84, 38, 86, 20);
		contentPane.add(last);
		last.setColumns(10);
		
		first = new JTextField();
		first.setBounds(84, 77, 86, 20);
		contentPane.add(first);
		first.setColumns(10);
		
		email = new JTextField();
		email.setBounds(84, 121, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		login = new JTextField();
		login.setBounds(84, 164, 86, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(84, 206, 86, 20);
		contentPane.add(pwd);
		pwd.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChefEditor chefeditor = new ChefEditor() ;
				chefeditor.setFirstName(first.getText());
				chefeditor.setLastName(last.getText());
				chefeditor.setEmail(email.getText());
				chefeditor.setLogin(login.getText());
				chefeditor.setPwd(pwd.getText());
				chefeditorService.create(chefeditor);
				
			}
				
			
		});
		btnAdd.setBounds(335, 205, 89, 23);
		contentPane.add(btnAdd);
	}
}
