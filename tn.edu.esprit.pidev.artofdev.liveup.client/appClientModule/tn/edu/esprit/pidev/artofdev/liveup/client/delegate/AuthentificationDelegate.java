package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.SelectFreelance;
import GUI.SelectJournalist;

import tn.edu.esprit.pidev.artofdev.liveup.client.Swing.AuthentificationSwing;
import tn.edu.esprit.pidev.artofdev.liveup.client.Swing.ChefEditorArticleSwing;
import tn.edu.esprit.pidev.artofdev.liveup.client.Swing.ReporterPhotoViewDeleteSwing;
import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Administrator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user.UserServicesRemote;

public class AuthentificationDelegate {
	private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/UserServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user.UserServicesRemote";
	private static UserServicesRemote getProxy(){
		return (UserServicesRemote) ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	
	public static void Authentification(AuthentificationSwing a , String login , String password , JPanel contentPane ){
		
		User user =getProxy().authentification(login, password);
		if(user!=null){
			if(user instanceof ChefEditor)
				 {new ChefEditorArticleSwing().setVisible(true);
                 
				 a.setVisible(false);
				 }
			if(user instanceof Reporter){
			new ReporterPhotoViewDeleteSwing().setVisible(true);
            a.setVisible(false);}
			
			if(user instanceof FreeLance)
			{
				new SelectFreelance().setVisible(true);
			a.setVisible(false);
			}
			if(user instanceof Journalist)
			{
				new SelectJournalist().setVisible(true);
				a.setVisible(false);
			}
			if(user instanceof Reporter)
			{
				new ReporterPhotoViewDeleteSwing().setVisible(true);
				a.setVisible(false);
			}
			if(user instanceof ChefEditor)
			{
				new ChefEditorArticleSwing().setVisible(true);
				a.setVisible(false);
			}
			if(user instanceof Administrator){
				
			}
		}
		//if(journalist)
		
		else {JLabel label = new JLabel("");
		label.setBounds(113, 190, 217, 14);
		contentPane.add(label);
		label.setText("Login  failed !");
		}
		
	}


}
