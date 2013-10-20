package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.SubscribedClient;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.subscribbedclient.SubscribedclientServiceRemote;

public class SubscribedclientServiceDelegate {
	
	
	private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/SubscribedclientService!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.subscribbedclient.SubscribedclientServiceRemote";

	private static SubscribedclientServiceRemote getProxy() {
		return (SubscribedclientServiceRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public void create(SubscribedClient subscribedClient) {
		getProxy().createSubscribedClient(subscribedClient);

	}

	public static void update(SubscribedClient subscribedClient) {
		getProxy().updateSubscribedClient(subscribedClient);

	}

	public static void delete(SubscribedClient subscribedClient) {
		getProxy().deleteSubscribedClient(subscribedClient);

	}

	public static List<SubscribedClient> findAllSubscribedClients() {
		return getProxy().findAllSubscribedClient();
	}

	public static SubscribedClient findSubJournalistById(int idSubscribedClient) {
		return getProxy().findSubscribedClientById(idSubscribedClient);
	}

}
