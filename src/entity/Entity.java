package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x,y;
    public int speed;
    public double gravity;
    public int jumpheight;

    public BufferedImage jumpright1, jumpright2;
    public BufferedImage jumpleft1, jumpleft2;
    public BufferedImage hitright1, hitright2, hitright3, hitright4, hitright5, hitright6;
    public BufferedImage hitleft1, hitleft2, hitleft3, hitleft4, hitleft5, hitleft6;
    public BufferedImage left1, left2, left3;
    public BufferedImage right1, right2, right3;
    public BufferedImage down1, down2, down3;
    public BufferedImage nothing1, nothing2, nothing3;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

}
