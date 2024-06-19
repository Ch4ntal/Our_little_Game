package main;

import entity.NPC_CatMan;
import entity.NPC_Dragon;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {

    }
    public void setNPC() {

        int mapNum = 0;
        if(gp.currentMap == 0){
            mapNum = 0;
            gp.npc[mapNum][0] = new NPC_CatMan(gp);
            gp.npc[mapNum][0].worldX = gp.tileSize * 17;
            gp.npc[mapNum][0].worldY = gp.tileSize * 56 - 20;
        }
        else if(gp.currentMap== 2){
            mapNum = 2;
            gp.npc[mapNum][0] = new NPC_Dragon(gp);
            gp.npc[mapNum][0].worldX = gp.tileSize * 55;
            gp.npc[mapNum][0].worldY = (gp.tileSize * 51) + 32;
        }

    }

}
