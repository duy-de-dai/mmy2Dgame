package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener {             // nhận sự kiện từ bàn phím

    public boolean upPressed, downPressed,leftPressed, rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {      //Được triệu hồi khi một key đã được gõ.

    }

    @Override
    public void keyPressed(KeyEvent e) {    //Được triệu hồi khi một key đã được nhấn.
        int code=e.getKeyCode();
        if (code == KeyEvent.VK_W)  {
            upPressed=true;
        }

        if (code == KeyEvent.VK_S)  {
            downPressed=true;
        }

        if (code == KeyEvent.VK_A)  leftPressed=true;

        if (code == KeyEvent.VK_D)  rightPressed=true;
    }
    @Override
    public void keyReleased(KeyEvent e) {   // Được triệu hồi khi một key đã được nhả ra.
        int code=e.getKeyCode();
        if (code == KeyEvent.VK_W)  {
            upPressed=false;
        }

        if (code == KeyEvent.VK_S)  downPressed=false;

        if (code == KeyEvent.VK_A)  leftPressed=false;

        if (code == KeyEvent.VK_D)  rightPressed=false;
    }
}
