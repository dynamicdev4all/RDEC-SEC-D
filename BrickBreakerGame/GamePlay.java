package BrickBreakerGame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Graphics2D;



public class GamePlay extends JPanel implements ActionListener,KeyListener{
    private int score = 0;
    private boolean play = false;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 5;
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private int playerX = 350;
    private MapGenerator map;

    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        timer = new Timer(delay,this);
        timer.start();

        map = new MapGenerator(3,7);
    }

    public void paint(Graphics g){
        //black canvas
        g.setColor(Color.black);
        g.fillRect(2,2,688,588);
        
        //border
        g.setColor(Color.yellow);
        g.fillRect(0,0,680,3);
        g.fillRect(0,3,3,680);
        g.fillRect(681,0,3,680);

        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX,550,100,8);

        //bricks
        map.draw((Graphics2D)g);

        //ball
        g.setColor(Color.red);
        g.fillOval(ballposX,ballposY,30,30);        

        //score
        g.setColor(Color.green);
        g.setFont(new Font("serif", Font.BOLD,20));
        g.drawString("Score: "+score,550,30);


        //game over
        if(ballposY >= 580){
            play = false;
            ballXdir = 0;
            ballYdir = 0;

            g.setColor(Color.green);
            g.setFont(new Font("serif",Font.BOLD,40));
            g.drawString("GameOver!!,Score : "+score ,180,280);

            g.setColor(Color.green);
            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Press Enter to Restart",200,350);

            //player win 

            if(totalBricks<=0){
                play = false;
                ballXdir = 0;
                ballYdir = 0;

                g.setColor(Color.ORANGE);
                g.setFont(new Font("serif",Font.BOLD,40));
                g.drawString("Congrats!! You Won,Score : "+score ,180,280);

                g.setColor(Color.green);
                g.setFont(new Font("serif",Font.BOLD,20));
                g.drawString("Press Enter to Restart",200,350);
            }

        }
    }

    private void moveLeft(){
        play = true;
        if(playerX >=0)
            playerX = playerX - 20;
        // else 
        //     playerX = 0;
    }

    private void moveRight(){
        play = true;
        if(playerX <=580)
            playerX = playerX + 20;
        // else
        //     playerX = 580;
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            moveLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            moveRight();
        }
        if(e.getKeyCode()== KeyEvent.VK_ENTER){
            if(!play){
                score = 0;
                totalBricks = 21;
                ballposX = 120;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 350;

                map = new MapGenerator(3,7);
            }
        }

        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(play){
            if(ballposX<0 || ballposX>650)
                ballXdir = -ballXdir;
            if(ballposY<0 )
                ballYdir = -ballYdir;

            Rectangle ballRect = new Rectangle(ballposX,ballposY,30,30);
            Rectangle paddleRect = new Rectangle(playerX,550,100,8);

            //ball return when collaspe with paddle

            if(ballRect.intersects(paddleRect)){
                ballYdir = -ballYdir;
            }

            //ball return when collaspe with brick 

            A:for(int i = 0;i<map.map.length;i++){
                for(int j = 0;j<map.map[i].length;j++){
                    if(map.map[i][j] > 0){
                        int width = map.brickWidth;
                        int height = map.brickHeight;
                        int brickXpos = 55+j*width;
                        int brickYpos = 50+ i*height;
                         
                        Rectangle brickRect = new Rectangle(brickXpos,brickYpos,width,height);
                        if(ballRect.intersects(brickRect)){
                            map.setBrick(0,i,j);
                            totalBricks--;
                            score += 5;

                            if(ballposX+19<=brickXpos || ballposX+1>=brickXpos+width){
                                ballXdir = -ballXdir;
                            }
                            else{
                                ballYdir = -ballYdir;
                            }

                            break A;
                        }

                    }
                }
            }



            ballposX += ballXdir;
            ballposY += ballYdir;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e){ }
    @Override
    public void keyReleased(KeyEvent e){}
    
}
