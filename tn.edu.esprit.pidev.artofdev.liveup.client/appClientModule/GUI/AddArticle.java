package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.ArticleServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.NewsServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Lambda;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddArticle extends JFrame {

	private JPanel contentPane;
	private JTextField title;
	private JTextField parag;
	private JTextField day;
	private JTextField type;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNews frame = new AddNews();
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
	public AddArticle() {
		final ArticleServicesDelegate articleService = new ArticleServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setBounds(114, 0, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("paragraph");
		lblNewLabel_1.setBounds(114, 29, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Day");
		lblNewLabel_2.setBounds(10, 153, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(10, 178, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Status");
		lblNewLabel_4.setBounds(10, 203, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		title = new JTextField();
		title.setBounds(148, -3, 86, 20);
		contentPane.add(title);
		title.setColumns(10);
		
		parag = new JTextField();
		parag.setBounds(28, 50, 261, 67);
		contentPane.add(parag);
		parag.setColumns(10);
		
		day = new JTextField();
		day.setBounds(66, 150, 103, 20);
		contentPane.add(day);
		day.setColumns(10);
		
		type = new JTextField();
		type.setBounds(76, 175, 86, 20);
		contentPane.add(type);
		type.setColumns(10);
		
		status = new JTextField();
		status.setBounds(66, 200, 86, 20);
		contentPane.add(status);
		status.setColumns(10);
		
		JButton btnPost = new JButton("post");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Article article = new Article() ;
				article.setTitle(title.getText());
				article.setParagraph(parag.getText());
				article.setDay(day.getText());
				article.setType(type.getText());
				article.setStatus(false);
				articleService.create(article);
			}
		});
		btnPost.setBounds(229, 228, 89, 23);
		contentPane.add(btnPost);
	}

}
