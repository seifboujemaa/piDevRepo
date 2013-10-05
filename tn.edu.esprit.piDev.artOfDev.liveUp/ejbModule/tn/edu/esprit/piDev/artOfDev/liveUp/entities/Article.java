package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Article
 *
 */
@Entity

public class Article implements Serializable {

	
	private int idArticle;
	private String title;
	private String paragraph;
	private String day;
	private String type;
	private static final long serialVersionUID = 1L;

	public Article() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
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
   
}
