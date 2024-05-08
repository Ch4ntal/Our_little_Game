package main;

import javax.swing.JPanel;
import java.awt.*;




public class gamepanel extends JPanel implements Runnable {

    // Screen Settings
    final int originalTileSize = 32; //32x32
    final int scale = 2;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16; //Breite
    final int maxScreenRow = 12; //Höhe
    final int screenWidth = tileSize * maxScreenCol; // 1024 pixels
    final int screenHeight = tileSize * maxScreenRow; // 768 pixels

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //set players default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;



    public gamepanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null) {
            //System.out.println("Game is running!");

            //1 Update: Information as character position
                update();
            //2 Draw: draw screen with updated information
                repaint();
        }

    }
    public void update() {
        if (keyH.upPressed==true) {
            playerY -=playerSpeed;
        }
        else if(keyH.downPressed ==true) {
            playerY += playerSpeed;
        }
        else if(KeyH.leftPressed ==true) {
            playerX -= playerSpeed;
        }
        else if(key.rightPressed == true) {
            playerX += playerSpeed;
        }

    }
    public void paintComponent(Graphics g) {
         super.paintComponent(g);

         Graphics2D g2 = (Graphics2D) g;

         g2.setColor(Color.white);
         g2.fillRect(playerX,playerY,tileSize,tileSize);
         g2.dispose();
    }
}
