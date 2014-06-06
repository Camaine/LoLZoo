package Animations;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SnowAnimate
{
	public int x1, y1;
	File file1 = new File(".\\Resource\\snow.png");
	Image img1 = ImageIO.read(file1);
	
	public SnowAnimate() throws IOException
	{

	}
	
	public void draw(Graphics g)
	{
		g.drawImage(img1, x1, y1, null);
	}
}
