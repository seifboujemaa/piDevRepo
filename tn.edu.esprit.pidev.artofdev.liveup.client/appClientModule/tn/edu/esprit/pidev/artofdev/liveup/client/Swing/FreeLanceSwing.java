package tn.edu.esprit.pidev.artofdev.liveup.client.Swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class FreeLanceSwing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreeLanceSwing frame = new FreeLanceSwing();
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
	public FreeLanceSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(21, 42, 699, 295);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Article", null, panel, null);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 11, 674, 217);
		panel.add(textPane);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(10, 239, 89, 23);
		panel.add(btnSend);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("News", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnSend_1 = new JButton("Send");
		btnSend_1.setBounds(10, 233, 89, 23);
		panel_1.add(btnSend_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 11, 674, 215);
		panel_1.add(textPane_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(21, 8, 89, 23);
		contentPane.add(btnLogout);
	}
}
