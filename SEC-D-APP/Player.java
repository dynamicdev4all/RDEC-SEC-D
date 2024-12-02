
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
    int x;
    int y;
    int h;
    int w;
    int speed;
    BufferedImage completeImage;
    BufferedImage rightRun[] = new BufferedImage[4];
    String fileName;

    Player() {
        loadBgImage();
        h=Integer.parseInt(ResourceBundleData.getBundleData("IMG_HEIGHT"));
        w=Integer.parseInt(ResourceBundleData.getBundleData("IMG_WIDTH"));
    }

    void loadBgImage() {
        try {
            completeImage = ImageIO.read(AppPanel.class.getResource("player.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    BufferedImage[] getRightRunImages() {
        rightRun[0] = completeImage.getSubimage(0, 120, 60, 60);
        rightRun[1] = completeImage.getSubimage(60, 120, 60, 60);
        rightRun[2] = completeImage.getSubimage(120, 120, 60, 60);
        rightRun[3] = completeImage.getSubimage(180, 120, 60, 60);

        return rightRun;
    }

    void paintImage(Graphics pen, BufferedImage img, int x) {
        pen.drawImage(img, x, 150, w, h, null);
    }

    void move() {
        // x = x + speed;
        y = y - speed;
    }
}
