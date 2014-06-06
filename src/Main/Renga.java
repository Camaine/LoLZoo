package Main;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.*;


@SuppressWarnings("serial")
public class Renga extends JPanel
{
	Color gray = new Color(200,200,200);
	Color Ggray = new Color(150,150,150);
	Color blue = new Color(150,180,255);
	Color sc = new Color(150,150,50);
	Color tong = new Color(205,150,150);
	Color col;
	BasicStroke BS = new BasicStroke(4);
	
	public int x1 = 0, y1 = 0;
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		draw(g2);
	}
	
	public void draw(Graphics2D g2)
	{
		
		Ellipse2D.Double body = new Ellipse2D.Double(x1+20,y1+30,70,70);
		g2.setColor(gray);
		g2.fill(body);
		g2.draw(body);
		
		Ellipse2D.Double hair1 = new Ellipse2D.Double(x1+15,y1+45,20,20);
		g2.setColor(gray);
		g2.fill(hair1);
		g2.draw(hair1);
		
		Ellipse2D.Double hair2 = new Ellipse2D.Double(x1+22,y1+30,20,20);
		g2.setColor(gray);
		g2.fill(hair2);
		g2.draw(hair2);
		
		Ellipse2D.Double hair3 = new Ellipse2D.Double(x1+35,y1+25,20,20);
		g2.setColor(gray);
		g2.fill(hair3);
		g2.draw(hair3);
		
		Ellipse2D.Double hair4 = new Ellipse2D.Double(x1+50,y1+25,20,20);
		g2.setColor(gray);
		g2.fill(hair4);
		g2.draw(hair4);
		
		Ellipse2D.Double hair5 = new Ellipse2D.Double(x1+65,y1+30,15,20);
		g2.setColor(gray);
		g2.fill(hair5);
		g2.draw(hair5);
		
		for(int i=0; i<5; i++)
		{
			Line2D.Double horn1 = new Line2D.Double(x1+12-3*i,y1+58-2*i,x1+14,y1+48);
			g2.setStroke(BS);
			g2.setColor(Ggray);
			g2.fill(horn1);
			g2.draw(horn1);
		}
		
		for(int i=0; i<5; i++)
		{
			Line2D.Double horn2 = new Line2D.Double(x1+20-2*i,y1+37-2*i,x1+26,y1+30);
			g2.setStroke(BS);
			g2.setColor(Ggray);
			g2.fill(horn2);
			g2.draw(horn2);
		}
		
		for(int i=0; i<9; i++)
		{
			Line2D.Double horn3 = new Line2D.Double(x1+38+i,y1+23,x1+34,y1+12);
			g2.setStroke(BS);
			g2.setColor(Ggray);
			g2.fill(horn3);
			g2.draw(horn3);
		}
		
		for(int i=0; i<7; i++)
		{
			Line2D.Double horn4 = new Line2D.Double(x1+57+i,y1+23,x1+52,y1+13);
			g2.setStroke(BS);
			g2.setColor(Ggray);
			g2.fill(horn4);
			g2.draw(horn4);
		}
		
		for(int i=0; i<7; i++)
		{
			Line2D.Double horn5 = new Line2D.Double(x1+75+i,y1+24+2*i,x1+68,y1+22);
			g2.setStroke(BS);
			g2.setColor(Ggray);
			g2.fill(horn5);
			g2.draw(horn5);
		}
		
		Ellipse2D.Double blueeye = new Ellipse2D.Double(x1+35,y1+55,10,10);
		g2.setColor(blue);
		g2.fill(blueeye);
		g2.draw(blueeye);
		
		Line2D.Double scar = new Line2D.Double(x1+60,y1+45,x1+85,y1+65);
		BasicStroke SS = new BasicStroke(4);
		g2.setStroke(SS);
		g2.setColor(sc);
		g2.fill(scar);
		g2.draw(scar);
		
		Ellipse2D.Double redeye = new Ellipse2D.Double(x1+68,y1+50,10,10);
		g2.setColor(Color.RED);
		g2.fill(redeye);
		g2.draw(redeye);
		
		Ellipse2D.Double yelloweye = new Ellipse2D.Double(x1+70,y1+52,6,6);
		g2.setColor(Color.YELLOW);
		g2.fill(yelloweye);
		g2.draw(yelloweye);
		
		for(int i=0; i<9; i++)
		{
			Line2D.Double mouth = new Line2D.Double(x1+50,y1+77+i,x1+70,y1+74+i);
			g2.setStroke(BS);
			g2.setColor(tong);
			g2.fill(mouth);
			g2.draw(mouth);
		}
		
		Ellipse2D.Double leg1 = new Ellipse2D.Double(x1+35,y1+90,10,10);
		g2.setColor(gray);
		g2.fill(leg1);
		g2.draw(leg1);
		
		Ellipse2D.Double leg2 = new Ellipse2D.Double(x1+75,y1+85,10,10);
		g2.setColor(gray);
		g2.fill(leg2);
		g2.draw(leg2);
	}
}
