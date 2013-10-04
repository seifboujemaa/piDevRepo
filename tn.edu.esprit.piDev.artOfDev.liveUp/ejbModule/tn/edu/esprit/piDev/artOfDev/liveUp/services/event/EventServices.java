package tn.edu.esprit.piDev.artOfDev.liveUp.services.event;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.piDev.artOfDev.liveUp.entities.Event;
import tn.edu.esprit.piDev.artOfDev.liveUp.entities.Game;

/**
 * Session Bean implementation class EventServices
 */
@Stateless
public class EventServices implements EventServicesRemote, EventServicesLocal {
	@PersistenceContext
	EntityManager entityManager ;
    /**
     * Default constructor. 
     */
    public EventServices() {
    	
    	}

	@Override
	public void createEvent(Event event) {
		entityManager.persist(event);		
	}

	@Override
	public void updateEvent(Event event) {
		entityManager.merge(event);
		
	}

	@Override
	public void deleteEvent(Event event) {
		entityManager.remove(entityManager.merge(event));
		
	}

	@Override
	public Event findEventById(int idEvent) {
		Event event =entityManager.find(Event.class, idEvent);
		return event;
	}

	@Override
	public List<Event> findAllEvent() {
		Query query=entityManager.createQuery("select e from Event e");
		return query.getResultList();
	}

	@Override
	public List<Event> findEventByMatch(int idMatch) {
		Query query=entityManager.createQuery("select e from Event e where idGame='" + idMatch +  "' " );
		return query.getResultList();
	}

}
