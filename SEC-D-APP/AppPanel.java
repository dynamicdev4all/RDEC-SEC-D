import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AppPanel extends JPanel {
    BufferedImage bgImage;
    Timer timer;
    int x = 0;
    int y = 100;
    Car car1;
    Car car2;
    Car car3;

    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.BLUE);
        // loadBgImage();
        car1 = new Car(20, 420, 50, 30, "car.png", 2);
        car2 = new Car(180, 420, 50, 30, "car.png", 5);
        car3 = new Car(360, 420, 50, 30, "car.png", 7);
        keyBoardControls();
        appLoop();
        setFocusable(true);
    }

    // void loadBgImage() {
    // try {
    // bgImage = ImageIO.read(AppPanel.class.getResource("car.png"));
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    void appLoop() {
        timer = new Timer(30, (abc) -> {
            car1.move();
            car2.move();
            car3.move();
            repaint();
        });
        timer.start();
    }

    void keyBoardControls() {
        System.out.println("YES called");
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("KEVENT CALLED");
                // TODO Auto-generated method stub
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    x = x + 1;
                }

                throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }

        });
    }

    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        // TODO Auto-generated method stub
        // pen.drawImage(bgImage, x, y, 120, 120, null);
        car1.paintImage(pen);
        car2.paintImage(pen);
        car3.paintImage(pen);
    }
}
