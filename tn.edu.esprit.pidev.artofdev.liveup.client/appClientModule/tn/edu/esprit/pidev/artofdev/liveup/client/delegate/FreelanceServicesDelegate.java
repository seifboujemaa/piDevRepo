package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.Freelance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.FreelanceRemote;


public class FreelanceServicesDelegate {
	
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/Freelance!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.FreelanceRemote";

	
	private static FreelanceRemote getProxy(){
		return (FreelanceRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Freelance freelance) {
		getProxy().createFreelance(freelance);
		
	}
	
	public static void update(Freelance freelance) {
		getProxy().updateFreelance(freelance);
		
	}
	public static void delete(Freelance freelance) {
		getProxy().deleteFreelance(freelance);
		
	}
	public static List<Freelance> findAllFreeLance() {
		return getProxy().findAllFreelance();
		
	}
	public static FreeLance findFreelanceById(int idFreeLance) {
		return getProxy().findFreelanceById(idFreeLance);
		
	}
	
	

}
