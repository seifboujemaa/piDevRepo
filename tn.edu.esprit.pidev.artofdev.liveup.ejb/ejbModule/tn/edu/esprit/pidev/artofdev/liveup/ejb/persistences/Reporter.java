package tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Reporter
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Reporter extends User implements Serializable {

	private List<Photo> photos= new ArrayList<Photo>();
	private List<Video> videos = new ArrayList<Video>();
	
	private Administrator administrator;
	private static final long serialVersionUID = 1L;

	public Reporter() {
		super();
	}
    @OneToMany(mappedBy="reporter")
	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
     @OneToMany(mappedBy="reporter")
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	@ManyToOne
	public Administrator getAdministrator() {
		return administrator;
	}
   
}
