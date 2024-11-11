package carGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;
import entity.*;

public class AppPanel extends JPanel implements ActionListener {

    public static final int TILE_SIZE = 100;
    public static final int SCREEN_COLS = 12;
    public static final int SCREEN_ROWS = 7;
    public static final int SCREEN_WIDTH = TILE_SIZE * SCREEN_COLS;
    public static final int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROWS;
    private static final int DELAY = 12;

    private Timer timer;
    private KeyControls keyBind = new KeyControls();
    private ArrayList<Enemy> enemies; 
    private Player player;
    private Road road;
    private int score;
    private int highScore;
    private boolean gameOver = false,newGame=true;

    private ScreenManager screenManager;

    public AppPanel() {
//      enemy = new Enemy(this);
        enemies = new ArrayList<>();
        player = new Player(this, keyBind);
        road = new Road(this, keyBind);
        screenManager = new ScreenManager(this);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(keyBind);
        startGame();
    }

    private void startGame() {
        timer = new Timer(DELAY, this);
        timer.start();
        spawnEnemy();
    }
    
    private void spawnEnemy() {
            enemies.add(new Enemy(this));
    }

    private void update() {
        if (gameOver) return;
        for (Enemy enemy : enemies) {
        	if (player.x < enemy.x + enemy.sizex &&
        			player.x + player.sizex > enemy.x &&
        			player.y < enemy.y + enemy.sizey &&
        			player.y + player.sizey > enemy.y) {
        		keyBind.running = false;
        		gameOver = true;
        	}
        }
        player.update();//updates the player coordinates 
        for (Enemy enemy : enemies) {
        	enemy.update();//update the enemy cars 
        }
        road.update();//update the road to show the movement
    }

    private void restartGame() {
        if (gameOver && keyBind.restart) {
            keyBind.restart = false;
            player.reset();
            enemies.clear();
            road.reset();
            resetScore();
            gameOver = false;
            keyBind.running = true;
            spawnEnemy();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            screenManager.drawGameOver(g, score, highScore);
        } else if (!keyBind.running&&newGame) {
            screenManager.drawWelcome(g);
        } 
        else if(!keyBind.running&&!newGame){
            road.paintRoad(g);
            this.setBackground(Color.white);
            drawGrid(g);
            for (Enemy enemy : enemies) {
            	enemy.draw(g);
            }
            player.drawPlayer(g);
            drawScore(g);
        }
        else {
        	newGame=false;
            road.paintRoad(g);
            this.setBackground(Color.white);
//            drawGrid(g);
            for (Enemy enemy : enemies) {
            enemy.draw(g);
            }
            player.drawPlayer(g);
            drawScore(g);
        }
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("High Score: " + highScore, SCREEN_WIDTH - 150, 30);
        g.drawString("Score: " + score, SCREEN_WIDTH - 150, 60);
        g.drawString("Speed: " + road.roadSpeed, SCREEN_WIDTH - 150, 90);
        }

    public void incrementScore() {
        score++;
    }

    public void resetScore() {
        if (score > highScore) {
            highScore = score;
        }
        score = 0;
    }

    private void drawGrid(Graphics g) {
        for (int i = 0; i < SCREEN_WIDTH / TILE_SIZE; i++) {
            g.drawLine(i * TILE_SIZE, 0, i * TILE_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * TILE_SIZE, SCREEN_WIDTH, i * TILE_SIZE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (keyBind.running) {
            update();
        }
        restartGame();
        repaint();
    }
}