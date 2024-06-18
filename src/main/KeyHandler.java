package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements KeyListener, MouseListener {

    GamePanel gp;
    public boolean upPressed;
    public boolean hitPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean downPressed;
    public boolean enterPressed;

    public KeyHandler(GamePanel gp) {
        this.gp =gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();


        //TITLE STATE
        if(gp.gameState == gp.titleState) {
            if (code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum >2) {
                    gp.ui.commandNum =0;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNum == 0) {
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1){
                    //add later
                }
                if(gp.ui.commandNum == 2){
                    System.exit(0);
                }
            }
        }

        //PLAY STATE
        if(gp.gameState == gp.playState) {

            if (code == KeyEvent.VK_W) {
                upPressed = true;

            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;

            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;

            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.pauseState;

                }
            }

        //PAUSE STATE
        if(gp.gameState == gp.pauseState) {
        if (code == KeyEvent.VK_ESCAPE) {
        gp.gameState = gp.playState;
            }
        }

        // DIALOGUE STATE
        if(gp.gameState == gp.dialogueState) {
            if(code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code ==KeyEvent.VK_W) {
            upPressed = false;

        }
        if(code ==KeyEvent.VK_A) {
            leftPressed = false;

        }
        if(code ==KeyEvent.VK_D) {
            rightPressed = false;

        }
        if (code ==KeyEvent.VK_S) {
            downPressed = false;

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int button = e.getButton();
        if (button == MouseEvent.BUTTON1) {
            hitPressed = true;
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int button = e.getButton();
        if (button == MouseEvent.BUTTON1) {
            hitPressed = false;
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
