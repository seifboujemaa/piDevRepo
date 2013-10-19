package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;

@Local
public interface UserServicesLocal {
	public User authentification(String login , String password);

}
