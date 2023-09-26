package character;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import items.Weapon;
import items.Items;
import items.Sword;
import main.GamePanel;
import main.KeyAction;

public class Player extends Character{
    GamePanel gp;
    KeyAction keyA;
    ArrayList<Items> inventory;
    Items Equiped;

    public Player(GamePanel gamePanel, KeyAction key){
        gp = gamePanel;
        keyA = key;    
        Default();
    }

    public void Default(){

        
        x = gp.screenWidth/2-50;
        y = gp.ScreenHeight/2-50;
        movement = 4;
        health = 3;
        direction = "right";
        getPLayerImage();
        Equiped = new Sword(this, gp);
    }

    public void getPLayerImage(){

        try {
            right1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_Right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_Right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_Right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_Right4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_Left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_Left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_Left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Player_Left4.png"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public void update(){

        if(keyA.up || keyA.down || keyA.left|| keyA.right){
            if(keyA.up){
                y -= movement;
            }
            if(keyA.down){
                y += movement;
            }
            if(keyA.left){
                x -= movement;
                direction = "left";
            }
            if(keyA.right){
                x += movement;
                direction = "right";
            }

            sCounter++;
            if(sCounter > 6){
                sNum++;
                if(sNum > 4){
                    sNum = 1;
                }
                sCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2){
        
        BufferedImage image = null;

        if(keyA.action){
            
                try {
                    Equiped.use(g2, direction, x, y);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

        switch(direction){
            case "right":
                if(sNum == 1){
                    image = right1;
                }
                if(sNum == 2){
                    image = right2;
                }
                if(sNum == 3){
                    image = right3;
                }
                if(sNum == 4){
                    image = right4;
                }
                break;
            case "left":
                if(sNum == 1){
                    image = left1;
                }
                if(sNum == 2){
                    image = left2;
                }
                if(sNum == 3){
                    image = left3;
                }
                if(sNum == 4){
                    image = left4;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.playerSize, gp.playerSize, null);
    }
}
