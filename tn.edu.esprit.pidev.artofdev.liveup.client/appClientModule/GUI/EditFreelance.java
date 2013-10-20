package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.FreelanceServicesDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.client.delegate.JournalistServiceDelegate;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.FreeLance;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditFreelance extends JFrame {

	private JPanel contentPane;
	private JTextField FirstNameText;
	private JTextField LastNameText;
	private JTextField LoginText;
	private JTextField PasswordText;
	private JTextField EmailText;
	JRadioButton RadioActivate = new JRadioButton("Activate");
	JRadioButton RadioDesactivate = new JRadioButton("Desactivate");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditFreelance frame = new EditFreelance();
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
	public EditFreelance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FirstNameText = new JTextField();
		FirstNameText.setBounds(152, 60, 153, 20);
		contentPane.add(FirstNameText);
		FirstNameText.setColumns(10);
		
		LastNameText = new JTextField();
		LastNameText.setColumns(10);
		LastNameText.setBounds(152, 106, 153, 20);
		contentPane.add(LastNameText);
		
		LoginText = new JTextField();
		LoginText.setColumns(10);
		LoginText.setBounds(152, 154, 153, 20);
		contentPane.add(LoginText);
		
		PasswordText = new JTextField();
		PasswordText.setColumns(10);
		PasswordText.setBounds(152, 206, 153, 20);
		contentPane.add(PasswordText);
		
		EmailText = new JTextField();
		EmailText.setColumns(10);
		EmailText.setBounds(152, 252, 153, 20);
		contentPane.add(EmailText);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(31, 63, 67, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(31, 109, 67, 14);
		contentPane.add(lblLastName);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(31, 157, 67, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 209, 67, 14);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(31, 255, 67, 14);
		contentPane.add(lblEmail);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(31, 325, 67, 14);
		contentPane.add(lblStatus);
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boolean status;
				int selectedRow = SelectFreelance.freelanceTable.getSelectedRow();
				FreeLance freeLance = (FreeLance) SelectFreelance.freelanceTable.getValueAt(selectedRow, -1);
				
				String firstname = FirstNameText.getText();
				String lastname = LastNameText.getText();
				String login = LoginText.getText();
				String password = PasswordText.getText();
				String email = EmailText.getText();
				if(RadioActivate.isSelected())
					 status=true;
				else
					status=false;
				
				
				freeLance.setFirstName(firstname);
				freeLance.setLastName(lastname);
				freeLance.setLogin(login);
				freeLance.setPwd(password);
				freeLance.setEmail(email);
				freeLance.setStatus(status);
					
				
				FreelanceServicesDelegate.update(freeLance);
				
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnSaveChanges.setBounds(367, 321, 105, 23);
		contentPane.add(btnSaveChanges);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(482, 321, 89, 23);
		contentPane.add(btnExit);
		
		
		RadioActivate.setBounds(152, 300, 109, 23);
		contentPane.add(RadioActivate);
		
		
		RadioDesactivate.setBounds(152, 337, 109, 23);
		contentPane.add(RadioDesactivate);
	}

	public JTextField getFirstNameText() {
		return FirstNameText;
	}

	public void setFirstNameText(JTextField firstNameText) {
		FirstNameText = firstNameText;
	}

	public JTextField getLastNameText() {
		return LastNameText;
	}

	public void setLastNameText(JTextField lastNameText) {
		LastNameText = lastNameText;
	}

	public JTextField getLoginText() {
		return LoginText;
	}

	public void setLoginText(JTextField loginText) {
		LoginText = loginText;
	}

	public JTextField getPasswordText() {
		return PasswordText;
	}

	public void setPasswordText(JTextField passwordText) {
		PasswordText = passwordText;
	}

	public JTextField getEmailText() {
		return EmailText;
	}

	public void setEmailText(JTextField emailText) {
		EmailText = emailText;
	}
	
	
}
