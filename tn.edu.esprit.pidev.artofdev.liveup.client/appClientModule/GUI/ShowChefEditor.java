package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddAgentServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.AddChefEditorServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.ChefEditorServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Agent;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.ChefEditor;

public class ShowChefEditor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<ChefEditor> chefeditors = new ArrayList<ChefEditor>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowChefEditor frame = new ShowChefEditor();
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
	public ShowChefEditor() {
		final AddChefEditorServicesDelegate chefeditorService = new AddChefEditorServicesDelegate();
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
		chefeditors=chefeditorService.findAllChefeditor();
		for(ChefEditor chefeditor : chefeditors)
			
		{   
		     int id = chefeditor.getIdUser();
			String first = chefeditor.getFirstName();
			String last = chefeditor.getLastName();
			String pwd = chefeditor.getPwd();
			String log = chefeditor.getLogin();
			String mail = chefeditor.getEmail();
			Object obj [] = {id,first,last,mail,pwd,log};
			model.addRow(obj);

		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 278, 149);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(model);
	}

}
