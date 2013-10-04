package tn.edu.esprit.piDev.artOfDev.liveUp.services.event;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.piDev.artOfDev.liveUp.entities.Event;
import tn.edu.esprit.piDev.artOfDev.liveUp.entities.Game;

@Local
public interface EventServicesLocal {
	public void createEvent(Event event);
	public void updateEvent(Event event);
	public void deleteEvent(Event event);
	public Event findEventById(int idEvent);
	public List<Event> findAllEvent();   
	public List<Event> findEventByMatch(int idMatch);

}
