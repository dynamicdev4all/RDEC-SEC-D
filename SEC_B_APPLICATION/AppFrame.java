import javax.swing.JFrame;

public class AppFrame extends JFrame{
    AppFrame(){
        setTitle("SEC B APP");
        setSize(500,500);
        setLocationRelativeTo(null);
        AppPanel aPanel = new AppPanel();
        add(aPanel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
