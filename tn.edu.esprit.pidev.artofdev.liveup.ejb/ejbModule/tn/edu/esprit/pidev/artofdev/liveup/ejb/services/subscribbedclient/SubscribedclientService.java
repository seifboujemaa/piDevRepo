package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.subscribbedclient;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.SubscribedClient;
@Stateless
public class SubscribedclientService implements SubscribedclientServiceLocal,SubscribedclientServiceRemote {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void createSubscribedClient(SubscribedClient subscribedClient) {
		entityManager.persist(subscribedClient);
		
	}

	@Override
	public void updateSubscribedClient(SubscribedClient subscribedClient) {
		entityManager.merge(subscribedClient);
		
	}

	@Override
	public void deleteSubscribedClient(SubscribedClient subscribedClient) {
		entityManager.remove(entityManager.merge(subscribedClient));
		
	}

	@Override
	public SubscribedClient findSubscribedClientById(int idSubscribedClient) {
		SubscribedClient subscribedClient = entityManager.find(SubscribedClient.class,
				idSubscribedClient);
		return subscribedClient;
	}

	@Override
	public List<SubscribedClient> findAllSubscribedClient() {
		Query query = entityManager.createQuery("from SubscribedClient e");
		List<SubscribedClient> subscribedClients = query.getResultList();
		
		return subscribedClients;
	}
	
	
	

}
