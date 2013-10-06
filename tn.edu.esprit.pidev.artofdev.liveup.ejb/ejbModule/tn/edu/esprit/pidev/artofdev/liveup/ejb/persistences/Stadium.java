package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Stadium
 *
 */
@Entity

public class Stadium implements Serializable {

	
	private int idStadium;
	private String name;
	private int capacity;
	private String address;
	
	private Agent agent;
	private Game game;
	private static final long serialVersionUID = 1L;

	public Stadium() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public int getIdStadium() {
		return this.idStadium;
	}

	public void setIdStadium(int idStadium) {
		this.idStadium = idStadium;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
   @ManyToOne
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@OneToOne
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
}