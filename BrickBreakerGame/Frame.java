package BrickBreakerGame;
import javax.swing.*;



public class Frame extends JFrame{
    Frame(){
        setTitle("Brick Breaker game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,600);
        setLocationRelativeTo(null);
        setResizable(false);
        
        GamePlay game = new GamePlay();
        add(game);
        setVisible(true);
    }

}
