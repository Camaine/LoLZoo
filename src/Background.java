import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Background extends JPanel
{
	JLabel background = new JLabel(new ImageIcon(
			"C:\\Users\\Kim\\workspace\\LoLZoo\\Resource\\Poro.jpg"));

	public Background()
	{
		add(background);
	}
}
