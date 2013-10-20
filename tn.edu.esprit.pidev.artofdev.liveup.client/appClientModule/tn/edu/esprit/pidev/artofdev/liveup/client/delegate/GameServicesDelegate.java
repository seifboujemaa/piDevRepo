package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Game;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.game.GameServicesRemote;

public class GameServicesDelegate {

private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/GameServices!"+GameServicesRemote.class.getCanonicalName();
	
	private static GameServicesRemote getProxy(){
		return (GameServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Game game) {
		getProxy().createGame(game);
		
	}
	
	public static void update(Game game) {
		getProxy().updateGame(game);
		
	}
	public static void delete(Game game) {
		getProxy().deleteGame(game);
		
	}
	public static List<Game> findAllGame() {
		return getProxy().findAllGame();
		
	}
	public static Game findGameById(int idGame) {
		return getProxy().findGameById(idGame);
		
	}
	public static List<Team> findTeamsOnGame(Game game) {
		return getProxy().findTeamsOnGame(game);
		
	}
}
	
