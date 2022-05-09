package design.patterns.state;


// The base state class declares methods that all concrete
// states should implement and also provides a backreference to
// the context object associated with the state. States can use
// the backreference to transition the context to another state.
public abstract class State {
  protected AudioPlayer player;

  // Context passes itself through the state constructor. This
  // may help a state fetch some useful context data if it's needed.
  State(AudioPlayer player) {
    this.player = player;
  }
  abstract public void clickLock();
  abstract public void clickPlay();
  abstract public void clickNext();
  abstract public void clickPrevious();
}


// Concrete states implement various behaviors associated with a
// state of the context.
class LockedState extends State {
  public LockedState(AudioPlayer player) {
    super(player);
  }

  // When you unlock a locked player, it may assume one of two
  // states.
  public void clickLock() {
    System.out.println("Clicked lock in Locked State");
    if (player.isPlaying()) {
      player.changeState(new PlayingState(player));
    } else {
      player.changeState(new ReadyState(player));
    }
  }
  public void clickPlay() {
    System.out.println("Clicked play in Locked State. Ignoring...");

    // Locked, so do nothing.
  }
  public void clickNext() {
    System.out.println("Clicked next in Locked State. Ignoring...");

    // Locked, so do nothing.
  }

  public void clickPrevious() {
    System.out.println("Clicked previous in Locked State. Ignoring...");

    // Locked, so do nothing.
  }
}

// They can also trigger state transitions in the context.
class ReadyState extends State {
  public ReadyState(AudioPlayer player) {
    super(player);
  }
  public void clickLock() {
    System.out.println("Clicked lock in Ready State. Changing state to Locked State");

    player.changeState(new LockedState(player));
  }

  public void clickPlay() {
    player.startPlayback(); // play == true
    System.out.println("Clicked play in Ready State. Playing started and state change to PlayingState");

    player.changeState(new PlayingState(player));
  }

  public void clickNext() {
    System.out.println("Clicked next in Ready State. Queuing next song");

    player.nextSong();
  }

  public void clickPrevious() {
    System.out.println("Clicked next in Ready State. Queuing previous song");

    player.previousSong();
  }
}

class PlayingState extends State {

  public PlayingState(AudioPlayer player) {
    super(player);
  }

  public void clickLock() {
    System.out.println("Clicked lock in Play State. Changing state to Locked State");

    player.changeState(new LockedState(player));
  }

  public void clickPlay() {
    System.out.println("Clicked Play in Play State. Pause. Changing state to Ready State");

    player.stopPlayback(); // pause/stop playback. play == false
    player.changeState(new ReadyState(player));
  }

  public void clickNext() {
    System.out.println("Clicked next in Play State. Fast Forward by 5");

    player.fastForward(5);
  }

  public void clickPrevious() {
    System.out.println("Clicked previous in Play State. Rewind by 5 ");

    player.rewind(5);
  }
}

