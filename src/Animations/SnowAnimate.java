package Animations;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SnowAnimate
{
	public int x1, y1;
	Image img1 = ImageIO.read(getClass().getResource("/snow.png"));
	
	public SnowAnimate() throws IOException
	{

	}
	
	public void draw(Graphics g)
	{
		g.drawImage(img1, 0, (-600)+y1, null);
	}
}
