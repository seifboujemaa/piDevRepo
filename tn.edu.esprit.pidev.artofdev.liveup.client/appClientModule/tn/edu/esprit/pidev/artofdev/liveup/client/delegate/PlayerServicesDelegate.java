package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.player.PlayerServicesRemote;

public class PlayerServicesDelegate {
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/PlayerServices!"+PlayerServicesRemote.class.getCanonicalName();
	
	private static PlayerServicesRemote getProxy(){
		return (PlayerServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Player player) {
		getProxy().createPlayer(player);
		
	}
	
	public static void update(Player player) {
		getProxy().updatePlayer(player);
		
	}
	public static void delete(Player player) {
		getProxy().deletePlayer(player);
		
	}
	public static void findAllPlayer() {
		getProxy().findAllPlayer();
		
	}
	public static void findPlayerById(int idPlayer) {
		getProxy().findPlayerById(idPlayer);
		
	}
	
	
	

	

}
