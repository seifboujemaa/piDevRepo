package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

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
	
	private Reporter reporter;
	private Game game;
	
	private static final long serialVersionUID = 1L;

	public Photo() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@ManyToOne
	public Reporter getReporter() {
		return reporter;
	}
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	@ManyToOne
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	
	
	
   
}
