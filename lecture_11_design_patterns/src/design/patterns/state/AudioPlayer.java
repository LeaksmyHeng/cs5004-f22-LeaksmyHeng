package design.patterns.state;

// The AudioPlayer class acts as a context. It also maintains a
// reference to an instance of one of the state classes that
// represents the current state of the audio player.
public class AudioPlayer {
  private State state;
  int volume;
  String playlist, currentSong;
  boolean playing;

  public AudioPlayer() {
    this.state = new ReadyState(this);
  }

  public boolean isPlaying() { return playing; }
  public void  setPlay(boolean playing) {this.playing = playing;}

  // Other objects must be able to switch the audio player's
  // active state.
  //a dvertised user-centered methods that would hook in as call-backs for
  // a graphical UI or physical control buttons on a device
  public void changeState(State state) {
    this.state = state;
  }

  // Method to handle event triggers.
  public void  clickLock() {
    state.clickLock();
  }

  public void clickPlay() {
    state.clickPlay();
  }

  public void clickNext() {
    state.clickNext();
  }

  public void clickPrevious() {
    state.clickPrevious();
  }

  // A state may call some service methods on the context.
  // The following are the service methods. While public, they are really only for the
  // State instances to use to fulfill the contract.

  public void startPlayback() {this.setPlay(true);}
  public void stopPlayback() {this.setPlay(false);}
  public void nextSong() {}
  public void previousSong() {}
  public void fastForward(int gap) {}
  public void rewind(int gap) {}

  public static void main(String [] args) {
    AudioPlayer audioPlayer = new AudioPlayer();
    audioPlayer.clickPlay();
    audioPlayer.clickNext();
    audioPlayer.clickLock();
    audioPlayer.clickPlay(); // should do nothing
    audioPlayer.clickLock();
    audioPlayer.clickPlay();
    audioPlayer.clickPrevious();
    audioPlayer.clickPlay();

  }
}

