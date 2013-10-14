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
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChefEditorArticleSwing extends JFrame {
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
					ChefEditorArticleSwing frame = new ChefEditorArticleSwing();
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
	public ChefEditorArticleSwing() {
		
		 	
		try {
			Context context= new InitialContext();
		Object o=	context.lookup("ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/ChefEditor!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.chefeditor.ChefEditorRemote");
		remote = (ChefEditorRemote) o;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Article> articles= new ArrayList<Article>();
		articles = remote.findAllArticles();
		
		
		Object[][] data = {};
		 data = new Object[articles.size()][6];
	        int i = 0;
	        for (Article article :  articles) {
	            data[i][0] = article.getIdArticle();
	            data[i][1] = article.getTitle();
	            data[i][2] = article.getParagraph();
	            data[i][3] = article.getType();
	            data[i][4] = article.getDay();
	            data[i][5] = article.isStatus();
	         
	            i++;
	        }
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 409);
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
				Article article = new Article();
				article.setIdArticle(var);
				article.setTitle(table.getValueAt(table.getSelectedRow(), 1).toString());
				article.setParagraph(table.getValueAt(table.getSelectedRow(), 2).toString());
				article.setType(table.getValueAt(table.getSelectedRow(), 3).toString());
				article.setDay(table.getValueAt(table.getSelectedRow(), 4).toString());
				article.setStatus(true);
				remote.appointArticle(article);
			}
		});
		btnAccept.setBounds(0, 0, 89, 23);
		panel_1.add(btnAccept);
		
		JButton btnDecline = new JButton("Decline");
		btnDecline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
				Article article  = new Article();
				article.setIdArticle(var);
				remote.declineArticle(article);
			}
		});
		btnDecline.setBounds(99, 0, 89, 23);
		panel_1.add(btnDecline);
		
		JButton btnRefrech = new JButton("Refrech");
		btnRefrech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Article> articles= new ArrayList<Article>();
				articles = remote.findAllArticles();
				
				
				Object[][] data = {};
				 data = new Object[articles.size()][6];
			        int i = 0;
			        for (Article article :  articles) {
			            data[i][0] = article.getIdArticle();
			            data[i][1] = article.getTitle();
			            data[i][2] = article.getParagraph();
			            data[i][3] = article.getType();
			            data[i][4] = article.getDay();
			            data[i][5] = article.isStatus();
			         
			            i++;
			        }
				
				
				table.setModel(new DefaultTableModel(data,new String[] {"ID", "Title", "Paragraph",  "Type","Day","status"}));
			}
		});
		btnRefrech.setBounds(297, 0, 89, 23);
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
		panel_2.setBounds(635, 11, 104, 314);
		contentPane.add(panel_2);
		
		JButton button = new JButton("News");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefEditorNewsSwing().setVisible(true);
                setVisible(false);
			}
		});
		button.setBounds(10, 89, 89, 23);
		panel_2.add(button);
		
		JButton button_1 = new JButton("FreeLance");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChefEditorFreelanceSwing().setVisible(true);
                setVisible(false);
			}
		});
		button_1.setBounds(10, 146, 89, 23);
		panel_2.add(button_1);
	}
}
