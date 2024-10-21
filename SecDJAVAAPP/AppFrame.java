import javax.swing.JFrame;

public class AppFrame extends JFrame {
    AppFrame(){
        initApp();
    }

    public void initApp(){
        setTitle("JAVA SEC D APP");
        setSize(500,500);
        setVisible(true);
        AppPanel ap = new AppPanel();
        add(ap);
        setResizable(false);
    }
}
