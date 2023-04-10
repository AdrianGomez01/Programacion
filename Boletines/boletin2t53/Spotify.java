package boletin2t53;

public class Spotify implements OnlineMusicPlayer {

	@Override
	public void play() {
		System.out.println("Playing music on Spotify");

	}

	@Override
	public void stop() {
		System.out.println("Stopping music on Spotify");

	}

	@Override
	public void stream() {
		System.out.println("Streaming music on Spotify");

	}

}
