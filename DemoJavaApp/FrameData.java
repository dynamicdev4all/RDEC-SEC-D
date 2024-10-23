import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FrameData extends JPanel {
    BufferedImage bufferImage;
    Timer timer;

    FrameData(){
        setSize(500,500);
        // setBackground(Color.RED);
        printBgImage();
        loopRepaint();
    }

    void printBgImage(){
        try {
            bufferImage = ImageIO.read(FrameData.class.getResource("car.gif"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("No image Found");
            e.printStackTrace();
        }
    }


    void loopRepaint(){
        // Timer();
        timer.start();

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.drawImage(bufferImage, 0,0,500,500, null);
    }
}
