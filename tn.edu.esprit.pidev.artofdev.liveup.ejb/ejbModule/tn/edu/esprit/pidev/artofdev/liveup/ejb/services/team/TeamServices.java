package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.team;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

/**
 * Session Bean implementation class TeamServices
 */
@Stateless
public class TeamServices implements TeamServicesRemote, TeamServicesLocal {
@PersistenceContext
    /**
     * Default constructor. 
     */
EntityManager entityManager ;
    public TeamServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createTeam(Team team) {
		entityManager.persist(team);		
	}

	@Override
	public void updateTeam(Team team) {
entityManager.merge(team);		
	}

	@Override
	public void deleteTeam(Team team) {
		entityManager.remove(entityManager.merge(team));
		
	}

	@Override
	public Team findTeamById(int idTeam) {
		Team team=entityManager.find(Team.class, idTeam);
		return team ;
	}

	@Override
	public List<Team> findAllTeam() {
		Query query=entityManager.createQuery("select t from Team t");
		return query.getResultList();
	}

}
