package carGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControls implements KeyListener {
    
    public boolean up = false;
    public boolean right = false;
    public boolean down = false;
    public boolean left = false;
    public boolean running = false;
    public boolean restart = false;
    
    @Override
    public void keyTyped(KeyEvent e) { }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_P) {
            // Toggle running state
            running = !running;
        }
        
        if(!running && !restart) {
        	if(code == KeyEvent.VK_R) {
            	restart = true;
        	}
        }
        
        switch (code) {
            case KeyEvent.VK_UP: up = true; break;
            case KeyEvent.VK_LEFT: left = true; break;
            case KeyEvent.VK_RIGHT: right = true; break;
            case KeyEvent.VK_DOWN: down = true; break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        switch (code) {
            case KeyEvent.VK_UP: up = false; break;
            case KeyEvent.VK_LEFT: left = false; break;
            case KeyEvent.VK_RIGHT: right = false; break;
            case KeyEvent.VK_DOWN: down = false; break;
        }
    }
}
