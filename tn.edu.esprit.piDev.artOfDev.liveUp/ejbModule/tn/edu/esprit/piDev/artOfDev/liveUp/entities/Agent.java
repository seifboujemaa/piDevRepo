package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import tn.edu.esprit.piDev.artOfDev.liveUp.entities.User;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Agent extends User implements Serializable {

	private List<Game> games ;
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}

	@OneToMany(mappedBy="agent")
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
   
}
