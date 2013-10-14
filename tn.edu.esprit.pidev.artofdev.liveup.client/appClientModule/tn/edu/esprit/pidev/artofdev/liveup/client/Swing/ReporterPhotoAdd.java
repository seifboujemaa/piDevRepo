package tn.edu.esprit.pidev.artofdev.liveup.client.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JLabel;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.ReporterRemote;

public class ReporterPhotoAdd extends JFrame {
	String filepath = "";
	ReporterRemote remote = null;	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporterPhotoAdd frame = new ReporterPhotoAdd();
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
	public ReporterPhotoAdd() {
		
		 
		try {
			Context context= new InitialContext();
		Object o=	context.lookup("ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/Reporter!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.ReporterRemote");
		remote =  (ReporterRemote) o;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
         
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 276, 325);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 256, 257);
		panel.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 280, 256, 34);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Attach");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showDialog(panel_1, "attach");
				File f = fc.getSelectedFile();
                filepath = f.getAbsolutePath();
                System.out.println(filepath);
               
               
			}
		});
		btnNewButton.setBounds(0, 0, 256, 34);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(296, 11, 343, 270);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 25, 276, 223);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(296, 292, 343, 44);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(filepath);
				 
				Photo photo = new Photo();
			     photo.setDescription(textArea.getText());
				photo.setImage(remote.imageToByte(file));
		         remote.addPhoto(photo);
		         }
		});
		btnNewButton_1.setBounds(27, 11, 108, 33);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Return");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReporterPhotoViewDeleteSwing().setVisible(true);
                setVisible(false);
			}
		});
		btnNewButton_2.setBounds(145, 11, 99, 33);
		panel_3.add(btnNewButton_2);
		
		
	}
}
