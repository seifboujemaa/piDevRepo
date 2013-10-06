package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity

public class Player implements Serializable {

	
	private int intPlayer;
	private String firstName;
	private String lastName;
	private int yellowCards;
	private int redCards;
	private int goals;
	private int playTime;
	private static final long serialVersionUID = 1L;

	public Player() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)

	public int getIntPlayer() {
		return this.intPlayer;
	}

	public void setIntPlayer(int intPlayer) {
		this.intPlayer = intPlayer;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public int getYellowCards() {
		return this.yellowCards;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}   
	public int getRedCards() {
		return this.redCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}   
	public int getGoals() {
		return this.goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}   
	public int getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
   
}