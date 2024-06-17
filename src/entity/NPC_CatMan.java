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
        }
        public void getImage() {


            nothing1 = setup("/npc/catman_1");
            nothing2 = setup("/npc/catman_2");

        }

        public void setDialogue() {


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
        //this.gp.ui.currentDialogue = this.dialogues[0];
    }
}