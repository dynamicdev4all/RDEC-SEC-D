import org.json.JSONArray;
import org.json.JSONObject;

public class Demo {
    public static void main(String[] args) {
        String data = """
                [{"name":"Keshav","age":"19"},{"name":"Harshit","age":"20"},{"name":"Nikhil","age":"21"}]
                """;

        JSONArray array = new JSONArray(data);
        System.out.println(array.length());

        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            System.out.println(object.getString("name"));
        }
    }
}
