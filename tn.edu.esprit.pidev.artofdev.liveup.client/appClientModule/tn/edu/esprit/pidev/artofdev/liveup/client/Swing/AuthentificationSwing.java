package tn.edu.esprit.pidev.artofdev.liveup.client.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AuthentificationDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user.UserServicesRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class AuthentificationSwing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	UserServicesRemote remote = null;
	private JPasswordField passwordField;
	static AuthentificationSwing frame = null ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AuthentificationSwing();
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
	public AuthentificationSwing() {
		final AuthentificationDelegate authentificationDelegate = new AuthentificationDelegate();
		
//		try {
//			Context context= new InitialContext();
//		Object o=	context.lookup("ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/UserServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user.UserServicesRemote");
//		remote =  (UserServicesRemote) o;
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(138, 67, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(52, 70, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 101, 46, 14);
		contentPane.add(lblPassword);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				authentificationDelegate.Authentification(frame, textField.getText(), passwordField.getText(), contentPane);
				
//				User user =remote.authentification(textField.getText(), passwordField.getText());
//				if(user!=null){
//					if(user instanceof ChefEditor)
//						 {new ChefEditorArticleSwing().setVisible(true);
//		                 setVisible(false);}
//					if(user instanceof Reporter){
//					new ReporterPhotoViewDeleteSwing().setVisible(true);
//	                setVisible(false);}
//					}
//				else {JLabel label = new JLabel("");
//				label.setBounds(113, 190, 217, 14);
//				contentPane.add(label);
//				label.setText("Login  failed !");
//				}
			} 
				
		
		});
		btnConnexion.setBounds(189, 129, 118, 23);
		contentPane.add(btnConnexion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 98, 140, 20);
		contentPane.add(passwordField);
		
//		JLabel label = new JLabel("");
//		label.setBounds(113, 190, 217, 14);
//		contentPane.add(label);
	}
}
