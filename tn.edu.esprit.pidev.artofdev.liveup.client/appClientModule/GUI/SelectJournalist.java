package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import GUI.model.JournalistTableModel;
import javax.swing.JScrollPane;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class SelectJournalist extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable journalistTable;

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
		JournalistTableModel journalistTableModel = new JournalistTableModel();
		journalistTable.setModel(journalistTableModel);
		
		JLabel lblSelectAJournalist = new JLabel("Select a Journalist you want to accept");
		lblSelectAJournalist.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblSelectAJournalist.setBounds(24, 23, 229, 30);
		contentPane.add(lblSelectAJournalist);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(529, 363, 89, 23);
		contentPane.add(btnAccept);
		
		JButton btnReject = new JButton("Reject");
		btnReject.setBounds(362, 363, 89, 23);
		contentPane.add(btnReject);
		//int selectedRow = journalistTable.getSelectedRow();
		//Journalist journalist = (Journalist) journalistTableModel.getValueAt(selectedRow, -1);
	}
}
