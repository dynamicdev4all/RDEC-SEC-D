import javax.swing.JFrame;

public class AppFrame extends JFrame {

    public AppFrame() {
        setTitle("ABCD");
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FrameData fd = new FrameData();
        add(fd);
        setVisible(true);
    }
}