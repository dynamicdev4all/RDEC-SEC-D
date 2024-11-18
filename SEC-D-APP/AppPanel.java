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
    BufferedImage bgImage;
    Timer timer;
    int x = 0;
    int y = 100;

    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.BLUE);
        loadBgImage();
        keyBoardControls();
        appLoop();
        setFocusable(true);
    }

    void loadBgImage() {
        try {
            bgImage = ImageIO.read(AppPanel.class.getResource("ryu_sprite_sheet.png")).getSubimage(0, 0, 83, 106);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void appLoop() {
        timer = new Timer(30, (abc) -> {
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
        pen.drawImage(bgImage, x, y, 120, 120, null);
    }
}
