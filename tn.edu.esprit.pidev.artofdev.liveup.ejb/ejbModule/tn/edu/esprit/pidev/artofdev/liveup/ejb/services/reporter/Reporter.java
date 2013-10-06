package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter;

import java.util.List;

import javax.ejb.Stateless;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;

/**
 * Session Bean implementation class Reporter
 */
@Stateless
public class Reporter implements ReporterRemote, ReporterLocal {

    /**
     * Default constructor. 
     */
    public Reporter() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Photo> viewPhoto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> viewVideo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPhoto(Photo photo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVideo(Video video) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVideo(Video video) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePhoto(Photo photo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reporter authentification(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

}
