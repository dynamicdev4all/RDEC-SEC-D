import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient {

    static ArrayList<SongModel> songList = new ArrayList<>();

    static ArrayList<SongModel> getSongList() {
        getSongDataFromApi();
        return songList;
    }

    static void getSongDataFromApi() {
        String address = "https://itunes.apple.com/search?term=kishore+kumar&limit=25";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(address)).GET().build();
        try {
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (res.statusCode() == 200) {
                extractDataFromRes(res.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void extractDataFromRes(String completeData) {
        JSONObject dataObject = new JSONObject(completeData);
        JSONArray dataArray = dataObject.getJSONArray("results");
        for (int i = 0; i < dataArray.length(); i++) {
            SongModel songObject;
            JSONObject singlObject = dataArray.getJSONObject(i);
            songObject = new SongModel(
                    singlObject.has("trackName") ? singlObject.getString("trackName") : "No Data Found",
                    singlObject.has("artistName") ? singlObject.getString("artistName") : "No Data Found",
                    singlObject.has("artworkUrl100") ? singlObject.getString("artworkUrl100") : "No Data Found",
                    singlObject.has("previewUrl") ? singlObject.getString("previewUrl") : "No Data Found");
            songList.add(songObject);
        }
    }
}