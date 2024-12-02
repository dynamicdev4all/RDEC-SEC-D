import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AppPanel extends JPanel {
    Timer timer;
    int x = 0;
    int y = 100;
    int playerCount = 1;
    int currentIndex = 0;
    int currentX = 150;
    Player player = new Player();

    BufferedImage rightRunningImages[] = player.getRightRunImages();

    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.BLUE);
        // loadBgImage();
        keyBoardControls();
        appLoop();
        setFocusable(true);
    }

    void appLoop() {
        timer = new Timer(80, (abc) -> {
            if (currentIndex > 3) {
                currentIndex = 0;
            }
            currentIndex++;
            if (currentX > 500) {
                currentX = -60;
            }
            currentX += 15;
            repaint();
        });
        timer.start();
    }

    void paintPlayer(Graphics pen) {
        // for (int i = 0; i < rightRunningImages.length; i++) {
        // System.out.println(i);
        player.paintImage(pen, rightRunningImages[currentIndex], currentX);
        // }
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
        // player.paintImage(pen);
        paintPlayer(pen);
    }
}
