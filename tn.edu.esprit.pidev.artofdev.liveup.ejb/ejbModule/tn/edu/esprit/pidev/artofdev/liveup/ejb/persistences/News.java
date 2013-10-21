package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: News
 *
 */
@Entity

public class News implements Serializable {

	
	private int idNews;
	private String title;
	private String paragraph;
	private String day;
	private String type;
	private boolean status;
	
	private FreeLance freeLance;
	private Journalist journalist;
	private static final long serialVersionUID = 1L;

	public News() {
		
	}   
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdNews() {
		return this.idNews;
	}

	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getParagraph() {
		return this.paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}   
	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@ManyToOne
	//@JoinColumn(name="fk")
	public FreeLance getFreeLance() {
		return freeLance;
	}
	public void setFreeLance(FreeLance freeLance) {
		this.freeLance = freeLance;
	}
	@ManyToOne
	public Journalist getJournalist() {
		return journalist;
	}
	public void setJournalist(Journalist journalist) {
		this.journalist = journalist;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
   
}
