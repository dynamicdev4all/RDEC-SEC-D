import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AppPanel extends JPanel {
    Timer timer;

    BufferedImage songImage;

    int currentSongIndex = 0;

    JButton playPauseButton;
    JButton nextSongButton;
    JButton previousSongButton;

    JSlider

    ArrayList<SongModel> songList = ApiClient.getSongList();

    AppPanel() {
        setSize(500, 500);
        setBackground(Color.GREEN);
        playPauseButton = new JButton("Play/Pause");
        nextSongButton = new JButton("Next");
        previousSongButton = new JButton("Previous");
        add(playPauseButton);
        add(nextSongButton);
        add(previousSongButton);

        loadImage();
        appLoop();
        addButtonControls();
        setFocusable(true);
    }

    void addButtonControls() {
        nextSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSongIndex++;
                System.out.println(currentSongIndex);
            }
        });
        previousSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSongIndex--;
                System.out.println(currentSongIndex);
            }
        });
    }

    void loadImage() {
        try {
            songImage = ImageIO.read(new URL(songList.get(currentSongIndex).songImageUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void appLoop() {
        timer = new Timer(80, (abc) -> {
            loadImage();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        pen.setColor(Color.MAGENTA);
        pen.setFont(new Font("Arial", Font.ITALIC, 25));
        pen.drawString(songList.get(currentSongIndex).songName, 140, 320);
        pen.drawString(songList.get(currentSongIndex).singerName, 140, 340);
        pen.drawImage(songImage, 150, 100, 200, 200, null);
    }
}
