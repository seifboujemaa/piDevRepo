package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import GUI.model.JournalistTableModel;
import javax.swing.JScrollPane;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.JournalistServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectJournalist extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected static JTable journalistTable;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SelectJournalist frame = new SelectJournalist();
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
	public SelectJournalist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 64, 483, 271);
		contentPane.add(scrollPane);
		
		journalistTable = new JTable();
		scrollPane.setViewportView(journalistTable);
		final JournalistTableModel journalistTableModel = new JournalistTableModel();
		journalistTable.setModel(journalistTableModel);
		
		JLabel lblSelectAJournalist = new JLabel("Select a journalist :");
		lblSelectAJournalist.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblSelectAJournalist.setBounds(24, 23, 229, 30);
		contentPane.add(lblSelectAJournalist);
		
		JButton btnAccept = new JButton("Exit");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnAccept.setBounds(573, 394, 89, 23);
		contentPane.add(btnAccept);
		
		JButton btnReject = new JButton("Edit");
		btnReject.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
			
				EditJournalist EJ= new EditJournalist();
				EJ.setVisible(true);
				int selectedRow = journalistTable.getSelectedRow();
				Journalist journalist = (Journalist) journalistTableModel.getValueAt(selectedRow, -1);
				
				EJ.getFirstNameText().setText(journalist.getFirstName());
				EJ.getLastNameText().setText(journalist.getLastName());
				EJ.getLoginText().setText(journalist.getLogin());
				EJ.getPasswordText().setText(journalist.getPwd());
				EJ.getEmailText().setText(journalist.getEmail());
				if(journalist.getStatus()==true)
				EJ.RadioActivate.doClick();
				else
					EJ.RadioDesactivate.doClick();
				
				
			}
		});
		btnReject.setBounds(365, 346, 89, 23);
		contentPane.add(btnReject);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = journalistTable.getSelectedRow();
				Journalist journalist = (Journalist) journalistTableModel.getValueAt(selectedRow, -1);
				
				int userChoice =  JOptionPane.showConfirmDialog(rootPane, "Do you want to delete "+journalist.getFirstName()+"   "+journalist.getLastName()+"?", "User delete", JOptionPane.YES_NO_OPTION);
				if(userChoice==JOptionPane.NO_OPTION) return;
				else if(userChoice==JOptionPane.YES_OPTION){
					JournalistServiceDelegate.delete(journalist);
					journalistTable.setModel(new JournalistTableModel());
					JOptionPane.showMessageDialog(rootPane, "The user has been removed");
				
				}
				//JOptionPane.showMessageDialog(null, "  "+journalist.getFirstName()+" "+journalist.getLastName()+"has been removed");
				
				}
		});
		
		btnRemove.setBounds(465, 346, 89, 23);
		contentPane.add(btnRemove);
	
	}
}
