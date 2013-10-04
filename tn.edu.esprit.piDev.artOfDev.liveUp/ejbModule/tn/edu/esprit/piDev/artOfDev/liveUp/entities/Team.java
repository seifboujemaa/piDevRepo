package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Team
 *
 */
@Entity

public class Team implements Serializable {

	
	private int idTeam;
	private String name;
	private int victories;
	private int draws;
	private int defeats;
	private int qualification;
	private static final long serialVersionUID = 1L;

	public Team() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public int getIdTeam() {
		return this.idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getVictories() {
		return this.victories;
	}

	public void setVictories(int victories) {
		this.victories = victories;
	}   
	public int getDraws() {
		return this.draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}   
	public int getDefeats() {
		return this.defeats;
	}

	public void setDefeats(int defeats) {
		this.defeats = defeats;
	}   
	public int getQualification() {
		return this.qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}
   
}
