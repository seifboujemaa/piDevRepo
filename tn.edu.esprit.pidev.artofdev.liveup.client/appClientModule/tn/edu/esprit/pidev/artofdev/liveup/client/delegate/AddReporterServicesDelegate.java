package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Reporter;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent.AgentServicesRemote;

public class AddReporterServicesDelegate {

private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/AdministratorServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesRemote";

	
	private static AdministratorServicesRemote getProxy(){
		return (AdministratorServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Reporter reporter) {
		getProxy().createReporter(reporter);
		
	}
	/*
	public static void update(Reporter reporter) {
		getProxy().updateReporter(reporter);
		
	}
	public static void delete(Reporter reproter) {
		getProxy().deleteReproter(reproter);
		
	}
	public static List<Reporter> findAllReproter() {
		return getProxy().findAllAgent();
		
	}
	public static Agent findReporterById(int idReporter) {
		return getProxy().findReporterById(idReporter);
		
	}
	*/
	}
	
