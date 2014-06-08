package Animations;

import java.io.*;
import java.awt.*;

import javax.imageio.ImageIO;

public class RiftBackground
{
	public int y1 = 600;

	Image img1 = ImageIO.read(getClass().getResource("/rift_sky.png"));
	Image img2 = ImageIO.read(getClass().getResource("/rift_ground.png"));
	Image img3 = ImageIO.read(getClass().getResource("/rift_sun.png"));
	Image img4 = ImageIO.read(getClass().getResource("/rift_darkgrass.png"));
	Image img5 = ImageIO.read(getClass().getResource("/rift_lightgrass.png"));
	Image img6 = ImageIO.read(getClass().getResource("/rift_cloud.png"));
	Image img7 = ImageIO.read(getClass().getResource("/rift_tower.png"));

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