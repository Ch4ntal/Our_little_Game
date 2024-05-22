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

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt1.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt2.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt3.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt4.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt5.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt6.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y =0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {

            g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}

