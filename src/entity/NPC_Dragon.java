
package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NPC_Dragon extends Entity {

    public NPC_Dragon(GamePanel gp){
        super(gp);
        direction = "nothing";
        getImage();
        setDialogue();
    }
    public void getImage() {


        nothing1 = setup("/npc/dragon_1");
        nothing2 = setup("/npc/dragon_2");

    }

    public void setDialogue() {
        dialogues[0] = "Du hast mich gerettet!!";
        dialogues[1] = "*ROOOAR*";

    }
    public BufferedImage setup(String imagePath) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream(  imagePath +".png"));
            //image = uTool.scaleImage(image, 64, 122);

        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public void speak() {
        if(dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
            gp.gameState = gp.playState;;
        }
        this.gp.ui.currentDialogue = this.dialogues[dialogueIndex];
        dialogueIndex++;
    }
}
