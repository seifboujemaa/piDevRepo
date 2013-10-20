package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.ArticleServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article.ArticleServicesRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import GUI.model.ArticleTableModel;

public class AddArticleFreelance extends JFrame {
	
	ArticleServicesRemote remote = null;

	private JPanel contentPane;
	private JTextField title;
	private JTextField parag;
	private JTextField day;
	private JTable ArticleTable;

	protected static JTable NewsTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddArticleFreelance frame = new AddArticleFreelance();
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
	public AddArticleFreelance() {
		
		try {
			Context context= new InitialContext();
		Object o=	context.lookup("ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/ArticleServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article.ArticleServicesRemote");
		remote =  (ArticleServicesRemote) o;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		
		try {
			Context context= new InitialContext();
		Object o=	context.lookup("ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/ArticleServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.article.ArticleServicesRemote");
		remote =  (ArticleServicesRemote) o;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		final ArticleServicesDelegate articleService = new ArticleServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setBounds(97, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("paragraph");
		lblNewLabel_1.setBounds(114, 47, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Day");
		lblNewLabel_2.setBounds(10, 153, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		title = new JTextField();
		title.setBounds(146, 11, 86, 20);
		contentPane.add(title);
		title.setColumns(10);
		
		parag = new JTextField();
		parag.setBounds(10, 75, 261, 67);
		contentPane.add(parag);
		parag.setColumns(10);
		
		day = new JTextField();
		day.setBounds(66, 150, 103, 20);
		contentPane.add(day);
		day.setColumns(10);
		
		JButton btnPost = new JButton("post");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Article article = new Article() ;
				article.setTitle(title.getText());
				article.setParagraph(parag.getText());
				article.setDay(day.getText());
				article.setType("freelancer");
				article.setStatus(false);
				//articleService.create(article);
				remote.createArticle(article);
			}
		});
		btnPost.setBounds(229, 228, 89, 23);
		contentPane.add(btnPost);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 26, 251, 191);
		contentPane.add(scrollPane);
		
	
		
		ArticleTable = new JTable();
		scrollPane.setViewportView(ArticleTable);
		final ArticleTableModel articleTableModel = new ArticleTableModel();
		ArticleTable.setModel(articleTableModel);
	
		
		JButton btnDeleteArticle = new JButton("Delete ");
		btnDeleteArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int selectedRow = ArticleTable.getSelectedRow();
				Article article = (Article) ArticleTable.getValueAt(selectedRow, -1);
				
				
				remote.deleteArticle(article);
			}
		});
		btnDeleteArticle.setBounds(338, 228, 103, 23);
		contentPane.add(btnDeleteArticle);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setBounds(281, 262, 89, 23);
		contentPane.add(btnUpdate);
	}
}
