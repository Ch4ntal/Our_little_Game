package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NPC_CatMan extends Entity {

        public NPC_CatMan(GamePanel gp){
            super(gp);
            direction = "nothing";
            getImage();
            setDialogue();
        }
        public void getImage() {


            nothing1 = setup("/npc/catman_1");
            nothing2 = setup("/npc/catman_2");

        }

        public void setDialogue() {
            dialogues[0] = "Sei gegrüßt tapferer Held! *meow*";
            dialogues[1] = "Eh! Warum du hier bist? \nDas solltest du doch wissen!";
            dialogues[2] = "Rette unser Dorf! *meow*";
            dialogues[3] = "Beschütze die Dorfbewohner, indem \ndu die Dracheneier aus den Krallen der \nMutter befreist!";
            dialogues[4] = "Let’s go!!!! *meow*";
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