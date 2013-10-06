package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor;

import java.util.List;

import javax.ejb.Stateless;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

/**
 * Session Bean implementation class ChefEditor
 */
@Stateless
public class ChefEditor implements ChefEditorRemote, ChefEditorLocal {

    
    public ChefEditor() {
        
    }

	@Override
	public List<FreeLance> viewFreeLances() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FreeLance> viewRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptFreeLance(FreeLance freeLance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declineFreeLance(FreeLance freeLance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFreeLance(FreeLance freeLance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChefEditor authentification(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void appointNews(News news) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appointArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declineNews(News news) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declineArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> viewNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> viewsArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}


    
    

}
