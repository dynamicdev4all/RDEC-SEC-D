import javax.swing.JFrame;
import javax.swing.JWindow;

public class LoadingScreen extends JWindow{
    LoadingScreen(){
        setSize(500,500);
        AppFrame aFrame = new AppFrame();
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoadingScreen();
    }
}
