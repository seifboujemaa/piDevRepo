package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SubscribedClient
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class SubscribedClient extends User implements Serializable {

	private Administrator administrator;
	private static final long serialVersionUID = 1L;

	public SubscribedClient() {
		super();
	}
     @ManyToOne
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
   
}
