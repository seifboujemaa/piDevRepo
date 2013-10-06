package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;


public interface JournalistServicesRemote {
	
	
	public void createEvent(Journalist journalist);
	public void updateEvent(Journalist journalist);
	public void deleteEvent(Journalist journalist);
	public Journalist findJournalistById(int idJournalist);
	public List<Journalist> findAllJournalist();  

}
