package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import GUI.model.AgentTableModel;
import GUI.model.JournalistTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddAgentServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.ChefEditorServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.User;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.agent.AgentServicesRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.user.UserServicesRemote;

public class Agent extends JFrame {

	private JPanel contentPane;
	
	protected static JTable agentTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agent frame = new Agent();
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
	public Agent() {
		
		


	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 24, 364, 199);
		contentPane.add(scrollPane);
		
		agentTable = new JTable();
		scrollPane.setViewportView(agentTable);
		final AgentTableModel agentTableModel = new AgentTableModel();
		agentTable.setModel(agentTableModel);
		
	
		
	}

}
