import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class SongReport {
    ArrayList<Song> songList;

    public static void main(String[] args) {
        new SongReport().go();
    }

    private void go() {
        songList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/rashmit/Github/head-first-java-notes/CH16/songs.txt"));
            String[] words;
            while (true) {
                String title, song;
                String temp = reader.readLine();
                if (temp == null)
                    break;
                words = temp.split("/");
                title = words[1];
                song = words[0];
                songList.add(new Song(title, song, 9, "good"));
            }
            songList.sort(new TitleComparator());
//            songList.sort(String::compareTo);
//            for (String s : songList)
//                System.out.println(s);
            System.out.println(songList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class TitleComparator implements Comparator<Song> {

        @Override
        public int compare(Song song, Song t1) {
            return song.getTitle().compareTo(t1.getTitle());
        }
    }

    static class ArtistComparator implements Comparator<Song> {

        @Override
        public int compare(Song song, Song t1) {
            return song.getArtist().compareTo(t1.getArtist());
        }
    }
}