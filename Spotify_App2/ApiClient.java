import java.io.IOException;
import java.net.URI;
import java.net.http.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient {

    public static void main(String[] args) {
        String address = "https://itunes.apple.com/search?term=arijit+singh&limit=25";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(address)).GET().build();

        try {
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (res.statusCode() == 200) {
                // System.out.println(res.body());

                String completeData = res.body();

                JSONObject dataObject = new JSONObject(completeData);
                JSONArray dataArray = dataObject.getJSONArray("results");
                // System.out.println(dataArray.length());

                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject singleSong = dataArray.getJSONObject(i);
                    System.out.println(singleSong.getString("trackName")); 
                }
            } else {
                System.out.println("Some error occured");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // System.out.println(URI.create(address).getPath());
        // System.out.println(URI.create(address).getHost());
        // System.out.println(URI.create(address).getQuery());
    }
}