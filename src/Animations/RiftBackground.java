package Animations;

import java.io.*;
import java.awt.*;

import javax.imageio.ImageIO;

public class RiftBackground
{
	public int y1 = 600;

	File file1 = new File(".\\Resource\\rift_sky.png");
	File file2 = new File(".\\Resource\\rift_ground.png");
	File file3 = new File(".\\Resource\\rift_sun.png");
	File file4 = new File(".\\Resource\\rift_darkgrass.png");
	File file5 = new File(".\\Resource\\rift_lightgrass.png");
	File file6 = new File(".\\Resource\\rift_cloud.png");
	File file7 = new File(".\\Resource\\rift_tower.png");
	Image img1 = ImageIO.read(file1);
	Image img2 = ImageIO.read(file2);
	Image img3 = ImageIO.read(file3);
	Image img4 = ImageIO.read(file4);
	Image img5 = ImageIO.read(file5);
	Image img6 = ImageIO.read(file6);
	Image img7 = ImageIO.read(file7);

	public RiftBackground() throws IOException
	{

	}

	public void draw(Graphics g)
	{
		g.drawImage(img1, 0, y1, null);
		g.drawImage(img2, 0, y1, null);
		g.drawImage(img3, 0, y1, null);
		g.drawImage(img4, 0, y1, null);
		g.drawImage(img5, 0, y1, null);
		g.drawImage(img6, 0, y1, null);
		g.drawImage(img7, 0, y1, null);
	}
	
	public int getY()
	{
		return y1;
	}
}