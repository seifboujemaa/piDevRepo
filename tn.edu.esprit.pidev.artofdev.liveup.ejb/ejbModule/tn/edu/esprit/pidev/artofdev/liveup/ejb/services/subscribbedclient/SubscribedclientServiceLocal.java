package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.subscribbedclient;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.SubscribedClient;
@Local
public interface SubscribedclientServiceLocal {
	
	public void createSubscribedClient(SubscribedClient subscribedClient);
	public void updateSubscribedClient(SubscribedClient subscribedClient);
	public void deleteSubscribedClient(SubscribedClient subscribedClient);
	public SubscribedClient findSubscribedClientById(int idSubscribedClient);
	public List<SubscribedClient> findAllSubscribedClient(); 

}
