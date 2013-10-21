package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Player;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Team;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.news.NewsServicesRemote;

public class NewsServicesDelegate {
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/NewsServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.news.NewsServicesRemote";
	
	private static NewsServicesRemote getProxy(){
		return (NewsServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(News news) {
		getProxy().createNews(news);
		
	}
	
	public static void update(News news) {
		getProxy().updateNews(news);
		
	}
	public static void delete(News news) {
		getProxy().deleteNews(news);
		
	}
	public static List<News> findAllNews() {
		 return getProxy().findAllNews();
		
	}
	public static News findNewsById(int idNews) {
		return getProxy().findNewsById(idNews);
		
	}
	
	
	}
	
	
	

	


