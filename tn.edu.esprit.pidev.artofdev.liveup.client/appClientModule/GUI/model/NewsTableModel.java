package GUI.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.NewsServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

public class NewsTableModel extends AbstractTableModel {
	
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String[] columns = { "Title", "Paragraph" , "Day" , "type","Status"};
	private List<News> data = new ArrayList<News>();
	
	public NewsTableModel(){
		data= NewsServicesDelegate.findAllNews();
		System.out.println("Got "+data.size()+" news");
	}

	@Override
	public int getRowCount() {
		return columns.length;
	}

	@Override
	public int getColumnCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		News news = data.get(row);
		switch (column) {
		case 0:
			return news.getTitle();
		case 1:
			return news.getParagraph();
		case 2:
			return news.getDay();
		case 3:
			return news.getType();
		case 4:
			return news.isStatus();
		
		
		default:
			return news;
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
