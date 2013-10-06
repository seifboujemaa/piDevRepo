package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Stadium;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.sadium.StadiumServicesRemote;

public class StadiumServicesDelegate {
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/StadiumServices!"+StadiumServicesRemote.class.getCanonicalName();
	
	private static StadiumServicesRemote getProxy(){
		return (StadiumServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Stadium stadium) {
		getProxy().createStadium(stadium);
		
	}
	
	public static void update(Stadium stadium) {
		getProxy().updateStadium(stadium);
		
	}
	public static void delete(Stadium stadium) {
		getProxy().deleteStadium(stadium);
		
	}
	public static void findAllStadium() {
		getProxy().findAllStadium();
		
	}
	public static void findStadiumById(int idStadium) {
		getProxy().findStadiumById(idStadium);
		
	}

}
