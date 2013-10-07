package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: FreeLance
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class FreeLance extends User implements Serializable {

	
	private boolean status;
	
	private List<Article> articles= new ArrayList<Article>();
	private List<News> news = new ArrayList<News>();
	
	private ChefEditor chefEditor;
	private static final long serialVersionUID = 1L;

	public FreeLance() {
		super();
	}   
   public boolean isStatus() {
	return status;
}
   
   public void setStatus(boolean status) {
	this.status = status;
}
	@OneToMany(mappedBy="freeLance")
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@OneToMany(mappedBy="freeLance")
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	@ManyToOne
	public ChefEditor getChefEditor() {
		return chefEditor;
	}
	public void setChefEditor(ChefEditor chefEditor) {
		this.chefEditor = chefEditor;
	}
	
	
	
	
   
}
