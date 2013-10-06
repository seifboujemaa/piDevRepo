package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.team;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;

@Remote
public interface TeamServicesRemote {
	public void createTeam(Team team);
	public void updateTeam(Team team);
	public void deleteTeam(Team team);
	public Team findTeamById(int idTeam);
	public List<Team> findAllTeam();


}
