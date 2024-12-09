import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class SongClient {
    public static void main(String[] args) {
        String songUrl = "https://itunes.apple.com/search?term=karan+aujla&limit=25";
        // https://itunes.apple.com/search?term=karan+aujla&limit=25
        ArrayList<Songs> songList = new ArrayList<>();

        // HttpClient client2 = new HttpClient();
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(songUrl)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // System.out.println(response.body());

            JSONObject object = new JSONObject(response.body());
            JSONArray songsArray = new JSONArray(object.getJSONArray("results"));

            for (int i = 0; i < songsArray.length(); i++) {
                Songs song = new Songs();
                JSONObject song2 = songsArray.getJSONObject(i);
                // System.out.println(song2.getString("artistName"));
                // System.out.println(song2.getString("trackName"));
                song.artistName = song2.getString("artistName");
                if (song2.has("trackName")) {
                    song.trackName = song2.getString("trackName");
                } else {
                    song.trackName = "No Track Found";

                }
                song.songPic = song2.getString("artworkUrl100");
                song.dateReleased = song2.getString("releaseDate");

                songList.add(song);
            }

            // System.out.println(songsArray.length());
            System.out.println(songList.get(0).trackName);
            System.out.println(songList.get(1).trackName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}