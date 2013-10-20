package GUI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddAgentServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.*;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowAgent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Agent> agents = new ArrayList<Agent>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAgent frame = new ShowAgent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowAgent() {
		
		


	
		final AddAgentServiceDelegate agentService = new AddAgentServiceDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("First Name");
		model.addColumn("Last Name");
		model.addColumn("Email");
		model.addColumn("Password");
		model.addColumn("Login");


		
		 agents=agentService.findAllAgent();
		for(Agent agent : agents)
			
		{   
		     int id = agent.getIdUser();
			String first = agent.getFirstName();
			String last = agent.getLastName();
			String pwd = agent.getPwd();
			String log = agent.getLogin();
			String mail = agent.getEmail();
			Object obj [] = {id,first,last,mail,pwd,log};
			model.addRow(obj);

		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 23, 335, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
				Agent agent = new Agent();
				agent.setIdUser(var);
				agentService.delete(agent);
				
			}
		});
		btnDelete.setBounds(150, 203, 89, 23);
		contentPane.add(btnDelete);
	}
}
