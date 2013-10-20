package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Stadium;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.team.TeamServicesRemote;

public class TeamServicesDelegate {
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/TeamServices!"+TeamServicesRemote.class.getCanonicalName();
	
	private static TeamServicesRemote getProxy(){
		return (TeamServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Team team) {
		getProxy().createTeam(team);
		
	}
	
	public static void update(Team team) {
		getProxy().updateTeam(team);
		
	}
	public static void delete(Team team) {
		getProxy().deleteTeam(team);
		
	}
	public static List<Team> findAllTeam() {
		 return getProxy().findAllTeam();
		
	}
	public static Team findTeamById(int idTeam) {
		return getProxy().findTeamById(idTeam);
		
	}
	
	public static Team findTeamByName(String teamName) {
		return getProxy().findTeamByName(teamName);
		
	}

}
