package entity;

import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import carGame.AppPanel;
import carGame.KeyControls;

public class Road extends Entity {

    AppPanel appPanel;
    KeyControls keyControl;
    public static int roadSpeed;
    public float friction;

    public Road(AppPanel appPanel, KeyControls keyControl) {
        this.appPanel = appPanel;
        this.keyControl = keyControl;
//        x = 4 * appPanel.TILE_SIZE;
        x = 0;
        y = 0;
//        sizex = 4 * appPanel.TILE_SIZE;
        sizex = appPanel.SCREEN_WIDTH;
        sizey = appPanel.SCREEN_HEIGHT;
        speed = 0;
        friction = 0;
        loadRoad(); // Load the image once when the Road object is created
    }

    public void loadRoad() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/background/road4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyControl.up) {
            speed += acceleration;
            friction = 0; // Reset friction when the key is pressed
        } else {
            friction = -0.05f; // Apply friction when no key is pressed
        }
        
        if(keyControl.down) {
        	speed-=acceleration;
        }

//        if (speed > 0) {
        if (speed > 0) speed += friction; // Reduce speed by the friction value
            if (speed < 0) speed = speed -= friction;  // Ensure speed doesn't go below zero
//        }
        if(speed<0) {
        	y = (int)(y%500);
        }
        // Move the background downwards to create movement illusion
        y = (int) ((y + speed) % 500);
        roadSpeed = (int) speed;
    }

    public void reset() {
        speed = 0;
        friction = 0;
        y = 0;
    }

    public void paintRoad(Graphics g) {
        g.drawImage(image, x, y - 500, sizex, sizey, null);
        g.drawImage(image, x, y, sizex, sizey, null);
        g.drawImage(image, x, y+500, sizex, sizey, null);
    }
}