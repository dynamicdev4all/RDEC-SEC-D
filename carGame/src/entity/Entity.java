package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x;
    public int y;
    public int sizex = 100;
    public int sizey = 100;
    public float speed = 1;
    public float acceleration = 0.08f;
    public float steer = 8;
    BufferedImage image;
}