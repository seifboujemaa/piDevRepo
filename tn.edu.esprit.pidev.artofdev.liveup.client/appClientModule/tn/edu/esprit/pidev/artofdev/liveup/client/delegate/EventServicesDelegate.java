package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Event;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.event.EventServicesRemote;

public class EventServicesDelegate {
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/EventServices!"+EventServicesRemote.class.getCanonicalName();
	
	private static EventServicesRemote getProxy(){
		return (EventServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Event event) {
		getProxy().createEvent(event);
		
	}
	
	public static void update(Event event) {
		getProxy().updateEventEvent(event);
		
	}
	public static void delete(Event event) {
		getProxy().deleteEvent(event);
		
	}
	public static void findAllEvent() {
		getProxy().findAllEvent();
		
	}
	public static void findEventById(int idEvent) {
		getProxy().findEventById(idEvent);
		
	}

}
