package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import tn.edu.esprit.piDev.artOfDev.liveUp.entities.Team;

/**
 * Entity implementation class for Entity: Game
 *
 */
@Entity

public class Game implements Serializable {

	
	private int idGame;
	private Team team1;
	private Team team2;
	private int team1Goals;
	private int team2Goals;
	private Date date;
	private String time;
	private String refree;
	private String type;
	private String group;
	
	private Agent agent ;
	private List<Event> events ;
	private static final long serialVersionUID = 1L;

	public Game() {
		super();
	}  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdGame() {
		return this.idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}   
	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}   
	public Team getTeam2() {
		return this.team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}   
	public int getTeam1Goals() {
		return this.team1Goals;
	}

	public void setTeam1Goals(int team1Goals) {
		this.team1Goals = team1Goals;
	}   
	public int getTeam2Goals() {
		return this.team2Goals;
	}

	public void setTeam2Goals(int team2Goals) {
		this.team2Goals = team2Goals;
	}   
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}   
	public String getRefree() {
		return this.refree;
	}

	public void setRefree(String refree) {
		this.refree = refree;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	@ManyToOne
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	@OneToMany(mappedBy="game")
	@JoinColumn(name="idGame")
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
   
}
