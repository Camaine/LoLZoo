package Animations;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AbyssBackground
{
	public int x1 = 0;
	
	File file1 = new File(".\\Resource\\abyss_left.png");
	File file2 = new File(".\\Resource\\abyss_right.png");
	Image img1 = ImageIO.read(file1);
	Image img2 = ImageIO.read(file2);
	
	public AbyssBackground() throws IOException
	{
		
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(img1, x1-400, 0, null);
		g.drawImage(img2, (-x1)+800, 0, null);
	}
}
