package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;


@Stateless
public class JournalistServices implements JournalistServicesLocal,JournalistServicesRemote {

	@PersistenceContext
	EntityManager entityManager ;
	
	public JournalistServices(){
		
	}
	
	@Override
	public void createEvent(Journalist journalist) {
		entityManager.persist(journalist);
		
	}

	@Override
	public void updateEvent(Journalist journalist) {
		entityManager.merge(journalist);
		
	}

	@Override
	public void deleteEvent(Journalist journalist) {
		entityManager.remove(entityManager.merge(journalist));
		
	}

	@Override
	public Journalist findJournalistById(int idJournalist) {
		Journalist journalist =entityManager.find(Journalist.class, idJournalist);
		return journalist;
	}

	@Override
	public List<Journalist> findAllJournalist() {
		Query query=entityManager.createQuery("select e from Journalist e");
		return query.getResultList();
	}
	
	
	
	
	

}
