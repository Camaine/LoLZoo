import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPanel extends JPanel
{
	Image img;
	Cursor Cursor;
	File op = new File(".\\Resource\\Poro.jpg");
	Buttons button1 = new Buttons();
	Poro poro;
	
	public int check_poro = 0;
	int i;
	
	public MainPanel() throws IOException
	{
		setLayout(new BorderLayout());
		myCursor();
		addMouseMotionListener(new MouseMotionListener()
		{
			
			@Override
			public void mouseDragged(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				final int x = e.getX();
		        final int y = e.getY();
		       
		       setCursor(Cursor);
				
			}
			
		});
		button_action();
		img = ImageIO.read(op);
		add(button1, BorderLayout.NORTH);
		repaint();
		

	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Random rd = new Random();

		g.drawImage(img, 0, 0, null);
		if(check_poro == 1)
		{
			poro = new Poro();
			poro.draw(g2);
			check_poro = 0;
		}
		
	}

	public void myCursor() throws IOException
	{
		
		Toolkit tk = Toolkit.getDefaultToolkit();

		Image lol = ImageIO.read(new File(".\\Resource\\LoL_cursor.png"));

		Cursor = tk.createCustomCursor(lol, new Point(10, 10),"OUR CURSOR");
	}
	
	public void button_action()
	{
		button1.character_select.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
				Object[] Field1 =
				{ button1.character1, button1.character2 };
				int value = JOptionPane.showOptionDialog(null,
						"Select Character", "Select Character",
						JOptionPane.DEFAULT_OPTION, 0, null, Field1, Field1[i]);
				
				
			}

		});
		
		button1.character1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("poro");
				check_poro = 1;
				repaint();
			}
			
		});
		
	}
}
