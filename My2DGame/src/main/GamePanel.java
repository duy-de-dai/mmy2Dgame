package main;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize =16; //16x16 tile
    final int scale = 3;
    final int tileSize=originalTileSize*scale;
    final int maxScreenCol=16;
    final int maxScreenRow=12;
    final int screenWidth=maxScreenCol*tileSize;//768 pixels
    final int screenHeight=maxScreenRow*tileSize;//576 pixels
    final int playerSpeed=1;
    int FPS=60;
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;

    // set player's default position
    int playerX=100;
    int playerY=100;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);            //bản vẽ từ component này sẽ được thực hiện trong bộ đệm vẽ ngoài màn hình.
        this.addKeyListener(keyH);
        this.setFocusable(true);            //Đặt trạng thái có thể lấy tiêu điểm của component thành giá trị được chỉ định
    }

    public void startGameThread(){
        gameThread= new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
       // double drawInterval = 1000000000/FPS;
       // double nextDrawTime= System.nanoTime() + drawInterval;
        while (gameThread!= null){

            update(); // update information such as charater positions

            repaint(); // draw screen with update infomation

           /* try {
                double remainingTime= nextDrawTime-System.nanoTime();
                Thread.sleep((long) (remainingTime/1000000));
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } */
        }
    }

    private void update() {
            if (keyH.upPressed)  playerY-=playerSpeed;
            if (keyH.downPressed)  playerY+=playerSpeed;
            if (keyH.rightPressed)  playerX+=playerSpeed;
            if (keyH.leftPressed)  playerX-=playerSpeed;

        }
    public void paintComponent(Graphics g){                         //ghi đè
        super.paintComponent(g);
        //Graphics2D g2=(Graphics2D)g;
        g.setColor(Color.white);
        g.fillRect(playerX,playerY,tileSize,tileSize);                 // vẽ hình chữ nhật
        g.dispose();                                                 // giải phóng
    }
}
