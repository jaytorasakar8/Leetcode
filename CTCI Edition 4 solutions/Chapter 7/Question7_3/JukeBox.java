package Question7_3;

import java.util.Set;

public class JukeBox {
	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollection;
	private TrackSelector ts;
	
	public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection,
				   TrackSelector ts) {
		super();
		this.cdPlayer = cdPlayer;
		this.user = user;
		this.cdCollection = cdCollection;
		this.ts = ts;
	}
	
	public Song getCurrentTrack() { return ts.getCurrentSong();	}
	public void processOneUser(User u) { this.user = u;	}
}
