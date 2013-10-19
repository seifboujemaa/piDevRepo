package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.awt.TextArea;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import tn.edu.esprit.pidev.artofdev.liveup.client.Swing.ReporterPhotoViewDeleteSwing;
import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.ReporterRemote;

public class ReporterServicesDelegate {
	
	private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/Reporter!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter.ReporterRemote";
	private static ReporterRemote getProxy(){
		return (ReporterRemote) ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	
	public static void PhotoAdd(String filepath, JTextArea textArea){
		File file = new File(filepath);
		 
		Photo photo = new Photo();
	     photo.setDescription(textArea.getText());
		photo.setImage(getProxy().imageToByte(file));
         getProxy().addPhoto(photo);
      
		
		
	}
	
	public static void ListPhoto(JTable table){
		
		List<Photo> photos= new ArrayList<Photo>();
		photos=getProxy().viewPhoto();
		
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
	
	public static void ViewPhoto(JTable table , JPanel contentPane){
		int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		List<Photo> photos= new ArrayList<Photo>();
		photos=getProxy().viewPhoto();
		Object[][] data = {};
        data = new Object[photos.size()][3];
        int i = 0;
        for (Photo photo :  photos) {
            data[i][0] = photo.getIdPhoto();
            data[i][1] = photo.getDescription();
            data[i][2] = photo.getImage();
            
            if (i + 1  == var ) {
            	JPanel panel_2 = new JPanel();
        		panel_2.setBounds(546, 11, 306, 283);
        		contentPane.add(panel_2);
        		panel_2.setLayout(null);
        		
        		JLabel lblNewLabel = new JLabel("");
        		lblNewLabel.setBounds(0, 0, 306, 283);
        		panel_2.add(lblNewLabel);
        		
        		ImageIcon icon = new ImageIcon(photo.getImage());
                lblNewLabel.setIcon(icon);
                panel_2.add(lblNewLabel);
            	
            	break; }
            i++;
        }
		
	}
	
	
	public static void DeletePhoto(JTable table){
		Photo photo = new Photo();
		int var = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		photo.setIdPhoto(var);
		getProxy().deletePhoto(photo);
		
		
	}

}
