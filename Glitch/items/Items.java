package items;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Items {
    public BufferedImage image;
    public String name;
    public int stageX, stageY;

    public void use(Graphics2D g) throws InterruptedException{
    }
    public void use(Graphics2D g, String direction, int x, int y) throws InterruptedException{
    }
}
