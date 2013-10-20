package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.NewsServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Article;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Lambda;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.News;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import GUI.model.JournalistTableModel;
import GUI.model.NewsTableModel;

public class AddNewsFreelance extends JFrame {

	private JPanel contentPane;
	private JTextField title;
	private JTextField parag;
	private JTextField day;
	
	protected static JTable NewsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewsFreelance frame = new AddNewsFreelance();
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
	public AddNewsFreelance() {
		final NewsServicesDelegate newsService = new NewsServicesDelegate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 461);
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
		
		title = new JTextField();
		title.setBounds(148, -3, 86, 20);
		contentPane.add(title);
		title.setColumns(10);
		
		parag = new JTextField();
		parag.setBounds(28, 50, 261, 67);
		contentPane.add(parag);
		parag.setColumns(10);
		
		day = new JTextField();
		day.setBounds(66, 139, 103, 20);
		contentPane.add(day);
		day.setColumns(10);
		
		JButton btnPost = new JButton("post");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				News news = new News() ;
				news.setTitle(title.getText());
				news.setParagraph(parag.getText());
				news.setDay(day.getText());
				news.setType("freelance");
				news.setStatus(false);
				newsService.create(news);
			}
		});
		btnPost.setBounds(134, 187, 89, 23);
		contentPane.add(btnPost);
		
		JScrollPane newsTable = new JScrollPane();
		newsTable.setBounds(299, 50, 359, 242);
		contentPane.add(newsTable);
		
		NewsTable = new JTable();
		newsTable.setViewportView(NewsTable);
		final NewsTableModel newsTableModel = new NewsTableModel();
		NewsTable.setModel(newsTableModel);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					
					int selectedRow = NewsTable.getSelectedRow();
					News news = (News) NewsTable.getValueAt(selectedRow, -1);
					
					
					newsService.delete(news);
			}
		});
		btnDelete.setBounds(144, 221, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setBounds(145, 255, 89, 23);
		contentPane.add(btnUpdate);
	}
}
