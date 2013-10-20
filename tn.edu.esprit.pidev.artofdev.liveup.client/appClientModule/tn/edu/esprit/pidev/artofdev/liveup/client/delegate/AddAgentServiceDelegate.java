package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent.AgentServicesRemote;

public class AddAgentServiceDelegate {

private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/AgentServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent.AgentServicesRemote";
	
	private static AgentServicesRemote getProxy(){
		return (AgentServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Agent agent) {
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
	
	

}
