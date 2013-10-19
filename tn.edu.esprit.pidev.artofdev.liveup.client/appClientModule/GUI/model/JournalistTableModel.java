package GUI.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.JournalistServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;

public class JournalistTableModel extends AbstractTableModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String[] columns = { "First name", "Last name", "Login","Password", "Email","Status" };
	private List<Journalist> data = new ArrayList<Journalist>();

	public JournalistTableModel() {
		data = JournalistServiceDelegate.findAllJournalist();
		//System.out.println("Got "+data.size()+" journalists");
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Journalist journalist = data.get(row);
		switch (column) {
		case 0:
			return journalist.getFirstName();
		case 1:
			return journalist.getLastName();
		case 2:
			return journalist.getLogin();
		case 3:
			return journalist.getPwd();
		case 4:
			return journalist.getEmail();
		case 5:
			return journalist.getStatus();
		default:
			return journalist;
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

//	@Override
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		Journalist row = (Journalist) aValue;
//		
//	}

}
