package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.edu.esprit.piDev.artOfDev.liveUp.entities.User;

/**
 * Entity implementation class for Entity: FreeLance
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class FreeLance extends User implements Serializable {

	
	private int status;
	private static final long serialVersionUID = 1L;

	public FreeLance() {
		super();
	}   
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
   
}
