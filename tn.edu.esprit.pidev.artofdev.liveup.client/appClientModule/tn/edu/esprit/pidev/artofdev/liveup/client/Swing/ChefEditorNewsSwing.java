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

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChefEditorNewsSwing extends JFrame {
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
					ChefEditorNewsSwing frame = new ChefEditorNewsSwing();
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
	public ChefEditorNewsSwing() {
		
		 	
		try {
			Context context= new InitialContext();
		Object o=	context.lookup("ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/ChefEditor!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote");
		remote = (ChefEditorRemote) o;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<News> newss= new ArrayList<News>();
		newss = remote.findAllNews();
		
		
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
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 409);
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
		table.setModel(new DefaultTableModel(data,new String[] {"ID", "Title", "Paragraph",  "Type","Day","status"}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 336, 613, 24);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
				News news = new News();
				news.setIdNews(var);
				news.setTitle(table.getValueAt(table.getSelectedRow(), 1).toString());
				news.setParagraph(table.getValueAt(table.getSelectedRow(), 2).toString());
				news.setType(table.getValueAt(table.getSelectedRow(), 3).toString());
			    news.setDay(table.getValueAt(table.getSelectedRow(), 4).toString());
				news.setStatus(true);
				remote.appointNews(news);
			}
		});
		btnAccept.setBounds(0, 0, 89, 23);
		panel_1.add(btnAccept);
		
		JButton btnDecline = new JButton("Decline");
		btnDecline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
				News news = new News();
				news.setIdNews(var);
				remote.declineNews(news);
			}
		});
		btnDecline.setBounds(99, 0, 89, 23);
		panel_1.add(btnDecline);
		
		JButton btnRefrech = new JButton("Refrech");
		btnRefrech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<News> newss= new ArrayList<News>();
				newss = remote.findAllNews();
				
				
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
		panel_2.setLayout(null);
		panel_2.setBounds(633, 11, 107, 314);
		contentPane.add(panel_2);
		
		JButton button = new JButton("Freelance");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefEditorFreelanceSwing().setVisible(true);
                setVisible(false);
			}
		});
		button.setBounds(10, 89, 89, 23);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Articles");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefEditorArticleSwing().setVisible(true);
                setVisible(false);
			}
		});
		button_1.setBounds(10, 146, 89, 23);
		panel_2.add(button_1);
	}
}
