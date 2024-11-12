package carGame;

import javax.swing.JFrame;

public class AppFrame extends JFrame {

    public AppFrame() {
        this.add(new AppPanel());
        this.setTitle("Car Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
