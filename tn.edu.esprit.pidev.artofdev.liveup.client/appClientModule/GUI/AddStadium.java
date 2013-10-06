package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.StadiumServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Stadium;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStadium extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Address;
	private JTextField Capacity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStadium frame = new AddStadium();
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
	public AddStadium() {
		final StadiumServicesDelegate stadiumService= new StadiumServicesDelegate() ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Name = new JTextField();
		Name.setBounds(153, 40, 86, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Address = new JTextField();
		Address.setBounds(153, 96, 86, 20);
		contentPane.add(Address);
		Address.setColumns(10);
		
		Capacity = new JTextField();
		Capacity.setBounds(153, 154, 47, 20);
		contentPane.add(Capacity);
		Capacity.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(38, 43, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setBounds(38, 99, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Capacity");
		lblNewLabel_2.setBounds(39, 157, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = Name.getText();
				String address = Address.getText();
				int capacity = Integer.parseInt(Capacity.getText());
				
				Stadium stadium = new Stadium ();
				stadium.setName(name);
				stadium.setAddress(address);
				stadium.setCapacity(capacity);
				
				stadiumService.create(stadium);
			}
		});
		btnNewButton.setBounds(300, 204, 89, 23);
		contentPane.add(btnNewButton);
	}
}
