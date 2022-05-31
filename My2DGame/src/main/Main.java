package main;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create a frame

        JFrame window = new JFrame("duy dại dột");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // tắt chương trình
        window.setResizable(true);                              // tùy chỉnh size cửa sổ

        GamePanel gamePanel=new GamePanel();
        window.add(gamePanel);
        window.pack();                                          // GamePanel fit frame

        window.setLocationRelativeTo(null);                     // window đặt ở giữa
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
