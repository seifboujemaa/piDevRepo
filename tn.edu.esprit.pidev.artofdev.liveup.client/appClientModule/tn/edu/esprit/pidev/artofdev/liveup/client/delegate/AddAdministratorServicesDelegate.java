package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist.JournalistServicesRemote;



public class AddAdministratorServicesDelegate {
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/JournalistServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist.JournalistServicesRemote";

	
	private static JournalistServicesRemote getProxy(){
		return (JournalistServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	
/*	public  void create(Agent agent) {
		getProxy().createAgent(agent);
		
	}
	
	public static void update(Agent agent) {
		getProxy().updateAgent(agent);
		
	}
	public static void delete(Agent agent) {
		getProxy().deleteAgent(agent);
		
	}
	public static List<Agent> findAllAgent() {
		return getProxy().findAllAgent();
		
	}
	public static Agent findAgentById(int idAgent) {
		return getProxy().findAgentById(idAgent);
		
	}
	*/

	public  void create(Journalist journalist) {
		getProxy().createJournalist(journalist);
		
	}
	
	public static void update(Journalist journalist) {
		getProxy().updateJournalist(journalist);
		
	}
	public static void delete(Journalist journalist) {
		getProxy().deleteJournalist(journalist);
		
	}
	public static List<Journalist> findAllJournaliste() {
		return getProxy().findAllJournalist();
		
	}
	public static Journalist findJournalistById(int idJournalist) {
		return getProxy().findJournalistById(idJournalist);
		
	}
	

}
