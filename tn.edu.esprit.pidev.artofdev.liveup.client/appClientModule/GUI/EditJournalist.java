package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditJournalist extends JFrame {

	private JPanel contentPane;
	private JTextField FirstNameText;
	private JTextField LastNameText;
	private JTextField LoginText;
	private JTextField PasswordText;
	private JTextField EmailText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditJournalist frame = new EditJournalist();
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
	public EditJournalist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(47, 58, 63, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(47, 113, 63, 14);
		contentPane.add(lblLastName);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(47, 163, 63, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(47, 202, 63, 14);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(47, 244, 63, 14);
		contentPane.add(lblEmail);
		
		FirstNameText = new JTextField();
		FirstNameText.setBounds(155, 55, 132, 20);
		contentPane.add(FirstNameText);
		FirstNameText.setColumns(10);
		
		LastNameText = new JTextField();
		LastNameText.setColumns(10);
		LastNameText.setBounds(155, 110, 132, 20);
		contentPane.add(LastNameText);
		
		LoginText = new JTextField();
		LoginText.setColumns(10);
		LoginText.setBounds(155, 160, 132, 20);
		contentPane.add(LoginText);
		
		PasswordText = new JTextField();
		PasswordText.setColumns(10);
		PasswordText.setBounds(155, 199, 132, 20);
		contentPane.add(PasswordText);
		
		EmailText = new JTextField();
		EmailText.setColumns(10);
		EmailText.setBounds(155, 241, 132, 20);
		contentPane.add(EmailText);
		
		
		
		JButton btnApplyChanges = new JButton("Apply changes");
		btnApplyChanges.setBounds(287, 345, 120, 23);
		contentPane.add(btnApplyChanges);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(442, 345, 89, 23);
		contentPane.add(btnExit);
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
