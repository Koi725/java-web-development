package ti.exam3;

public class Music {
  private String title;
  private String artist;
  private int duration;

  public Music () {};

  public Music (String title, String artist, int duration) {
    this.title = title;
    this.artist = artist;
    this.duration = duration;
  }

  public String getTitle() {
    return title;
  }
  
  public String getArtist() {
    return artist;
  }

  public int getDuration() {
    return duration;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }
}