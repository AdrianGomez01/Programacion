package Tema5.boletin2t53;

public class ITunes implements OfflineMusicPlayer {

	@Override
	public void play() {
		System.out.println("Playing music con iTunes");

	}

	@Override
	public void stop() {
		System.out.println("Stopping music on iTunes");

	}

	@Override
	public void load() {
		System.out.println("Loading music on iTunes");

	}

}
