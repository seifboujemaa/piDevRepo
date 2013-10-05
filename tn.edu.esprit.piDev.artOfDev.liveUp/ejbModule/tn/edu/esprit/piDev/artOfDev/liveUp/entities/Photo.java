package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Photo
 *
 */
@Entity

public class Photo implements Serializable {

	
	private int idPhoto;
	private Blob image;
	private static final long serialVersionUID = 1L;

	public Photo() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}   
	public Blob getImage() {
		return this.image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
   
}
