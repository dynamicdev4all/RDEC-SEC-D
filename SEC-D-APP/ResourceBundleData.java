import java.util.ResourceBundle;

public record ResourceBundleData() {
    static ResourceBundle rb = ResourceBundle.getBundle("config");

    static String getBundleData(String key) {
        return rb.getString(key);
    }
}
