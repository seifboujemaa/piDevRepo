package tn.edu.esprit.pidev.artofdev.liveup.client.Swing;

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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.ChefEditorServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.freelance.Freelance;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChefEditorFreelanceSwing extends JFrame {
	ChefEditorRemote remote = null;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefEditorFreelanceSwing frame = new ChefEditorFreelanceSwing();
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
	public ChefEditorFreelanceSwing() {
		final ChefEditorServicesDelegate chefEditorDelegate = new ChefEditorServicesDelegate();
		 	
//		try {
//			Context context= new InitialContext();
//		Object o=	context.lookup("ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/ChefEditor!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote");
//		remote = (ChefEditorRemote) o;
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<FreeLance> freelances= new ArrayList<FreeLance>();
//		freelances = remote.findAllFreelances();
//		
//		
//		Object[][] data = {};
//		 data = new Object[freelances.size()][7];
//	        int i = 0;
//	        for (FreeLance freelance :  freelances) {
//	            data[i][0] = freelance.getIdUser();
//	            data[i][1] = freelance.getLogin();
//	            data[i][2] = freelance.getPwd();
//	            data[i][3] = freelance.getFirstName();
//	            data[i][4] = freelance.getLastName();
//	            data[i][5] = freelance.getEmail();
//	            data[i][6] = freelance.isStatus();
//	         
//	            i++;
//	        }
//		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 613, 314);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 603, 314);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		chefEditorDelegate.ListFreeLance(table);
		//table.setModel(new DefaultTableModel(data,new String[] {"ID", "Login", "Password","First name ","Last namme","Email","Status"}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 336, 613, 24);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chefEditorDelegate.AcceptFreeLance(table);
//				Integer var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
//				FreeLance freeLance = new FreeLance();
//				freeLance.setIdUser(var);
//				freeLance.setLogin(table.getValueAt(table.getSelectedRow(), 1).toString());
//				freeLance.setPwd(table.getValueAt(table.getSelectedRow(), 2).toString());
//				freeLance.setFirstName(table.getValueAt(table.getSelectedRow(), 3).toString());
//				freeLance.setLastName(table.getValueAt(table.getSelectedRow(), 4).toString());
//				freeLance.setEmail(table.getValueAt(table.getSelectedRow(), 5).toString());
//				freeLance.setStatus(true);
//				remote.acceptFreeLance(freeLance);
			}
		});
		btnAccept.setBounds(0, 0, 89, 23);
		panel_1.add(btnAccept);
		
		JButton btnDecline = new JButton("Decline");
		btnDecline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chefEditorDelegate.DeclineFreeLance(table);
//				int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
//				FreeLance freeLance = new FreeLance();
//				freeLance.setIdUser(var);
//				remote.declineFreeLance(freeLance);
			}
		});
		btnDecline.setBounds(99, 0, 89, 23);
		panel_1.add(btnDecline);
		
		JButton btnRefrech = new JButton("Refrech");
		btnRefrech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chefEditorDelegate.ListFreeLance(table);
				
//				List<FreeLance> freelances= new ArrayList<FreeLance>();
//				freelances = remote.findAllFreelances();
//				
//				
//				Object[][] data = {};
//				 data = new Object[freelances.size()][7];
//			        int i = 0;
//			        for (FreeLance freelance :  freelances) {
//			            data[i][0] = freelance.getIdUser();
//			            data[i][1] = freelance.getLogin();
//			            data[i][2] = freelance.getPwd();
//			            data[i][3] = freelance.getFirstName();
//			            data[i][4] = freelance.getLastName();
//			            data[i][5] = freelance.getEmail();
//			            data[i][6] = freelance.isStatus();
//			         
//			            i++;
//			        }
//				
//				
//				table.setModel(new DefaultTableModel(data,new String[] {"ID", "Login", "Password",  "First name","Last name","Email","Status"}));
			}
		});
		btnRefrech.setBounds(198, 0, 89, 23);
		panel_1.add(btnRefrech);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AuthentificationSwing().setVisible(true);
                setVisible(false);
			}
		});
		btnLogout.setBounds(514, 0, 89, 23);
		panel_1.add(btnLogout);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(622, 11, 94, 314);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("News");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefEditorNewsSwing().setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 89, 89, 23);
		panel_2.add(btnNewButton);
		
		JButton btnArticles = new JButton("Articles");
		btnArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefEditorArticleSwing().setVisible(true);
                setVisible(false);
				
			}
		});
		btnArticles.setBounds(10, 146, 89, 23);
		panel_2.add(btnArticles);
	}
}
