package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance;

import java.util.List;

import javax.ejb.Stateless;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

/**
 * Session Bean implementation class Freelance
 */
@Stateless
public class Freelance implements FreelanceRemote, FreelanceLocal {

    /**
     * Default constructor. 
     */
    public Freelance() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Article> viewArticle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> viewNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FreeLance authentification(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNews(News news) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyNews(News news) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNews(News news) {
		// TODO Auto-generated method stub
		
	}

}
