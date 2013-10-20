package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import java.util.List;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocator.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Journalist;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesRemote;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.services.journalist.JournalistServicesRemote;

public class JournalistServiceDelegate {

	private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/AdministratorServices!tn.edu.esprit.pidev.artofdev.liveup.ejb.services.administrator.AdministratorServicesRemote";

	private static AdministratorServicesRemote getProxy() {
		return (AdministratorServicesRemote) ServiceLocator.getInstance()
				.getProxy(jndiName);
	}

	public void create(Journalist journalist) {
		getProxy().createJournalist(journalist);

	}

	public static void update(Journalist journalist) {
		getProxy().updateJournalist(journalist);

	}

	public static void delete(Journalist journalist) {
		getProxy().deleteJournalist(journalist);

	}

	public static List<Journalist> findAllJournalist() {
		return getProxy().findAllJournalist();
	}

	public static Journalist findJournalistById(int idJournalist) {
		return getProxy().findJournalistById(idJournalist);
	}

}
