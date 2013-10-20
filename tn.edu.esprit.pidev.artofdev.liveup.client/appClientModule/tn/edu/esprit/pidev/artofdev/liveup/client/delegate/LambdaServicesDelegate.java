package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Lambda;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.lambda.LambdaServicesRemote;

public class LambdaServicesDelegate {
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/LambdaServices!"+LambdaServicesRemote.class.getCanonicalName();
	
	private static LambdaServicesRemote getProxy(){
		return (LambdaServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Lambda lambda) {
		getProxy().createLambda(lambda);
		
	}
	
	public static void update(Lambda lambda) {
		getProxy().updateLambda(lambda);
		
	}
	public static void delete(Lambda lambda) {
		getProxy().deleteLambda(lambda);
		
	}
	public static void findAllLambda() {
		getProxy().findAllLambda();
		
	}
	public static void findLambdaById(int idLambda) {
		getProxy().findLambdaById(idLambda);
		
	}
	
	
	

	

}
