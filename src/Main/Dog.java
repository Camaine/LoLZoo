package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;


public class Dog extends JPanel implements DrawAnimal
{
	int x1 = 0, y1 = 0;
		

		@Override
		public void draw(Graphics2D g2)
		{
			int i;
			BasicStroke Stokehand = new BasicStroke(3);
			Color Red = new Color(255,0,0);
			Color Yellow = new Color(255,255,0);
			Color Green = new Color(0,255,0);
			Color Black = new Color(0,0,0);
			// Color Setting //
			
			// Dog Head //
			g2.setStroke(Stokehand);
			g2.setColor(Black);
			for(i=0;i<=40;i++)
			{
				Line2D.Double HeadLine1 = new Line2D.Double(40+i+x1,80+y1,120+x1,40+i+y1);
				g2.draw(HeadLine1);
			}
			// Dog Hone(?) //
			g2.setColor(Yellow);
			for(i=0;i<=12;i++)
			{
				Line2D.Double HoneLine1 = new Line2D.Double(95+i+x1,55-i+y1,83+x1,30+y1);
				g2.draw(HoneLine1);
			}
			// Dog Hone(?) //
			
			// Dog Eye //
			g2.setColor(Red);
			Ellipse2D.Double DogEye1 = new Ellipse2D.Double(101+x1,57+y1,8,8);
			g2.draw(DogEye1);
			//
			
			// Dog Axe's Line //
			g2.setColor(Green);
			for(i=0;i<=5;i++)
			{
				Line2D.Double AxeLine1 = new Line2D.Double(64+i+x1,140+y1,154+x1,80+i+y1);
				g2.draw(AxeLine1);
			}
			// Dog Axe's Line //
			
			// Dog Axe //
			for(i=0;i<=20;i++)
			{
				Line2D.Double Axe1 = new Line2D.Double(159+x1,119+y1,154-i+x1,85-i+y1);
				g2.draw(Axe1);
			}
			// Dog Axe //
			
			// Dog Legs //
			g2.setColor(Black);
			for(i=0;i<=30;i++)
			{
				Line2D.Double LegLine1 = new Line2D.Double(95+i+x1,152+y1,112+x1,77+y1);
				g2.draw(LegLine1);
			}
			// Dog Legs //
			
			// Dog Heart(?)
			g2.setColor(Green);
			Rectangle NewRect = new Rectangle(109+x1,107+y1,5,5);
			g2.fill(NewRect);
			g2.draw(NewRect);
			// Dog Heart(?)
			
		}
	
}
