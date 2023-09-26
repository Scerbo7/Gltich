package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import character.Player;

//import KeyAction;
public class GamePanel extends JPanel implements Runnable{
    
    //Screen settings for pixels on screen
    final int defaultPLayerSize = 32;
    final int scale = 3;
    public final int playerSize = defaultPLayerSize*scale; //48x48 scaled size 
    public final int screenWidth = 900;    //dimensions of the screen
    public final int ScreenHeight = 600;

    public KeyAction keyA = new KeyAction();
    Thread gameThread;
    Player player = new Player(this, keyA);

    //Player default position


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);  
        

        this.addKeyListener(keyA);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

        double drawInterveral = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){

            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterveral;
            lastTime = currentTime;
            //System.out.println("game");
            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }   
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        g2.dispose();

    }
}
