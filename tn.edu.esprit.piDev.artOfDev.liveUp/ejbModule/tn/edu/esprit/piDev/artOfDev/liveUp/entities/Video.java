package tn.edu.esprit.piDev.artOfDev.liveUp.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Video
 *
 */
@Entity

public class Video implements Serializable {

	
	private int idVideo;
	private String url;
	private static final long serialVersionUID = 1L;

	public Video() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdVideo() {
		return this.idVideo;
	}

	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
   
}
