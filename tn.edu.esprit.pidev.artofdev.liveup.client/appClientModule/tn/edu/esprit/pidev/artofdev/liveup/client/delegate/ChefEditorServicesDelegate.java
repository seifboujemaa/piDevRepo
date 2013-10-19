package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.ArrayList;
import java.util.List;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote;


public class ChefEditorServicesDelegate {
	
	private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/ChefEditor!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote";
	private static ChefEditorRemote getProxy(){
		return (ChefEditorRemote) ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public static void ListArticles(JTable table) {
		List<Article> articles= new ArrayList<Article>();
		articles = getProxy().findAllArticles();
		
		Object[][] data = {};
		 data = new Object[articles.size()][6];
	        int i = 0;
	        for (Article article :  articles) {
	            data[i][0] = article.getIdArticle();
	            data[i][1] = article.getTitle();
	            data[i][2] = article.getParagraph();
	            data[i][3] = article.getType();
	            data[i][4] = article.getDay();
	            data[i][5] = article.isStatus();
	         
	            i++;
	        }
	        
	        table.setModel(new DefaultTableModel(data,new String[] {"ID", "Title", "Paragraph",  "Type","Day","status"}));
		
	}
	
	
	
	public static void AcceptArticle(JTable table) {
		
		Integer var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		Article article = new Article();
		article.setIdArticle(var);
		article.setTitle(table.getValueAt(table.getSelectedRow(), 1).toString());
		article.setParagraph(table.getValueAt(table.getSelectedRow(), 2).toString());
		article.setType(table.getValueAt(table.getSelectedRow(), 3).toString());
		article.setDay(table.getValueAt(table.getSelectedRow(), 4).toString());
		article.setStatus(true);
		getProxy().appointArticle(article);
		
		
	}
	
	
	public static void DeclineArticle(JTable table){
		int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		Article article  = new Article();
		article.setIdArticle(var);
		getProxy().declineArticle(article);
		
		
	}
	
	public static void ListFreeLance(JTable table){
		List<FreeLance> freelances= new ArrayList<FreeLance>();
		freelances = getProxy().findAllFreelances();
		
		
		Object[][] data = {};
		 data = new Object[freelances.size()][7];
	        int i = 0;
	        for (FreeLance freelance :  freelances) {
	            data[i][0] = freelance.getIdUser();
	            data[i][1] = freelance.getLogin();
	            data[i][2] = freelance.getPwd();
	            data[i][3] = freelance.getFirstName();
	            data[i][4] = freelance.getLastName();
	            data[i][5] = freelance.getEmail();
	            data[i][6] = freelance.isStatus();
	         
	            i++;
	        }
	        table.setModel(new DefaultTableModel(data,new String[] {"ID", "Login", "Password","First name ","Last namme","Email","Status"}));
		     
	
	}
	
	
	
	public static void AcceptFreeLance(JTable table){
		Integer var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		FreeLance freeLance = new FreeLance();
		freeLance.setIdUser(var);
		freeLance.setLogin(table.getValueAt(table.getSelectedRow(), 1).toString());
		freeLance.setPwd(table.getValueAt(table.getSelectedRow(), 2).toString());
		freeLance.setFirstName(table.getValueAt(table.getSelectedRow(), 3).toString());
		freeLance.setLastName(table.getValueAt(table.getSelectedRow(), 4).toString());
		freeLance.setEmail(table.getValueAt(table.getSelectedRow(), 5).toString());
		freeLance.setStatus(true);
		getProxy().acceptFreeLance(freeLance);
		
		
	}
	
	
	public static void DeclineFreeLance(JTable table){
		int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		FreeLance freeLance = new FreeLance();
		freeLance.setIdUser(var);
		getProxy().declineFreeLance(freeLance);
		
		
	}
	
	public static void ListNews(JTable table){
		List<News> newss= new ArrayList<News>();
		newss = getProxy().findAllNews();
		
		
		Object[][] data = {};
		 data = new Object[newss.size()][6];
	        int i = 0;
	        for (News n :  newss) {
	            data[i][0] = n.getIdNews();
	            data[i][1] = n.getTitle();
	            data[i][2] = n.getParagraph();
	            data[i][3] = n.getType();
	            data[i][4] = n.getDay();
	            data[i][5] = n.isStatus();
	         
	            i++;
	        }
	        
	        table.setModel(new DefaultTableModel(data,new String[] {"ID", "Title", "Paragraph",  "Type","Day","status"}));
		
			
	}
	
	public static void acceptNews(JTable table){
		
		Integer var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		News news = new News();
		news.setIdNews(var);
		news.setTitle(table.getValueAt(table.getSelectedRow(), 1).toString());
		news.setParagraph(table.getValueAt(table.getSelectedRow(), 2).toString());
		news.setType(table.getValueAt(table.getSelectedRow(), 3).toString());
	    news.setDay(table.getValueAt(table.getSelectedRow(), 4).toString());
		news.setStatus(true);
		getProxy().appointNews(news);
		
	}
	
	public static void declineNews(JTable table){
		int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		News news = new News();
		news.setIdNews(var);
		getProxy().declineNews(news);
		
		
	}
	

}
