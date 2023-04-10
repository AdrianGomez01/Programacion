package Tema5.boletin2t53;

public class MusicApp {

	public static void main(String[] args) {
		MusicPlayer[] players = new MusicPlayer[] { new Spotify(), new ITunes(), new MP3Player() };
		MusicApp.startMusic(players);

	}

	public static void startMusic(MusicPlayer[] players) {

		for (MusicPlayer musicPlayer : players) {
			
			musicPlayer.play();
			musicPlayer.stop();
			
			if (musicPlayer instanceof OnlineMusicPlayer) {
				((OnlineMusicPlayer) musicPlayer).stream();
			}
			if (musicPlayer instanceof OfflineMusicPlayer) {
				((OfflineMusicPlayer) musicPlayer).load();
			}

			/**
			 * Se puede hacer con el metodo getclass() de esta forma.
			 * 
			 * if (musicPlayer.getClass()== OfflineMusicPlayer.class) {
			 * ((OfflineMusicPlayer) musicPlayer).load(); }
			 */

		}

	}
}
