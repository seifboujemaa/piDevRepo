package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;

@Local
public interface AgentServicesLocal {
	public void createAgent(Agent agent);
	public void updateAgent(Agent agent);
	public void deleteAgent(Agent agent);
	public Agent findAgentById(int idAgent);
	public List<Agent> findAllAgent();

}
