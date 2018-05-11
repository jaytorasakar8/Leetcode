package Question7_3;


public class TrackSelector {
	private Song currentSong;
	public TrackSelector(Song s) { currentSong=s; }
	public void setTrack(Song s) { currentSong = s;	}
	public Song getCurrentSong() { return currentSong;	}
}

