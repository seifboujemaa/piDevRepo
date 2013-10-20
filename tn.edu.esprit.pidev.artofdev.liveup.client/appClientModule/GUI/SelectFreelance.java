package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import GUI.model.FreelanceTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectFreelance extends JFrame {
	
	

	private JPanel contentPane;
	
	protected static JTable freelanceTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFreelance frame = new SelectFreelance();
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
	public SelectFreelance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane FreelanceTable = new JScrollPane();
		FreelanceTable.setBounds(44, 52, 452, 220);
		contentPane.add(FreelanceTable);
		
		freelanceTable = new JTable();
		FreelanceTable.setViewportView(freelanceTable);
		final FreelanceTableModel freelanceTableModel = new FreelanceTableModel();
		freelanceTable.setModel(freelanceTableModel);
		
		JLabel lblSelectAFreelance = new JLabel("Select a freelance:");
		lblSelectAFreelance.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblSelectAFreelance.setBounds(40, 11, 122, 14);
		contentPane.add(lblSelectAFreelance);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EditFreelance EF= new EditFreelance();
				EF.setVisible(true);
				int selectedRow = freelanceTable.getSelectedRow();
				FreeLance freeLance = (FreeLance) freelanceTableModel.getValueAt(selectedRow, -1);
				
				EF.getFirstNameText().setText(freeLance.getFirstName());
				EF.getLastNameText().setText(freeLance.getLastName());
				EF.getLoginText().setText(freeLance.getLogin());
				EF.getPasswordText().setText(freeLance.getPwd());
				EF.getEmailText().setText(freeLance.getEmail());
				if(freeLance.getStatus()==true)
				EF.RadioActivate.doClick();
				else
					EF.RadioDesactivate.doClick();
				
				
			}
		});
		btnEdit.setBounds(302, 303, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(430, 303, 89, 23);
		contentPane.add(btnExit);
	}
}
