package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article.ArticleServicesRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.news.NewsServicesRemote;

public class ArticleServicesDelegate {
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/ArticleServices!"+ArticleServicesRemote.class.getCanonicalName();
	
	private static ArticleServicesRemote getProxy(){
		return (ArticleServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Article article) {
		getProxy().createArticle(article);
		
	}
	
	public static void update(Article article) {
		getProxy().updateArticle(article);
		
	}
	public static void delete(Article article) {
		getProxy().deleteArticle(article);
		
	}
	public static List<Article> findAllArticle() {
		 return getProxy().findAllArticle();
		
	}
	public static Article findArticleById(int idArticle) {
		return getProxy().findArticleById(idArticle);
		
	}
	
	
	}
	
	
	

	


