package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Administrator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditor;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.Freelance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.Reporter;

/**
 * Session Bean implementation class AdministratorServices
 */
@Stateless
@LocalBean
public class AdministratorServices implements AdministratorServicesRemote, AdministratorServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	
	
	@Override
	public void createAgent(Agent agent) {
		entityManager.persist(agent);		
		
	}

	@Override
	public void updateAgent(Agent agent) {
		entityManager.merge(agent);	
		
	}

	@Override
	public void deleteAgent(Agent agent) {
		entityManager.remove(entityManager.merge(agent));	
		
	}

	@Override
	public Agent findAgentById(int idAgent) {
		Agent agent = entityManager.find(Agent.class,idAgent );
		return agent ;
	}

	@Override
	public List<Agent> findAllAgent() {
		Query query=entityManager.createQuery("select a from Agent a");
		return query.getResultList();
	}

	@Override
	public void createJournalist(Journalist journalist) {
		entityManager.persist(journalist);
		
	}

	@Override
	public void updateJournalist(Journalist journalist) {
		entityManager.merge(journalist);

	}

	@Override
	public void deleteJournalist(Journalist journalist) {
	entityManager.remove(entityManager.merge(journalist));
		
	}

	@Override
	public Journalist findJournalistById(int idJournalist) {
		Journalist journalist = entityManager.find(Journalist.class,
				idJournalist);
		return journalist;
	}

	@Override
	public List<Journalist> findAllJournalist() {
		Query query = entityManager.createQuery("from Journalist e");
		List<Journalist> journalists = query.getResultList();
		System.out.println("EntityManager returned "+journalists.size()+" journalists");
		return journalists;
	}

	@Override
	public void createFreelance(Freelance freelance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFreelance(Freelance freelance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFreelance(Freelance freelance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FreeLance findFreelanceById(int idFreelance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Freelance> findAllFreelance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createChefEditor(ChefEditor chefeditor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createReporter(Reporter reporter) {
		// TODO Auto-generated method stub
		
	}

  
}
