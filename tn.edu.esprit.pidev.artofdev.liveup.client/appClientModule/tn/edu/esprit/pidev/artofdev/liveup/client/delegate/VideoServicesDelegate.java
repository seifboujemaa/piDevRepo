package tn.edu.esprit.pidev.artofdev.liveup.client.delegate;

import tn.edu.esprit.pidev.artofdev.liveup.client.servicelocater.ServiceLocator;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.persistences.Video;
import tn.edu.esprit.pidev.artofdev.liveup.ejb.sevices.video.VideoServicesRemote;

public class VideoServicesDelegate {
	
	
private static final String jndiName = "ejb:/tn.edu.esprit.pidev.artofdev.liveup.ejb/VideoServices!"+VideoServicesRemote.class.getCanonicalName();

	
	private static VideoServicesRemote getProxy(){
		return (VideoServicesRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public  void create(Video video) {
		getProxy().createVideo(video);
		
	}
	
	public static void update(Video video) {
		getProxy().updateVideo(video);
		
	}
	public static void delete(Video video) {
		getProxy().deleteVideo(video);
		
	}
	public static void findAllVideo() {
		getProxy().findAllVideo();
		
	}
	public static void findVideoById(int idVideo) {
		getProxy().findVideoById(idVideo);
		
	}
	

}
