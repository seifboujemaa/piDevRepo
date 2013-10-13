package tn.edu.esprit.pidev.artofdev.liveup.client.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.ReporterRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ReporterPhotoViewDeleteSwing extends JFrame {
	 ReporterRemote remote = null;	

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporterPhotoViewDeleteSwing frame = new ReporterPhotoViewDeleteSwing();
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
	public ReporterPhotoViewDeleteSwing() {
		
	
		try {
			Context context= new InitialContext();
		Object o=	context.lookup("ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/Reporter!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.ReporterRemote");
		remote =  (ReporterRemote) o;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Photo> photos= new ArrayList<Photo>();
		photos=remote.viewPhoto();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[][] data = {};
        data = new Object[photos.size()][3];
        int i = 0;
        for (Photo photo :  photos) {
            data[i][0] = photo.getIdPhoto();
            data[i][1] = photo.getDescription();
            data[i][2] = photo.getImage();
           
         
            i++;
        }
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 526, 285);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		table.setModel(new DefaultTableModel(data,new String[] {"ID", "Description","Photo"}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 307, 526, 32);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddPhoto = new JButton("Add photo");
		btnAddPhoto.setBounds(0, 0, 89, 23);
		panel_1.add(btnAddPhoto);
		
		JButton btnDeletePhoto = new JButton("Delete Photo");
		btnDeletePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Photo photo = new Photo();
				int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
				photo.setIdPhoto(var);
				remote.deletePhoto(photo);
			}
		});
		btnDeletePhoto.setBounds(97, 0, 124, 23);
		panel_1.add(btnDeletePhoto);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(427, 0, 89, 23);
		panel_1.add(btnLogout);
		
		JButton btnRefrech = new JButton("Refrech");
		btnRefrech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Photo> photos= new ArrayList<Photo>();
				photos=remote.viewPhoto();
				
				Object[][] data = {};
		        data = new Object[photos.size()][3];
		        int i = 0;
		        for (Photo photo :  photos) {
		            data[i][0] = photo.getIdPhoto();
		            data[i][1] = photo.getDescription();
		            data[i][2] = photo.getImage();
		           
		         
		            i++;
		        }
		        table.setModel(new DefaultTableModel(data,new String[] {"ID", "Description","Photo"}));
		        
		        
			}
		});
		btnRefrech.setBounds(232, 0, 89, 23);
		panel_1.add(btnRefrech);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(546, 11, 306, 283);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 306, 283);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(542, 307, 310, 32);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("View Photo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 0, 290, 23);
		panel_3.add(btnNewButton);
	}
}
