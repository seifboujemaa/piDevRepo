package tn.edu.esprit.pidev.artofdev.liveup.ejb.services.reporter;

import java.io.File;
import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Photo;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;

@Remote
public interface ReporterRemote {
	public List<Photo> viewPhoto();
	public List<Video> viewVideo();
	public byte[] imageToByte(File imageFile);
	public void addVideo(Video video);
	public void deleteVideo(Video video);
	public void deletePhoto(Photo photo);
	public Reporter authentification(String login, String password);
	public void disconnect();
	public void addPhoto(Photo photo);
}
