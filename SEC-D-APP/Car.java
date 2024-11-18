
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Car {
    int x;
    int y;
    int h;
    int w;
    int speed;
    BufferedImage image;
    String fileName;

    Car(int x, int y, int h, int w, String fileName, int speed) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.fileName = fileName;
        this.speed = speed;
        loadBgImage();
    }

    void loadBgImage() {
        try {
            image = ImageIO.read(AppPanel.class.getResource(fileName)).getSubimage(0, 0, 83, 106);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void paintImage(Graphics pen) {
        pen.drawImage(image, x, y, 120, 120, null);
    }

    void move() {
        // x = x + speed;
        y = y - speed;
    }
}
