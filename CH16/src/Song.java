import java.util.Comparator;

public class Song implements Comparable<Song> {

    private String title;
    private String artist;
    private int rating;
    private String bpm;

    Song(String t, String a, int r, String b) {
        setTitle(t);
        setArtist(a);
        setRating(r);
        setBpm(b);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Song song) {
        return title.compareTo(song.title);
    }
}
