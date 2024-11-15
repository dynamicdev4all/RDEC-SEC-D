package BrickBreakerGame;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

public class MapGenerator {
    public int map[][];
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row , int col){
        map = new int[row][col];

        for(int i = 0;i<row;i++){
            for(int j = 0 ; j <col; j++){
                map[i][j] = 1;
            }
        }

        brickWidth = 540/col;
        brickHeight = 150/row;

    }

    public void setBrick(int value,int r ,int c){
        map[r][c] = value;
    }

    public void draw(Graphics2D g){
        for(int i = 0;i<map.length;i++){
            for(int j = 0;j<map[i].length;j++){
                if(map[i][j]>0){
                    g.setColor(Color.white);
                    g.fillRect(j*brickWidth+55,i*brickHeight+50,brickWidth,brickHeight);

                    g.setColor(Color.black);                           //border of brick
                    g.setStroke(new BasicStroke(3));
                    g.drawRect(j*brickWidth+55,i*brickHeight+50,brickWidth,brickHeight);
                }
            }
        }





    }
}
