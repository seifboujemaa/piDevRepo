package GUI.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddAgentServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.JournalistServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;

public class AgentTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columns = { "First name", "Last name", "Login","Password", "Email","Status" };
	private List<Agent> data = new ArrayList<Agent>();

	public AgentTableModel() {
		data = AddAgentServiceDelegate.findAllAgent();
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
		Agent agent = data.get(row);
		switch (column) {
		case 0:
			return agent.getFirstName();
		case 1:
			return agent.getLastName();
		case 2:
			return agent.getLogin();
		case 3:
			return agent.getPwd();
		case 4:
			return agent.getEmail();
		case 5:
			return agent.getStatus();
		default:
			return agent;
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
