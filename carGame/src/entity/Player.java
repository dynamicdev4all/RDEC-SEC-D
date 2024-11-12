package entity;

import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import carGame.AppPanel;
import carGame.KeyControls;

public class Player extends Entity {

    AppPanel appPanel;
    KeyControls keyControl;

    public Player(AppPanel appPanel, KeyControls keyControl) {
        this.appPanel = appPanel;
        this.keyControl = keyControl;
        y = appPanel.SCREEN_HEIGHT - appPanel.TILE_SIZE - 25;
        x = 5 * appPanel.TILE_SIZE;
    }

    public void update() {
        if (keyControl.left) {
            x -= steer;
        }
        if (keyControl.right) {
            x += steer;
        }
        if (keyControl.up) {
            speed += acceleration;
        } else {
            speed = Math.max(0, speed - acceleration);
        }

        if (x < 3 * appPanel.TILE_SIZE) {
            x = 3 * appPanel.TILE_SIZE;
        }
        if (x > appPanel.SCREEN_WIDTH - (4 * appPanel.TILE_SIZE)) {
            x = appPanel.SCREEN_WIDTH - (4 * appPanel.TILE_SIZE);
        }
    }

    public void reset() {
        x = 5 * appPanel.TILE_SIZE;
        y = appPanel.SCREEN_HEIGHT - appPanel.TILE_SIZE - 25;
        speed = 0;
    }

    public void loadPlayer() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/car.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPlayer(Graphics g) {
        loadPlayer();
        g.drawImage(image, x, y, sizex, sizey + 25, null);
    }
}