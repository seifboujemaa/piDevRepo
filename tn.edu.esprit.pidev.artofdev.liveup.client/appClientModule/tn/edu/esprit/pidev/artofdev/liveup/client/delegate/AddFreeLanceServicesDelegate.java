package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent.AgentServicesRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.FreelanceRemote;

public class AddFreeLanceServicesDelegate {

private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/AdministratorServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesRemote";

	
	private static AdministratorServicesRemote getProxy(){
		return (AdministratorServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(FreeLance freelance) {
		getProxy().createFreelance(freelance);
		
	}
	
	public static void update(FreeLance freelance) {
		getProxy().updateFreelance(freelance);
		
	}
	public static void delete(FreeLance freelance) {
		getProxy().deleteFreelance(freelance);
		
	}
	public static List<FreeLance> findAllFreelance() {
		return getProxy().findAllFreelance();
		
	}


	

}