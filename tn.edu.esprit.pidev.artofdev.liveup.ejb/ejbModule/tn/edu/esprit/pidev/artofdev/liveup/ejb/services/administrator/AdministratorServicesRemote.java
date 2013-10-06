package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Administrator;

@Remote
public interface AdministratorServicesRemote {
	public void createAdministrator(Administrator administrator);
	public void updateAdministrato(Administrator administrator);
	public void deleteAdministrator(Administrator administrator);
	public Administrator findAdministratorById(int idAdministrator);
	public List<Administrator> findAllAdministrator();
	public Administrator authentification(String login, String password);
	public void disconnect();
	

}
