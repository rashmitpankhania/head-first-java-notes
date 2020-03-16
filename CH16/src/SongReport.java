import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

class SongReport implements Comparator<String> {

    public static void main(String[] args) {
        ArrayList<String> songList = new ArrayList<>();
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
                songList.add(song);
            }
            songList.sort(String::compareTo);
            for (String s : songList)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compare(String s, String t1) {
        return t1.compareTo(s);
    }
}