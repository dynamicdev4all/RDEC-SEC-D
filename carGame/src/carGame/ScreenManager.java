package carGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ScreenManager {

    private AppPanel appPanel;
    BufferedImage grass;

    public ScreenManager(AppPanel appPanel) {
        this.appPanel = appPanel;
    }

    public void drawWelcome(Graphics g) {
        appPanel.setBackground(Color.black);
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = g.getFontMetrics(g.getFont());
        g.drawString("PRESS P TO START",
            (AppPanel.SCREEN_WIDTH - metrics1.stringWidth("PRESS P TO START")) / 2,
            appPanel.SCREEN_HEIGHT / 2);
    }

    public void drawGameOver(Graphics g, int score, int highScore) {
        appPanel.setBackground(Color.black);
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));

        String[] gameOverLines = {
            "GAME OVER",
            "Score: " + score,
            "High Score: " + highScore,
            "Press R to Restart"
        };

        int startY = AppPanel.SCREEN_HEIGHT / 2 - 60;
        int lineSpacing = 50;

        for (int i = 0; i < gameOverLines.length; i++) {
            int x = (AppPanel.SCREEN_WIDTH - g.getFontMetrics().stringWidth(gameOverLines[i])) / 2;
            g.drawString(gameOverLines[i], x, startY + (i * lineSpacing));
        }
    }

}