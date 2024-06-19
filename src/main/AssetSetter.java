package main;

import entity.NPC_CatMan;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {

    }
    public void setNPC() {
        int mapNum = 0;
        gp.npc[mapNum][0] = new NPC_CatMan(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize * 17;
        gp.npc[mapNum][0].worldY = gp.tileSize * 56 - 20;

    }

}
