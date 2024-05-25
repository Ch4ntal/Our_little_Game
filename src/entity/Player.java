package entity;

        import main.GamePanel;
        import main.KeyHandler;

        import javax.imageio.ImageIO;
        import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.IOException;
        import java.util.Objects;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player (GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {

        x=100;
        y=100;
        speed = 4;
        direction = "nothing";
        gravity = 0;
        jumpheight = 8;
    }
    public void getPlayerImage() {


        try {
            jumpright1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_jump_1.png"));
            jumpright2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_jump_right_2.png"));

            jumpleft1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_jump_left_1.png"));
            jumpleft2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_jump_left_2.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_3.png"));

            hitright1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_right_1.png"));
            hitright2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_right_2.png"));
            hitright2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_right_2.png"));
            hitright3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_right_3.png"));
            hitright4 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_right_4.png"));
            hitright5 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_right_5.png"));
            hitright6 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_right_6.png"));

            hitleft1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_left_1.png"));
            hitleft2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_left_2.png"));
            hitleft3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_left_3.png"));
            hitleft4 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_left_4.png"));
            hitleft5 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_left_5.png"));
            hitleft6 = ImageIO.read(getClass().getResourceAsStream("/player/boy_hit_left_6.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_3.png"));

            nothing1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_nothing_1.png"));
            nothing2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_nothing_2.png"));
            nothing3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_nothing_3.png"));

            //down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            //down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            //down3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_3.png"));



        } catch(IOException e){
            e.printStackTrace();
        }

    }


    public void update(){
        if (keyH.jumpPressed) {
            if (keyH.leftPressed) {
                direction = "jumpleft";
                y -= jumpheight;

            } else {

                direction = "jumpright";
                y -= jumpheight;

            }
        }
        else if(keyH.hitPressed) {

                direction = "hitright";


        }
        else if(keyH.leftPressed) {
            direction = "left";
            x -= speed;
        }
        else if(keyH.rightPressed) {
            direction = "right";
            x += speed;
        }
        else if (keyH.downPressed){
            direction = "down";
            y += speed;

        }
        else {
            direction = "nothing";
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
        y += gravity;
    }

    public void draw(Graphics2D g2){
        //  g2.setColor(Color.white);
        // g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "jumpleft":
                if(spriteNum ==1 || spriteNum==3 || spriteNum ==5) {
                    image = jumpleft1;
                }
                if (spriteNum == 2 || spriteNum == 4 || spriteNum == 6) {
                    image = jumpleft2;
                }
                break;

            case "jumpright":
                if(spriteNum ==1 || spriteNum==3 || spriteNum ==5) {
                    image = jumpright1;
                }
                if (spriteNum == 2 || spriteNum == 4 || spriteNum == 6) {
                    image = jumpright2;
                }
                break;

            case "hitright" :
                if(spriteNum == 1) {
                    image = hitright1;
                }
                if (spriteNum == 2) {
                    image = hitright2;
                }
                if (spriteNum == 3) {
                    image = hitright3;
                }
                if (spriteNum == 4) {
                    image = hitright4;
                }
                if (spriteNum == 5) {
                    image = hitright5;
                }
                if (spriteNum == 6) {
                    image = hitright6;
                }
                break;

            case "hitleft" :
                if(spriteNum == 1) {
                    image = hitleft1;
                }
                if (spriteNum == 2) {
                    image = hitleft2;
                }
                if (spriteNum == 3) {
                    image = hitleft3;
                }
                if (spriteNum == 4) {
                    image = hitleft4;
                }
                if (spriteNum == 5) {
                    image = hitleft5;
                }
                if (spriteNum == 6) {
                    image = hitleft6;
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
                    image = down2;
                }
                if (spriteNum == 3 || spriteNum == 6) {
                    image = down3;
                }
                break;

            case "nothing":
                if (spriteNum == 1 || spriteNum == 4) {
                    image = nothing1;
                }
                if (spriteNum == 2 || spriteNum == 5) {
                    image = nothing2;
                }
                if (spriteNum == 3 || spriteNum == 6) {
                    image = nothing3;
                }
                break;

        }
        g2.drawImage(image, x,y ,gp.playerwidth, gp.playerheight, null);

    }

}
