package Animations;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AbyssBackground
{
	public int x1 = 0;
	
	Image img1 = ImageIO.read(getClass().getResource("/abyss_left.png"));
	Image img2 = ImageIO.read(getClass().getResource("/abyss_right.png"));
	
	public AbyssBackground() throws IOException
	{
		
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(img1, x1-400, 0, null);
		g.drawImage(img2, (-x1)+800, 0, null);
	}
}
