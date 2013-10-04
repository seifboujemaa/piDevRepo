package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.edu.esprit.piDev.artOfDev.liveUp.entities.User;

/**
 * Entity implementation class for Entity: Journalist
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Journalist extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Journalist() {
		super();
	}
   
}
