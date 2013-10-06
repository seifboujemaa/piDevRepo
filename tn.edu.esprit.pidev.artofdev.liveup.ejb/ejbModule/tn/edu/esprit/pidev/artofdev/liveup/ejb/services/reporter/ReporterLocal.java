package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;

@Local
public interface ReporterLocal {
	
	public List<Photo> viewPhoto();
	public List<Video> viewVideo();
	public void addPhoto(Photo photo);
	public void addVideo(Video video);
	public void deleteVideo(Video video);
	public void deletePhoto(Photo photo);
	public Reporter authentification(String login, String password);
	public void disconnect();

}
