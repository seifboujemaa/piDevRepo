package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
@Remote
public interface ArticleServicesRemote {
	public void createArticle(Article article);
	public void updateArticle(Article article);
	public void deleteArticle(Article article);
	public Article findArticleById(int idArticle);
	public List<Article> findAllArticle();

}
