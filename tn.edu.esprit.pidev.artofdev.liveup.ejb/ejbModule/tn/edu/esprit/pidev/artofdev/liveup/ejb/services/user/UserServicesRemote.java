package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.SubscribedClient;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;

@Remote
public interface UserServicesRemote {
	public User authentification(String login , String password);
	public void Create(SubscribedClient client);
	public User authentificationCondition(String login , String password );
	public List<User> findAllAgent();

}
