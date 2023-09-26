package items;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import character.Player;
import main.GamePanel;
import main.KeyAction;

public class Sword extends Weapon{

    public BufferedImage left1, left2, left3, left4, right1, right2, right3, right4;
    GamePanel gp; 
    Thread gameThread = new Thread();
    
    public Sword(Player player, GamePanel gamePanel){
        damage = 2;
        range = 1;
        name = "Sword";
        stageX = player.x;
        stageY = player.y;
        gp = gamePanel;
        getPLayerImage();
        gameThread.start();
    }
    
    public void getPLayerImage(){

        try {
            right1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_SwordR1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_SwordR2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_SwordR3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_SwordR4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_SwordL1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_SwordL2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_SwordL3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_SwordL4.png"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void use(Graphics2D g, String d, int x, int y){
        
        draw(g, d, x, y);
    }
    
    public void draw(Graphics2D g2, String d, int x, int y){

        getPLayerImage();
        BufferedImage image = null;
        if(d.equalsIgnoreCase("right")){
            image = right1;
            g2.drawImage(image, x, y, 40*3, gp.playerSize, null);
            g2.dispose();
            image = right2;
            g2.drawImage(image, x, y, 40*3, gp.playerSize, null);
            g2.dispose();
            image = right3;
            g2.drawImage(image, x, y, 40*3, gp.playerSize, null);
            g2.dispose();
            image = right4;
            g2.drawImage(image, x, y, 40*3, gp.playerSize, null);
            g2.dispose();
        }
    }

}
