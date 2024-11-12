package com.Siddharth.Upload.JavaFullStack.Ball_Bounce;

import javax.swing.*;
import java.awt.*;


class AppFrame extends JFrame{
    AppFrame(){
        setTitle("Bounce Ball");
        setSize(1000,700);
        setFocusable(true);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        AppPanel appPanel = new AppPanel(100,Color.RED);
        add(appPanel);
        setVisible(true);
    }
}

class AppPanel extends JPanel{
    Boolean down = false, right = false;
    float boost = 0.1f;
    float addx = 10;
    float addy = 8;
    private final int diameter;
    private final Color color;
    int xAxis = 0,yAxis = 0;
    AppPanel(int diameter, Color color){
        this.diameter = diameter;
        this.color = color;
        setPreferredSize(new Dimension(1000, 700));
        StartAnimation();
        setBackground(Color.cyan);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(xAxis, yAxis, diameter, diameter);
    }

    private void StartAnimation(){
        Timer timer = new Timer(8,(abcd)->{
            ballmove();
            repaint();
        });
        timer.start();
    }

    private void ballmove(){
        addx+=boost;
        xAxis+=addx;
        if(xAxis>= getWidth()-diameter || xAxis <= 0){
            addx*=-1;
        }
        addy+=boost;
        yAxis+=addy;
        if(yAxis>=getHeight()-diameter || yAxis<=0){
            addy*=-1;
        }
    }
}


public class AppLaunch {
    public static void main(String[] args) {
        AppFrame aframe = new AppFrame();
    }
}
