package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {
    GamePanel gp;
    public int worldX,worldY;
    public int speed;
    public double gravity;
    public int jumpheight;

    public BufferedImage up1, up2, up3;
    // public BufferedImage hitright1, hitright2, hitright3, hitright4, hitright5, hitright6;
    // public BufferedImage hitleft1, hitleft2, hitleft3, hitleft4, hitleft5, hitleft6;
    public BufferedImage left1, left2, left3;
    public BufferedImage right1, right2, right3;
    public BufferedImage down1, down2;
    public BufferedImage nothing1, nothing2, nothing3;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(8,0,42,80);
    public boolean collisionOn = false;

    public int solidAreaDefaultX, solidAreaDefaultY;
    String dialogues[] = new String [20];
    public int dialogueIndex = 0;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void update() {

        collisionOn = false;
        gp.cChecker.checkTile(this);

        // IF COLLISION = FALSE, Player can move
        if (collisionOn == false) {
            switch(direction) {
                case "up":
                    worldY-= speed;
                    break;
                case "down":
                    worldY+= speed;
                    break;
                case "right":
                    worldX+= speed;
                    break;
                case "left":
                    worldX-= speed;
                    break;
            }
        }
        spriteCounter++;
        if (spriteCounter >12) {
            if (spriteNum < 6) {
                spriteNum ++;
            }
            else if (spriteNum >=6){
                spriteNum=1;
            }
            spriteCounter=0;
        }
    }

    public void speak() {

    }


    public void draw(Graphics2D g2){

        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            switch (direction) {

                case "nothing":
                    if (spriteNum == 1 || spriteNum == 3 || spriteNum == 5) {
                        image = nothing1;
                    }
                    if (spriteNum == 2 || spriteNum == 4 || spriteNum == 6) {
                        image = nothing2;
                    }
                    break;

                case "up":
                    if (spriteNum == 1 || spriteNum == 4) {
                        image = up1;
                    }
                    if (spriteNum == 2 || spriteNum == 5) {
                        image = up2;
                    }
                    if (spriteNum == 3 || spriteNum == 6) {
                        image = up3;
                    }
                    break;

                case "right":
                    if (spriteNum == 1 || spriteNum == 4) {
                        image = right1;
                    }
                    if (spriteNum == 2 || spriteNum == 5) {
                        image = right2;
                    }
                    if (spriteNum == 3 || spriteNum == 6) {
                        image = right3;
                    }
                    break;

                case "left":
                    if (spriteNum == 1 || spriteNum == 4) {
                        image = left1;
                    }
                    if (spriteNum == 2 || spriteNum == 5) {
                        image = left1;
                    }
                    if (spriteNum == 3 || spriteNum == 6) {
                        image = left3;
                    }
                    break;

                case "down":
                    if (spriteNum ==1 || spriteNum == 4) {
                        image = down1;
                    }
                    if (spriteNum == 2 || spriteNum == 5) {
                        image = nothing1;
                    }
                    if (spriteNum == 3 || spriteNum == 6) {
                        image = down2;
                    }
                    break;



            }

            g2.drawImage(image, screenX, screenY, 52, 81, null);
        }

    }

}
