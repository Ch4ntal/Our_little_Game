package main;

import entity.Player;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public final int playerwidth = 46;
    public final int playerheight = 71;

    // Screen Settings
    final int originalTileSize = 32; //32x32
    final int scale = 2;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16; //Breite
    final int maxScreenRow = 12; //Höhe
    final int screenWidth = tileSize * maxScreenCol; // 1024 pixels
    final int screenHeight = tileSize * maxScreenRow; // 768 pixels

    //FPS
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);

    //set players default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;



    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.addMouseListener(keyH);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // every 0.01666666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime-lastTime);
            lastTime = currentTime;

            if (delta >=1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }

    }
    public void update() {

        player.update();


    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();


    }
}