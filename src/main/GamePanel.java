package main;

import entity.Entity;
import entity.Player;
import main.tile.TileManager;
import main.UI;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public final int playerwidth = 46;
    public final int playerheight = 71;

    // Screen Settings
    final int originalTileSize = 32; //32x32
    final int scale = 2;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16; //Breite
    public final int maxScreenRow = 12; //Höhe
    public final int screenWidth = tileSize * maxScreenCol; // 1024 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 768 pixels

    // World Settings
    public  int maxWorldCol =100;
    public  int maxWorldRow =100;
    public final int maxMap = 10;
    public int currentMap = 1;



    //FPS
    int FPS = 60;
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public EventHandler eHandler = new EventHandler(this);
    Sound sound = new Sound();
    public UI ui = new UI(this);
    Thread gameThread;
    public AssetSetter aSetter = new AssetSetter(this);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this,keyH);

    public Entity npc[][] = new Entity[maxMap][10];

    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState =1;
    public final int pauseState =2;
    public final int dialogueState = 3;

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

    public void setupGame() {

        gameState = titleState;
        aSetter.setNPC();
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

        if (gameState == playState) {
            player.update();
            //NPC
            for(int i = 0; i < npc[1].length; i++){
                if(npc[currentMap][i] != null){
                    npc[currentMap][i].update();
                }
            }

        }
        if (gameState == pauseState) {
            // nothing --> no playerupdate
        }


    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        // TITLE SCREEN
        if (gameState == titleState) {
            ui.draw(g2);

        } else {
            //Tile
            tileM.draw(g2);

            //NPC
            for (int i = 0; i <  npc[1].length; i++){
                if(npc[currentMap][i] != null) {
                    npc[currentMap][i].draw(g2);
                }
            }

            //player
            player.draw(g2);

            //UI
            ui.draw(g2);

            g2.dispose();
        }



    }
    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic() {
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}