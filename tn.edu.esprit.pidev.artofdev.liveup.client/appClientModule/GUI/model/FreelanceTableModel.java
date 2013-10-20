package GUI.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.FreelanceServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;

public class FreelanceTableModel extends AbstractTableModel {
	
	
	private String[] columns = { "First name", "Last name", "Login","Password", "Email","Status" };
	private List<FreeLance> data = new ArrayList<FreeLance>();
	
	public FreelanceTableModel(){
		
		data = FreelanceServicesDelegate.findAllFreeLance();
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
		FreeLance freeLance = data.get(row);
		switch (column) {
		case 0:
			return freeLance.getFirstName();
		case 1:
			return freeLance.getLastName();
		case 2:
			return freeLance.getLogin();
		case 3:
			return freeLance.getPwd();
		case 4:
			return freeLance.getEmail();
		case 5:
			return freeLance.getStatus();
		default:
			return freeLance;
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
