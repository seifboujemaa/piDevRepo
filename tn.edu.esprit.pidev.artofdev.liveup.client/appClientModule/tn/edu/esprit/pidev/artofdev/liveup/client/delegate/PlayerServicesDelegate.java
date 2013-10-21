package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
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
	public static List<Player> findAllPlayer() {
		 return getProxy().findAllPlayer();
		
	}
	public static Player findPlayerById(int idPlayer) {
		return getProxy().findPlayerById(idPlayer);
		
	}
	
	public static List<Player> findPlayerByTeam(int idTeam) {
		return getProxy().findPlayerByTeam(idTeam);
		
	}
	
	
	

	

}
