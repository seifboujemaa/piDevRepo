package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Administrator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditor;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.Freelance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.Reporter;

@Remote
public interface AdministratorServicesRemote {
	public void createAgent(Agent agent);
	public void updateAgent(Agent agent);
	public void deleteAgent(Agent agent);
	public Agent findAgentById(int idAgent);
	public List<Agent> findAllAgent();
	public void createJournalist(Journalist journalist);
	public void updateJournalist(Journalist journalist);
	public void deleteJournalist(Journalist journalist);
	public Journalist findJournalistById(int idJournalist);
	public List<Journalist> findAllJournalist();  
	public void createFreelance(Freelance freelance);
	public void updateFreelance(Freelance freelance);
	public void deleteFreelance(Freelance freelance);
	public FreeLance findFreelanceById(int idFreelance);
	public List<Freelance> findAllFreelance(); 
	public void createChefEditor(ChefEditor chefeditor);
	public void createReporter(Reporter reporter);
	
}
