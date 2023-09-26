package main;
import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){
    
        JFrame screen = new JFrame();
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("Glitch");

        GamePanel gamePanel = new GamePanel();
        screen.add(gamePanel);

        screen.pack();

        screen.setLocationRelativeTo(null);
        screen.setVisible(true);

        gamePanel.startGameThread();  
    }
}