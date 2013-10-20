package GUI.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.ArticleServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.NewsServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

public class ArticleTableModel extends AbstractTableModel {
	
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String[] columns = { "Title", "Paragraph" , "Day" , "type","Status"};
	private List<Article> data = new ArrayList<Article>();
	
	public ArticleTableModel(){
		data= ArticleServicesDelegate.findAllArticle();
		System.out.println("Got "+data.size()+" article");
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		Article article = data.get(row);
		switch (column) {
		case 0:
			return article.getTitle();
		case 1:
			return article.getParagraph();
		case 2:
			return article.getDay();
		case 3:
			return article.getType();
		case 4:
			return article.isStatus();
		
		
		default:
			return article;
		}
	}
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public String getColumnName(int column) {
		return columns[column];
	}
	
	
	
	

}
