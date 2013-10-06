package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Administrator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;

/**
 * Session Bean implementation class AdministratorServices
 */
@Stateless
@LocalBean
public class AdministratorServices implements AdministratorServicesRemote, AdministratorServicesLocal {

    /**
     * Default constructor. 
     */
	EntityManager entityManager ;
    public AdministratorServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createAdministrator(Administrator administrator) {
		entityManager.persist(administrator);		
		
	}

	@Override
	public void updateAdministrato(Administrator administrator) {
		entityManager.merge(administrator);	
		
	}

	@Override
	public void deleteAdministrator(Administrator administrator) {
		entityManager.remove(entityManager.merge(administrator));		
	}

	@Override
	public Administrator findAdministratorById(int idAdministrator) {
		Administrator administrator = entityManager.find(Administrator.class,idAdministrator );
		return administrator;
	}

	@Override
	public List<Administrator> findAllAdministrator() {
		Query query=entityManager.createQuery("select a from Administrator a");
		return query.getResultList();
	}

	@Override
	public Administrator authentification(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

}
