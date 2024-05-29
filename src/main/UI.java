package main;

import java.awt.*;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp){
        this.gp =gp;

        arial_40 = new Font ("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    }

    public void showMessage (String text) {
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);

        //TITLE STATE
        if(gp.gameState ==gp.titleState){
            drawTitleScreen();
        }
        if(gp.gameState == gp.playState){
            //do playState stuff later
        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }

    }
    public void drawTitleScreen() {
        // BACKGROUND
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
        //TILTE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Dragonexplorer";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;

        //SHADOW
        g2.setColor(Color.gray);
        g2.drawString(text, x+5,y+5);


        //MAIN COLOR
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        // MAINCHARACTER IMAGE
        x = gp.screenWidth/2- (gp.playerwidth*2)/2;
        y += gp.tileSize*2;
        g2.drawImage(gp.player.nothing1, x, y, gp.playerwidth*2, gp.playerheight*2, null);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
        text = "START GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*3.5;
        g2.drawString(text,x,y);
        if (commandNum == 0) {
            g2.drawString(">", x-gp.tileSize, y);
        }


        text = "LOAD GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if (commandNum == 1) {
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text,x,y);
        if (commandNum == 2) {
            g2.drawString(">", x-gp.tileSize, y);
        }
    }
    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x,y);

    }
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

}
