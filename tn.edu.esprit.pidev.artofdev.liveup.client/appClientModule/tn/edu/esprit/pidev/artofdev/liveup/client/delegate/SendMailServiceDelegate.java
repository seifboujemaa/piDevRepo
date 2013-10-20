package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Mail;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.mail.MailServicesRemote;

public class SendMailServiceDelegate {
	
	
	private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/MailServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.mail.MailServicesRemote";

	private static MailServicesRemote getProxy() {
		return (MailServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	
	public static Mail doSendMail(Mail mail) {
		getProxy().sendMail(mail);
		return mail;

	}

}
