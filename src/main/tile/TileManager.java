package main.tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y =0;

        while (col < gp.maxS)
    }
}

