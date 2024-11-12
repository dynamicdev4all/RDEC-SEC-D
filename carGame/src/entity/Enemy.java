package entity;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import carGame.AppPanel;
import carGame.KeyControls;

public class Enemy extends Entity {

    private AppPanel appPanel;
    private Random random;
    private int speedIncrementInterval = 10;

    public Enemy(AppPanel appPanel) {
        this.appPanel = appPanel;
        this.random = new Random();
        this.x = appPanel.SCREEN_WIDTH / 2;
        this.y = -appPanel.SCREEN_HEIGHT;
        this.speed = 2 + random.nextInt(5);
    }

    public void update() {
        y += speed;
        y += Road.roadSpeed;
        if (y > appPanel.SCREEN_HEIGHT - appPanel.TILE_SIZE+100) {
            y = -appPanel.TILE_SIZE-25;
            speed += 0.1;
            int col = 3 + random.nextInt(appPanel.SCREEN_COLS - 6);
            x = col * appPanel.TILE_SIZE;
            appPanel.incrementScore();
        }
    }

    public void reset() {
        x = appPanel.SCREEN_WIDTH / 2;
        y = -appPanel.SCREEN_HEIGHT;
        speed = 3 + random.nextInt(5);
    }

    public void loadImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/enemy/enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        loadImage();
        g.drawImage(image, x, y, sizex, sizey + 25, null);
    }
}