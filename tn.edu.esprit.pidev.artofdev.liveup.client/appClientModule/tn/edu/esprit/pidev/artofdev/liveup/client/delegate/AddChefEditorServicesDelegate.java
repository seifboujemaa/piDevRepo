package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent.AgentServicesRemote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote;

public class AddChefEditorServicesDelegate {

private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/AdministratorServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesRemote";

	
	private static AdministratorServicesRemote getProxy(){
		return (AdministratorServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(ChefEditor chefeditor) {
		getProxy().createChefEditor(chefeditor);
		
	}
	
	//public static void update(ChefEditor chefeditor) {
		//getProxy().updateChefEditor(chefeditor);
		
	//}
	//public static void delete(Agent agent) {
		//getProxy().deleteAgent(agent);
		
	//}
	public static List<ChefEditor> findAllChefeditor() {
		return getProxy().findAllChefeditor();
	}
	
	//public static Agent findAgentById(int idAgent) {
		//return getProxy().findAgentById(idAgent);
		
	}
	
	


