package tn.edu.esprit.pidev.artofdev.liveup.client.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.table.DefaultTableModel;

public class ChefEditorSwing extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefEditorSwing frame = new ChefEditorSwing();
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
	public ChefEditorSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 122, 25);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(0, 0, 118, 23);
		panel_2.add(btnLogout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 47, 681, 295);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Articles", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 234, 293, 22);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(10, 0, 89, 23);
		panel_1.add(btnAccept);
		
		JButton btnDecline = new JButton("Decline");
		btnDecline.setBounds(97, 0, 89, 23);
		panel_1.add(btnDecline);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(196, 0, 89, 23);
		panel_1.add(btnDelete);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(0, 0, 666, 228);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(0, 0, 666, 223);
		panel.add(table);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("News", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 231, 273, 25);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnAccept_1 = new JButton("accept");
		btnAccept_1.setBounds(0, 0, 89, 23);
		panel_4.add(btnAccept_1);
		
		JButton btnDecline_1 = new JButton("decline");
		btnDecline_1.setBounds(88, 0, 89, 23);
		panel_4.add(btnDecline_1);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(184, 0, 89, 23);
		panel_4.add(btnDelete_1);
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(10, 0, 656, 223);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBounds(10, 0, 656, 220);
		panel_3.add(table_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("FreeLances", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 231, 293, 25);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnA = new JButton("Accept");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnA.setBounds(0, 0, 89, 23);
		panel_6.add(btnA);
		
		JButton btnDecline_2 = new JButton("Decline");
		btnDecline_2.setBounds(94, 0, 89, 23);
		panel_6.add(btnDecline_2);
		
		JButton btnDelete_2 = new JButton("Delete");
		btnDelete_2.setBounds(193, 0, 89, 23);
		panel_6.add(btnDelete_2);
		
		ScrollPane scrollPane_2 = new ScrollPane();
		scrollPane_2.setBounds(10, 10, 656, 215);
		panel_5.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setBounds(10, 10, 656, 210);
		panel_5.add(table_2);
	}
}
