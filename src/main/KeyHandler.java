package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements KeyListener, MouseListener {

    public boolean jumpPressed;
    public boolean hitPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code =e.getKeyCode();

        if(code ==KeyEvent.VK_SPACE) {
            jumpPressed = true;

        }
        if(code ==KeyEvent.VK_A) {
            leftPressed = true;

        }

        if(code ==KeyEvent.VK_D) {
            rightPressed = true;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code ==KeyEvent.VK_SPACE) {
            jumpPressed = false;

        }
        if(code ==KeyEvent.VK_A) {
            leftPressed = false;

        }
        if(code ==KeyEvent.VK_D) {
            rightPressed = false;

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
