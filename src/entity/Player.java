package entity;

        import main.GamePanel;
        import main.KeyHandler;
        import main.UtilityTool;

        import javax.imageio.ImageIO;
        import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.IOException;
        import java.util.Objects;

public class Player extends Entity {
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;


    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        screenX = gp.screenWidth / 2 - (gp.playerwidth / 2);
        screenY = gp.screenHeight / 2 - (gp.playerheight / 2);

        solidArea = new Rectangle();
        solidArea.x = 14;
        solidArea.y = 52;
        solidArea.width = 15;
        solidArea.height = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {

        //Startpoint:
        worldX = gp.tileSize * 17;
        worldY = gp.tileSize * 57;
        speed = 4;
        direction = "nothing";
        gravity = 0;
        jumpheight = 8;
    }

    public void getPlayerImage() {

        up1 = setup("/player/boy_up_1");
        up2 = setup("/player/boy_up_2");
        up3 = setup("/player/boy_up_3");
        left1 = setup("/player/boy_left_1");
        left2 = setup("/player/boy_left_2");
        left3 = setup("/player/boy_left_3");
        right1 = setup("/player/boy_right_1");
        right2 = setup("/player/boy_right_2");
        right3 = setup("/player/boy_right_3");
        down1 = setup("/player/boy_down_1");
        down2 = setup("/player/boy_down_2");
        nothing1 = setup("/player/boy_nothing_1");
        nothing2 = setup("/player/boy_nothing_2");
        nothing3 = setup("/player/boy_nothing_3");
    }

    public BufferedImage setup(String imagePath) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, gp.playerwidth, gp.playerheight);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }


    public void update() {
        if (keyH.upPressed) {
            direction = "up";

        } else if (keyH.leftPressed) {
            direction = "left";
        } else if (keyH.rightPressed) {
            direction = "right";
        } else if (keyH.downPressed) {
            direction = "down";
        } else {
            direction = "nothing";
        }

        // CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);

        // CHECK NPC OR MONSTER COLLISION
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC(npcIndex);

        //CHECK EVENT
        gp.eHandler.checkEvent();

        gp.keyH.enterPressed = false;


        // IF COLLISION = FALSE, Player can move
        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
            }
        }
        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum < 6) {
                spriteNum++;
            } else if (spriteNum >= 6) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        worldY += gravity;
    }

    public void pickUpObject(int i) {
        if (i != 999) {

        }
    }

    public void interactNPC(int i) {
        if (i != 999) {

            if (gp.keyH.enterPressed == true) {
                gp.gameState = gp.dialogueState; //  gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
    }


        public void draw (Graphics2D g2){
            //  g2.setColor(Color.white);
            // g2.fillRect(x,y,gp.tileSize,gp.tileSize);

            BufferedImage image = null;

            switch (direction) {

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
                    if (spriteNum == 1 || spriteNum == 4) {
                        image = down1;
                    }
                    if (spriteNum == 2 || spriteNum == 5) {
                        image = nothing1;
                    }
                    if (spriteNum == 3 || spriteNum == 6) {
                        image = down2;
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
            g2.drawImage(image, screenX, screenY, null);

        }


    }
